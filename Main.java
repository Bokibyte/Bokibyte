import java.awt.*;
import java.awt.event.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args){
        Launcher launch = new Launcher();
    }

    public String path(){
        String pathtext = System.getProperty("user.dir")+"/"+"dataTools.txt";
        return pathtext;
    }

    public String folderPath(){
        String folderPath = System.getProperty("user.dir")+"/Tools/";
        return folderPath;
    }

    JButton go = new JButton("Run");
    JTextField getInput = new JTextField();

    public void mainExecutor(){
        String path = path();
        ArrayList<String> dataSet = new ArrayList<>();
        Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while((line = br.readLine()) != null){
                dataSet.add(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        String[] dataMenu = new String[dataSet.size()];
        StringBuilder sb = new StringBuilder();
        StringBuilder sbN = new StringBuilder();
        for(int i = 0; i < dataSet.size(); ){
            dataMenu[i] = dataSet.get(i);
            sb.append(i+"<br>");
            sbN.append(dataMenu[i]+"<br>");
            i++;
        }
        String nameList = String.format("<html><div style='text-align: left; line-height: 20;'>%s</div></html>", sbN.toString());
        String numList = String.format("<html><div style='text-align: right; line-height: 20;'>%s</div></html>", sb.toString());
        
        JLabel headLabel = new JLabel(">    ToolsList");
        headLabel.setForeground(new Color(180, 180, 180));
        headLabel.setFont(new Font("Arial", Font.PLAIN, 30));

        JPanel headMenu1 = new JPanel();
        headMenu1.setLayout(new FlowLayout(FlowLayout.LEFT));
        headMenu1.add(headLabel);
        headMenu1.setBounds(0, 0, 350, 50);
        headMenu1.setBackground(new Color(50, 50, 50));

        getInput.setBounds(10,20, 200, 30);
        
        go.setBounds(220, 20, 60, 30);
        go.setFocusable(false);
        go.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(e.getSource()==go){
                    String inpMenu = getInput.getText();
                    try{
                        int noMenu = Integer.parseInt(inpMenu);
                        if(noMenu < dataMenu.length){
                            try{
                                getInput.setText("");
                                System.out.println(folderPath()+dataMenu[noMenu]);
                                System.out.println(path());

                                String fileName = folderPath()+dataMenu[noMenu];System.out.println(fileName);
                                String cmd = "cmd /c javac "+fileName+" && java "+fileName.replace(".java", "");
                                Process process = Runtime.getRuntime().exec(cmd);
                            }catch (IOException y){
                                y.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Problem with path name!", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Tool not found", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }catch(NumberFormatException x){
                        getInput.setText("");
                        JOptionPane.showMessageDialog(null, "Invalid input!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
        
                    
                }
            }
        });

        JPanel downLine = new JPanel(null);
        downLine.setBounds(0,  r.height-100, 300,r.height);
        downLine.setBackground(new Color(80, 80, 80));
        downLine.add(getInput);
        downLine.add(go);

        JLabel toolName = new JLabel(nameList);
        toolName.setFont(new Font("Courier New", Font.PLAIN, 15));
        toolName.setForeground(Color.WHITE);
        toolName.setBounds(0, 0, 300, r.height-100);
        toolName.setVerticalAlignment(JLabel.TOP);
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBounds(50, 0, 250, r.height-100);
        listPanel.setBackground(new Color(80, 80, 80));
        listPanel.add(toolName);

        JLabel numbering = new JLabel(numList);
        numbering.setFont(new Font("Courier New", Font.PLAIN, 15));
        numbering.setForeground(new Color(180, 180, 180));
        JPanel lJPanel = new JPanel();
        lJPanel.setBounds(0, 0, 50, r.width-100);
        lJPanel.setBackground(new Color(50, 50, 50));
        lJPanel.add(numbering);

        JPanel menuPanel = new JPanel(null);
        menuPanel.setBounds(0, 50, 300, r.height-100);
        menuPanel.add(lJPanel);
        menuPanel.add(listPanel);

        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, r.height);
        frame.setVisible(true);
        
        frame.add(downLine);
        frame.add(headMenu1);
        frame.add(menuPanel);

        
    }
}

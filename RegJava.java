import java.awt.*;
import java.awt.event.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.*;
import javax.swing.*;

public class RegJava implements ActionListener{
    JFrame frame = new JFrame();
    JButton regFile = new JButton("Add Tool");
    JButton delFile = new JButton("Remove");
    JTextField nameReg = new JTextField();

    // get Path file
    Main main = new Main();
    String path = main.path();

    RegJava(){
        
        JLabel titlLabel = new JLabel("<html><font color = 'white'><p style = 'font-size: 40px;'>REGISTER YOUR</p></html>");
        titlLabel.setBounds(170, 0, 800, 50);

        JLabel subTitlLabel = new JLabel("<html><font color = 'white'<p style = 'font-size: 20px;'>TOOL</p></font></html>");
        subTitlLabel.setBounds(180, 40, 300, 50);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(80, 80, 80));
        rightPanel.setBounds(150, 0, 650, 350);

        nameReg.setBounds(165, 260, 400, 25);
        JLabel titleReg = new JLabel("<html><font color = 'white'<p style = 'font-size: 10px;'>Enter your file name:</p></font></html>");
        titleReg.setBounds(165, 235, 300, 25);

        JLabel infoReg = new JLabel("<html><font color = 'white'<p style = 'font-size: 7px;'>// Remember to put your file first!</p></font></html>");
        infoReg.setBounds(165, 280, 300, 25);

        regFile.setBounds(570, 260, 100, 25);
        regFile.setFocusable(false);
        regFile.addActionListener(this);

        delFile.setBounds(675, 260, 100, 25);
        delFile.setFocusable(false);
        delFile.addActionListener(this);

        JPanel leftJPanel2 = new JPanel();
        leftJPanel2.setBounds(635, 0, 105, 240);
        leftJPanel2.setBackground(Color.BLACK);

        // Background Decor
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int rep = 0;
        for(int i = 0; i <= 180; i++){
            int seed = random.nextInt(2);
            rep++;
            sb.append(seed);
            if(rep >= 15){
                sb.append("<br>");
                rep = 0;
            }else{
                sb.append("");
            }
        }
        String raNumb = String.format("<html><p style = 'font-size: 15px'; 'color: #3C3C3C;'>%s</p></html>", sb.toString());

        JPanel leftPanel = new JPanel();
        leftPanel.add(new JLabel(raNumb));
        leftPanel.setBackground(Color.BLACK);
        leftPanel.setBounds(0, 0, 150, 350);

        frame.setLayout(null);
        frame.setSize(800, 350);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(subTitlLabel);
        frame.add(titlLabel);
        frame.add(infoReg);
        frame.add(titleReg);
        frame.add(nameReg);
        frame.add(regFile);
        frame.add(delFile);
        frame.add(leftJPanel2);
        frame.add(rightPanel);
        frame.add(leftPanel);
        frame.setResizable(false);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                Launcher back = new Launcher();
            }
        });
    }

    private String path() {
        return null;
    }

    private void regist(){
        UIManager.put("OptionPane.okButtonText", "Ok");
        ArrayList<String> dataSet = new ArrayList<>();
        Set<String> detectDuplicate = new HashSet<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while((line = br.readLine()) != null){
                detectDuplicate.add(line);
                dataSet.add(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        // Write
        
        String newData = nameReg.getText();
        if(detectDuplicate.contains(newData)){
            JOptionPane.showMessageDialog(null, "Name already taken.", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(newData.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid name!", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
           dataSet.add(newData);
           dataSet.sort(null);
            try(FileWriter writer = new FileWriter(path)){
                for(String data : dataSet){
                    writer.write(data+"\n");
                }
                JOptionPane.showMessageDialog(null, "Successfuly added!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        nameReg.setText("");
    }

    private void remove(){
        // get Data
        UIManager.put("OptionPane.okButtonText", "Ok");
        ArrayList<String> dataSet = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while((line = br.readLine()) != null){
                dataSet.add(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        // Search & Remove then rewrite
        String toRemove = nameReg.getText();
        boolean isCompleted = false;
        for(int i = 0; i < dataSet.size(); i++){
            if(dataSet.get(i).equals(toRemove)){
                dataSet.remove(i);
                isCompleted = true;
                i--;
                try(FileWriter writer = new FileWriter(path)){
                    for(String data : dataSet){
                        writer.write(data+"\n");
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            nameReg.setText("");
        }
        if(isCompleted){
            JOptionPane.showMessageDialog(null, "Successfuly removed!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Invalid name!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==regFile){
            regist();
        }
        if(e.getSource()==delFile){
            remove();
        }
    }
}

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.TextStyle;
import java.awt.*;

public class Launcher implements ActionListener{

    JFrame frame = new JFrame("Launcher 0.1");
    JButton regButton = new JButton("Reg Tools");
    JButton runButton = new JButton("Run");

    //private static volatile JLabel anim;

    Launcher(){
        UIManager.put("OptionPane.okButtonText", "Masuk");

        // getDate
        Locale BInd = new Locale("id", "ID");
        LocalDate Date = LocalDate.now();
        String Hari = Date.getDayOfWeek().getDisplayName(TextStyle.FULL, BInd);
        String Bulan = Date.getMonth().getDisplayName(TextStyle.FULL, BInd);
        int Tanggal = Date.getDayOfMonth();
        int Tahun = Date.getYear();
        String showDate = String.format("<html><body><font color = 'white'><p style='font-size: 10px;'>&nbsp;&nbsp;%s, %s %s %s</p></font></body></html>", Hari, Tanggal, Bulan, Tahun);
        
        /*
        Runnable loopTask = () -> {
            String animChar = "|/-\\";
            int x = 0;
            while(true){
                try {
                    x++;
                    String animData = "\r"+animChar.charAt(x % animChar.length());
                    String animS = String.format("<html><body><p style='font-size: 50px;'>%s</p></font></body></html>", animData);
                    JLabel anim = new JLabel(animS);
                    anim.setBounds(700, 40, 80, 80);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        };
        Thread loopThread = new Thread(loopTask);
        loopThread.start();
        */

        // Header
        JPanel headPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headPanel.setBackground(Color.WHITE);
        headPanel.add(new JLabel("<html><body><p style = 'font-size: 40px;'>&nbsp;&nbsp;Hello :D </p></html>"));
        headPanel.setBounds(0, 40, 800, 80);

        JLabel stringLabel = new JLabel("<html><font color = 'white'><body><p style = 'font-size: 10px;'>&nbsp;Java Tools Launcher </p></font></html>");
        stringLabel.setBounds(80, 120, 200, 30);
        
        // Date
        JLabel dateLabel = new JLabel(showDate);
        dateLabel.setBounds(0, 270, 200, 30);

        // Button Reg
        regButton.setBounds(660, 270, 100, 30);
        regButton.setFocusable(false);
        regButton.addActionListener(this);

        // Button Run
        runButton.setBounds(550, 270, 100, 30);
        runButton.setFocusable(false);
        runButton.addActionListener(this);

        JPanel lowPanel = new JPanel();
        lowPanel.setBackground(Color.BLACK);
        lowPanel.setBounds(0, 250, 800, 350);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(800, 350);
        frame.getContentPane().setBackground(new Color(80, 80, 80));
        frame.setVisible(true);
        //frame.add(anim);
        frame.add(headPanel);
        frame.add(stringLabel);
        frame.add(dateLabel);
        frame.add(regButton);
        frame.add(runButton);
        frame.add(lowPanel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==regButton){
            RegJava regJava = new RegJava();
            frame.dispose();
            }
        if(e.getSource()==runButton){
            Main main = new Main();
            frame.dispose();
            main.mainExecutor();
        }
    }
}

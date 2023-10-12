   // MultiTools v0.3 Beta -   29/8/23


import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MultiTools_v03 {
    public static void main(String[] args){
        DecimalFormat df = new DecimalFormat("#.###################");
//  Intro
        UIManager.put("OptionPane.okButtonText", "Masuk");
        Locale BInd = new Locale("id", "ID");
        LocalDate Date = LocalDate.now();
        String Hari = Date.getDayOfWeek().getDisplayName(TextStyle.FULL, BInd);
        String Bulan = Date.getMonth().getDisplayName(TextStyle.FULL, BInd);
        int Tanggal = Date.getDayOfMonth();
        int Tahun = Date.getYear();
        String IntroText =String.format(
            "<html><body><p style='font-size: 17px;'>Hello!</p></html>\n"+
            "\n"+
            "   Version 0.3 :\n"+
            "           - Tampilan berubah\n"+
            "           - Tambahan menu\n"+
            "           - Awal menggunakan GUI\n"+
            "\n"+
            "<html><body><p style='font-size: 7px;'><pre>                               %s, %s %s %s</pre></p></body></html>", Hari, Tanggal, Bulan, Tahun);
        String[] MethodIntro = {"Masuk"};
        JOptionPane.showOptionDialog(null, IntroText, "Selamat Datang!", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, MethodIntro, 0);

// Main Menu
        while(true){
            UIManager.put("OptionPane.cancelButtonText", "Keluar");
            UIManager.put("OptionPane.okButtonText", "Masukan");
            String MainMenu =
                "<html><body><p style='font-size: 15px;'> Main Menu</p></html>\n"+
                "\n"+
                "A = Pengetahuan\n"+
                "B = Operasi Matematika\n"+
                "C = Tentang\n"+
                "\n";
            String InputMainMenu = JOptionPane.showInputDialog(null, MainMenu, "Masukan Pilihan", JOptionPane.QUESTION_MESSAGE);
            if(InputMainMenu == null){
                UIManager.put("OptionPane.okButtonText", "Bye!");
                JOptionPane.showMessageDialog(null, "Goodbye! Semoga Harimu Menyenangkan!\n(Tidak bertemu kalkulus hehe)", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }else if(InputMainMenu.equalsIgnoreCase("A")){
                System.out.println("(Under Construct)");
            }else if(InputMainMenu.equalsIgnoreCase("B")){
                
// Menu Operasi Matematika
            while(true){
                UIManager.put("OptionPane.cancelButtonText", "Kembali");
                String OperasiMatematika = ""+
                    "<html><body><p style='font-size: 15px;'> Operasi Matematika</p></html>\n"+
                    "\n"+
                    "A = Bangun Datar\n"+
                    "B = Bangun Ruang\n"+
                    "C = Segitiga Istimewa\n "+
                    "\n";
                String InputOpMtk = JOptionPane.showInputDialog(null, OperasiMatematika, "Masukan Pilihan", JOptionPane.QUESTION_MESSAGE);
                if(InputOpMtk == null){
                    break;
                }else if(InputOpMtk.equalsIgnoreCase("A")){
                    
    //  Bangun Datar
                    while(true){
                        String BangunDatar = ""+
                            "<html><body><p style='font-size: 15px;'> Bangun Datar</p></html>\n"+
                            "\n"+
                            "A = Persegi\n"+
                            "B = Persegi Panjang\n"+
                            "C = Jajargenjang\n"+
                            "D = Segitiga\n"+
                            "E = Belah Ketupat\n"+
                            "F = Layang-Layang\n"+
                            "G = Trapesium\n"+
                            "H = Lingkaran\n"+
                            "\n";
                        String BangunDatarInput = JOptionPane.showInputDialog(null, BangunDatar, "Bangun Datar", JOptionPane.QUESTION_MESSAGE);
                        if (BangunDatarInput == null){
                            break;
                        }else if(BangunDatarInput.equalsIgnoreCase("A")){

                            // Persegi
                            JTextField KotakInput1 = new JTextField();
                            while(true){
                                JPanel Panel = new JPanel();
                                Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
                                Panel.add(new JLabel("<html><body><p style='font-size: 15px;'> Persegi</p></html>"));
                                Panel.add(new JLabel("\n"));
                                Panel.add(new JLabel("Masukan s (sisi)"));
                                Panel.add(KotakInput1);
                                int InputPersegi = JOptionPane.showConfirmDialog(null, Panel, "Masukan Input", JOptionPane.OK_CANCEL_OPTION);
                                try{
                                    if(InputPersegi==JOptionPane.OK_OPTION){
                                        UIManager.put("OptionPane.okButtonText", "Oke");
                                        String IP = KotakInput1.getText();
                                        double Persegis = Double.parseDouble(IP);
                                        double OperasiL1 = Math.pow(Persegis, 2);
                                        double OperasiK1 = Persegis*4;
                                        String L = df.format(OperasiL1);
                                        String K = df.format(OperasiK1);
                                        String showResult = String.format("Luas = %s\nKeliling = %s", L, K);
                                        JOptionPane.showMessageDialog(null, showResult, "Hasil", JOptionPane.WARNING_MESSAGE);
                                    }else if(InputPersegi==JOptionPane.CANCEL_OPTION){
                                        break;
                                    }
                                }catch(NumberFormatException e){
                                    UIManager.put("OptionPane.okButtonText", "Oke");
                                    JOptionPane.showMessageDialog(null, "Salah", "Peringatan", JOptionPane.ERROR_MESSAGE);
                                }  
                            }   // END

                        }else if(BangunDatarInput.equalsIgnoreCase("B")){

                            //  Persegi Panjang
                            JTextField BoxInput1 = new JTextField();
                            JTextField BoxInput2 = new JTextField();
                            while(true){
                                JPanel Panel = new JPanel();
                                Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
                                Panel.add(new JLabel("<html><body><p style='font-size: 15px;'> Persegi Panjang</p></html>"));
                                Panel.add(new JLabel("\n"));
                                Panel.add(new JLabel("Masukan p (panjang)"));
                                Panel.add(BoxInput1);
                                Panel.add(new JLabel("Masukan l (lebar)"));
                                Panel.add(BoxInput2);
                                int Input = JOptionPane.showConfirmDialog(null, Panel, "Masukan Input", JOptionPane.OK_CANCEL_OPTION);
                                try{
                                    if(Input==JOptionPane.OK_OPTION){
                                        String GetValue1 = BoxInput1.getText();
                                        String GetValue2 = BoxInput2.getText();
                                        double Value1 = Double.parseDouble(GetValue1);
                                        double Value2 = Double.parseDouble(GetValue2);
                                        double OperasiLF = Value1*Value2;
                                        double OperasiKF = 2*(Value1*Value2);
                                        String L = df.format(OperasiLF);
                                        String K = df.format(OperasiKF);
                                        String showResult = String.format("Luas = %s\nKeliling = %s", L, K);
                                        JOptionPane.showMessageDialog(null, showResult, "Hasil", JOptionPane.WARNING_MESSAGE);
                                    }else if(Input==JOptionPane.CANCEL_OPTION){
                                        break;
                                    }
                                }catch(NumberFormatException e){
                                    UIManager.put("OptionPane.okButtonText", "Oke");
                                    JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                                }  
                            }// END PP MENU
                            
                        }else if(BangunDatarInput.equalsIgnoreCase("C")){

                            //  Jajargenjang
                            while(true){
                                String OpsiJajargenjang =
                                    "Ingin mencari Luas atau Keliling?"+
                                    "\n"+
                                    "L = Luas\n"+
                                    "K = Keliling\n";
                                String InpMJ = JOptionPane.showInputDialog(null, OpsiJajargenjang, "Pilihan Operasi", JOptionPane.QUESTION_MESSAGE);
                                if(InpMJ==null){
                                    break;
                                }else if(InpMJ.equalsIgnoreCase("L")){
                                    JTextField BoxInput1 = new JTextField();
                                    JTextField BoxInput2 = new JTextField();
                                    while(true){
                                        JPanel Panel = new JPanel();
                                        Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
                                        Panel.add(new JLabel("<html><body><p style='font-size: 15px;'> L. Jajargenjang</p></html>"));
                                        Panel.add(new JLabel("\n"));
                                        Panel.add(new JLabel("Masukan a (alas)"));
                                        Panel.add(BoxInput1);
                                        Panel.add(new JLabel("Masukan t (tinggi)"));
                                        Panel.add(BoxInput2);
                                        int Input = JOptionPane.showConfirmDialog(null, Panel, "Masukan Input", JOptionPane.OK_CANCEL_OPTION);
                                        try{
                                            if(Input==JOptionPane.OK_OPTION){
                                                UIManager.put("OptionPane.okButtonText", "Oke");
                                                String GetValue1 = BoxInput1.getText();
                                                String GetValue2 = BoxInput2.getText();
                                                double Value1 = Double.parseDouble(GetValue1);
                                                double Value2 = Double.parseDouble(GetValue2);
                                                double OperasiLF = Value1*Value2;
                                                String L = df.format(OperasiLF);
                                                String showResult = String.format("Luas = %s", L);
                                                JOptionPane.showMessageDialog(null, showResult, "Hasil", JOptionPane.WARNING_MESSAGE);
                                            }else if(Input==JOptionPane.CANCEL_OPTION){
                                                break;
                                            }
                                        }catch(NumberFormatException e){
                                            UIManager.put("OptionPane.okButtonText", "Oke");
                                            JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                                        }  
                                    }
                                }else if(InpMJ.equalsIgnoreCase("K")){
                                    JTextField BoxInput1 = new JTextField();
                                    JTextField BoxInput2 = new JTextField();
                                    while(true){
                                        JPanel Panel = new JPanel();
                                        Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
                                        Panel.add(new JLabel("<html><body><p style='font-size: 15px;'> K. Jajargenjang</p></html>"));
                                        Panel.add(new JLabel("\n"));
                                        Panel.add(new JLabel("Masukan a (alas)"));
                                        Panel.add(BoxInput1);
                                        Panel.add(new JLabel("Masukan sm (sisi miring)"));
                                        Panel.add(BoxInput2);
                                        int Input = JOptionPane.showConfirmDialog(null, Panel, "Masukan Input", JOptionPane.OK_CANCEL_OPTION);
                                        try{
                                            if(Input==JOptionPane.OK_OPTION){
                                                UIManager.put("OptionPane.okButtonText", "Oke");
                                                String GetValue1 = BoxInput1.getText();
                                                String GetValue2 = BoxInput2.getText();
                                                double Value1 = Double.parseDouble(GetValue1);
                                                double Value2 = Double.parseDouble(GetValue2);
                                                double OperasiKF = 2*(Value1+Value2);
                                                String K = df.format(OperasiKF);
                                                String showResult = String.format("Keliiling = %s", K);
                                                JOptionPane.showMessageDialog(null, showResult, "Hasil", JOptionPane.WARNING_MESSAGE);
                                            }else if(Input==JOptionPane.CANCEL_OPTION){
                                                break;
                                            }
                                        }catch(NumberFormatException e){
                                            UIManager.put("OptionPane.okButtonText", "Oke");
                                            JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                                        }  
                                    }
                                }else{
                                    UIManager.put("OptionPane.okButtonText", "Oke");
                                    JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                                }
                            }// END JJ MENU

                        }else if(BangunDatarInput.equalsIgnoreCase("D")){
                           
                            //Segitiga Samasisi
                            JTextField BoxInput1 = new JTextField();
                            JTextField BoxInput2 = new JTextField();
                            while(true){
                                JPanel Panel = new JPanel();
                                Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
                                Panel.add(new JLabel("<html><body><p style='font-size: 15px;'> Segitiga SS</p></html>"));
                                Panel.add(new JLabel("\n"));
                                Panel.add(new JLabel("Masukan a (alas)"));
                                Panel.add(BoxInput1);
                                Panel.add(new JLabel("Masukan t (tinggi)"));
                                Panel.add(BoxInput2);
                                int Input = JOptionPane.showConfirmDialog(null, Panel, "Masukan Input", JOptionPane.OK_CANCEL_OPTION);
                                try{
                                    if(Input==JOptionPane.OK_OPTION){
                                        UIManager.put("OptionPane.okButtonText", "Oke");
                                        String GetValue1 = BoxInput1.getText();
                                        String GetValue2 = BoxInput2.getText();
                                        double Value1 = Double.parseDouble(GetValue1);
                                        double Value2 = Double.parseDouble(GetValue2);
                                        double OperasiLF = (Value1+Value2)/2;
                                        double OperasiK1 = Value1/2;
                                        double OperasiK2 = Math.sqrt(Math.pow(OperasiK1, 2)+Math.pow(Value2, 2));
                                        double OperasiKF = Value1+2*(OperasiK2);
                                        String L = df.format(OperasiLF);
                                        String K = df.format(OperasiKF);
                                        String showResult = String.format("Luas = %s\nKeliling = %s", L, K);
                                        JOptionPane.showMessageDialog(null, showResult, "Hasil", JOptionPane.WARNING_MESSAGE);
                                    }else if(Input==JOptionPane.CANCEL_OPTION){
                                        break;
                                    }
                                }catch(NumberFormatException e){
                                    UIManager.put("OptionPane.okButtonText", "Oke");
                                    JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                                }  
                            }// END SS MENU

                        }else if(BangunDatarInput.equalsIgnoreCase("E")){

                            //  Belah Ketupat
                            JTextField BoxInput1 = new JTextField();
                            JTextField BoxInput2 = new JTextField();
                            while(true){
                                JPanel Panel = new JPanel();
                                Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
                                Panel.add(new JLabel("<html><body><p style='font-size: 15px;'> Belah Ketupat</p></html>"));
                                Panel.add(new JLabel("\n"));
                                Panel.add(new JLabel("Masukan d1 (diagonal 1)"));
                                Panel.add(BoxInput1);
                                Panel.add(new JLabel("Masukan d2 (diagonal 2)"));
                                Panel.add(BoxInput2);
                                int Input = JOptionPane.showConfirmDialog(null, Panel, "Masukan Input", JOptionPane.OK_CANCEL_OPTION);
                                try{
                                    if(Input==JOptionPane.OK_OPTION){
                                        UIManager.put("OptionPane.okButtonText", "Oke");
                                        String GetValue1 = BoxInput1.getText();
                                        String GetValue2 = BoxInput2.getText();
                                        double Value1 = Double.parseDouble(GetValue1);
                                        double Value2 = Double.parseDouble(GetValue2);
                                        double OperasiLF = (Value1*Value2)/2;
                                        double OperasiKF = 4*(Math.sqrt(((Value1/2)*(Value1/2))+((Value2/2)*(Value2/2))));
                                        String L = df.format(OperasiLF);
                                        String K = df.format(OperasiKF);
                                        String showResult = String.format("Luas = %s\nKeliling = %s", L, K);
                                        JOptionPane.showMessageDialog(null, showResult, "Hasil", JOptionPane.WARNING_MESSAGE);
                                    }else if(Input==JOptionPane.CANCEL_OPTION){
                                        break;
                                    }
                                }catch(NumberFormatException e){
                                    UIManager.put("OptionPane.okButtonText", "Oke");
                                    JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                                }  
                            }// END BK MENU
                            
                        }else if(BangunDatarInput.equalsIgnoreCase("F")){

                            //  
                            JTextField BoxInput1 = new JTextField();
                            JTextField BoxInput2 = new JTextField();
                            while(true){
                                JPanel Panel = new JPanel();
                                Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
                                Panel.add(new JLabel("<html><body><p style='font-size: 15px;'> Persegi</p></html>"));
                                Panel.add(new JLabel("\n"));
                                Panel.add(new JLabel("Masukan s (sisi)"));
                                Panel.add(BoxInput1);
                                Panel.add(new JLabel("Masukan l (lebar)"));
                                Panel.add(BoxInput2);
                                int Input = JOptionPane.showConfirmDialog(null, Panel, "Masukan Input", JOptionPane.OK_CANCEL_OPTION);
                                try{
                                    if(Input==JOptionPane.OK_OPTION){
                                        UIManager.put("OptionPane.okButtonText", "Oke");
                                        String GetValue1 = BoxInput1.getText();
                                        String GetValue2 = BoxInput2.getText();
                                        double Value1 = Double.parseDouble(GetValue1);
                                        double Value2 = Double.parseDouble(GetValue2);
                                        double OperasiLF = (Value1*Value2)/2;
                                        String L = df.format(OperasiLF);
                                        String showResult = String.format("Luas = %s\nKeliling = (Gunakan Operasi Segitiga)", L);
                                        JOptionPane.showMessageDialog(null, showResult, "Hasil", JOptionPane.WARNING_MESSAGE);
                                    }else if(Input==JOptionPane.CANCEL_OPTION){
                                        break;
                                    }
                                }catch(NumberFormatException e){
                                    UIManager.put("OptionPane.okButtonText", "Oke");
                                    JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                                }  
                            }// END LL MENU
                            
                        }else if(BangunDatarInput.equalsIgnoreCase("G")){

                            // Trapesium
                            JTextField BoxInput1 = new JTextField();
                            JTextField BoxInput2 = new JTextField();
                            JTextField BoxInput3 = new JTextField();
                            while(true){
                                JPanel Panel = new JPanel();
                                Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
                                Panel.add(new JLabel("<html><body><p style='font-size: 15px;'> Trapesium</p></html>"));
                                Panel.add(new JLabel("\n"));
                                Panel.add(new JLabel("Masukan a (alas)"));
                                Panel.add(BoxInput1);
                                Panel.add(new JLabel("Masukan b (alas atas)"));
                                Panel.add(BoxInput2);
                                Panel.add(new JLabel("Masukan t (tinggi)"));
                                Panel.add(BoxInput3);
                                int Input = JOptionPane.showConfirmDialog(null, Panel, "Masukan Input", JOptionPane.OK_CANCEL_OPTION);
                                try{
                                    if(Input==JOptionPane.OK_OPTION){
                                        UIManager.put("OptionPane.okButtonText", "Oke");
                                        String GetValue1 = BoxInput1.getText();
                                        String GetValue2 = BoxInput2.getText();
                                        String GetValue3 = BoxInput3.getText();
                                        double Value1 = Double.parseDouble(GetValue1);
                                        double Value2 = Double.parseDouble(GetValue2);
                                        double Value3 = Double.parseDouble(GetValue3);
                                        double OperasiLF = ((Value1+Value2)/2)*Value3;
                                        double OperasiKF = Value1+Value2+(2*(Math.sqrt(((Value1-Value2)*(Value1-Value2))+(Value3*Value3))));
                                        String L = df.format(OperasiLF);
                                        String K = df.format(OperasiKF);
                                        String showResult = String.format("Luas = %s\nKeliling = %s", L, K);
                                        JOptionPane.showMessageDialog(null, showResult, "Hasil", JOptionPane.WARNING_MESSAGE);
                                    }else if(Input==JOptionPane.CANCEL_OPTION){
                                        break;
                                    }
                                }catch(NumberFormatException e){
                                    UIManager.put("OptionPane.okButtonText", "Oke");
                                    JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                                }  
                            }// END TRP MENU

                        }else if(BangunDatarInput.equalsIgnoreCase("H")){

                            //  Lingkaran
                            JTextField BoxInput1 = new JTextField();
                            while(true){
                                JPanel Panel = new JPanel();
                                Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
                                Panel.add(new JLabel("<html><body><p style='font-size: 15px;'> Lingkaran</p></html>"));
                                Panel.add(new JLabel("\n"));
                                Panel.add(new JLabel("Masukan s (sisi)"));
                                Panel.add(BoxInput1);
                                Panel.add(new JLabel("Masukan l (lebar)"));
                                Panel.add(BoxInput2);
                                int Input = JOptionPane.showConfirmDialog(null, Panel, "Masukan Input", JOptionPane.OK_CANCEL_OPTION);
                                try{
                                    if(Input==JOptionPane.OK_OPTION){
                                        UIManager.put("OptionPane.okButtonText", "Oke");
                                        String GetValue1 = BoxInput1.getText();
                                        double Value1 = Double.parseDouble(GetValue1);
                                        double OperasiLF = 3.14*Math.pow(Value1, 2);
                                        double OperasiKF = 2*3.14*Value1;
                                        String L = df.format(OperasiLF);
                                        String K = df.format(OperasiKF);
                                        String showResult = String.format("Luas = %s\nKeliling = %s", L, K);
                                        JOptionPane.showMessageDialog(null, showResult, "Hasil", JOptionPane.WARNING_MESSAGE);
                                    }else if(Input==JOptionPane.CANCEL_OPTION){
                                        break;
                                    }
                                }catch(NumberFormatException e){
                                    UIManager.put("OptionPane.okButtonText", "Oke");
                                    JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                                }  
                            }
                        }else{
                            UIManager.put("OptionPane.okButtonText", "Oke");
                            JOptionPane.showMessageDialog(null, "Perintah Invalid!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
                        }

                    }// END BD MENU

                }else if(InputOpMtk.equalsIgnoreCase("B")){
                    
    //  Bangun Ruang              
                    while(true){
                        String BangunRuang =
                            "<html><body><p style='font-size: 15px;'> Bangun Ruang</p></html>\n"+
                            "\n"+
                            "A = Kubus\n"+
                            "B = Balok\n"+
                            "C = Limas Segiempat\n"+
                            "D = Prisma Segiempata\n"+
                            "E = Limas Segitiga\n"+
                            "F = Silinder\n"+
                            "G = Kerucut\n"+
                            "H = Bola\n"+
                            "\n";
                        String BangunRuangInput = JOptionPane.showInputDialog(null, BangunRuang, "Bangun Ruang", JOptionPane.QUESTION_MESSAGE);
                        if(BangunRuangInput == null){
                            break;
                        }else if(BangunRuangInput.equalsIgnoreCase("A")){
                            System.out.println("(Coming Soon)");
                        }else if(BangunRuangInput.equalsIgnoreCase("B")){
                            System.out.println("(Coming Soon)");
                        }else if(BangunRuangInput.equalsIgnoreCase("C")){
                            System.out.println("(Coming Soon)");
                        }else if(BangunRuangInput.equalsIgnoreCase("D")){
                            System.out.println("(Coming Soon)");
                        }else if(BangunRuangInput.equalsIgnoreCase("E")){
                            System.out.println("(Coming Soon)");
                        }else if(BangunRuangInput.equalsIgnoreCase("F")){
                            System.out.println("(Coming Soon)");
                        }else if(BangunRuangInput.equalsIgnoreCase("G")){
                            System.out.println("(Coming Soon)");
                        }else if(BangunRuangInput.equalsIgnoreCase("H")){
                            System.out.println("(Coming Soon)");
                        }else{
                            UIManager.put("OptionPane.okButtonText", "Oke");
                            JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                        }
                    }// END BR MENU

                }else if(InputOpMtk.equalsIgnoreCase("C")){

    //  Segitiga Istimewa
                    while(true){

        //  Phytagoras
                        String SegitigaMenu =
                            "<html><body><p style='font-size: 15px;'> Segitiga Istimewa</p></html>\n"+
                            "\n"+
                            "A = Phytagoras";
                        String SegitigaInput = JOptionPane.showInputDialog(null, SegitigaMenu, "Segitiga Istimewa", JOptionPane.QUESTION_MESSAGE);
                        if(SegitigaInput == null){
                            break;
                        }else if(SegitigaInput.equalsIgnoreCase("A")){
                            System.out.println("(Coming Soon)");
                        }else{
                            UIManager.put("OptionPane.okButtonText", "Oke");
                            JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                        }
                    }// END S MENU

                }else{
                    UIManager.put("OptionPane.okButtonText", "Oke");
                    JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
                }
            }
            }else if(InputMainMenu.equalsIgnoreCase("C")){
                
// Tentang
                UIManager.put("OptionPane.okButtonText", "Kembali");
                String Tentang =
                    "<html><body><p style='font-size: 15px;'> Tentang</p></html>\n"+
                    "\n"+
                    "Selamat datang! Saya adalah Sayboki, atau Amalul. :D\n"+
                    "<html><br><center>"+
                    "MultiTools merupakan program yang dibuat dengan tujuan untuk membantu menyelesaikan tugas kuliah.<br>"+
                    "tools ini juga direncanakan bisa menjadi sebuah cheat code jika saya mampu membuatnya lebih komplit.<br>"+
                    "Program ini akan berkembang mengikuti apa yang dipelajari saat MK Programming dan tentu saja niat hehe.<br>"+
                    "Selamat Menggunakan walau banyak bug!<br>"+
                    "<br></center></html>";
                JOptionPane.showMessageDialog(null, Tentang, "punten", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Perintah Invalid!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
            }

        }

    }
}
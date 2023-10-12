import javax.swing.*;
import java.text.*;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Monetary {

    //  Nama Angka
    private static final String[] GreenSheetan = {
        "",  "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
    };
    private static final String[] belasan = {
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] puluhan = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Eighty", "Ninety"
    };

    public static String Converter(long angka){
        if (angka == 0){
            return "Zero";
        }
        return  ConverterSystem(angka);
    }

    //  Proses Penamaan Angka
    private static String ConverterSystem(long angka){
        String kata = "";
        if(angka < 10){
            kata = GreenSheetan[(int) angka];
        }else if(angka < 20){
            kata = belasan[(int) (angka - 10)];
        }else if(angka < 100){
            kata = puluhan[(int) (angka / 10)] +""+ GreenSheetan[(int) (angka % 10)];
        }else if(angka < 1000){
            kata = GreenSheetan[(int) (angka/100)] + " Hundred " + ConverterSystem(angka % 100);
        }else if(angka < 1000000){
            kata = ConverterSystem(angka / 1000) + " Thousand " + ConverterSystem(angka % 1000);
        }else if(angka < 1000000000){
            kata = ConverterSystem(angka / 1000000) + " Million " + ConverterSystem(angka % 1000000);
        }else{
            kata = ConverterSystem(angka / 1000000000) + " Billion " + ConverterSystem(angka % 1000000000);
        }
        return kata.trim();
    }
    public static void main(String[] args){
        UIManager.put("OptionPane.okButtonText", "Enter");
        UIManager.put("OptionPane.cancelButtonText", "Exit");
        JTextField BoxInput = new JTextField();
        JPanel Panel = new JPanel();
        Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
        Panel.add(new JLabel("Input your number :"));
        Panel.add(BoxInput);
        while(true){
            int InputAngka = JOptionPane.showConfirmDialog(null, Panel, "Input", JOptionPane.OK_CANCEL_OPTION);
            try{
                if(InputAngka==JOptionPane.OK_OPTION){
                    String GetValue = BoxInput.getText();
                    long nilai = Long.parseLong(GetValue);
                    NumberFormat formatuang = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
                    String uang = formatuang.format(nilai);
                    String convuang = Converter(nilai);
                    String uangWords = convuang.substring(0, 1).toUpperCase() + convuang.substring(1).toLowerCase();

                    long Cash = Long.parseLong(GetValue);
                    long RedSheet = 0;       long YellowSheet = 0;       long Gopek = 0;
                    long BlueSheet = 0;      long LightBlueSheet = 0;    long Jipek = 0;
                    long PurpleSheet = 0;    long GreenSheet = 0;        long Cepek = 0;
                    RedSheet = Cash / 100000;
                    Cash = Cash % 100000;
                    BlueSheet = Cash / 50000;
                    Cash = Cash % 50000;
                    PurpleSheet = Cash / 10000;
                    Cash = Cash % 10000;
                    YellowSheet = Cash / 5000;
                    Cash = Cash % 5000;
                    LightBlueSheet = Cash / 2000;
                    Cash = Cash % 2000;
                    GreenSheet = Cash / 1000;
                    Cash = Cash % 1000;
                    Gopek = Cash / 500;
                    Cash = Cash % 500;
                    Jipek = Cash / 200;
                    Cash = Cash % 200;
                    Cepek = Cash / 100;
                    String S100Rb = (RedSheet==0) ? "" : RedSheet+"x One hundred thousand rupiah\n";
                    String S50Rb = (BlueSheet==0) ? "" : BlueSheet+"x Fifty thousand rupiah\n";
                    String S10Rb = (PurpleSheet==0) ? "" : PurpleSheet+"x Ten thousand rupiah\n";
                    String S5Rb = (YellowSheet==0) ? "" : YellowSheet+"x Five thousand rupiah\n";
                    String S2Rb = (LightBlueSheet==0) ? "" : LightBlueSheet+"x Two thousand rupiah\n";
                    String S1Rb = (GreenSheet==0) ? "" : GreenSheet+"x One thousand rupiah\n";
                    String S5R = (Gopek==0) ? "" : Gopek+"x Five hundred coins\n";
                    String S2R = (Jipek==0) ? "" : Jipek+"x Two hundred coins\n";
                    String S1R = (Cepek==0) ? "" : Cepek+"x One hundred coins\n";

                    UIManager.put("OptionPane.okButtonText", "Ok");
                    String hasil = String.format("Input :\n%s\n\nIn Words :\n%s Rupiah\n\nNumber of money :\n%s%s%s%s%s%s%s%s%s", uang, uangWords, S100Rb, S50Rb, S10Rb, S5Rb, S2Rb, S1Rb, S5R, S2R, S1R);
                    JOptionPane.showMessageDialog(null, hasil, "Result", JOptionPane.INFORMATION_MESSAGE);
                }else if(InputAngka==JOptionPane.CANCEL_OPTION){
                    System.exit(0);
                }
            }catch(NumberFormatException e){
                UIManager.put("OptionPane.okButtonText", "Ok");
                JOptionPane.showMessageDialog(null, "Wrong Input!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
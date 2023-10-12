import javax.swing.*;
import java.util.Locale;
import java.text.*;

public class Loans {
    public static void main(String[] args){
        while(true){
        UIManager.put("OptionPane.okButtonText", "Enter");
        UIManager.put("OptionPane.cancelButtonText", "Exit");
        JTextField InputLoan = new JTextField();
        JTextField InputInterestRate = new JTextField();
        JTextField InputYears = new JTextField();
        JPanel Panel = new JPanel();
        Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
        Panel.add(new JLabel("Input Loans"));
        Panel.add(InputLoan);
        Panel.add(new JLabel("Input Interest Rate %"));
        Panel.add(InputInterestRate);
        Panel.add(new JLabel("Input Years"));
        Panel.add(InputYears);
        int Input = JOptionPane.showConfirmDialog(null, Panel, "Loans Calculator", JOptionPane.OK_CANCEL_OPTION);
            try{
                if(Input==JOptionPane.YES_OPTION){
                    String GetLoan = InputLoan.getText();
                    String GetInterestRate = InputInterestRate.getText();
                    String GetYears = InputYears.getText();
                    double LoanPercent = Double.parseDouble(GetLoan);
                    double InterestRate = Double.parseDouble(GetInterestRate);
                    double Years = Double.parseDouble(GetYears);
                    double Loan = LoanPercent/100;
                    double Monthly = (Loan*InterestRate)/(1-(1/Math.pow(1+InterestRate,(Years*12))));
                    double Total = Monthly*12;

                    NumberFormat formatuang = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
                    String MonthlyRp = formatuang.format(Monthly);
                    String TotalRp = formatuang.format(Total);
                    String Result = String.format("Monthly Payment =   %s Rupiah\nTotal Payment =   %s Rupiah", MonthlyRp, TotalRp);

                    UIManager.put("OptionPane.okButtonText", "OK");
                    JOptionPane.showMessageDialog(null, Result, "Output", JOptionPane.INFORMATION_MESSAGE);
                }else if(Input==JOptionPane.CANCEL_OPTION){
                    System.exit(0);
                }
            }catch(NumberFormatException e){
                UIManager.put("OptionPane.okButtonText", "Oke");
                JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

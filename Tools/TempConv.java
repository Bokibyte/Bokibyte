import javax.swing.*;
import java.text.*;

public class TempConv {
    public static void main(String[] args){
        DecimalFormat df = new DecimalFormat("#.###################");
        JTextField BoxInput = new JTextField();
        String[] Temp = {"Celcius", "Farenheit", "Reamur", "Kelvin"};
        JComboBox<String> TempFrom = new JComboBox<>(Temp);
        JComboBox<String> TempTo = new JComboBox<>(Temp);
        JPanel Panel = new JPanel();
        Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
        Panel.add(new JLabel("Input"));
        Panel.add(BoxInput);
        Panel.add(TempFrom);
        Panel.add(new JLabel("Convert to"));
        Panel.add(TempTo);
        while(true){
            UIManager.put("OptionPane.cancelButtonText", "Exit");
            UIManager.put("OptionPane.okButtonText", "Enter");
            int Input = JOptionPane.showConfirmDialog(null, Panel, "Temp Converter", JOptionPane.OK_CANCEL_OPTION);
            try{
                if(Input==JOptionPane.OK_OPTION){
                    String ConvFrm ="";
                    String ConvTo = "";
                    String degree = "";
                    double Result = 0;
                    String ChoiceFrom = (String) TempFrom.getSelectedItem();
                    String ChoiceTo = (String) TempTo.getSelectedItem();

                    if(ChoiceFrom=="Celcius"){
                        ConvFrm = "Celcius";
                        if(ChoiceTo=="Celcius"){
                            degree = "\u00B0C";
                            ConvTo = "Celcius";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Celcius = Value;
                            Result = Celcius;
                        }else if(ChoiceTo=="Farenheit"){
                            degree = "\u00B0F";
                            ConvTo = "Farenheit";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Farenheit = (Value*9/5)+32;
                            Result = Farenheit;
                        }else if(ChoiceTo=="Reamur"){
                            degree = "\u00B0R";
                            ConvTo = "Reamur";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Reamur = Value*4/5;
                            Result = Reamur;
                        }else if(ChoiceTo=="Kelvin"){
                            degree = " K";
                            ConvTo = "Kelvin";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Kelvin = Value+273.15;
                            Result = Kelvin;
                        }
                    }else if(ChoiceFrom=="Farenheit"){
                        ConvFrm = "Farenheit";
                        if(ChoiceTo=="Celcius"){
                            degree = "\u00B0C";
                            ConvTo = "Celcius";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Celcius = (Value-32)*5/9;
                            Result = Celcius;
                        }else if(ChoiceTo=="Farenheit"){
                            degree = "\u00B0F";
                            ConvTo = "Farenheit";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Farenheit = Value;
                            Result = Farenheit;
                        }else if(ChoiceTo=="Reamur"){
                            degree = "\u00B0R";
                            ConvTo = "Reamur";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Reamur = (Value-32)*4/9;
                            Result = Reamur;
                        }else if(ChoiceTo=="Kelvin"){
                            degree = " K";
                            ConvTo = "Kelvin";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Kelvin = (Value-32)*5/9+273.15;
                            Result = Kelvin;
                        }
                    }else if(ChoiceFrom=="Reamur"){
                        ConvFrm = "Reamur";
                        if(ChoiceTo=="Celcius"){
                            degree = "\u00B0C";
                            ConvTo = "Celcius";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Celcius = Value*5/9;
                            Result = Celcius;
                        }else if(ChoiceTo=="Farenheit"){
                            degree = "\u00B0F";
                            ConvTo = "Farenheit";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Farenheit = (Value*9/4)+32;
                            Result = Farenheit;
                        }else if(ChoiceTo=="Reamur"){
                            degree = "\u00B0R";
                            ConvTo = "Reamur";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Reamur = Value;
                            Result = Reamur;
                        }else if(ChoiceTo=="Kelvin"){
                            degree = " K";
                            ConvTo = "Kelvin";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Kelvin = (Value*5/4)+273.15;
                            Result = Kelvin;
                        }
                    }else if(ChoiceFrom=="Kelvin"){
                        ConvFrm = "Kelvin";
                        if(ChoiceTo=="Celcius"){
                            degree = "\u00B0C";
                            ConvTo = "Celcius";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Celcius = Value-273.15;
                            Result = Celcius;
                        }else if(ChoiceTo=="Farenheit"){
                            degree = "\u00B0F";
                            ConvTo = "Farenheit";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Farenheit = (Value-273.15)*9/5+32;
                            Result = Farenheit;
                        }else if(ChoiceTo=="Reamur"){
                            degree = "\u00B0R";
                            ConvTo = "Reamur";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Reamur = (Value-273.15)*4/5;
                            Result = Reamur;
                        }else if(ChoiceTo=="Kelvin"){
                            degree = " K";
                            ConvTo = "Kelvin";
                            String GetValue = BoxInput.getText();
                            double Value = Double.parseDouble(GetValue);
                            double Kelvin = Value;
                            Result = Kelvin;
                        }
                    }

                    UIManager.put("OptionPane.okButtonText", "Ok");
                    String Format = df.format(Result);
                    String showResult = "Temp : "+Format+degree;
                    JOptionPane.showMessageDialog(null, showResult, ConvFrm+" -> "+ConvTo, JOptionPane.INFORMATION_MESSAGE);

                }else if(Input==JOptionPane.CANCEL_OPTION){
                    System.exit(0);
                }
            }catch(NumberFormatException e){
                UIManager.put("OptionPane.okButtonText", "Ok");
                JOptionPane.showMessageDialog(null, "Input Salah!", "Peringatan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

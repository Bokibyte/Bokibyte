
// Assumption :
// if input are not in same type, then a message will be displayed.
// if money is not enough to make a purchase, then a message will be displayed.

import javax.swing.*;
public class CoffeeShop {
    public static void main(String[]args){
        int money = 0;
        while(money == 0){
            String input = JOptionPane.showInputDialog(null, "Enter your money (USD)");
            if(input == null){
                break;
            }else{
                try{
                    money = Integer.parseInt(input);
                    if(money < 0){
                        JOptionPane.showMessageDialog(null, "Wrong input, input again", "Information", JOptionPane.WARNING_MESSAGE);
                    }else{
                        break;
                    }
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Wrong input, input again", "Information", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        while(true){
            money = menu(money);
            if(money >= 20){
                int x = JOptionPane.showConfirmDialog(null, "Do you want to order again?", "Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(x == JOptionPane.CANCEL_OPTION){
                    break;
                }
            }else{
                break;
            }
        }
    }

    static int menu(int money){
        String a = "Black Coffee";
        int pa = 10;
        String b = "Coffee Latte";
        int pb = 14;
        String c = "Matcha Latte";
        int pc = 16;
        String d = "Dolce Latte";
        int pd = 18;
        String order = "";
        int price = 0;
        boolean isMenu = true;
        String input = "";
        while(isMenu){
            String menu = "What do you want to order?\n"+
            "\n1. "+a+" "+pa+" USD"+
            "\n2. "+b+" "+pb+" USD"+
            "\n3. "+c+" "+pc+" USD"+
            "\n4. "+d+" "+pd+" USD";
            input = JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.PLAIN_MESSAGE);
            if(input == null){
                System.exit(0);
            }else{
                switch (input){
                    case "1":
                        order = a;
                        price = pa;
                        money -= pa;
                        isMenu = false;
                        break;
                    case "2":
                        order = b;
                        price = pb;
                        money -= pb;
                        isMenu = false;
                        break;
                    case "3":
                        order = c;
                        price = pc;
                        money -= pc;
                        isMenu = false;
                        break;
                    case "4":
                        order = d;
                        price = pd;
                        money -= pd;
                        isMenu = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Wrong input, input again", "Information", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        if(money >= 0){
            String menu2 = "Thank you for ordering "+order+", price is "+price+" USD, the balance of your money is now "+money+" USD.";
            JOptionPane.showMessageDialog(null, menu2, "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Not enough money", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return money;
    }
}
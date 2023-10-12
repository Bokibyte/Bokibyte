import java.util.Scanner;
public class KuisPengAlgo01 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n%2==0){
            for(int i = 2; i <= n; i+=2){
                System.out.print(" * " + i);
            }
        }else{
            for(int i = 1; i <= n; i += 2){
                System.out.print(i);
                if(i != n){
                    System.out.print(" * ");
                }
            }
        }
        System.out.println();
        sc.close();
    }
}
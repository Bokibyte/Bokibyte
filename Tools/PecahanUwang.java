import java.util.*;


public class PecahanUwang {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input");
        int Uwang = sc.nextInt();
        
        int Ratus = 0;
        int LimaPuluh = 0;
        int Sepuluh = 0;
        int Lima = 0;
        int Dua = 0;
        int Satu = 0;
        int Gopek = 0;
        int Jipek = 0;
        int Cepek = 0;
        
            Ratus = Uwang / 100000;
            Uwang = Uwang % 100000;
            if(Uwang >= 50000){
            LimaPuluh = Uwang / 50000;
            Uwang = Uwang % 50000;
            }
            if(Uwang >= 10000){
            Sepuluh = Uwang / 10000;
            Uwang = Uwang % 10000;
            }
            if(Uwang >= 5000){
            Lima = Uwang / 5000;
            Uwang = Uwang % 5000;
            }
            if(Uwang >= 2000){
            Dua = Uwang / 2000;
            Uwang = Uwang % 2000;
            }
            if(Uwang >= 1000){
            Satu = Uwang / 1000;
            Uwang = Uwang % 1000;
            }
            if(Uwang >= 500){
            Gopek = Uwang / 500;
            Uwang = Uwang % 500;
            }
            if(Uwang >= 200){
            Jipek = Uwang / 200;
            Uwang = Uwang % 200;
            }
            if(Uwang >= 100){
            Cepek = Uwang / 100;
            
        }
        String S100Rb = (Ratus==0) ? "" : Ratus+"x Seratus Ribu\n";
        String S50Rb = (LimaPuluh==0) ? "" : LimaPuluh+"x Lima Puluh Ribu\n";
        String S10Rb = (Sepuluh==0) ? "" : Sepuluh+"x Sepuluh Ribu\n";
        String S5Rb = (Lima==0) ? "" : Lima+"x Lima Ribu\n";
        String S2Rb = (Dua==0) ? "" : Dua+"x Dua Ribu\n";
        String S1Rb = (Satu==0) ? "" : Satu+"x Seribu\n";
        String S5R = (Gopek==0) ? "" : Gopek+"x Lima Ratus Perak\n";
        String S2R = (Jipek==0) ? "" : Jipek+"x Dua Ratus Perak\n";
        String S1R = (Cepek==0) ? "" : Cepek+"x Seratus Perak\n";
        String Print = String.format("%s %s %s %s %s %s %s %s %s", S100Rb, S50Rb, S10Rb, S5Rb, S2Rb, S1Rb, S5R, S2R, S1R);
        System.out.println(Print);
    }
}

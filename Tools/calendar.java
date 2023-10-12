import java.util.*;
public class calendar {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String tanggal1;
        String tanggal2;
        int hari1;
        int hari2;
        int batashari1;
        int batashari2;
        int bulan1;
        int bulan2;
        int tahun1;
        int tahun2;
        boolean kabisat = false;
        boolean debug= true;   //debug mode
        
        // Mengelolah input 1
        while(true){
            System.out.println("Masukan Hari 1 (dd-mm-yyyy)");
            if(sc.hasNextLine()){
                tanggal1 = sc.nextLine();
                if(tanggal1.length()==10){
                    String ambiltahun1 = tanggal1.substring(6, 10);
                    tahun1 = Integer.parseInt(ambiltahun1);
                    String ambilbulan1 = tanggal1.substring(3, 5);
                    bulan1 = Integer.parseInt(ambilbulan1);
                    String ambilhari1 = tanggal1.substring(0, 2);
                    hari1 = Integer.parseInt(ambilhari1);

                    //showdebug
                    if(debug){
                        System.out.println(tahun1);
                        System.out.println(bulan1);
                        System.out.println(hari1);
                    }

                    if((tahun1%4==0 && tahun1 % 100 != 0) || tahun1 % 400 == 0 ){
                        kabisat = true;
                        if(bulan1>=1&&bulan1<=12){
                            if(bulan1==1||bulan1==3||bulan1==5||bulan1==7||bulan1==8||bulan1==10||bulan1==12){
                                batashari1 = 31;
                                if(hari1<=batashari1&&hari1>1){
                                    break;
                                }else{
                                    System.out.println("Input hari terlalu besar atau kecil");
                                }
                            }else if(bulan1==4||bulan1==6||bulan1==9||bulan1==11){
                                batashari1 = 30;
                                if(hari1<=batashari1&&hari1>=1){
                                    break;
                                }else{
                                    System.out.println("Input hari terlalu besar atau kecil");
                                }
                            }else{
                                batashari1 = 29;
                                if(hari1<=batashari1&&hari1>=1){
                                    break;
                                }else{
                                    System.out.println("Input hari terlalu besar atau kecil");
                                }
                            }
                        }else{
                            System.out.println("Input bulan terlalu besar atau kecil");
                        }
                    }else{
                        if(bulan1>=1&&bulan1<=12){
                            if(bulan1==1||bulan1==3||bulan1==5||bulan1==7||bulan1==8||bulan1==10||bulan1==12){
                                batashari1 = 31;
                                if(hari1<=batashari1&&hari1>=1){
                                    break;
                                }else{
                                    System.out.println("Input hari terlalu besar atau kecil");
                                }
                            }else if(bulan1==4||bulan1==6||bulan1==9||bulan1==11){
                                batashari1 = 30;
                                if(hari1<=batashari1&&hari1>=1){
                                    break;
                                }else{
                                    System.out.println("Input hari terlalu besar atau kecil");
                                }
                            }else{
                                batashari1 = 29;
                                if(hari1<=batashari1&&hari1>=1){
                                    break;
                                }else{
                                    System.out.println("Input hari terlalu besar atau kecil");
                                }
                            }
                        }else{
                            System.out.println("Input bulan terlalu besar atau kecil");
                        }
                    }
                }else if(tanggal1.length()>9){
                    System.out.println("Input terlalu banyak");
                }else{
                    System.out.println("Input tidak memenuhi kondisi");
                }
            }else{
                System.out.println("Input bukan angka");
                sc.next();
            }
        }

        // Mengelolah input 2
        while(true){
            System.out.println("Masukan Hari 2 (dd-mm-yyyy)");
            if(sc.hasNextLine()){
                tanggal2 = sc.nextLine();
                if(tanggal2.length()==10){
                    String ambiltahun2 = tanggal2.substring(6, 10);
                    tahun2 = Math.abs(Integer.parseInt(ambiltahun2));
                    String ambilbulan2 = tanggal2.substring(3, 5);
                    bulan2 = Math.abs(Integer.parseInt(ambilbulan2));
                    String ambilhari2 = tanggal2.substring(0, 2);
                    hari2 = Integer.parseInt(ambilhari2);
                    
                    //showdebug
                    if(debug){
                        System.out.println(tahun2);
                        System.out.println(bulan2);
                        System.out.println(hari2);
                    }

                    if((tahun2%4==0 && tahun2 % 100 != 0) || tahun2 % 400 == 0 ){
                        kabisat = true;
                        if(bulan2>=1&&bulan2<=12){
                            if(bulan2==1||bulan2==3||bulan2==5||bulan2==7||bulan2==8||bulan2==10||bulan2==12){
                                batashari2 = 31;
                                if(hari2<=batashari2&&hari2>=1){
                                    break;
                                }else{
                                    System.out.println("Input hari terlalu besar atau kecil");
                                }
                            }else if(bulan2==4||bulan2==6||bulan2==9||bulan2==11){
                                batashari2 = 30;
                                if(hari2<=batashari2&&hari2>=1){
                                    break;
                                }else{
                                    System.out.println("Input hari terlalu besar atau kecil");
                                }
                            }else{
                                batashari2 = 29;
                                if(hari2<=batashari2&&hari2>=1){
                                    break;
                                }else{
                                    System.out.println("Input hari terlalu besar atau kecil");
                                }
                            }
                        }else{
                            System.out.println("Input bulan terlalu besar atau kecil");
                        }
                    }else{
                        if(bulan2>=1&&bulan2<=12){
                            if(bulan2==1||bulan2==3||bulan2==5||bulan2==7||bulan2==8||bulan2==10||bulan2==12){
                                batashari2 = 31;
                                if(hari2<=batashari2&&hari2>=1){
                                    break;
                                }else{
                                    System.out.println("Input hari terlalu besar atau kecil");
                                }
                            }else if(bulan2==4||bulan2==6||bulan2==9||bulan2==11){
                                batashari2 = 30;
                                if(hari2<=batashari2&&hari2>=1){
                                    break;
                                }else{
                                    System.out.println("Input hari terlalu besar atau kecil");
                                }
                            }else{
                                batashari2 = 29;
                                if(hari2<=batashari2&&hari2>=1){
                                    break;
                                }else{
                                    System.out.println("Input hari terlalu besar atau kecil");
                                }
                            }
                        }else{
                            System.out.println("Input bulan terlalu besar atau kecil");
                        }
                    }
                }else if(tanggal2.length()>9){
                    System.out.println("Input terlalu banyak");
                }else{
                    System.out.println("Input tidak memenuhi kondisi");
                }
            }else{
                System.out.println("Input bukan angka");
                sc.next();
            }
        }

        // Mengelolah data
        // Jumlahkan hari di masing-masing awal bulan

        int haribulan1 = batashari1 - (batashari1 - hari1);
        int haribulan2 = batashari2 - (batashari2 - hari2);
        int totalhariawalbulan = Math.abs(haribulan1 - haribulan2);

        //showdebug
        if(debug){
        System.out.println("selisih hari bulan 1 "+ haribulan1);
        System.out.println("selisih hari bulan 2 "+ haribulan2);
        System.out.println("total selisih bulan awal = "+ totalhariawalbulan);
        }

        //menghitung hari selisih bulan
        int hariselisihbulan = 0;
        if(bulan1>bulan2){
            for(int i = bulan2 ; i < bulan1; i++){
                if(i==1||i==3||i==5||i==7||i==8||i==10||i==12){
                    hariselisihbulan += 31;
                }else if(i==4||i==6||i==9||i==11){
                    hariselisihbulan += 30;
                }else{
                    if(kabisat){
                        hariselisihbulan += 29;
                    }else{
                        hariselisihbulan +=28;
                    }
                }
            }
        }else if(bulan1<bulan2){
            for(int i = bulan2 ; i > bulan1; i--){
                if(i==1||i==3||i==5||i==7||i==8||i==10||i==12){
                    hariselisihbulan += 31;
                }else if(i==4||i==6||i==9||i==11){
                    hariselisihbulan += 30;
                }else{
                    if(kabisat){
                        hariselisihbulan += 29;
                    }else{
                        hariselisihbulan +=28;
                    }
                }
            }
        }else{
            hariselisihbulan = 0;
        }
        
        //showdebug
        if(debug){
        System.out.println("hari selisih bulan = "+hariselisihbulan);
        }

        //menghitung hari selisih tahun
        int haripertahun = 0;
        if(tahun1>tahun2){
            for(int i = tahun2 ; i < tahun1; i++){
                if((i%4==0 && i % 100 != 0) || i % 400 == 0 ){
                    haripertahun += 366;
                }else{
                    haripertahun += 365;
                }
            }
        }else if(tahun1<tahun2){
            for(int i = tahun2 ; i > tahun1 ; i--){
                if((i%4==0 && i % 1000 != 0) || i % 400 == 0){
                    haripertahun += 366;
                }else{
                    haripertahun += 365;
                }
            }
        }else{
            haripertahun = 0;
        }

        //showdebug
        if(debug){
        System.out.println("hari dalam tahun = "+haripertahun);
        }

        int hasilselisih = Math.abs(haripertahun + hariselisihbulan -totalhariawalbulan);
        System.out.println("Selisih hari = "+hasilselisih);
        sc.close();
    }
}
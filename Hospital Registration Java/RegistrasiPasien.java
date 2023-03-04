import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class RegistrasiPasien {
    
    static Scanner sc = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in); 
    static LocalTime time = LocalTime.now();
    static LocalDate dayNow = LocalDate.now();
    static LocalDateTime tanggalnow = LocalDateTime.now();

    static Scanner scInt = new Scanner(System.in);

    // fungsi Random No Pasien 
    static int random (){
        int max = 999999;
        int min = 99999;
        int rndNum =  (int)Math.floor(Math.random()*(max-min+1)+min);
        return rndNum;
    }
    static int index [] =
    {
        /*0 index Jumlah pasien*/ 2,
        /*1 save Index hari */ 0,
        /*2 save index dokter */ 0,
        /*3 save index jam */ 0,
        /*4 save pasien index */0,
        /*5 save pelayanan */0,
        /*6 save Index Kamar  */0,
        /*7 save doktor cepat */0

    };

    // Kuota Pasien
    static int kuotaPasien [][] = {
        /*poli */ {5,5},  
        /*poli mata*/ {5,5},  
        /*poli cek Diabetes*/ {5,5},  
        /*poli Tes Kesehatan*/ {5,5}  
    };

    // Data Pasien
    static String dataPasien [][] = new String [3][999]; 
    // no pasien
    static int noPasien [] = new int [999];
    // Isi Data Psien
    static void data (){
       dataPasien [0][0] = "Ahmad Kurniawan"; dataPasien [1][0] = "35199988877"; dataPasien [2][0] = "Jln. Merdeka";
       dataPasien [0][1] = "Budi Setiawana"; dataPasien [1][1] = "35199933899"; dataPasien [2][1] = "Jln. Pelajar";
       dataPasien [0][2] = "Wahyu Hidayat"; dataPasien [1][2] = "35177988855"; dataPasien [2][2] = "Jln. Perjuangan";
       noPasien   [0]    = 789132; noPasien   [1]    = 756113; noPasien   [2]    = 745986;
    }

    // static Harga Pelayanan 
    static String hargaPelayanan [] = {
        /* Pelayanan Rawat Jalan*/ "50000",
        /* Pelayanan Rawat Inap*/ "100000",
        /* Pelayanan BPJS*/ "0"
    };

    // Data nomor rujukan BPJS
    static String noRujukanBPJS [] = {
        "123456", "654321"
    };

    //  daftar Poli
    static String dokter  [][][]= new String [3][2][5];
    static String poli [] = {
        "Poli Bedah", "Poli Mata", "Cek Diabetes & Kolestrol", "Tes Kesehatan"
    };

    // Daftar spesialis Doktor
    static String dokSpesial  [] = {
        "Dokter Bedah", "Dokter Mata", "Dokter Umum"
    };

    // Day Index
    static String indexHari [][] = {
        {"Monday", "Tuesday", "Wednesday", "Saturday"},
        {"Wednesday", "Thursday", "Friday", "Sunday"},
        {"Monday", "Tuesday", "Wednesday", "Saturday"},
        {"Wednesday", "Thursday", "Friday", "Sunday"},
        {"Monday", "Tuesday", "Wednesday", "Saturday"}
        
    };

    // Day String 
    static String dino []= {
        "Senin, Selasa, Rabu",
        "Rabu, Kamis, Jum'at", 
        "Senin, Selasa, Rabu", 
        "Rabu, Kamis, Jum'at",
        "Senin, Selasa, Rabu"
        
    };

    // index jam +-
    static int indexJam []={
        12, 16
    };

    // String Jam
    static String jam [] = {
        "09:00 - 12:00", "13:00 - 16:00",
    };

    // Data Dokter Anak
    static void dataDokter (){
        // Dokter Bedah
        dokter [0][0][0] = "Dr. Kurniawan"; dokter [0][1][0] = "180370";
        dokter [0][0][1] = "Dr. Rahmawati"; dokter [0][1][1] = "797865";      

        // Dokter Mata
        dokter [1][0][0] = "Dr. Sertomo"; dokter [1][1][0] = "897855";
        dokter [1][0][1] = "Dr. Zanyudin"; dokter [1][1][1] = "897877";

        // Dokter Umum
        dokter [2][0][0] = "Dr. Albarokah"; dokter [2][1][0] = "897899";
        dokter [2][0][1] = "Dr. Albert"; dokter [2][1][1] = "897888";

    } 

    // Daftar kamar
    static String kamar [] = { "Kamar Diamond", "Kamar Gold"};
    // Kuota Kamar
    static int kuotaKamar [] = {5,5};
    // nomor Kamar
    static String noKamar [][] = {
        {"787960", "303129", "404130", "556677", "304020"},
        {"783069", "345166", "484132", "557654", "307090"}
    };

    // Data Admin
    static String DataAdmin [][] = {
        {"admin1", "admin2"},
        {"654321", "123456"}
    };

    // Index jum doktor
    static int indexInDoc [] = {
        /*Doctor bedah*/2,
        /*Doctor Mata*/2,
        /*Doctor Umum*/2
    };
    

// ===========================================================================================================================================================
// ===========================================================================================================================================================
// ===========================================================================================================================================================



    // Fungsi main
    public static void main(String[] args) {
        boolean key = true;
        while (key==true) {
            data();        
            System.out.println("====================================================");
            System.out.println("                 Rumah Sakit Ultra Sehat            ");
            System.out.println("===================================================="); 
            System.out.println("Menu Pelayanan : ");
            System.out.println("1. Registrasi Pasien");
            System.out.println("2. Menu Pelayanan");
            System.out.println("3. Pelayanan Darurat");
            System.out.println("4. Admin Mode");
            System.out.print("Pilih Index di Atas : ");
            String a1 = sc.next();
            if (a1.equalsIgnoreCase("1")){
                dataPasienBaru();
            }else if (a1.equalsIgnoreCase("2")){
                dataPasienLama(1);
            }else if (a1.equalsIgnoreCase("3")){
                dataPasienLama(2);
            }else if (a1.equalsIgnoreCase("4")){
                admin();
            }else {
                System.out.println("======================================");
                System.out.println("Index salah");
                System.out.println("Sihlakan Masukan Ulang");
                System.out.println("======================================");
            }
        }
    }


    // ==========================================================================================================================================
    // ==========================================================================================================================================
    // ==========================================================================================================================================

    // fungsi pengisian data pasien Lama
    static int dataPasienLama (int parameter){
        boolean key =true;
        while (key) {
            System.out.println("======================================");
            System.out.println("Ketik 0 untuk Kembali ke menu utama");
            System.out.println("Ketik 1 Apabila Lupa Nomor Pasien");
            System.out.println("Silahkan Masukan No Pasien (Registrasi terlebih Dahulu Apabila Pasien Baru)");
            System.out.print("No Pasien  6 digit   : ");
            String no = sc.next();
            System.out.println("======================================");
            int x = no.length();
            if(x == 6 || x == 1){
                if (no.equalsIgnoreCase("0")){
                    return 0;
                } else if (no.equals("1")) {
                    System.out.println("---------------------------------------");
                    System.out.print("masukan NIK Pasien : ");
                    String nik = scStr.next();
                    System.out.println("---------------------------------------");
                    lupaNoPasien(nik, 0);
                    return 0;
                }
                int dig = Integer.parseInt(no);
                int par = cekdata(dig, 0);
                if(par == 7){
                   return 0;
                } 
                index[4] = par;
                if(parameter == 1){
                    if (par >= 0){ 
                        pelayananA();
                        key = false;
                    } 
                    return 0;
                } else if (parameter == 2){
                    if (par >= 0){ 
                        pelayananCepat();
                        key = false;
                    } 
                    return 0;
                } 
            } else if (x > 6){
                int a = x - 6;
                System.out.println("Angka Yang Anda Masukan Kelebihan "+a+" Digit");
            } else {
                System.out.println("Input Yang Anda Masukan Salah");
              }       
        }
        return 0;
    }

    // fungsi rekursif cek data pasien lama
    static int cekdata (int a, int hit){
        if (hit > noPasien.length-1){
            System.out.println("======================================");
            System.out.println("Data tidak ditemukan");
            System.out.print("Apakah Anda Lupa Nomor Pasien ? (Y/N)");
            String nopas = sc.next();
            System.out.println("======================================");
            if (nopas.equalsIgnoreCase("y")){
                System.out.print("masukan NIK Pasien : ");
                String nik = scStr.nextLine();
                int bck = lupaNoPasien(nik,0);
                if(bck == 0){

                } else {
                    return 7;
                }
            } else if (nopas.equalsIgnoreCase("n")){
                return 7;
            };
        } else
        if (a == noPasien [hit] ){
            System.out.println("======================================");
            System.out.println("Nama Pasien   : " + dataPasien[0][hit]);
            System.out.println("NIK Pasien    : " + dataPasien[1][hit]);
            System.out.println("Alamat Pasien : " + dataPasien[2][hit]);
            System.out.println("Nomor Pasien  : " + noPasien[hit]);
            System.out.println("======================================");
            return hit;
        }  
        return (cekdata(a, hit+1));
    }

    // Fungsi data pasien Baru
    static void dataPasienBaru(){
        boolean key1=true;
        while (key1==true) {
            System.out.println("======================================");
            System.out.println("Dengan Melakukan Regstrasi Anda setuju Untuk \nMemberikan Informasi Kepada Pihak Rumah Sakit");
            System.out.println("======================================");
            System.out.println("Ketik 0 untuk Kembali ke menu utama");
            System.out.println("Ketik 1 untuk Melanjutkan Registrasi");
            System.out.println("======================================");
            System.out.print("Pilih Index : ");
            String x = sc.next();
            if (x.equalsIgnoreCase("0")){
                System.out.println("========================================");
                key1 = false;
            } else if (x.equalsIgnoreCase("1")) {
                index[0]++;
                boolean key = true;
                while (key==true) {
                    System.out.println("========================================");
                    System.out.println("Silahkan Imputkan Data Sesuai Dengan Data pada KTP Atau Akta Kelahiran ");
                    System.out.println("========================================");
                    System.out.print("Nama Pasien : ");
                    String nama =scStr.nextLine();
                    dataPasien[0][index[0]] = nama;
                    System.out.print("NIK Pasien : ");
                    String nik = scStr.nextLine();
                    dataPasien[1][index[0]]=nik;
                    System.out.print("Alamat Pasien : ");
                     String alamat = scStr.nextLine();
                    dataPasien[2][index[0]]=alamat;
                    noPasien[index[0]] = random();
        
                    System.out.println("======================================");
                    System.out.println("Nama Pasien   : " + dataPasien[0][index[0]]);
                    System.out.println("NIK Pasien    : " + dataPasien[1][index[0]]);
                    System.out.println("Alamat Pasien : " + dataPasien[2][index[0]]);
                    System.out.println("Nomor Pasien  : " + noPasien[index[0]]);
                    System.out.println("======================================");
                    System.out.println("Diharap Untuk Menyimpan Nomor Pasien Yang Tertera Pada Struck \nUntuk Digunakan Untuk Melakukan Pelayanan Di rumah Sakit");
                    System.out.println("======================================");
        
                    System.out.print("Apakah Data Yang Anda Masukan Benar ? (Y/N) ");
                    String YorN = sc.next();
        
                    if (YorN.equalsIgnoreCase("Y")){
                        key = false;
                        key1 = false;
                    } 
                }
            } else {
                System.out.println("======================================");
                System.out.println("Index salah");
                System.out.println("Sihlakan Masukan Ulang");
                System.out.println("======================================");
            }
        }
    }

    // Fungsi Rekursif Lupa nomor pasien
    static int lupaNoPasien (String a, int x){
        if( x > dataPasien[0].length-1){
            System.out.println("======================================");
            System.out.println("Mohon Maaf NIK Tidak Terdaftar");
            System.out.println("Sihlakan Masukan Ulang");
            System.out.println("======================================");
            return 0;
        } else if (a.equals(dataPasien[1][x])){
            System.out.println("======================================");
            System.out.println("Nama Pasien   : " + dataPasien[0][x]);
            System.out.println("NIK Pasien    : " + dataPasien[1][x]);
            System.out.println("Alamat Pasien : " + dataPasien[2][x]);
            System.out.println("Nomor Pasien  : " + noPasien[x]);
            System.out.println("======================================");
            return 1;
        } else {
           return lupaNoPasien(a, x+1);
        }
    }

    // Pelayanan BPJS
    static int pelayananBPJS (){
        System.out.println("Ketik 0 Untuk Kembali");
        System.out.print("Masukan No Rujukan BPJS (6 Digit) : ");
        String noRujukan = sc.next();
        int o = noRujukan.length();
        if(o == 6||o == 1){
            if (noRujukan.equalsIgnoreCase("0")){
                return 0;
            } else {
                int bck = cekBpjs(noRujukan, 0);
                if(bck == 0){

                } else {
                    return 1;
                }
            }
        }else if (o > 6){
            int b = o - 6;
            System.out.println("Angka Yang Anda Masukan Kelebihan "+b+" Digit");
            System.out.println("Silahkan Masukan Ulang");
        } else {
            System.out.println("Inout Yang Anda Masukan Salah");
            System.out.println("Silahkan Masukan Ulang");
        }
        return 0;
    }

    // Cek Bpjs 
    static int cekBpjs (String noRujukan,int hit){
        if(hit >= noRujukanBPJS.length){
            System.out.println("Mohon Maaf Data Tidak Di Temukan ");
            return 0;
        } else if (noRujukan.equalsIgnoreCase(noRujukanBPJS[hit])){
            return 1;
        }
        return (cekBpjs(noRujukan, hit+1));
    } 

    

    // ===================================================================================================================
    // ===================================================================================================================
    // ===================================================================================================================

    // Input Pelayan Pasien page 1
    static int pelayananA (){
        boolean key = true;
        while (key = true) {
            System.out.println("======================================");
            System.out.println("       Silahkan Pilih Pelayanan ");
            System.out.println("======================================");
            System.out.println("1. Rawat Jalan");
            System.out.println("2. Rawat Inap");
            System.out.println("0. Kembali");
            System.out.print("Pilih Index : ");
            String x = sc.next();
            System.out.println("======================================");
            if (x.equalsIgnoreCase("0")){
                return 0;
            } else 
            if (x.equalsIgnoreCase("1")){
                int bck = pelayananA1();
                if( bck == 1 ){

                } else if(bck == 0){
                    key = false;
                    return 0;
                }
            } else if (x.equalsIgnoreCase("2")){
                int bck1 = pelayananA2();
                if( bck1 == 1 ){

                } else if(bck1 == 0){
                    key = false;
                    return 0;
                }
            } else {
                System.out.println("======================================");
                System.out.println("Index salah");
                System.out.println("Sihlakan Masukan Ulang");
                System.out.println("======================================");
            }
        }
        return 1;
    } 

    // Input Rawat Inap 
    static int pelayananA2 (){
        boolean key = true;
        while (key) {
            System.out.println("--------------------------------------------");
            System.out.print("Apakah Anda Memiliki BPJS (Y/N) ");
            String inJS = sc.next();
            System.out.println("--------------------------------------------");
            if (inJS.equalsIgnoreCase("y")) {
               int idk = pelayananBPJS();
               if (idk == 0){

               } else{
               index[5] = 2;
               key = false;}
            } else if (inJS.equalsIgnoreCase("n")){
                index[5] = 0;
                key = false;
            } else {
                System.out.println("Input Yang Anda Masukan Salah");
            }
        }

        boolean key2 = true;
        while (key2) {
            System.out.println("======================================");
            System.out.println("1. Kamar Diamond");
            System.out.println("2. Kamar Gold");
            System.out.println("0. Kembali");
            System.out.print("Pilih Index : ");
            String x = sc.next();
            System.out.println("======================================");
            if (x.equalsIgnoreCase("0")){
                return 1;
            }
            if (x.equalsIgnoreCase("1")){
                int kuota = index[6];
                outputRoom(0, kuota);
                index[6]++; 
                kuotaKamar[0] = kuotaKamar[0]-1;
                key2 = false;
            } else if (x.equalsIgnoreCase("2")){
                int kuota = index[6];
                outputRoom(1, kuota);
                index[6]++; 
                kuotaKamar[1] = kuotaKamar[1]-1;
                key2 = false;
            } else {
                System.out.println("======================================");
                System.out.println("Index salah");
                System.out.println("Sihlakan Masukan Ulang");
                System.out.println("======================================");
            }
        }
        return 0;
    }

    // Kamar Output 
    static int outputRoom(int codeRoom,int kuota){
        int dex = index[4];
        System.out.println("====================================================");
        System.out.println("               Rumah Sakit Ultra Sehat              ");
        System.out.println("====================================================");
        System.out.println("Nama Pasien     : " + dataPasien[0][dex]);
        System.out.println("NIK Pasien      : " + dataPasien[1][dex]);
        System.out.println("Alamat Pasien   : " + dataPasien[2][dex]);
        System.out.println("Nomor Pasien    : " + noPasien[dex]);
        System.out.println("----------------------------------------------------");
        System.out.println("Jenis Kamar     : " +kamar[codeRoom] );
        System.out.println("Nomor Kamar     : " +noKamar[codeRoom][kuota] );
        System.out.println("----------------------------------------------------");
        System.out.println("Biaya Pelayanan : " + hargaPelayanan[index[5]]);
        System.out.println("Kode Pembayaran : " + random());
        System.out.println("====================================================");
        System.out.println("-------------------- Terima Kasih ------------------");
        System.out.println("====================================================");
        return 0;
    }

    // ===================================================================================================================
    // ===================================================================================================================
    // ===================================================================================================================
    
    // Input Pelayanan Rawat Jalan
    static int pelayananA1 (){
        boolean key3 = true;
        while (key3) {
            System.out.println("--------------------------------------------");
            System.out.print("Apakah Anda Memiliki BPJS (Y/N) ");
            String inJS = sc.next();
            System.out.println("--------------------------------------------");
            if (inJS.equalsIgnoreCase("y")) { 
               int idk = pelayananBPJS();
               if (idk == 0){

               } else{
               index[5] = 2;
               key3 = false;}
            } else if (inJS.equalsIgnoreCase("n")){
                index[5] = 0;
                key3 = false;
            } else {
                System.out.println("Input Yang Anda Masukan Salah");
            }
        }
        boolean key = true;
        while (key=true) {
            System.out.println("======================================");
            System.out.println("1. Pelayanan Poliklinik");
            System.out.println("2. Pelayanan Kesehatan");
            System.out.println("0. Kembali");
            System.out.print("Pilih Index : ");
            String x = sc.next();
            System.out.println("======================================");
            if (x.equalsIgnoreCase("0")){
                return 1;
            }
            if (x.equalsIgnoreCase("1")){
                int bck = pelayananA11(0,0);
                if( bck == 1 ){

                } else if(bck == 0){
                    System.out.println("======================================");
                    System.out.print("Apakah Ada Transaksi Lain (Y/N)");
                    String con = sc.next();
                    System.out.println("======================================");
                    if (con.equalsIgnoreCase("y")) {
                        
                    } else if (con.equalsIgnoreCase("n")) {
                        key = false;
                        return 0;
                    } else {
                        System.out.println("======================================");
                        System.out.println("Index salah");
                        System.out.println("Sihlakan Masukan Ulang");
                        System.out.println("======================================");
                    }
                    
                }
            } else if (x.equalsIgnoreCase("2")){
                int bck = pelayananA12();
                if( bck == 1 ){

                } else if(bck == 0){
                    System.out.println("======================================");
                    System.out.print("Apakah Ada Transaksi Lain (Y/N)");
                    String con = sc.next();
                    System.out.println("======================================");
                    if (con.equalsIgnoreCase("y")) {
                        
                    } else if (con.equalsIgnoreCase("n")) {
                        key = false;
                        return 0;
                    } else {
                        System.out.println("======================================");
                        System.out.println("Index salah");
                        System.out.println("Sihlakan Masukan Ulang");
                        System.out.println("======================================");
                    }
                }
            } else {
                System.out.println("======================================");
                System.out.println("Index salah");
                System.out.println("Sihlakan Masukan Ulang");
                System.out.println("======================================");
            }
        }
        
        return 1;
    }

    // Pelayanan Poli
    static int pelayananA11(int coderoom, int kuota){
        Boolean key1 = true;
        while (key1=true) {
            System.out.println("======================================");
            System.out.println("1. Poli Bedah");
            System.out.println("2. Poli Mata");
            System.out.println("0. Kembali");
            System.out.print("Pilih Index : ");
            String y = sc.next();
            System.out.println("======================================");
            if (y.equalsIgnoreCase("0")){
                return 1;
            }else if(y.equalsIgnoreCase("1")){
                int bck = infoDokter(0);
                if( bck == 1 ){

                } else if(bck == 0){
                    key1 = false;
                    return 0;
                }
            } else if (y.equalsIgnoreCase("2")){
                int bck = infoDokter(1);
                if( bck == 1 ){

                } else if(bck == 0){
                    key1 = false;
                    return 0;
                }
            }else {
                System.out.println("======================================");
                System.out.println("Index salah");
                System.out.println("Sihlakan Masukan Ulang");
                System.out.println("======================================");
            }
        }
        return 1;
    }

    // Pelayanan Kesehatan
    static int pelayananA12 (){
        Boolean key1 = true;
        while (key1=true) {
            System.out.println("======================================");
            System.out.println("1. Cek Diabetes & kolestrol");
            System.out.println("2. Tes Kesehatan");
            System.out.println("0. Kembali");
            System.out.print("Pilih Index : ");
            String y = sc.next();
            System.out.println("======================================");
            if (y.equalsIgnoreCase("0")){
                return 1;
            }else if(y.equalsIgnoreCase("1")){
                int bck = infoDokter(2);
                if( bck == 1 ){

                } else if(bck == 0){
                    key1 = false;
                    return 0;
                }
            } else if (y.equalsIgnoreCase("2")){
                int bck = infoDokter(2);
                if( bck == 1 ){

                } else if(bck == 0){
                    key1 = false;
                    return 0;
                }
            }else {
                System.out.println("======================================");
                System.out.println("Index salah");
                System.out.println("Sihlakan Masukan Ulang");
                System.out.println("======================================");
            }
        }
        return 1;
    }

    // Halaman Booking
    static int infoDokter (int codeDoc){
        boolean key = true ;
        while (key) {
            dataDokter();
            System.out.println("======================================");
            System.out.println("1. Booking & Registrasi");
            System.out.println("0. Kembali");
            System.out.print("Pilih Index : ");
            String in = sc.next();
            System.out.println("======================================");

            if (in.equals("0")){
                return 1;
            } else if (in.equals("1")){
                int bck = booking(codeDoc);
                if( bck == 1 ){
                    
                } else if(bck == 0){
                    key = false;
                    return 0;
                }
            } else {
                System.out.println("======================================");
                System.out.println("Index salah");
                System.out.println("Sihlakan Masukan Ulang");
                System.out.println("======================================");
            }
        }
        return 1;
    }

    // Booking 
    static int booking (int codeDoc){
        dataDokter();
        boolean key = true;
        while (key) {
            System.out.println("============================================================================");
                System.out.println("                             "+ dokSpesial[codeDoc] + "                        ");
                System.out.println("============================================================================");
                System.out.printf("|%5s|%20s|%20s|%20s|\n","Index", "Nama Dokter", "ID dokter", "Hari");
                System.out.println("----------------------------------------------------------------------------");
            for (int x = 0; x <= indexInDoc[codeDoc]-1; x++){
                System.out.printf("|%5s|%20s|%20s|%20s|\n", x+1 , dokter[codeDoc][0][x], dokter[codeDoc][1][x], dino[x]);
            }
            System.out.printf("|%5s|%20s|%20s|%20s|\n", "0"," Kembali","","");
            System.out.print("Pilih Index : ");
            String in = sc.next();
            
            if (in.equals("0")){
                return 1;
            } else if (in.equals("1")||in.endsWith("2")||in.endsWith("3")||in.endsWith("4")||in.endsWith("5")){
                int a = Integer.parseInt(in);
                a = a -1;
                index[2] = a;
                int b = cekHari(a, 0, 0);
                if (b == 1){
                    int bck = Pilihjam(codeDoc);
                    if( bck == 1 ){
                        
                    } else if(bck == 0){
                        key = false;
                        return 0;
                    }
                } 
            } else {
                System.out.println("======================================");
                System.out.println("Index salah");
                System.out.println("Sihlakan Masukan Ulang");
                System.out.println("======================================");
            }
        }
        return 1;
    }

    // Cek Hari
    static int cekHari (int hari, int hit, int turn){
        String harsek =dayNow.getDayOfWeek().toString();
        
        if (hit >= indexHari[0].length){
            System.out.println("======================================");
            System.out.println("Mohon Maaf Dokter Tidak Praktik Hari Ini");
            System.out.println("Silahkan Pilih Dokter Yang Lain");
            System.out.println("======================================");
            return 0;
        }
        if (indexHari[hari][hit].equalsIgnoreCase(harsek) ){
            
            return 1;
        } else {
            return (cekHari(hari, hit+1, turn+1));
        }
     
    }

    //Pilih Jam
    static int Pilihjam (int codeDoc){
    boolean key = true;
        while (key) {
            System.out.println("=========================");
            System.out.printf("|%5s|%20s|\n", "Index", "Jam");
            for(int a = 0; a < jam.length; a++){
            System.out.printf("|%5s|%20s|\n", a+1,jam[a]);
            }
            System.out.printf("|%5s|%20s|\n", "0", "Kembali");
            System.out.println("=========================");
            System.out.print("Pilih jam : ");
            String y = sc.next();
            
            if (y.equalsIgnoreCase("0")){
                return 1;
            }else if(y.equalsIgnoreCase("1")||y.equalsIgnoreCase("2")){  
                int x = Integer.parseInt(y);
                x--;
                index[3] = x;
                int inJam = cekJam(x, codeDoc);

                if(inJam == 0){
                    
                }else{
                    return 0;
                };
                
            }else {
                System.out.println("======================================");
                System.out.println("Index salah");
                System.out.println("Sihlakan Masukan Ulang");
                System.out.println("======================================");
            }
        }
        return 0;
    }

    // cek jam 
    static int cekJam (int index, int codeDoc){
            int selisih = indexJam[index] - time.getHour();
            if (selisih < 0 ){
                System.out.println("======================================");
                System.out.println("Mohon Maaf Jam Praktik Telah Usai");
                System.out.println("Silahkan Pilih Ulang");
                System.out.println("======================================");
                return 0;
            } else {
                if(kuotaPasien[codeDoc][index] > 0 ){
                    kuotaPasien[codeDoc][index]--;
                    printOut(codeDoc,2);
                } else {
                    System.out.println("======================================");
                    System.out.println("Mohon Maaf Jumlah Pasien Telah Penuh");
                    System.out.println("======================================");
                }
            }
        return 1;
    }

    // Menu Pelayanan Cepat
    static int pelayananCepat (){
        dataDokter();
        boolean key = true;
        while (key) {
            System.out.println("--------------------------------------------");
            System.out.print("Apakah Anda Memiliki BPJS (Y/N) ");
            String inJS = sc.next();
            System.out.println("--------------------------------------------");
            if (inJS.equalsIgnoreCase("y")) {
               int idk = pelayananBPJS();
               if (idk == 0){

               } else{
               index[5] = 2;
               key = false;}
            } else if (inJS.equalsIgnoreCase("n")){
                index[5] = 0;
                key = false;
            } else {
                System.out.println("Input Yang Anda Masukan Salah");
            }
        }
        cekHariCepat(0, 0, 0);
        printOut(2,1);
        return 1;
    }

    // Cek Hari Pelayanan Cepat
    static int cekHariCepat (int hari, int hit, int turn){
        String harsek =dayNow.getDayOfWeek().toString();
        if(hari >= indexHari.length){
            System.out.println("Hari Tidak Ditemukan");
           return 0;
        }
        if (hit >= indexHari[0].length){
           hari++;
           hit = 0;
        }
        if (indexHari[hari][hit].equalsIgnoreCase(harsek) ){
            index [2] = hari;
            return 1;
        } else {
            return (cekHariCepat(hari, hit+1, turn+1));
        }
     
    }

    // Print Hasil Booking 
    static void printOut (int codeDoc ,int parameter){
        int dex = index[4];
        System.out.println("====================================================");
        System.out.println("               Rumah Sakit Ultra Sehat              ");
        System.out.println("====================================================");
        System.out.println("Nama Pasien     : " + dataPasien[0][dex]);
        System.out.println("NIK Pasien      : " + dataPasien[1][dex]);
        System.out.println("Alamat Pasien   : " + dataPasien[2][dex]);
        System.out.println("Nomor Pasien    : " + noPasien[dex]);
        System.out.println("----------------------------------------------------");
        System.out.println("Nama Dokter     : " + dokter[codeDoc][0][index[2]]);
        System.out.println("ID Dokter       : " + dokter[codeDoc][1][index[2]]);
        System.out.println("Pelayanan       : " + dokSpesial[codeDoc]);
        System.out.println("Hari            : " + dayNow.getDayOfWeek() +" / "+ tanggalnow.getDayOfMonth()+ " / "+tanggalnow.getMonth()+ " / "+tanggalnow.getYear() );
        if (parameter ==1) {
            System.out.println("Jam Pelayanan   : " + time.getHour() + ":" + time.getMinute());
        } else if (parameter == 2){
            System.out.println("Jam Pelayanan   : " + time.getHour() + ":" + time.getMinute());
            System.out.println("Jam Pelayanan   : " + jam[index[3]]);
        }
        System.out.println("----------------------------------------------------");
        System.out.println("Biaya Pelayanan : " + hargaPelayanan[index[5]]);
        System.out.println("Kode Pembayaran : " + random());
        System.out.println("====================================================");
        System.out.println("-------------------- Terima Kasih ------------------");
        System.out.println("====================================================");
        System.out.println("");
        System.out.println("");
    }

    // ===================================================================================================================
    // ===================================================================================================================
    // ===================================================================================================================
    
    // admin 
    static int admin (){
        boolean key = true;
        while (key) {
            System.out.println("======================================");
            System.out.println("Fitur Ini Hanya Digunakan Oleh Admin Rumah Sakit");
            System.out.println("======================================");
            System.out.println("Ketik 0 untuk Kembali ke menu utama");
            System.out.println("Ketik 1 untuk Melanjutkan Admin Mode");
            System.out.println("======================================");
            System.out.print("Pilih Index : ");
            String x = sc.next();
            if(x.equalsIgnoreCase("0")){
                return 1;
            } else if (x.equals("1")){
                System.out.println("======================================");
                System.out.println("Ketik 0 untuk kembali");
                System.out.print("Username : ");
                String userMin = sc.next();
                if(userMin.equals("0")){
                    key = false;
                    return 1;
                }
                System.out.print("Password : ");
                String pwsMin = sc.next();
                int o = pwsMin.length();
                    if(o == 6){
                        int id = cekAdmin(userMin, 0, 0);
                        int pws = cekAdmin(pwsMin, 1, 0);
                        if(id==pws){
                            int dex1 = adminMenu();
                            if (dex1 == 0) {
                                return 0;
                            } else {
                                
                            }
                        } else {
                            System.out.println("======================================");
                            System.out.println("Data tidak ditemukan");
                            System.out.println("Silahkan MAsukan Ulang");
                            System.out.println("======================================");
                        }
    
                    }else if (o > 6){
                        int b = o - 6;
                        System.out.println("Angka Yang Anda Masukan Kelebihan "+b+" Digit");
                        System.out.println("Silahkan Masukan Ulang");
                    } else {
                        System.out.println("Input Yang Anda Masukan Salah");
                        System.out.println("Silahkan Masukan Ulang");
                    }
            } 
        }
        return 0;
    }

    // cek admin 
    static int cekAdmin (String input, int index, int hit){
        
        if(hit >= DataAdmin[index].length){
            return 0;
        }
        if (input.equals(DataAdmin[index][hit])){
            return hit;
        } else {
            cekAdmin(input, index, hit+1);
        }
        return 1;
    }

    // menu admin 
    static int adminMenu (){
        boolean key = true;
        while (key==true) {
            System.out.println("====================================================");
            System.out.println("                    Admin Mode                  ");
            System.out.println("===================================================="); 
            System.out.println("Menu Pelayanan : ");
            System.out.println("1. Tambah Dokter");
            System.out.println("2. Tambah Kuota Pasien");
            System.out.println("0. Keluar ");
            System.out.print("Pilih Index di Atas : ");
            String a1 = sc.next();
            if (a1.equalsIgnoreCase("1")){
                newDoctor();
            }else if (a1.equalsIgnoreCase("2")){
                kuotaNew();
            }else if (a1.equalsIgnoreCase("0")){
                return 0;
            }else {
                System.out.println("======================================");
                System.out.println("Index salah");
                System.out.println("Sihlakan Masukan Ulang");
                System.out.println("======================================");
            }
        }
        return 1;
    }

    // Menu Tambah Kuota Pasien
    static int kuotaNew () {
        boolean key = true;
        while (key) {
            System.out.println("======================================");
            System.out.println("         Tambah Kuota Pasien          ");
            System.out.println("======================================");
            System.out.println("Pilih Bidang Dokter :");
            for(int x = 0; x<=poli.length-1;x++){
                System.out.println(x+1+" "+poli[x]);
            }

            System.out.println("0. Kembali"); 
            System.out.print("Silahkan Pilih Index : ");
            String in = scInt.next();
            int num = Integer.parseInt(in)-1;
            if (num >= 0 && num <= kuotaPasien.length ) {
                
                int dex1 = isiPasien(num);
                
                if (dex1 == 0) {
                    key = false;
                    return 0;
                } else {
                    
                }
            } 
            if (in.equals("0")){
                key = false;
                return 1;
            } else {
                System.out.println("======================================");
                System.out.println("Index salah");
                System.out.println("Sihlakan Masukan Ulang");
                System.out.println("======================================");
            }
              
        }
        return 1;
    }

    // new kuota 
    static int isiPasien (int codeDoc) {
        System.out.println("=========================");
        System.out.printf("|%5s|%20s|\n", "Index", "Jam");
        for(int a = 0; a < jam.length; a++){
        System.out.printf("|%5s|%20s|\n", a+1,jam[a]);
        }
        System.out.printf("|%5s|%20s|\n", "0", "Kembali");
        System.out.println("=========================");
        System.out.print("Pilih jam : ");
        int index = sc.nextInt();
        if (index==1||index==2) {
            index--;
            System.out.println("Kuota Lama : "+kuotaPasien[codeDoc][index]);
            System.out.print("Masukan Jumlah Pasien "+poli[codeDoc]+" : ");
            int input = scInt.nextInt();
            kuotaPasien[codeDoc][index]= input;
            System.out.println("Kuota terbaru : "+kuotaPasien[codeDoc][index]);
            return 0;
        } else if (index==0){
            return 0;
        }
        return 0;
        
    }

    // Tambah Doctor 
    static int newDoctor (){
        dataDokter();
        boolean key = true;
        while (key) {
            int codeDoc = 0;
            System.out.println("======================================");
            System.out.println("Pilih Bidang Dokter :");
            System.out.println("1. Dokter Bedah");
            System.out.println("2. Dokter Mata");
            System.out.println("3. Dokter Umum"); 
            System.out.println("0. Kembali"); 
            System.out.print("Silahkan Pilih Index : ");
            String in = sc.next();
            if (in.equals("1")) {
                codeDoc = 0;
                int dex1 = inputDoc(codeDoc);
                if (dex1 == 0) {
                    return 0;
                } else {
                    
                }
            } else if (in.equals("2")){
                codeDoc = 1;
                int dex1 = inputDoc(codeDoc);
                if (dex1 == 0) {
                    return 0;
                } else {
                    
                }
            } else if (in.equals("3")){
                codeDoc = 2;
                int dex1 = inputDoc(codeDoc);
                if (dex1 == 0) {
                    return 0;
                } else {
                    
                }
            } else if (in.equals("0")){
                key = false;
                return 0;
            } else {
                System.out.println("======================================");
                System.out.println("Index salah");
                System.out.println("Sihlakan Masukan Ulang");
                System.out.println("======================================");
            }
        }
        return 1;
    } 


    // Input Dokter Baru
    static int inputDoc (int codeDoc){
        dataDokter();
        if (indexInDoc[codeDoc]==5) {
            System.out.println("======================================");
            System.out.println("Mohon Maaf Kuota dokter Telah Penuh");
            System.out.println("======================================");
            return 1;
        } 
        indexInDoc[codeDoc]++; 
        boolean key = true;
        while (key) {
            System.out.print("Nama Doktor : ");
            String inNama = scStr.nextLine();
            dokter[codeDoc][0][indexInDoc[codeDoc]-1] = inNama;
            System.out.print("Masukan ID Dokter (6 Angka) : ");
            String inID = scStr.nextLine();
            dokter[codeDoc][1][indexInDoc[codeDoc]-1] = inID;

            int o = inID.length();
            if(o == 6){
                key = false;
                return 0;

            }else if (o > 6){
                int b = o - 6;
                System.out.println("Angka Yang Anda Masukan Kelebihan "+b+" Digit");
                System.out.println("Silahkan Masukan Ulang");
            } else {
                System.out.println("Input Yang Anda Masukan Salah");
                System.out.println("Silahkan Masukan Ulang");
            }
        }
        return 1;
    }
  
}
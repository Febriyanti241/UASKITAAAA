// AplikasiTransfer.java - Main program untuk testing aplikasi
import java.util.Scanner;
import java.util.ArrayList;

public class AplikasiTransfer {
    private static ArrayList<Pengirim> daftarPengirim = new ArrayList<>();
    private static ArrayList<Penerima> daftarPenerima = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== APLIKASI PENENGAH TRANSFER ===");
        System.out.println("Selamat datang di aplikasi transfer!");
        
        // Inisialisasi data dummy untuk testing
        initDataDummy();
        
        // Menu utama
        while (true) {
            tampilkanMenuUtama();
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (pilihan) {
                case 1:
                    menuPengirim();
                    break;
                case 2:
                    menuPenerima();
                    break;
                case 3:
                    daftarPengirimBaru();
                    break;
                case 4:
                    daftarPenerimaBaru();
                    break;
                case 5:
                    tampilkanSemuaUser();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    private static void initDataDummy() {
        // Membuat pengirim dummy
        Pengirim pengirim1 = new Pengirim("Ahmad Rizki", "P001", "ahmad@email.com", "081234567890", 5000000);
        Pengirim pengirim2 = new Pengirim("Siti Nurhaliza", "P002", "siti@email.com", "081234567891", 3000000);
        
        // Membuat penerima dummy
        Penerima penerima1 = new Penerima("Budi Santoso", "R001", "budi@email.com", "081234567892", 1000000, "1234567890", "Bank BCA");
        Penerima penerima2 = new Penerima("Maya Sari", "R002", "maya@email.com", "081234567893", 500000, "0987654321", "Bank Mandiri");
        Penerima penerima3 = new Penerima("Doni Pratama", "R003", "doni@email.com", "081234567894", 750000);
        
        daftarPengirim.add(pengirim1);
        daftarPengirim.add(pengirim2);
        daftarPenerima.add(penerima1);
        daftarPenerima.add(penerima2);
        daftarPenerima.add(penerima3);
    }
    
    private static void tampilkanMenuUtama() {
        System.out.println("\n=== MENU UTAMA ===");
        System.out.println("1. Menu Pengirim");
        System.out.println("2. Menu Penerima");
        System.out.println("3. Daftar Pengirim Baru");
        System.out.println("4. Daftar Penerima Baru");
        System.out.println("5. Tampilkan Semua User");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }
    
    private static void menuPengirim() {
        System.out.println("\n=== DAFTAR PENGIRIM ===");
        for (int i = 0; i < daftarPengirim.size(); i++) {
            System.out.println((i+1) + ". " + daftarPengirim.get(i).getNama() + " (ID: " + daftarPengirim.get(i).getId() + ")");
        }
        
        System.out.print("Pilih pengirim (0 untuk kembali): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        
        if (pilihan == 0) return;
        
        if (pilihan > 0 && pilihan <= daftarPengirim.size()) {
            Pengirim pengirim = daftarPengirim.get(pilihan - 1);
            menuAksiPengirim(pengirim);
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }
    
    private static void menuAksiPengirim(Pengirim pengirim) {
        while (true) {
            System.out.println("\n=== MENU PENGIRIM: " + pengirim.getNama() + " ===");
            System.out.println("1. Lihat Info Akun");
            System.out.println("2. Transfer Dana");
            System.out.println("3. Lihat Riwayat Transfer");
            System.out.println("4. Top Up Saldo");
            System.out.println("5. Ubah Limit Transfer");
            System.out.println("0. Kembali");
            System.out.print("Pilih aksi: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    pengirim.tampilkanInfo();
                    break;
                case 2:
                    prosesTransfer(pengirim);
                    break;
                case 3:
                    pengirim.tampilkanRiwayatTransfer();
                    break;
                case 4:
                    topUpSaldo(pengirim);
                    break;
                case 5:
                    ubahLimitTransfer(pengirim);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    private static void prosesTransfer(Pengirim pengirim) {
        System.out.println("\n=== DAFTAR PENERIMA ===");
        for (int i = 0; i < daftarPenerima.size(); i++) {
            Penerima penerima = daftarPenerima.get(i);
            System.out.println((i+1) + ". " + penerima.getNama() + " - " + penerima.getNamaBank() + " (ID: " + penerima.getId() + ")");
        }
        
        System.out.print("Pilih penerima: ");
        int pilihanPenerima = scanner.nextInt();
        scanner.nextLine();
        
        if (pilihanPenerima > 0 && pilihanPenerima <= daftarPenerima.size()) {
            Penerima penerima = daftarPenerima.get(pilihanPenerima - 1);
            
            System.out.print("Masukkan jumlah transfer: Rp");
            double jumlah = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Masukkan keterangan: ");
            String keterangan = scanner.nextLine();
            
            pengirim.transfer(penerima, jumlah, keterangan);
        } else {
            System.out.println("Pilihan penerima tidak valid!");
        }
    }
    
    private static void topUpSaldo(User user) {
        System.out.print("Masukkan jumlah top up: Rp");
        double jumlah = scanner.nextDouble();
        scanner.nextLine();
        
        user.tambahSaldo(jumlah);
    }
    
    private static void ubahLimitTransfer(Pengirim pengirim) {
        System.out.print("Masukkan limit transfer harian baru: Rp");
        double limitBaru = scanner.nextDouble();
        scanner.nextLine();
        
        pengirim.setLimitTransferHarian(limitBaru);
    }
    
    private static void menuPenerima() {
        System.out.println("\n=== DAFTAR PENERIMA ===");
        for (int i = 0; i < daftarPenerima.size(); i++) {
            System.out.println((i+1) + ". " + daftarPenerima.get(i).getNama() + " (ID: " + daftarPenerima.get(i).getId() + ")");
        }
        
        System.out.print("Pilih penerima (0 untuk kembali): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        
        if (pilihan == 0) return;
        
        if (pilihan > 0 && pilihan <= daftarPenerima.size()) {
            Penerima penerima = daftarPenerima.get(pilihan - 1);
            menuAksiPenerima(penerima);
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }
    
    private static void menuAksiPenerima(Penerima penerima) {
        while (true) {
            System.out.println("\n=== MENU PENERIMA: " + penerima.getNama() + " ===");
            System.out.println("1. Lihat Info Akun");
            System.out.println("2. Lihat Riwayat Penerimaan");
            System.out.println("3. Withdraw Dana");
            System.out.println("4. Top Up Saldo");
            System.out.println("0. Kembali");
            System.out.print("Pilih aksi: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    penerima.tampilkanInfo();
                    break;
                case 2:
                    penerima.tampilkanRiwayatPenerimaan();
                    break;
                case 3:
                    withdraw(penerima);
                    break;
                case 4:
                    topUpSaldo(penerima);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    private static void withdraw(Penerima penerima) {
        System.out.print("Masukkan jumlah withdraw: Rp");
        double jumlah = scanner.nextDouble();
        scanner.nextLine();
        
        penerima.withdraw(jumlah);
    }
    
    private static void daftarPengirimBaru() {
        System.out.println("\n=== DAFTAR PENGIRIM BARU ===");
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        
        String id = "P" + String.format("%03d", daftarPengirim.size() + 1);
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("No. Telepon: ");
        String noTelepon = scanner.nextLine();
        
        System.out.print("Saldo awal: Rp");
        double saldo = scanner.nextDouble();
        scanner.nextLine();
        
        Pengirim pengirimBaru = new Pengirim(nama, id, email, noTelepon, saldo);
        daftarPengirim.add(pengirimBaru);
        
        System.out.println("Pengirim baru berhasil didaftarkan dengan ID: " + id);
    }
    
    private static void daftarPenerimaBaru() {
        System.out.println("\n=== DAFTAR PENERIMA BARU ===");
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        
        String id = "R" + String.format("%03d", daftarPenerima.size() + 1);
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("No. Telepon: ");
        String noTelepon = scanner.nextLine();
        
        System.out.print("Saldo awal: Rp");
        double saldo = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Jenis akun (1: Bank, 2: Digital Wallet): ");
        int jenisAkun = scanner.nextInt();
        scanner.nextLine();
        
        Penerima penerimaBaru;
        
        if (jenisAkun == 1) {
            System.out.print("No. Rekening: ");
            String noRekening = scanner.nextLine();
            
            System.out.print("Nama Bank: ");
            String namaBank = scanner.nextLine();
            
            penerimaBaru = new Penerima(nama, id, email, noTelepon, saldo,
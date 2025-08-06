// Penerima.java - Subclass dari User
import java.util.ArrayList;

public class Penerima extends User {
    private ArrayList<TransaksiTransfer> riwayatPenerimaan;
    private String noRekening;
    private String namaBank;
    
    // Constructor
    public Penerima(String nama, String id, String email, String noTelepon, double saldo, 
                   String noRekening, String namaBank) {
        super(nama, id, email, noTelepon, saldo);
        this.riwayatPenerimaan = new ArrayList<>();
        this.noRekening = noRekening;
        this.namaBank = namaBank;
    }
    
    // Constructor tanpa info bank (untuk wallet digital)
    public Penerima(String nama, String id, String email, String noTelepon, double saldo) {
        super(nama, id, email, noTelepon, saldo);
        this.riwayatPenerimaan = new ArrayList<>();
        this.noRekening = "";
        this.namaBank = "Digital Wallet";
    }
    
    // Method untuk menerima saldo
    public void terimaSaldo(double jumlah) {
        if (jumlah > 0) {
            this.saldo += jumlah;
            System.out.println("Penerima " + this.nama + " menerima Rp" + jumlah);
        }
    }
    
    // Method untuk menambah riwayat penerimaan
    public void tambahRiwayatPenerimaan(TransaksiTransfer transaksi) {
        this.riwayatPenerimaan.add(transaksi);
    }
    
    // Method untuk melihat riwayat penerimaan
    public void tampilkanRiwayatPenerimaan() {
        System.out.println("\n=== Riwayat Penerimaan ===");
        if (riwayatPenerimaan.isEmpty()) {
            System.out.println("Belum ada transaksi penerimaan.");
        } else {
            for (TransaksiTransfer transaksi : riwayatPenerimaan) {
                transaksi.tampilkanDetailPenerimaan();
                System.out.println("------------------------");
            }
        }
    }
    
    // Method untuk withdraw saldo
    public boolean withdraw(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah withdraw harus positif!");
            return false;
        }
        
        if (this.saldo < jumlah) {
            System.out.println("Saldo tidak mencukupi untuk withdraw!");
            return false;
        }
        
        this.saldo -= jumlah;
        System.out.println("Withdraw berhasil! Jumlah: Rp" + jumlah);
        System.out.println("Saldo tersisa: Rp" + this.saldo);
        return true;
    }
    
    // Method untuk menghitung total penerimaan
    public double getTotalPenerimaan() {
        double total = 0;
        for (TransaksiTransfer transaksi : riwayatPenerimaan) {
            total += transaksi.getJumlah();
        }
        return total;
    }
    
    // Getter methods khusus Penerima
    public String getNoRekening() {
        return noRekening;
    }
    
    public String getNamaBank() {
        return namaBank;
    }
    
    public ArrayList<TransaksiTransfer> getRiwayatPenerimaan() {
        return riwayatPenerimaan;
    }
    
    // Setter methods
    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }
    
    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }
    
    // Override method tampilkanInfo dari parent class
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        if (!noRekening.isEmpty()) {
            System.out.println("No. Rekening: " + noRekening);
        }
        System.out.println("Bank/Platform: " + namaBank);
        System.out.println("Total Penerimaan: Rp" + getTotalPenerimaan());
        System.out.println("Jumlah Transaksi Diterima: " + riwayatPenerimaan.size());
    }
}
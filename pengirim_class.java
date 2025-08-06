// Pengirim.java - Subclass dari User
import java.util.ArrayList;
import java.util.Date;

public class Pengirim extends User {
    private ArrayList<TransaksiTransfer> riwayatTransfer;
    private double limitTransferHarian;
    private double totalTransferHariIni;
    
    // Constructor
    public Pengirim(String nama, String id, String email, String noTelepon, double saldo) {
        super(nama, id, email, noTelepon, saldo);
        this.riwayatTransfer = new ArrayList<>();
        this.limitTransferHarian = 10000000; // Rp 10 juta sebagai limit default
        this.totalTransferHariIni = 0;
    }
    
    // Constructor dengan limit custom
    public Pengirim(String nama, String id, String email, String noTelepon, double saldo, double limitTransferHarian) {
        super(nama, id, email, noTelepon, saldo);
        this.riwayatTransfer = new ArrayList<>();
        this.limitTransferHarian = limitTransferHarian;
        this.totalTransferHariIni = 0;
    }
    
    // Method untuk melakukan transfer
    public boolean transfer(Penerima penerima, double jumlah, String keterangan) {
        // Validasi jumlah transfer
        if (jumlah <= 0) {
            System.out.println("Jumlah transfer harus positif!");
            return false;
        }
        
        // Cek apakah saldo mencukupi
        if (this.saldo < jumlah) {
            System.out.println("Saldo tidak mencukupi! Saldo Anda: Rp" + this.saldo);
            return false;
        }
        
        // Cek limit transfer harian
        if (this.totalTransferHariIni + jumlah > this.limitTransferHarian) {
            System.out.println("Transfer melebihi limit harian! Limit: Rp" + this.limitTransferHarian + 
                             ", Sudah digunakan: Rp" + this.totalTransferHariIni);
            return false;
        }
        
        // Lakukan transfer
        this.saldo -= jumlah;
        penerima.terimaSaldo(jumlah);
        this.totalTransferHariIni += jumlah;
        
        // Buat record transaksi
        TransaksiTransfer transaksi = new TransaksiTransfer(
            this.id, 
            penerima.getId(), 
            jumlah, 
            keterangan, 
            new Date()
        );
        
        this.riwayatTransfer.add(transaksi);
        penerima.tambahRiwayatPenerimaan(transaksi);
        
        System.out.println("Transfer berhasil!");
        System.out.println("Jumlah: Rp" + jumlah);
        System.out.println("Kepada: " + penerima.getNama());
        System.out.println("Saldo tersisa: Rp" + this.saldo);
        
        return true;
    }
    
    // Method untuk melihat riwayat transfer
    public void tampilkanRiwayatTransfer() {
        System.out.println("\n=== Riwayat Transfer ===");
        if (riwayatTransfer.isEmpty()) {
            System.out.println("Belum ada transaksi transfer.");
        } else {
            for (TransaksiTransfer transaksi : riwayatTransfer) {
                transaksi.tampilkanDetail();
                System.out.println("------------------------");
            }
        }
    }
    
    // Getter methods khusus Pengirim
    public double getLimitTransferHarian() {
        return limitTransferHarian;
    }
    
    public double getTotalTransferHariIni() {
        return totalTransferHariIni;
    }
    
    public ArrayList<TransaksiTransfer> getRiwayatTransfer() {
        return riwayatTransfer;
    }
    
    // Setter untuk limit transfer harian
    public void setLimitTransferHarian(double limitTransferHarian) {
        this.limitTransferHarian = limitTransferHarian;
        System.out.println("Limit transfer harian diubah menjadi: Rp" + limitTransferHarian);
    }
    
    // Method untuk reset total transfer harian (biasanya dipanggil otomatis setiap hari)
    public void resetTotalTransferHarian() {
        this.totalTransferHariIni = 0;
        System.out.println("Total transfer harian telah direset.");
    }
    
    // Override method tampilkanInfo dari parent class
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Limit Transfer Harian: Rp" + limitTransferHarian);
        System.out.println("Total Transfer Hari Ini: Rp" + totalTransferHariIni);
        System.out.println("Jumlah Transaksi Transfer: " + riwayatTransfer.size());
    }
}
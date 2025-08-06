// TransaksiTransfer.java - Model untuk menyimpan data transaksi
import java.util.Date;
import java.text.SimpleDateFormat;

public class TransaksiTransfer {
    private String idTransaksi;
    private String idPengirim;
    private String idPenerima;
    private double jumlah;
    private String keterangan;
    private Date tanggalTransaksi;
    private String status;
    
    // Constructor
    public TransaksiTransfer(String idPengirim, String idPenerima, double jumlah, 
                           String keterangan, Date tanggalTransaksi) {
        this.idTransaksi = generateIdTransaksi();
        this.idPengirim = idPengirim;
        this.idPenerima = idPenerima;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.tanggalTransaksi = tanggalTransaksi;
        this.status = "BERHASIL";
    }
    
    // Method untuk generate ID transaksi unik
    private String generateIdTransaksi() {
        long timestamp = System.currentTimeMillis();
        return "TRX" + timestamp;
    }
    
    // Method untuk menampilkan detail transaksi (untuk pengirim)
    public void tampilkanDetail() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Tanggal: " + dateFormat.format(tanggalTransaksi));
        System.out.println("Penerima ID: " + idPenerima);
        System.out.println("Jumlah: Rp" + jumlah);
        System.out.println("Keterangan: " + keterangan);
        System.out.println("Status: " + status);
    }
    
    // Method untuk menampilkan detail transaksi (untuk penerima)
    public void tampilkanDetailPenerimaan() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Tanggal: " + dateFormat.format(tanggalTransaksi));
        System.out.println("Pengirim ID: " + idPengirim);
        System.out.println("Jumlah: Rp" + jumlah);
        System.out.println("Keterangan: " + keterangan);
        System.out.println("Status: " + status);
    }
    
    // Getter methods
    public String getIdTransaksi() {
        return idTransaksi;
    }
    
    public String getIdPengirim() {
        return idPengirim;
    }
    
    public String getIdPenerima() {
        return idPenerima;
    }
    
    public double getJumlah() {
        return jumlah;
    }
    
    public String getKeterangan() {
        return keterangan;
    }
    
    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }
    
    public String getStatus() {
        return status;
    }
    
    // Setter methods
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
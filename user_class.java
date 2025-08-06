// User.java - Superclass
public class User {
    protected String nama;
    protected String id;
    protected String email;
    protected String noTelepon;
    protected double saldo;
    
    // Constructor
    public User(String nama, String id, String email, String noTelepon, double saldo) {
        this.nama = nama;
        this.id = id;
        this.email = email;
        this.noTelepon = noTelepon;
        this.saldo = saldo;
    }
    
    // Getter methods
    public String getNama() {
        return nama;
    }
    
    public String getId() {
        return id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getNoTelepon() {
        return noTelepon;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    // Setter methods
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    // Method untuk menambah saldo
    public void tambahSaldo(double jumlah) {
        if (jumlah > 0) {
            this.saldo += jumlah;
            System.out.println("Saldo berhasil ditambahkan. Saldo saat ini: Rp" + this.saldo);
        } else {
            System.out.println("Jumlah yang ditambahkan harus positif!");
        }
    }
    
    // Method untuk menampilkan info user
    public void tampilkanInfo() {
        System.out.println("=== Informasi User ===");
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Email: " + email);
        System.out.println("No. Telepon: " + noTelepon);
        System.out.println("Saldo: Rp" + saldo);
    }
}
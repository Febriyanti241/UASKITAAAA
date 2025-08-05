// Abstract Class (dan Inheritance ke Abstract Class):
//➡️ Abstract class adalah class yang tidak bisa dibuat object-nya langsung, biasanya digunakan sebagai kerangka dasar (blueprint).
//➡️ Abstract class boleh punya method abstract (yang belum punya isi) dan boleh punya method biasa (yang sudah ada isi-nya).
//➡️ Subclass yang extend abstract class harus mengimplementasikan semua abstract method-nya (kecuali dia juga abstract).


public abstract class AbstractUser {
    protected String username;
    protected String password;

    public AbstractUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public abstract void login();
}

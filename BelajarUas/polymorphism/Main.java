public class Main {
    public static void main(String[] args) {
        User u1 = new Admin();
        User u2 = new Customer();

        u1.login();  // Polymorphism: Memanggil Admin's login()
        u2.login();  // Polymorphism: Memanggil Customer's login()

        u1.logout(); // Ini pakai logout() dari User (belum di-override)
        u2.logout(); // Ini juga pakai logout() dari User
    }
}

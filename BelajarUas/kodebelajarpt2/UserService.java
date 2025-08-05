import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private ArrayList<Customer> customers = new ArrayList<>();
    private Admin admin;

    public UserService() {
        admin = new Admin("admin", "admin123");
        updateUserCountFile();
    }

    public void registrasi(Scanner sc) throws UsernameAlreadyExistsException {
        System.out.print("Masukkan username: ");
        String username = sc.nextLine();

        if (isUsernameTaken(username)) {
            throw new UsernameAlreadyExistsException("Username sudah terdaftar.");
        }

        System.out.print("Masukkan password: ");
        String password = sc.nextLine();
        customers.add(new Customer(username, password));
        System.out.println("Registrasi berhasil!\n");
        updateUserCountFile();
    }

    public AbstractUser login(Scanner sc) {
        System.out.print("Masukkan username: ");
        String username = sc.nextLine();
        System.out.print("Masukkan password: ");
        String password = sc.nextLine();

        if (admin.getUsername().equals(username) && admin.checkPassword(password)) {
            admin.login();
            return admin;
        }

        for (Customer c : customers) {
            if (c.getUsername().equals(username) && c.checkPassword(password)) {
                c.login();
                return c;
            }
        }

        System.out.println("Login gagal! Username/password salah.\n");
        return null;
    }

    public void adminTambahUser(Scanner sc) throws UsernameAlreadyExistsException {
        System.out.print("Masukkan username baru: ");
        String username = sc.nextLine();

        if (isUsernameTaken(username)) {
            throw new UsernameAlreadyExistsException("Username sudah terdaftar.");
        }

        System.out.print("Masukkan password baru: ");
        String password = sc.nextLine();
        admin.addUser(username, password); // Panggil interface method
        customers.add(new Customer(username, password));
        System.out.println("User berhasil ditambahkan oleh admin!\n");
        updateUserCountFile();
    }

    private boolean isUsernameTaken(String username) {
        if (admin.getUsername().equals(username)) {
            return true;
        }
        for (Customer c : customers) {
            if (c.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private void updateUserCountFile() {
        try (FileWriter writer = new FileWriter("user_data.txt")) {
            writer.write("Total users (excluding admin): " + customers.size());
        } catch (IOException e) {
            System.out.println("Gagal menulis ke file user_data.txt");
        }
    }
}

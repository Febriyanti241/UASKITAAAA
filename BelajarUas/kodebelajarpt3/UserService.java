import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class UserService<T extends AbstractUser> {
    private List<T> users = new ArrayList<>();
    private Admin admin;

    public UserService() {
        admin = new Admin("admin", "admin123");
        updateUserCountFile();
    }

    public void registrasi(Scanner sc, UserFactory<T> factory) throws UsernameAlreadyExistsException {
        System.out.print("Masukkan username: ");
        String username = sc.nextLine();

        if (isUsernameTaken(username)) {
            throw new UsernameAlreadyExistsException("Username sudah terdaftar.");
        }

        System.out.print("Masukkan password: ");
        String password = sc.nextLine();
        T newUser = factory.createUser(username, password);
        users.add(newUser);
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

        Optional<T> matchedUser = users.stream()
                .filter(user -> user.getUsername().equals(username) && user.checkPassword(password))
                .findFirst();

        if (matchedUser.isPresent()) {
            matchedUser.get().login();
            return matchedUser.get();
        } else {
            System.out.println("Login gagal! Username/password salah.\n");
            return null;
        }
    }

    public void adminTambahUser(Scanner sc, UserFactory<T> factory) throws UsernameAlreadyExistsException {
        System.out.print("Masukkan username baru: ");
        String username = sc.nextLine();

        if (isUsernameTaken(username)) {
            throw new UsernameAlreadyExistsException("Username sudah terdaftar.");
        }

        System.out.print("Masukkan password baru: ");
        String password = sc.nextLine();
        admin.addUser(username, password);
        T newUser = factory.createUser(username, password);
        users.add(newUser);
        System.out.println("User berhasil ditambahkan oleh admin!\n");
        updateUserCountFile();
    }

    private boolean isUsernameTaken(String username) {
        return admin.getUsername().equals(username) ||
                users.stream().anyMatch(user -> user.getUsername().equals(username));
    }

    private void updateUserCountFile() {
        try (FileWriter writer = new FileWriter("user_data.txt")) {
            writer.write("Total users (excluding admin): " + users.size());
        } catch (IOException e) {
            System.out.println("Gagal menulis ke file user_data.txt");
        }
    }
}

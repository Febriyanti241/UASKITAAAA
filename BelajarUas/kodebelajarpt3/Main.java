import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService<Customer> userService = new UserService<>();
        CustomerFactory customerFactory = new CustomerFactory();

        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Registrasi");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            String pilihan = sc.nextLine();

            try {
                if (pilihan.equals("1")) {
                    userService.registrasi(sc, customerFactory);
                } else if (pilihan.equals("2")) {
                    AbstractUser user = userService.login(sc);
                    if (user instanceof Admin) {
                        // Admin Menu
                        while (true) {
                            System.out.println("\n=== Admin Menu ===");
                            System.out.println("1. Tambah User");
                            System.out.println("2. Logout");
                            System.out.print("Pilih: ");
                            String adminPilihan = sc.nextLine();

                            if (adminPilihan.equals("1")) {
                                try {
                                    userService.adminTambahUser(sc, customerFactory);
                                } catch (UsernameAlreadyExistsException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            } else if (adminPilihan.equals("2")) {
                                System.out.println("Logout berhasil.\n");
                                break;
                            } else {
                                System.out.println("Pilihan tidak valid.\n");
                            }
                        }
                    } else if (user instanceof Customer) {
                        // Customer Menu
                        while (true) {
                            System.out.println("\n=== Customer Menu ===");
                            System.out.println("1. Ganti Password");
                            System.out.println("2. Logout");
                            System.out.print("Pilih: ");
                            String customerPilihan = sc.nextLine();

                            if (customerPilihan.equals("1")) {
                                System.out.print("Masukkan password lama: ");
                                String oldPassword = sc.nextLine();
                                if (user.checkPassword(oldPassword)) {
                                    System.out.print("Masukkan password baru: ");
                                    String newPassword = sc.nextLine();
                                    user.setPassword(newPassword);
                                    System.out.println("Password berhasil diubah!\n");
                                } else {
                                    System.out.println("Password lama salah.\n");
                                }
                            } else if (customerPilihan.equals("2")) {
                                System.out.println("Logout berhasil.\n");
                                break;
                            } else {
                                System.out.println("Pilihan tidak valid.\n");
                            }
                        }
                    }
                } else if (pilihan.equals("3")) {
                    System.out.println("Program selesai.");
                    break;
                } else {
                    System.out.println("Pilihan tidak valid.\n");
                }
            } catch (UsernameAlreadyExistsException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
        }

        sc.close();
    }
}

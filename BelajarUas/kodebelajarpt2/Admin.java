public class Admin extends AbstractUser implements ManageableUser {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void login() {
        System.out.println("Admin login with OTP verification");
    }

    @Override
    public void addUser(String username, String password) {
        // Ini akan dipanggil oleh UserService untuk nambah user
        System.out.println("Admin menambahkan user: " + username);
    }
}

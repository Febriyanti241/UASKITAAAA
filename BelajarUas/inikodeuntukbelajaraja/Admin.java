public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void login() {
        System.out.println("Admin login with OTP verification");
    }
}

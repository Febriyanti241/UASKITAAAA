public class Admin extends User {
    @Override
    public void login() {
        System.out.println("Admin login with OTP verification");
    }
}

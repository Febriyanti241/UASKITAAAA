public class Customer extends User {
    public Customer(String username, String password) {
        super(username, password);
    }

    @Override
    public void login() {
        System.out.println("Customer login with username and password");
    }
}

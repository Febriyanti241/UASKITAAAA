public class CustomerFactory implements UserFactory<Customer> {
    @Override
    public Customer createUser(String username, String password) {
        return new Customer(username, password);
    }
}

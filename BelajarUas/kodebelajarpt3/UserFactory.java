public interface UserFactory<T extends AbstractUser> {
    T createUser(String username, String password);
}

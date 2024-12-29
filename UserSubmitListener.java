@FunctionalInterface
public interface UserSubmitListener {
    void onSubmit(String name, String userId, String address, String telephone, String extra);
}

public abstract class User {
    protected String name;
    protected String userId;
    protected String address;
    protected String telephone;

    public User(String name, String userId, String address, String telephone) {
        this.name = name;
        this.userId = userId;
        this.address = address;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }
}

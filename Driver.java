public class Driver extends User {
    private String driverLicense;

    public Driver(String name, String userId, String address, String telephone, String driverLicense) {
        super(name, userId, address, telephone);
        this.driverLicense = driverLicense;
    }

    public String getDriverLicense() {
        return driverLicense;
    }
}

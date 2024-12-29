public class Ride {
    private Driver driver;
    private Parent parent;
    private School school;
    private double cost;

    public Ride(Driver driver, Parent parent, School school, double cost) {
        this.driver = driver;
        this.parent = parent;
        this.school = school;
        this.cost = cost;
    }

    public Driver getDriver() {
        return driver;
    }

    public Parent getParent() {
        return parent;
    }

    public School getSchool() {
        return school;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "driver=" + driver.getName() +
                ", parent=" + parent.getName() +
                ", school=" + school.getName() +
                ", cost=" + cost +
                '}';
    }
}

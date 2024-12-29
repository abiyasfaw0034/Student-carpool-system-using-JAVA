public class Parent extends User {
    private int numberOfChildren;

    public Parent(String name, String userId, String address, String telephone, int numberOfChildren) {
        super(name, userId, address, telephone);
        this.numberOfChildren = numberOfChildren;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }
}

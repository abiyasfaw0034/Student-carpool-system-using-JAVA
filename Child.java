public class Child {
    String name;
    String age;
    String school;
    String pickupLocation;
    String dropOffLocation;

    public Child(String name, String age, String school, String pickupLocation, String dropOffLocation) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Child child = (Child) obj;
        return name.equals(child.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

public class School extends User {
    private String schoolName;

    public School(String name, String userId, String address, String telephone, String schoolName) {
        super(name, userId, address, telephone);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }
}

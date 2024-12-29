import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarpoolSystem extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    private List<Parent> parents;
    private List<Driver> drivers;
    private List<School> schools;
    private List<Ride> rides;

    private ParentInfoPanel parentInfoPanel;
    private ParentProfilePanel parentProfilePanel;
    private DriverInfoPanel driverInfoPanel;
    private DriverProfilePanel driverProfilePanel;
    private SchoolInfoPanel schoolInfoPanel;
    private SchoolProfilePanel schoolProfilePanel;
    private FindRidePanel findRidePanel;  // New panel for finding rides
    private User loggedInUser;

    public CarpoolSystem() {
        setTitle("Student Carpool System");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        parents = new ArrayList<>();
        drivers = new ArrayList<>();
        schools = new ArrayList<>();
        rides = new ArrayList<>();

        parentInfoPanel = new ParentInfoPanel(cardLayout, mainPanel, this);
        parentProfilePanel = new ParentProfilePanel(cardLayout, mainPanel);
        driverInfoPanel = new DriverInfoPanel(cardLayout, mainPanel, this);
        driverProfilePanel = new DriverProfilePanel(cardLayout, mainPanel);
        schoolInfoPanel = new SchoolInfoPanel(cardLayout, mainPanel, this);
        schoolProfilePanel = new SchoolProfilePanel(cardLayout, mainPanel);
        findRidePanel = new FindRidePanel(cardLayout, mainPanel, this);  // Initialize FindRidePanel

        addDemoData();
        addPanels();
        add(mainPanel);
        cardLayout.show(mainPanel, "Welcome");
    }

    private void addPanels() {
        mainPanel.add(new WelcomePanel(cardLayout, mainPanel), "Welcome");
        mainPanel.add(new LoginPanel(cardLayout, mainPanel, this), "Login");
        mainPanel.add(new SignUpPanel(cardLayout, mainPanel, this), "SignUp");
        mainPanel.add(new UserTypePanel("Parent", this::submitParent), "Parent");
        mainPanel.add(new UserTypePanel("Driver", this::submitDriver), "Driver");
        mainPanel.add(new UserTypePanel("School", this::submitSchool), "School");
        mainPanel.add(parentInfoPanel, "ParentInfo");
        mainPanel.add(parentProfilePanel, "ParentProfile");
        mainPanel.add(driverInfoPanel, "DriverInfo");
        mainPanel.add(driverProfilePanel, "DriverProfile");
        mainPanel.add(schoolInfoPanel, "SchoolInfo");
        mainPanel.add(schoolProfilePanel, "SchoolProfile");
        mainPanel.add(findRidePanel, "FindRide");  // Add FindRidePanel to the main panel
    }

    private void addDemoData() {
        parents.add(new Parent("John Doe", "P123", "123 Main St", "555-1234", 2));
        parents.add(new Parent("Jane Smith", "P124", "456 Elm St", "555-5678", 3));
        drivers.add(new Driver("Alice Brown", "D123", "789 Pine St", "555-8765", "XYZ123"));
        drivers.add(new Driver("Bob White", "D124", "101 Oak St", "555-4321", "ABC456"));
        drivers.add(new Driver("Bob White", "D124", "a", "555-4321", "ABC456"));
        schools.add(new School("Greenwood High", "S123", "101 Maple St", "555-1010", "Greenwood High"));
    }

    private void submitParent(String name, String userId, String address, String telephone, String extra) {
        int numberOfChildren = Integer.parseInt(extra);
        Parent parent = new Parent(name, userId, address, telephone, numberOfChildren);
        parents.add(parent);
        loggedInUser = parent;
        JOptionPane.showMessageDialog(this, "Parent information submitted!");
        cardLayout.show(mainPanel, "ParentInfo");
    }

    private void submitDriver(String name, String userId, String address, String telephone, String extra) {
        Driver driver = new Driver(name, userId, address, telephone, extra);
        drivers.add(driver);
        loggedInUser = driver;
        JOptionPane.showMessageDialog(this, "Driver information submitted!");
        cardLayout.show(mainPanel, "DriverInfo");
    }

    private void submitSchool(String name, String userId, String address, String telephone, String extra) {
        School school = new School(name, userId, address, telephone, extra);
        schools.add(school);
        loggedInUser = school;
        JOptionPane.showMessageDialog(this, "School information submitted!");
        cardLayout.show(mainPanel, "SchoolInfo");
    }

    public void login(String userId, String name) {
        for (Parent parent : parents) {
            if (parent.getUserId().equals(userId) && parent.getName().equals(name)) {
                loggedInUser = parent;
                cardLayout.show(mainPanel, "ParentInfo");
                return;
            }
        }
        for (Driver driver : drivers) {
            if (driver.getUserId().equals(userId) && driver.getName().equals(name)) {
                loggedInUser = driver;
                cardLayout.show(mainPanel, "DriverInfo");
                return;
            }
        }
        for (School school : schools) {
            if (school.getUserId().equals(userId) && school.getName().equals(name)) {
                loggedInUser = school;
                cardLayout.show(mainPanel, "SchoolInfo");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Invalid Name or User ID. Please try again.");
    }

    public void logout() {
        loggedInUser = null;
        parentInfoPanel.clearUserInfo();
        driverInfoPanel.clearUserInfo();
        schoolInfoPanel.clearUserInfo();
        cardLayout.show(mainPanel, "Welcome");
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<School> getSchools() {
        return schools;
    }

    public ParentProfilePanel getParentProfilePanel() {
        return parentProfilePanel;
    }

    public DriverProfilePanel getDriverProfilePanel() {
        return driverProfilePanel;
    }

    public SchoolProfilePanel getSchoolProfilePanel() {
        return schoolProfilePanel;
    }

    public void confirmRide(Driver selectedDriver, School school, double cost) {
        if (loggedInUser instanceof Parent) {
            Parent parent = (Parent) loggedInUser;
            Ride ride = new Ride(selectedDriver, parent, school, cost);
            rides.add(ride);
            JOptionPane.showMessageDialog(this, "Ride confirmed with " + selectedDriver.getName());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarpoolSystem app = new CarpoolSystem();
            app.setVisible(true);
        });
    }
}

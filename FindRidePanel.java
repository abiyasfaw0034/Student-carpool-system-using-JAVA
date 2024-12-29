import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FindRidePanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CarpoolSystem carpoolSystem;
    private JComboBox<Driver> driverComboBox;
    private JLabel costLabel;
    private double cost;
    private School selectedSchool; // Assuming there's a selected school

    public FindRidePanel(CardLayout cardLayout, JPanel mainPanel, CarpoolSystem carpoolSystem) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.carpoolSystem = carpoolSystem;
        setLayout(new GridBagLayout());
        setBackground(new Color(255, 248, 220));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(new JLabel("Select Driver:"), gbc);

        gbc.gridx = 1;
        driverComboBox = new JComboBox<>();
        driverComboBox.setPrototypeDisplayValue(new Driver("Bob White", "D124", "101 Oak St", "555-4321", "ABC456")); // Make the dropdown longer
        updateDriverComboBox();
        driverComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCost();
                updateDriverDetails();
            }
        });
        add(driverComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Cost:"), gbc);

        gbc.gridx = 1;
        costLabel = new JLabel("$0.0");
        add(costLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitRide();
            }
        });
        add(submitButton, gbc);
    }

    private void updateDriverComboBox() {
        driverComboBox.removeAllItems();
        Parent parent = (Parent) carpoolSystem.getLoggedInUser();
        if (parent != null) {
            List<Driver> filteredDrivers = filterDriversByLocation(parent.getAddress());
            for (Driver driver : filteredDrivers) {
                driverComboBox.addItem(driver);
            }
        }
    }

    private List<Driver> filterDriversByLocation(String location) {
        List<Driver> allDrivers = carpoolSystem.getDrivers();
        List<Driver> filteredDrivers = new ArrayList<>();
        for (Driver driver : allDrivers) {
            if (driver.getAddress().equals(location)) {
                filteredDrivers.add(driver);
            }
        }
        return filteredDrivers;
    }

    private void updateCost() {
        Driver selectedDriver = (Driver) driverComboBox.getSelectedItem();
        if (selectedDriver != null) {
            // Implement logic to calculate cost based on driver and parent's address
            // For demonstration purposes, I'm setting a dummy cost
            cost = 10.0; // Dummy cost
            costLabel.setText("$" + cost);
        }
    }

    private void updateDriverDetails() {
        Driver selectedDriver = (Driver) driverComboBox.getSelectedItem();
        if (selectedDriver != null) {
            // Show driver details (name and address) in smaller font
            JOptionPane.showMessageDialog(this, "Driver Details:\nName: " + selectedDriver.getName() + "\nAddress: " + selectedDriver.getAddress(), "Driver Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void submitRide() {
        Driver selectedDriver = (Driver) driverComboBox.getSelectedItem();
        Parent parent = (Parent) carpoolSystem.getLoggedInUser();
        if (selectedDriver != null && parent != null) {
            Ride newRide = new Ride(selectedDriver, parent, selectedSchool, cost);
            showConfirmationDialog(newRide);
        }
    }

    private void showConfirmationDialog(Ride ride) {
        int response = JOptionPane.showConfirmDialog(this, "Confirm ride details:\n" + ride, "Confirm Ride", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            carpoolSystem.confirmRide(ride.getDriver(), ride.getSchool(), ride.getCost());
            cardLayout.show(mainPanel, "ParentInfo");
        }
    }
}

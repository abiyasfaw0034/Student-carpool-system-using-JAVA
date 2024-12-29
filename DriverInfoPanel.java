import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverInfoPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel userIdLabel;
    private JLabel addressLabel;
    private JLabel telephoneLabel;
    private JLabel licenseLabel;
    private JButton profileButton;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CarpoolSystem carpoolSystem;

    public DriverInfoPanel(CardLayout cardLayout, JPanel mainPanel, CarpoolSystem carpoolSystem) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.carpoolSystem = carpoolSystem;

        setLayout(new GridBagLayout());
        setBackground(new Color(255, 248, 220));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JButton driverButton = new JButton("Driver");
        driverButton.setBackground(new Color(216, 191, 216));
        add(driverButton, gbc);

        gbc.gridx = 1;
        JButton logoutButton = new JButton("Log out");
        logoutButton.setBackground(new Color(216, 191, 216));
        add(logoutButton, gbc);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carpoolSystem.logout();
                clearUserInfo();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JButton findStudentsButton = createStyledButton("Find students");
        add(findStudentsButton, gbc);

        gbc.gridx = 1;
        JButton walletButton = createStyledButton("Wallet");
        add(walletButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        profileButton = createStyledButton("Profile");
        add(profileButton, gbc);

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carpoolSystem.getLoggedInUser() instanceof Driver) {
                    Driver driver = (Driver) carpoolSystem.getLoggedInUser();
                    carpoolSystem.getDriverProfilePanel().setUserInfo(driver.getName(), driver.getUserId(), driver.getAddress(), driver.getTelephone(), driver.getDriverLicense());
                }
                cardLayout.show(mainPanel, "DriverProfile");
            }
        });

        nameLabel = new JLabel();
        userIdLabel = new JLabel();
        addressLabel = new JLabel();
        telephoneLabel = new JLabel();
        licenseLabel = new JLabel();

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(nameLabel, gbc);
        gbc.gridy++;
        add(userIdLabel, gbc);
        gbc.gridy++;
        add(addressLabel, gbc);
        gbc.gridy++;
        add(telephoneLabel, gbc);
        gbc.gridy++;
        add(licenseLabel, gbc);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(216, 191, 216));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setOpaque(true);
        button.setBorderPainted(false);
        return button;
    }

    public void clearUserInfo() {
        nameLabel.setText("");
        userIdLabel.setText("");
        addressLabel.setText("");
        telephoneLabel.setText("");
        licenseLabel.setText("");
    }
}

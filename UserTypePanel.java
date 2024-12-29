import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserTypePanel extends JPanel {

    public UserTypePanel(String userType, UserSubmitListener submitListener) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        setBackground(new Color(255, 248, 220)); // Light background color

        // Initialize previous button and position it at the top right corner
        JButton previousButton = createStyledButton("Previous");
        gbc.gridx = 2; // Place at the furthest right
        gbc.gridy = 0; // Top corner
        gbc.anchor = GridBagConstraints.NORTHEAST; // Anchor to the top right corner
        gbc.insets = new Insets(10, 10, 10, 10); // Adjust insets for spacing
        add(previousButton, gbc);
        previousButton.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) getParent().getLayout();
            cardLayout.show(getParent(), "Welcome");
        });

        JLabel userLabel = new JLabel(userType + " Information");
        userLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        add(userLabel, gbc);

        JLabel nameLabel = new JLabel("Name:");
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        add(nameLabel, gbc);

        JTextField nameField = new JTextField(15);
        gbc.gridx = 1;
        add(nameField, gbc);

        JLabel userIdLabel = new JLabel("User ID:");
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(userIdLabel, gbc);

        JTextField userIdField = new JTextField(15);
        gbc.gridx = 1;
        add(userIdField, gbc);

        JLabel addressLabel = new JLabel("Address:");
        gbc.gridy = 3;
        gbc.gridx = 0;
        add(addressLabel, gbc);

        JTextField addressField = new JTextField(15);
        gbc.gridx = 1;
        add(addressField, gbc);

        JLabel telephoneLabel = new JLabel("Telephone:");
        gbc.gridy = 4;
        gbc.gridx = 0;
        add(telephoneLabel, gbc);

        JTextField telephoneField = new JTextField(15);
        gbc.gridx = 1;
        add(telephoneField, gbc);

        JLabel extraLabel = new JLabel(userType.equals("Parent") ? "Number of Children:" : userType.equals("Driver") ? "Driver License:" : "Additional Info:");
        gbc.gridy = 5;
        gbc.gridx = 0;
        add(extraLabel, gbc);

        JTextField extraField = new JTextField(15);
        gbc.gridx = 1;
        add(extraField, gbc);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(new Color(255, 215, 0)); // Gold color
        submitButton.setFocusPainted(false);
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 10, 10);
        add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String userId = userIdField.getText();
            String address = addressField.getText();
            String telephone = telephoneField.getText();
            String extra = extraField.getText();
            submitListener.onSubmit(name, userId, address, telephone, extra);
        });
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(255, 215, 0)); // Gold color
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setOpaque(true);
        button.setBorderPainted(false);
        return button;
    }
}

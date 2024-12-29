import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel {

    private JTextField userIdField;
    private JTextField nameField; // Add name field
    private JButton loginButton; // Make login button accessible outside constructor
    private JButton previousButton; // Previous button

    public LoginPanel(CardLayout cardLayout, JPanel mainPanel, CarpoolSystem carpoolSystem) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        setBackground(new Color(255, 248, 220)); // Light background color

        // Initialize previous button and position it at the top right corner
        previousButton = createStyledButton("Previous");
        previousButton.addActionListener(e -> cardLayout.show(mainPanel, "Welcome"));
        gbc.gridx = 2; // Place at the furthest right
        gbc.gridy = 0; // Top corner
        gbc.anchor = GridBagConstraints.NORTHEAST; // Anchor to the top right corner
        gbc.insets = new Insets(10, 10, 10, 10); // Adjust insets for spacing
        add(previousButton, gbc);

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginLabel, gbc);

        JLabel userIdLabel = new JLabel("User ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(userIdLabel, gbc);

        userIdField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(userIdField, gbc);

        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(nameLabel, gbc);

        nameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(nameField, gbc);

        loginButton = createStyledButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);

        loginButton.addActionListener(e -> {
            String userId = userIdField.getText();
            String name = nameField.getText(); // Get name
            if (!userId.isEmpty() && !name.isEmpty()) { // Check if both fields are filled
                carpoolSystem.login(userId, name); // Pass name to login method
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in both Name and User ID fields.");
            }
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

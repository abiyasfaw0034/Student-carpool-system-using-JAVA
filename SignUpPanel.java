import javax.swing.*;
import java.awt.*;

public class SignUpPanel extends JPanel {

    public SignUpPanel(CardLayout cardLayout, JPanel mainPanel, CarpoolSystem carpoolSystem) { // Adjusted constructor parameters
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        setBackground(new Color(255, 248, 220)); // Light background color

        JLabel signUpLabel = new JLabel("Sign Up");
        signUpLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(signUpLabel, gbc);

        JButton parentButton = createStyledButton("Parent");
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 10, 10, 5);
        add(parentButton, gbc);

        JButton driverButton = createStyledButton("Driver");
        gbc.gridx = 1;
        gbc.insets = new Insets(20, 5, 10, 10);
        add(driverButton, gbc);

        JButton schoolButton = createStyledButton("School");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 10, 10);
        add(schoolButton, gbc);

        parentButton.addActionListener(e -> cardLayout.show(mainPanel, "Parent"));
        driverButton.addActionListener(e -> cardLayout.show(mainPanel, "Driver"));
        schoolButton.addActionListener(e -> cardLayout.show(mainPanel, "School"));
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

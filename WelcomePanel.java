import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends JPanel {

    public WelcomePanel(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        setBackground(new Color(255, 248, 220)); // Light background color

        JLabel welcomeLabel = new JLabel("EduRide Express");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(welcomeLabel, gbc);

        JLabel subtitleLabel = new JLabel("(Student carpool service)");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 1;
        add(subtitleLabel, gbc);

        JButton loginButton = createStyledButton("Log In");
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 10, 10, 5);
        add(loginButton, gbc);

        JButton signUpButton = createStyledButton("Sign Up");
        gbc.gridx = 1;
        gbc.insets = new Insets(20, 5, 10, 10);
        add(signUpButton, gbc);

        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        signUpButton.addActionListener(e -> cardLayout.show(mainPanel, "SignUp"));
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

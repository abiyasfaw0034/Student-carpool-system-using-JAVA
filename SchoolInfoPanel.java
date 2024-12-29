import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchoolInfoPanel extends JPanel {
    private JButton schoolButton;
    private JButton logoutButton;
    private JButton sendNotificationsButton;
    private JButton profileButton;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CarpoolSystem carpoolSystem;

    public SchoolInfoPanel(CardLayout cardLayout, JPanel mainPanel, CarpoolSystem carpoolSystem) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.carpoolSystem = carpoolSystem;

        setLayout(new GridBagLayout());
        setBackground(new Color(255, 248, 220));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        schoolButton = createStyledButton("School");
        add(schoolButton, gbc);

        gbc.gridx = 1;
        logoutButton = createStyledButton("Log out");
        add(logoutButton, gbc);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carpoolSystem.logout();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        sendNotificationsButton = createStyledButton("Send notifications");
        add(sendNotificationsButton, gbc);

        gbc.gridy = 2;
        profileButton = createStyledButton("Profile");
        add(profileButton, gbc);

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carpoolSystem.getLoggedInUser() instanceof School) {
                    School school = (School) carpoolSystem.getLoggedInUser();
                    carpoolSystem.getSchoolProfilePanel().setUserInfo(school.getName(), school.getUserId(), school.getAddress(), school.getTelephone(), school.getSchoolName());
                }
                cardLayout.show(mainPanel, "SchoolProfile");
            }
        });
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
        // Clear any specific user-related information here if needed.
    }
}

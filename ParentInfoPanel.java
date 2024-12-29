import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParentInfoPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel userIdLabel;
    private JLabel addressLabel;
    private JLabel telephoneLabel;
    private JLabel childrenLabel;
    private JButton profileButton;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CarpoolSystem carpoolSystem;

    public ParentInfoPanel(CardLayout cardLayout, JPanel mainPanel, CarpoolSystem carpoolSystem) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.carpoolSystem = carpoolSystem;

        setLayout(new GridBagLayout());
        setBackground(new Color(255, 248, 220));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JButton parentButton = new JButton("Parents");
        parentButton.setBackground(new Color(216, 191, 216));
        add(parentButton, gbc);

        gbc.gridx = 1;
        JButton logoutButton = new JButton("Log out");
        logoutButton.setBackground(new Color(216, 191, 216));
        add(logoutButton, gbc);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carpoolSystem.logout();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JButton checkStatusButton = createStyledButton("Check status");
        add(checkStatusButton, gbc);

        gbc.gridx = 1;
        JButton addChildButton = createStyledButton("Add child");
        add(addChildButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JButton findDriverButton = createStyledButton("Find driver");
        add(findDriverButton, gbc);

        gbc.gridx = 1;
        JButton removeChildButton = createStyledButton("Remove child");
        add(removeChildButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JButton walletButton = createStyledButton("Wallet");
        add(walletButton, gbc);

        gbc.gridx = 1;
        profileButton = createStyledButton("Profile");
        add(profileButton, gbc);

        findDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "FindRide");
            }
        });
        
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carpoolSystem.getLoggedInUser() instanceof Parent) {
                    Parent parent = (Parent) carpoolSystem.getLoggedInUser();
                    carpoolSystem.getParentProfilePanel().setUserInfo(parent.getName(), parent.getUserId(), parent.getAddress(), parent.getTelephone(), String.valueOf(parent.getNumberOfChildren()));
                }
                cardLayout.show(mainPanel, "ParentProfile");
            }
        });

        nameLabel = new JLabel();
        userIdLabel = new JLabel();
        addressLabel = new JLabel();
        telephoneLabel = new JLabel();
        childrenLabel = new JLabel();

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(nameLabel, gbc);
        gbc.gridy++;
        add(userIdLabel, gbc);
        gbc.gridy++;
        add(addressLabel, gbc);
        gbc.gridy++;
        add(telephoneLabel, gbc);
        gbc.gridy++;
        add(childrenLabel, gbc);
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
        childrenLabel.setText("");
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParentProfilePanel extends JPanel {
    private JLabel nameLabel;
    private JLabel userIdLabel;
    private JLabel addressLabel;
    private JLabel telephoneLabel;
    private JLabel childrenLabel;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public ParentProfilePanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new GridBagLayout());
        setBackground(new Color(255, 248, 220));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Parent Profile"), gbc);

        nameLabel = new JLabel();
        userIdLabel = new JLabel();
        addressLabel = new JLabel();
        telephoneLabel = new JLabel();
        childrenLabel = new JLabel();

        gbc.gridy++;
        add(nameLabel, gbc);
        gbc.gridy++;
        add(userIdLabel, gbc);
        gbc.gridy++;
        add(addressLabel, gbc);
        gbc.gridy++;
        add(telephoneLabel, gbc);
        gbc.gridy++;
        add(childrenLabel, gbc);

        gbc.gridy++;
        JButton previousButton = new JButton("Previous");
        previousButton.setBackground(new Color(216, 191, 216));
        previousButton.setFont(new Font("Arial", Font.BOLD, 14));
        previousButton.setFocusPainted(false);
        previousButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        previousButton.setOpaque(true);
        previousButton.setBorderPainted(false);
        add(previousButton, gbc);

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "ParentInfo");
            }
        });
    }

    public void setUserInfo(String name, String userId, String address, String telephone, String children) {
        nameLabel.setText("Name: " + name);
        userIdLabel.setText("User ID: " + userId);
        addressLabel.setText("Address: " + address);
        telephoneLabel.setText("Telephone: " + telephone);
        childrenLabel.setText("Number of Children: " + children);
    }
}

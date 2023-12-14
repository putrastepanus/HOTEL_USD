package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class navbar extends JPanel {
    private JLabel mainMenuLabel;
    private JLabel historyLabel;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public navbar(CardLayout cardLayout, JPanel cardPanel) {
        System.out.println("cardLayout: " + cardLayout); // Tambahkan log ini
        System.out.println("cardPanel: " + cardPanel); // Tambahkan log ini

        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        mainMenuLabel = createNavbarLabel("Home");
        historyLabel = createNavbarLabel("History");

        historyLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showHistoryPage();
            }
        });

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.decode("#AA323C"));

        addLabelsToNavbar(mainMenuLabel, historyLabel);
    }

    private JLabel createNavbarLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        return label;
    }

    private void addLabelsToNavbar(JLabel... labels) {
        for (JLabel label : labels) {
            add(label);
            add(Box.createHorizontalStrut(10));
        }
    }

    private void showHistoryPage() {
        System.out.println("Switching to historyCard");
        cardLayout.show(cardPanel, "historyCard");
    }
}
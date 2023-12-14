package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Components.CustomCardPanel;

public class CardLayoutExample {
    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CardLayoutExample example = new CardLayoutExample();
            example.createAndShowGUI();
        });
    }

    public void createAndShowGUI() {
        frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Create two cards
        JPanel card1 = createCard("Card 1", Color.RED);
        JPanel card2 = createCard("Card 2", Color.BLUE);
        JPanel card3 = createCard("Card 3", Color.GREEN);
        // Add cards to cardPanel
        cardPanel.add(card1, "Card1");
        cardPanel.add(card2, "Card2");

        // Create navigation buttons
        JButton showCard1Button = new JButton("Show Card 1");
        JButton showCard2Button = new JButton("Show Card 2");

        // Add action listeners to buttons
        showCard1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Card1");
            }
        });

        showCard2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Card2");
            }
        });

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showCard1Button);
        buttonPanel.add(showCard2Button);

        // Add components to the frame
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Set frame properties
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createCard(String cardName, Color color) {
        JPanel card = new JPanel();
        card.setBackground(color);
        JLabel label = new JLabel(cardName);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        card.add(label);
        return card;
    }
}
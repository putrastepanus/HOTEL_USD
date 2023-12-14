package Components;

import javax.swing.*;
import javax.swing.border.*;

import page.BookingPanel;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomCardPanel extends JPanel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Card Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new CustomCardPanel());
            frame.pack();
            frame.setVisible(true);
        });
    }

    public CustomCardPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        int margin = 10;
        int padding = 5;
        headerPanel.setBorder(new CompoundBorder(
                new EmptyBorder(margin, margin, margin, margin),
                new CompoundBorder(
                        new MatteBorder(0, 0, 1, 0, Color.lightGray), // Bottom border
                        new EmptyBorder(padding, padding, padding, padding))));

        JLabel headerLabel = new JLabel("Room 503");
        headerPanel.add(headerLabel);
        cardPanel.add(headerPanel, BorderLayout.NORTH);

        // Body
        JPanel bodyPanel = new JPanel(new BorderLayout());
        bodyPanel.setSize(949, 200);
        // JLabel bodyText = new JLabel("GAMBAR DISINI");
        // bodyPanel.add(bodyText, BorderLayout.WEST);
        try {
            URL imageUrl = new URL(
                    "https://aremorch.com/wp-content/uploads/2016/09/The-Details-That-Matter-Top-Things-Every-Luxury-Hotel-Room-Should-Have.png");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(949, 400, Image.SCALE_SMOOTH)));
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            bodyPanel.add(imageLabel, BorderLayout.CENTER);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        bodyPanel.setBorder(new CompoundBorder(
                new EmptyBorder(margin, margin, margin, margin),
                new CompoundBorder(
                        new MatteBorder(0, 0, 0, 0, Color.lightGray),
                        new EmptyBorder(padding, padding, padding, padding))));

        cardPanel.add(bodyPanel, BorderLayout.CENTER);

        // Footer
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBorder(new EmptyBorder(margin, margin, margin, margin));

        JLabel footerLabel = new JLabel("DESCRIPTION Goes Here");

        footerPanel.add(footerLabel, BorderLayout.WEST);

        JButton reservationButton = new JButton("Booking");

        reservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Reservation button clicked");
                BookingPanel bookingPanel = new BookingPanel();
                bookingPanel.display();
            }
        });

        footerPanel.add(reservationButton, BorderLayout.EAST);

        cardPanel.add(footerPanel, BorderLayout.SOUTH);

        add(cardPanel);
    }
}

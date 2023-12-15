package Components;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;

public class HistoryPanel extends JPanel {
    String roomNumber;
    String roomType;
    int roomCapacity;
    int pricePerNight;
    boolean availability;
    String roomDescription;
    String roomSize;

    public HistoryPanel() {
        super();
        init(); // Initializing the panel
    }

    public void init() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        // Add dummy data directly within the init method
        addHistory(panel, "https://via.placeholder.com/150", "101", "Standard", 2, 100, true,
                "Standard room with basic amenities", "Medium");
        addHistory(panel, "https://via.placeholder.com/150", "201", "Deluxe", 4, 200, true,
                "Deluxe room with extra space", "Large");
        addHistory(panel, "https://via.placeholder.com/150", "301", "Suite", 6, 300, false,
                "Luxurious suite with exclusive services", "Extra Large");

        setPreferredSize(new Dimension(800, 600)); // Set the preferred size
        revalidate();
        repaint();
    }

    private void addHistory(JPanel historyPanel, String imageUrl, String roomName, String type, int capacity,
            int price, boolean availability, String description, String size) {

        JPanel historyCardPanel = new JPanel(new BorderLayout());

        JLabel imageLabel = new JLabel();

        try {
            Image img = ImageIO.read(new URL(imageUrl));
            imageLabel.setIcon(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String formattedPrice = numberFormat.format(price);

        historyCardPanel.add(imageLabel, BorderLayout.WEST);

        JPanel detailsPanel = new JPanel(new BorderLayout());

        String detailsHtml = "<html><b>" + type + "</b><br>" + "Room Name: " + roomName + "<br>" + "Room Size: " + size
                + "<br>" + "Capacity: " + capacity + "<br>" + "Availability: " + availability + "<br>"
                + "Description: " + description + "<br>" + "<b>" + "Price: " + formattedPrice + "</b>" + "<br>"
                + "</html>";

        JLabel detailsLabel = new JLabel(detailsHtml);

        detailsLabel.setBorder(new EmptyBorder(0, 10, 0, 10));

        detailsPanel.add(detailsLabel, BorderLayout.CENTER);

        historyCardPanel.add(detailsPanel, BorderLayout.CENTER);

        JButton bookingButton = new JButton("Booking");
        bookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle booking action if needed
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(bookingButton);
        historyCardPanel.add(buttonPanel, BorderLayout.EAST);
        historyCardPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray), // Bottom border
                BorderFactory.createEmptyBorder(5, 5, 5, 5) // Add padding
        ));
        historyPanel.add(historyCardPanel);
    }
}

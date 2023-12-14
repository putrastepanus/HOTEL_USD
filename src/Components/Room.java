package Components;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class Room extends JPanel {
    private JPanel mainPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Room();
            }
        });
    }

    public Room() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1));
        addRoom("https://via.placeholder.com/150", "Room 113", "Deluxe", 3, 120000, "Tersedia",
                "Kamar Deluxe dengan pemandangan kota yang indah.", "3x3");
        addRoom("https://via.placeholder.com/150", "Room 114", "Standard", 2, 90000, "Tidak Tersedia",
                "Kamar Standard dengan fasilitas dasar.", "5x10");
        addRoom("https://via.placeholder.com/150", "Room 114", "Standard", 2, 90000, "Tidak Tersedia",
                "Kamar Standard dengan fasilitas dasar.", "12x 14");
        addRoom("https://via.placeholder.com/150", "Room 114", "Standard", 2, 90000, "Tidak Tersedia",
                "Kamar Standard dengan fasilitas dasar.", "12x 14");
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane);
    }

    private void addRoom(String imageUrl, String roomName, String type, int capacity, int price, String status,
            String description, String size) {
        JPanel roomPanel = new JPanel(new BorderLayout());

        JLabel imageLabel = new JLabel();

        try {
            Image img = ImageIO.read(new URL(imageUrl));
            imageLabel.setIcon(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        roomPanel.add(imageLabel, BorderLayout.WEST);

        JPanel detailsPanel = new JPanel(new BorderLayout());

        String detailsHtml = "<html><b>" + type + "</b><br>" +
                "Room Name: " + roomName + "<br>" +
                "Room Size: " + size + "<br>" +
                "Capacity: " + capacity + "<br>" +
                "Status: " + status + "<br>" +
                "Description: " + description + "<br>" +
                "<b>" + "Price: " + price + "</b>" + "<br>" +
                "</html>"
        ;

        JLabel detailsLabel = new JLabel(detailsHtml);

        detailsLabel.setBorder(new EmptyBorder(0, 10, 0, 10));

        detailsPanel.add(detailsLabel, BorderLayout.CENTER);

        roomPanel.add(detailsPanel, BorderLayout.CENTER);

        JButton bookingButton = new JButton("Booking");
        bookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Room.this, "Booking room: " + roomName);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(bookingButton);
        roomPanel.add(buttonPanel, BorderLayout.EAST);
        roomPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray), // Bottom border
                BorderFactory.createEmptyBorder(5, 5, 5, 5) // Menambahkan padding
        ));
        mainPanel.add(roomPanel);
    }
}

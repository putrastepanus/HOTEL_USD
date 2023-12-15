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
import java.util.List;
import java.util.Locale;

import Data.Room;
import page.BookingPanel;

public class ShowRoom extends JScrollPane {
    String user;

    public ShowRoom(String user) {
        super();
        this.user = user;
        JPanel roomPanel = new JPanel();
        roomPanel.setLayout(new GridLayout(0, 1));

        List<Room> roomsList = Room.getAllUsers();
        for (Room room : roomsList) {
            addRoom(roomPanel, "https://via.placeholder.com/150", room.getNo_kamar(), room.getTipe_kamar(),
                    room.getKapasitas_kamar(), room.getHarga_per_malam(), "Tersedia",
                    room.getUkuran_kamar());
        }

        setViewportView(roomPanel);
        setPreferredSize(new Dimension(800, 600)); // Set the preferred size
        revalidate();
        repaint();
    }

    private void addRoom(JPanel roomPanel, String imageUrl, int roomNo, String type, int capacity, int price,
            String status, String size) {

        JPanel roomCardPanel = new JPanel(new BorderLayout());

        JLabel imageLabel = new JLabel();

        try {
            Image img = ImageIO.read(new URL(imageUrl));
            imageLabel.setIcon(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        NumberFormat numberFormat = NumberFormat
                .getCurrencyInstance(new Locale.Builder().setLanguage("id").setRegion("ID").build());
        String formattedPrice = numberFormat.format(price);

        roomCardPanel.add(imageLabel, BorderLayout.WEST);

        JPanel detailsPanel = new JPanel(new BorderLayout());

        String detailsHtml = "<html><b>" + type + "</b><br>" + "Room Name: " + roomNo + "<br>" + "Room Size: " + size
                + "<br>" + "Capacity: " + capacity + "<br>" + "Status: " + status + "<br>" + "<br>" + "<b>" + "Price: "
                + formattedPrice + "</b>" + "<br>" + "</html>";

        JLabel detailsLabel = new JLabel(detailsHtml);

        detailsLabel.setBorder(new EmptyBorder(0, 10, 0, 10));

        detailsPanel.add(detailsLabel, BorderLayout.CENTER);

        roomCardPanel.add(detailsPanel, BorderLayout.CENTER);

        JButton bookingButton;
        if (user.equals("ADMIN")) {
            bookingButton = new JButton("Edit");
        } else {
            bookingButton = new JButton("Booking");
        }

        bookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (user.equals("ADMIN")) {
                    // Display edit frame
                    // EditFrame editFrame = new EditFrame(roomNo, type, capacity, price,
                    // status, description, size);
                    // editFrame.display();
                    System.out.println("Edit");
                } else {
                    // Display booking panel
                    BookingPanel bookingPanel = new BookingPanel(roomNo, type, capacity, price, status, size);
                    bookingPanel.display();
                }
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(bookingButton);
        roomCardPanel.add(buttonPanel, BorderLayout.EAST);
        roomCardPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray), // Bottom border
                BorderFactory.createEmptyBorder(5, 5, 5, 5) // Menambahkan padding
        ));
        roomPanel.add(roomCardPanel);
    }
}
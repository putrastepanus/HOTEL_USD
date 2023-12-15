package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Components.ListRoom.RoomInfo;

public class DetailRooms extends JPanel {

    public DetailRooms(RoomInfo roomInfo) {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240)); // Warna latar belakang

        JLabel titleLabel = new JLabel(roomInfo.type + " - " + roomInfo.category);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(51, 102, 204)); // Warna teks

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.setBackground(new Color(200, 200, 200)); // Warna latar belakang header
        headerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.gray)); // Garis bawah header

        JTextArea detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        detailsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsArea.append("Facilities: " + roomInfo.facilities + "\n\n");
        detailsArea.append("Description: " + roomInfo.description + "\n\n");
        detailsArea.append("Total Rooms: " + roomInfo.totalRooms);

        JScrollPane scrollPane = new JScrollPane(detailsArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        JButton bookButton = new JButton("Book Now");
        bookButton.setFont(new Font("Arial", Font.BOLD, 16));
        bookButton.setForeground(Color.WHITE);
        bookButton.setBackground(new Color(51, 102, 204)); 
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
       
                JOptionPane.showMessageDialog(DetailRooms.this, "Booking functionality will be implemented soon!");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(bookButton);

        add(headerPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Menambahkan padding keseluruhan panel
    }

    
}

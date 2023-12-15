package Components;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListRoom extends JPanel {

    private JList<RoomInfo> roomList;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListRoom());
    }

    public class RoomInfo {
        String category;
        String type;
        String facilities;
        String description;
        int totalRooms;
        String imagePath;

        RoomInfo(String category, String type, String facilities, String description, int totalRooms,
                String imagePath) {
            this.category = category;
            this.type = type;
            this.facilities = facilities;
            this.description = description;
            this.totalRooms = totalRooms;
            this.imagePath = imagePath;
        }

        @Override
        public String toString() {
            return type + " - " + category;
        }
    }

    public ListRoom() {

        roomList = new JList<>(generateDummyRoomData().toArray(new RoomInfo[0]));
        roomList.setCellRenderer(new RoomListRenderer());
        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(roomList);
        add(scrollPane, BorderLayout.CENTER);

        roomList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                // Mendapatkan indeks item yang dipilih
                int selectedIndex = roomList.getSelectedIndex();
                if (selectedIndex != -1) {
                    RoomInfo selectedRoom = roomList.getModel().getElementAt(selectedIndex);
                    displayRoomDetail(selectedRoom);
                }
            }
        });
    }

    private static class RoomListRenderer implements ListCellRenderer<RoomInfo> {

        private JPanel panel;
        private JLabel imageLabel;
        private JLabel detailsLabel;

        RoomListRenderer() {
            panel = new JPanel(new BorderLayout(10, 10)); // Menambahkan padding dan margin
            imageLabel = new JLabel();
            detailsLabel = new JLabel();
            panel.add(imageLabel, BorderLayout.WEST);
            panel.add(detailsLabel, BorderLayout.CENTER);

            panel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray), // Bottom border
                    BorderFactory.createEmptyBorder(5, 5, 5, 5) // Menambahkan padding
            ));
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends RoomInfo> list, RoomInfo value, int index,
                boolean isSelected, boolean cellHasFocus) {
            try {
                URL imageUrl = new URL(value.imagePath);
                Image image = ImageIO.read(imageUrl);
                // Memperbesar gambar agar lebih luas
                ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(150, 100, Image.SCALE_SMOOTH));
                imageLabel.setIcon(imageIcon);
            } catch (IOException e) {
                e.printStackTrace();
            }

            detailsLabel.setText("<html><b>" + value.type + " - " + value.category + "</b><br>" +
                    "Facilities: " + value.facilities + "<br>" +
                    "Description: " + value.description + "<br>" +
                    "Total Rooms: " + value.totalRooms + "</html>");

            if (isSelected) {
                panel.setBackground(list.getSelectionBackground());
                panel.setForeground(list.getSelectionForeground());
            } else {
                panel.setBackground(list.getBackground());
                panel.setForeground(list.getForeground());
            }
            return panel;
        }
    }

    private List<RoomInfo> generateDummyRoomData() {
        List<RoomInfo> roomData = new ArrayList<>();
        roomData.add(new RoomInfo("Deluxe", "Deluxe Room", "Wi-Fi, TV, Air Conditioning",
                "Spacious room with a king-size bed", 10,
                "https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg"));
        roomData.add(new RoomInfo("Deluxe", "Deluxe Twins", "Wi-Fi, TV, Air Conditioning", "Room with twin beds", 8,
                "https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg"));
        roomData.add(new RoomInfo("Superior", "Superior King", "Wi-Fi, TV, Air Conditioning",
                "Room with a king-size bed and a city view", 5,
                "https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg"));
        roomData.add(new RoomInfo("Superior", "Superior King", "Wi-Fi, TV, Air Conditioning",
                "Room with a king-size bed and a city view", 5,
                "https://t3.ftcdn.net/jpg/02/71/08/28/360_F_271082810_CtbTjpnOU3vx43ngAKqpCPUBx25udBrg.jpg"));
        // Add more room types as needed

        return roomData;
    }

    private void displayRoomDetail(RoomInfo roomInfo) {
        DetailRooms detailPanel = new DetailRooms(roomInfo);
        detailPanel.setVisible(true);
    }
}
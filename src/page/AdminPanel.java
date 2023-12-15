package page;

import Components.HistoryPanel;
import Components.ListRoom;
import Components.navHeader;
import Data.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Components.ShowRoom;

public class AdminPanel {

    private JFrame frame;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private JLabel mainMenuLabel;
    private JLabel historyLabel;
    private ShowRoom room;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminPanel roomMenu = new AdminPanel();
            roomMenu.displayHomePage();
        });
    }

    private void initializeFrame() {
        frame = new JFrame("Admin Panel");
        frame.setSize(949, 758);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setUndecorated(false);
    }

    public void displayHomePage() {
        initializeFrame();

        // NAVBAR
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));

        JPanel containerNavbar = new JPanel();
        JButton adminHome = new JButton("Room List"); // Use the class-level backButton variable
        adminHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        JButton newRoom = new JButton("New Room"); // Use the class-level backButton variable
        newRoom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        JButton bookedRoom = new JButton("Edit"); // Use the class-level backButton variable
        bookedRoom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        containerNavbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        containerNavbar.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        containerNavbar.setBackground(Color.decode("#AA323C"));

        containerNavbar.add(adminHome); // Use backButton instead of mainMenuLabel and historyLabel
        containerNavbar.add(newRoom); // Use backButton instead of mainMenuLabel and historyLabel
        containerNavbar.add(bookedRoom); // Use backButton instead of mainMenuLabel and historyLabel

        navPanel.add(new navHeader());
        navPanel.add(containerNavbar);

        frame.setLayout(new BorderLayout());
        frame.add(navPanel, BorderLayout.NORTH);

        contentPanel = new JPanel(new CardLayout());

        // Initialize room object
        room = new ShowRoom("ADMIN");

        contentPanel.add(room);

        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
package page;

import Components.HistoryPanel;
import Components.ListRoom;
import Components.navHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Components.Room;

public class RoomMenu {

    private JFrame frame;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private JLabel mainMenuLabel;
    private JLabel historyLabel;
    private Room room;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RoomMenu roomMenu = new RoomMenu();
            roomMenu.displayHomePage();
        });
    }

    private void initializeFrame() {
        frame = new JFrame("Homepage");
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
        JButton backButton = new JButton("Back"); // Use the class-level backButton variable
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainMenu mainMenu = new MainMenu();
                mainMenu.displayHomePage();
                frame.dispose();
            }
        });

        containerNavbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        containerNavbar.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        containerNavbar.setBackground(Color.decode("#AA323C"));
        containerNavbar.add(backButton); // Use backButton instead of mainMenuLabel and historyLabel

        navPanel.add(new navHeader());
        navPanel.add(containerNavbar);

        frame.setLayout(new BorderLayout());
        frame.add(navPanel, BorderLayout.NORTH);

        contentPanel = new JPanel(new CardLayout());

        // Initialize room object
        room = new Room();

        contentPanel.add(room);

        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
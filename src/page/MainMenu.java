package page;

import Components.DetailRooms;
import Components.HistoryPanel;
import Components.ListRoom;
import Components.navHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu {

    private JFrame frame;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private JLabel mainMenuLabel;
    private JLabel historyLabel;
    private ListRoom listRoom;
    private DetailRooms detailRooms;
    private HistoryPanel historyPage;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.displayHomePage();
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
        mainMenuLabel = createNavbarLabel("Home");
        mainMenuLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                roomListPage();
            }
        });

        historyLabel = createNavbarLabel("History");
        historyLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showHistoryPage();
            }
        });

        containerNavbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        containerNavbar.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        containerNavbar.setBackground(Color.decode("#AA323C"));
        containerNavbar.add(mainMenuLabel);
        containerNavbar.add(historyLabel);

        navPanel.add(new navHeader());
        navPanel.add(containerNavbar);

        frame.setLayout(new BorderLayout());
        frame.add(navPanel, BorderLayout.NORTH);

        contentPanel = new JPanel(new CardLayout()); // Memindahkan inisialisasi contentPanel ke sini
        frame.add(contentPanel, BorderLayout.CENTER);

        cardLayout = (CardLayout) contentPanel.getLayout();
        listRoom = new ListRoom();
        roomListPage();
        frame.setVisible(true);
    }

    private JLabel createNavbarLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));
        return label;
    }

    private void showHistoryPage() {
        JPanel historyPanel = new HistoryPanel(); // Ganti dengan kelas HistoryPanel sebenarnya atau komponen
        addCardToContentPanel(historyPanel);
    }

    private void roomListPage() {
        JPanel roomListPanel = new JPanel(new BorderLayout());
        roomListPanel.add(listRoom, BorderLayout.CENTER);
        addCardToContentPanel(roomListPanel);
    }

    private void ListRoomCreated(ListRoom list) {
        JPanel containerRoomList = new JPanel();
        containerRoomList.add(list);
        addCardToContentPanel(containerRoomList);
    }

    private void addCardToContentPanel(JPanel card) {
        contentPanel.add(card, "Card 1");
        cardLayout.show(contentPanel, "Card 1");
    }
}
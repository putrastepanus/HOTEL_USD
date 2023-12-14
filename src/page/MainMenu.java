package page;

import Components.CustomCardPanel;
import Components.HistoryPanel;
import Components.navHeader;
import Components.navbar;

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

        contentPanel = new JPanel(new CardLayout());

        // NAVBAR
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));

        // container
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

        frame.add(contentPanel, BorderLayout.CENTER);

        contentPanel = new JPanel(new CardLayout());
        frame.add(contentPanel, BorderLayout.CENTER);

        cardLayout = (CardLayout) contentPanel.getLayout();
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

    // ALL PAGE LISTED HERE
    private void Test() {
        JPanel card1 = createCard("Card 1");
        addCardToContentPanel(card1);
    }

    private void showHistoryPage() {
        JPanel historyPanel = new HistoryPanel(); // Replace with the actual HistoryPanel class or component
        addCardToContentPanel(historyPanel);
    }

    private void roomListPage() {
        JPanel roomList = new CustomCardPanel();
        System.out.println(roomList);
        addCardToContentPanel(roomList);
    }

    // ----------------------------
    // END OF ALL PAGE LISTED HERE
    // ----------------------------

    // DO NOT TOUCH THIS
    private void addCardToContentPanel(JPanel card) {
        contentPanel.add(card, "Card 1");
        cardLayout.show(contentPanel, "Card 1");
    }

    private JPanel createCard(String cardName) {
        JPanel card = new JPanel();
        JLabel label = new JLabel(cardName);
        label.setForeground(Color.WHITE);
        card.add(label);
        return card;
    }

}

// private JPanel createNavPanel() {

// navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));

// navPanel.add(new navHeader());

// // Buat objek navbar dengan mengirimkan CardLayout dan contentPanel
// nav = new navbar((CardLayout) contentPanel.getLayout(), contentPanel);
// navPanel.add(nav);

// return navPanel;
// }

// private void addCardsToContentPanel() {
// List<JPanel> homePanels = createHomePage();

// for (int i = 0; i < homePanels.size(); i++) {
// // Setiap kartu ditambahkan ke contentPanel dengan nama unik
// contentPanel.add(homePanels.get(i), "card" + i);
// }
// }

// private List<JPanel> createHomePage() {
// List<JPanel> homePanels = new ArrayList<>();

// // Buat dan tambahkan CustomCardPanel
// CustomCardPanel roomList = new CustomCardPanel();
// roomList.setPreferredSize(new Dimension(400, 300));
// roomList.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
// JPanel roomListWrapper = new JPanel(new BorderLayout());
// roomListWrapper.add(roomList, BorderLayout.CENTER);
// homePanels.add(roomListWrapper);

// // Buat dan tambahkan HistoryPanel
// HistoryPanel historyPanel = new HistoryPanel();
// JPanel historyWrapper = new JPanel(new BorderLayout());
// historyWrapper.add(historyPanel, BorderLayout.CENTER);
// homePanels.add(historyWrapper);

// return homePanels;
// }
// }

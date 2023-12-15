package page;

import Components.HistoryPanel;
import Components.ListRoom;
import Components.navHeader;
import Data.Reservasi;
import Data.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List; // Import List interface

import Components.ShowRoom;

public class HistoryMenu {

    private JFrame frame;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private JButton backButton; // Declare backButton at class level
    private JButton homeButton; // Declare homeButton at class level
    private JTable historyTable; // Declare historyTable at class level

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HistoryMenu historyMenu = new HistoryMenu();
            historyMenu.displayHistoryPage(); // Corrected method name
        });
    }

    private void initializeFrame() {
        frame = new JFrame("History Page"); // Adjust frame title
        frame.setSize(949, 758);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setUndecorated(false);
    }

    public void displayHistoryPage() { // Adjust method name
        initializeFrame();

        // NAVBAR
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));

        JPanel containerNavbar = new JPanel();

        backButton = new JButton("Back");
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Use dispose() to close the current frame
                frame.dispose();
            }
        });

        homeButton = new JButton("Home");
        homeButton.addMouseListener(new MouseAdapter() {
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
        containerNavbar.add(homeButton);
        containerNavbar.add(backButton);

        navPanel.add(new navHeader());
        navPanel.add(containerNavbar);

        frame.setLayout(new BorderLayout());
        frame.add(navPanel, BorderLayout.NORTH);

        // Content panel should be instantiated
        contentPanel = new JPanel(new BorderLayout());

        // Replace the following lines with the actual data retrieval logic
        List<Reservasi> reservationList = Reservasi.getAllUsers();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Reservation ID");
        tableModel.addColumn("Reservation Date");
        tableModel.addColumn("Check-in Date");
        tableModel.addColumn("Check-out Date");

        for (Reservasi reservation : reservationList) {
            tableModel.addRow(new Object[] {
                    reservation.getRESERVASI_ID(),
                    reservation.getTANGGAL_RESERVASI(),
                    reservation.getTANGGAL_CHECK_IN(),
                    reservation.getTANGGAL_CHECK_OUT()
            });
        }

        historyTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(historyTable);

        contentPanel.add(scrollPane, BorderLayout.CENTER);
        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

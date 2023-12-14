package page;

import Components.CustomCardPanel;
import Components.HistoryPanel;
import Components.navHeader;
import Components.navbar;

import javax.swing.*;
import java.awt.*;

public class Invoice {

    private JFrame frame;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private JLabel mainMenuLabel;
    private JLabel historyLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Invoice mainMenu = new Invoice();
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

    private void displayHomePage() {
        initializeFrame();

        JPanel panel = new JPanel(new GridLayout(2, 1));

        JLabel invoiceID = new JLabel();
        JLabel invoiceDate = new JLabel();
        JLabel invoiceTotal = new JLabel();
        JLabel invoiceRoom = new JLabel();
        JLabel invoiceGuest = new JLabel();
        JLabel invoiceCheckin = new JLabel();
        JLabel invoiceCheckout = new JLabel();
        JLabel invoiceDuration = new JLabel();
        JLabel invoicePrice = new JLabel();
        JLabel invoicePayment = new JLabel();

        JPanel topPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

    }
}
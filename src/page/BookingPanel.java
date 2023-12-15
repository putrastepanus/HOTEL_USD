package page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Properties;

public class BookingPanel extends JPanel {

    private JFrame frame;
    private JDatePicker checkinPicker;
    private JDatePicker checkoutPicker;

    private String roomName;
    private String type;
    private int capacity;
    private int price;
    private String status;
    private String description;
    private String size;
    JLabel totalLabel;

    // public static void main(String[] args) {
    // SwingUtilities.invokeLater(() -> {
    // BookingPanel bookingPanel = new BookingPanel("Room 1", "Single", 1, 100,
    // "Available", "Description",
    // "Small");
    // bookingPanel.display();
    // });
    // }

    public BookingPanel(String roomName, String type, int capacity, int price, String status, String description,
            String size) {
        this.roomName = roomName;
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        this.status = status;
        this.description = description;
        this.size = size;

        System.out.println("Room Name: " + roomName);
    }

    private void initialValues() {
        frame = new JFrame("Booking Panel");
        frame.setSize(949, 758);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
    }

    public void display() {
        initialValues();

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JPanel leftPane = createLeftPane();
        JPanel rightPane = createRightPane();

        panel.add(leftPane);
        panel.add(rightPane);

        frame.add(panel);
        frame.setVisible(true);
    }

    private JPanel createLeftPane() {
        JPanel leftPane = new JPanel(new BorderLayout());
        leftPane.setBackground(Color.decode("#AA323C"));

        NumberFormat numberFormat = NumberFormat
                .getCurrencyInstance(new Locale.Builder().setLanguage("id").setRegion("ID").build());
        String formattedPrice = numberFormat.format(price);

        String detailsHtml = "<html><div style='text-align: center;'>" +
                "<h2 style='color: #FFFFFF;'><b>" + "Room Information" + "</b></h2><br>" +
                "<b>Room Name:</b> " + roomName + "<br>" +
                "<b>Room Size:</b> " + size + "<br>" +
                "<b>Capacity:</b> " + capacity + "<br>" +
                "<b>Status:</b> " + status + "<br>" +
                "<b>Description:</b> " + description + "<br>" +
                "<h3 style='color: #FFFFFF;'>Price/Night: " + formattedPrice + "</h3><br>" +
                "</div></html>";

        JLabel detailsLabel = new JLabel(detailsHtml);
        detailsLabel.setForeground(Color.WHITE);
        leftPane.add(detailsLabel, BorderLayout.CENTER);

        JPanel containerPanel = new JPanel(new GridBagLayout());
        containerPanel.setBackground(Color.decode("#AA323C"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;

        containerPanel.add(leftPane, gbc);

        return containerPanel;
    }

    private JPanel createRightPane() {
        JPanel rightPane = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel guestNameLabel = new JLabel("Guest Name:");
        JTextField guestNameField = new JTextField(20);

        JLabel totalGuestLabel = new JLabel("Total Guests:");
        String[] totalGuest = { "1", "2", "3", "4" };
        JComboBox<String> totalGuestComboBox = new JComboBox<>(totalGuest);

        JLabel checkinLabel = new JLabel("Check-in:");
        checkinPicker = createDatePicker();
        JLabel checkinSelectedDateLabel = new JLabel("Selected Date: ");

        JLabel checkoutLabel = new JLabel("Check-out:");
        checkoutPicker = createDatePicker();
        JLabel checkoutSelectedDateLabel = new JLabel("Selected Date: ");

        totalLabel = new JLabel("Total" + " " + "IDR 1000000");
        totalLabel.setHorizontalAlignment(JLabel.RIGHT);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Checkout successful!, Please See Your History to see your booking");
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            RoomMenu roomMenu = new RoomMenu();
            roomMenu.displayHomePage();
            frame.dispose();
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        rightPane.add(guestNameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        rightPane.add(guestNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        rightPane.add(totalGuestLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        rightPane.add(totalGuestComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        rightPane.add(checkinLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        rightPane.add((Component) checkinPicker, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        rightPane.add(checkoutLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        rightPane.add((Component) checkoutPicker, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        rightPane.add(totalLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        rightPane.add(backButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        rightPane.add(checkoutButton, gbc);

        checkinPicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date selectedDate = (Date) checkinPicker.getModel().getValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate = dateFormat.format(selectedDate);
                checkinSelectedDateLabel.setText("Selected Date: " + formattedDate);

                System.out.println("Checkin : " + checkinSelectedDateLabel);
                calculateTotalPricePerDay();
            }
        });

        checkoutPicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date selectedDate = (Date) checkoutPicker.getModel().getValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate = dateFormat.format(selectedDate);
                checkoutSelectedDateLabel.setText("Selected Date: " + formattedDate);
                System.out.println("Checkout : " + checkoutSelectedDateLabel);
                calculateTotalPricePerDay();
            }
        });

        return rightPane;
    }

    private JDatePicker createDatePicker() {
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);

        datePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date selectedDate = (Date) datePicker.getModel().getValue();

                if (selectedDate != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate = dateFormat.format(selectedDate);
                    System.out.println(formattedDate);
                    datePicker.getJFormattedTextField().setText(formattedDate);
                }
            }
        });
        return datePicker;
    }

    private void calculateTotalPricePerDay() {
        LocalDate checkinDate = getSelectedDate(checkinPicker);
        LocalDate checkoutDate = getSelectedDate(checkoutPicker);

        if (checkinDate != null && checkoutDate != null) {
            long numberOfDays = Duration.between(checkinDate.atStartOfDay(), checkoutDate.atStartOfDay()).toDays();

            System.out.println("Number of days: " + numberOfDays);

            double nightlyPrice = (double) price;
            double totalWithoutPPN = numberOfDays * nightlyPrice;
            double ppn = totalWithoutPPN * 0.05; // PPN is 5% of the total without PPN
            double totalWithPPN = totalWithoutPPN + ppn;

            NumberFormat numberFormat = NumberFormat
                    .getCurrencyInstance(new Locale.Builder().setLanguage("id").setRegion("ID").build());
            String formattedTotal = numberFormat.format(totalWithPPN);
            totalLabel.setText("Total " + formattedTotal);

            // Display or use the totalWithPPN as needed
            System.out.println("Total Price per Day (including 5% PPN): " + totalWithPPN);
        } else {
            System.out.println("Please select both check-in and check-out dates.");
        }
    }

    private LocalDate getSelectedDate(JDatePicker datePicker) {
        Date selectedDate = (Date) datePicker.getModel().getValue();
        if (selectedDate != null) {
            return selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        return null;
    }

}

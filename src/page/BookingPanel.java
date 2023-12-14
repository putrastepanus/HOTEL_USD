package page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.swing.JFrame;

public class BookingPanel extends JPanel {

    private JFrame frame;
    private JDatePicker checkinPicker;
    private JDatePicker checkoutPicker;

    public static void main(String[] args) {
        BookingPanel bookingPanel = new BookingPanel();
        bookingPanel.display();
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

        JPanel leftPane = new JPanel(new BorderLayout());
        leftPane.setBackground(Color.decode("#AA323C"));
        JLabel bannerLabel = new JLabel("Room Information");
        bannerLabel.setForeground(Color.WHITE);
        bannerLabel.setHorizontalAlignment(JLabel.CENTER);
        leftPane.add(bannerLabel, BorderLayout.CENTER);

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

        JLabel totalLabel = new JLabel("Total" + " " + "IDR 1000000");
        totalLabel.setHorizontalAlignment(JLabel.RIGHT);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            System.out.println("Submit button clicked");
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        rightPane.add(guestNameLabel, gbc);

        gbc.gridx = 1;
        rightPane.add(guestNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        rightPane.add(totalGuestLabel, gbc);

        gbc.gridx = 1;
        rightPane.add(totalGuestComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        rightPane.add(checkinLabel, gbc);

        gbc.gridx = 1;
        rightPane.add((Component) checkinPicker, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        rightPane.add(checkoutLabel, gbc);

        gbc.gridx = 1;
        rightPane.add((Component) checkoutPicker, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        rightPane.add(totalLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        rightPane.add(submitButton, gbc);

        panel.add(leftPane);
        panel.add(rightPane);

        frame.add(panel);
        frame.setVisible(true);

        checkinPicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date selectedDate = (Date) checkinPicker.getModel().getValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate = dateFormat.format(selectedDate);
                checkinSelectedDateLabel.setText("Selected Date: " + formattedDate);
            }
        });

        checkoutPicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date selectedDate = (Date) checkoutPicker.getModel().getValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate = dateFormat.format(selectedDate);
                checkoutSelectedDateLabel.setText("Selected Date: " + formattedDate);
            }
        });
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
}

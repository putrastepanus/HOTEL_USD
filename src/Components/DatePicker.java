package Components;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.swing.*;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class DatePicker extends JPanel {
    private JFrame frame;
    private JDatePicker datePicker;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DatePicker();
            }
        });
    }

    public DatePicker() {
        frame = new JFrame("Checkin Date");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);

        JLabel selectedDateLabel = new JLabel("Selected Date: ");

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 1));
        formPanel.add(datePicker);
        formPanel.add(selectedDateLabel); 

        frame.add(formPanel);
        frame.pack();
        frame.setVisible(true);
    }
}

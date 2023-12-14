package page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class NewRooms extends JFrame {

    private JTextField roomNumberField;
    private JTextField roomTypeField;
    private JTextField numberOfRoomsField;
    private JButton addButton;
    private JButton uploadButton;
    private JLabel imageLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewRooms().setVisible(true);
            }
        });
    }

    public NewRooms() {
        setTitle("New Room");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        createLayout();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRoom();
            }
        });

        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadImage();
            }
        });
    }

    private void initComponents() {
        roomNumberField = new JTextField(10);
        roomTypeField = new JTextField(10);
        numberOfRoomsField = new JTextField(10);
        addButton = new JButton("Add Room");
        uploadButton = new JButton("Upload Image");
        imageLabel = new JLabel();
    }

    private void createLayout() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Room Number:"), gbc);

        gbc.gridx = 1;
        panel.add(roomNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Room Type:"), gbc);

        gbc.gridx = 1;
        panel.add(roomTypeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Number of Rooms:"), gbc);

        gbc.gridx = 1;
        panel.add(numberOfRoomsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(uploadButton, gbc);

        gbc.gridy = 4;
        panel.add(imageLabel, gbc);

        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(addButton, gbc);

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(panel);

        pack();
    }

    private void addRoom() {
        String roomNumber = roomNumberField.getText();
        String roomType = roomTypeField.getText();
        String numberOfRooms = numberOfRoomsField.getText();

        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Rooms: " + numberOfRooms);

        setVisible(false);
        dispose();
    }

    private void uploadImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            imageLabel.setText(selectedFile.getAbsolutePath());
        }
    }

}
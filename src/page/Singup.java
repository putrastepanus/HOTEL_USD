package page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.*;

public class Singup extends JFrame {
    private ImageIcon banner = new ImageIcon("C:\\Usd_hotel\\src\\assets\\usd-banner.png");

    public static void main(String[] args) {
        new Singup();
    }

    public Singup() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(949, 758);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        // Left pane - displaying the banner in the center
        JPanel leftPane = new JPanel();
        leftPane.setLayout(new BorderLayout());
        leftPane.setBackground(Color.decode("#AA323C"));
        JLabel bannerLabel = new JLabel(banner);
        leftPane.add(bannerLabel, BorderLayout.CENTER);

        // Right pane - displaying the login form
        JPanel rightPane = new JPanel();
        rightPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // labels
        JLabel fullNameLabel = new JLabel("Full Name:");
        JLabel usernameLabel = new JLabel("User Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JLabel passwordLabel = new JLabel("Password:");

        // fields
        JTextField fullNameField = new JTextField(20);
        JTextField usernameField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton signUp = new JButton("Sign Up");

        JButton loginButton = new JButton("Login");

        gbc.gridx = 0;
        gbc.gridy = 0;
        rightPane.add(fullNameLabel, gbc);

        gbc.gridx = 1;
        rightPane.add(fullNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        rightPane.add(usernameLabel, gbc);

        gbc.gridx = 1;
        rightPane.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        rightPane.add(emailLabel, gbc);

        gbc.gridx = 1;
        rightPane.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        rightPane.add(phoneNumberLabel, gbc);

        gbc.gridx = 1;
        rightPane.add(phoneNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        rightPane.add(passwordLabel, gbc);

        gbc.gridx = 1;
        rightPane.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        rightPane.add(signUp, gbc);

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullName = fullNameField.getText();
                String username = usernameField.getText();
                String email = emailField.getText();
                String phoneNumber = phoneNumberField.getText();
                String password = new String(passwordField.getPassword());

                if (!fullName.isEmpty() && !username.isEmpty() && !email.isEmpty() && !phoneNumber.isEmpty()
                        && !password.isEmpty()) {
                    // Perform sign up logic here
                    JOptionPane.showMessageDialog(null, "Sign up successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                }
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 7;
        rightPane.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login login = new login();
                login.setVisible(true);
                setVisible(false);
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 6;
        rightPane.add(new JLabel("Already have an account? Login"), gbc);

        gbc.gridx = 1;
        rightPane.add(new JLabel(), gbc);

        gbc.gridx = 2;
        rightPane.add(new JLabel(), gbc);

        panel.add(leftPane);
        panel.add(rightPane);

        add(panel);
        setVisible(true);

        phoneNumberField.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str.matches("\\d+") && getLength() + str.length() <= 15) {
                    super.insertString(offs, str, a);
                }
            }
        });
    }
}

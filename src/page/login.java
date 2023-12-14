package page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton; // Added signup button
    private ImageIcon banner = new ImageIcon("..\\USD_Hotels\\src\\assets\\usd-banner.png");

    public static void main(String[] args) {
        new login();
    }

    public login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(949, 758);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        JPanel leftPane = new JPanel();
        leftPane.setLayout(new BorderLayout());
        leftPane.setBackground(Color.decode("#AA323C"));
        JLabel bannerLabel = new JLabel(banner);
        leftPane.add(bannerLabel, BorderLayout.CENTER);

        JPanel rightPane = new JPanel();
        rightPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        signupButton = new JButton("Signup");

        gbc.gridx = 0;
        gbc.gridy = 0;
        rightPane.add(usernameLabel, gbc);

        gbc.gridx = 1;
        rightPane.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        rightPane.add(passwordLabel, gbc);

        gbc.gridx = 1;
        rightPane.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        rightPane.add(loginButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        rightPane.add(new JLabel("Doesnt have Acoount? Register Now"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        rightPane.add(signupButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (!username.isEmpty() && !password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    setVisible(false);
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.displayHomePage();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Singup singup = new Singup();
                singup.setVisible(true);
                setVisible(false);
            }
        });
        panel.add(leftPane);
        panel.add(rightPane);

        add(panel);
        setVisible(true);
    }
}

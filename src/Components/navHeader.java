package Components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class navHeader extends JPanel {
    private JLabel logoLabel;
    private JLabel profilePictureLabel;

    public navHeader() {
        setLayout(new BorderLayout());

        ImageIcon logoIcon = new ImageIcon("..\\USD_Hotels\\src\\assets\\n" + //
                "avHeader.png");
        logoLabel = new JLabel(logoIcon);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0)); // Add left padding of 5 pixels
        add(logoLabel, BorderLayout.WEST);

        // ImageIcon imageIcon = loadImageIconFromURL("https://i.pravatar.cc/500");
        // JComboBox<ImageIcon> imageComboBox = new JComboBox<>(new ImageIcon[] { imageIcon });
        // imageComboBox.setRenderer(new ImageComboBoxRenderer());

        // profilePictureLabel = new JLabel();
        // add(profilePictureLabel, BorderLayout.EAST);
    }

    // private ImageIcon loadImageIconFromURL(String url) {
    //     try {
    //         Image image = ImageIO.read(new URL(url));
    //         return new ImageIcon(image);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new navHeader().setVisible(true);
        });
    }

}

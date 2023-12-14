package Components;

import javax.swing.*;
import java.awt.*;

public class navHeader extends JPanel {
    private JLabel logoLabel;

    public navHeader() {
        setLayout(new BorderLayout());
        ImageIcon logoIcon = new ImageIcon(".\\src\\assets\\navHeader.png");
        logoLabel = new JLabel(logoIcon);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0)); 
        add(logoLabel, BorderLayout.WEST);

    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new navHeader().setVisible(true);
        });
    }

}

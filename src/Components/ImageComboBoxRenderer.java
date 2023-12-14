package Components;

import javax.swing.*;
import java.awt.*;


class ImageComboBoxRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // Set the icon for the JComboBox item
        if (value instanceof ImageIcon) {
            label.setIcon((ImageIcon) value);
        }

        return label;
    }
}
package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HistoryPanel extends JPanel {
    private List<String> transactionHistory;

    public HistoryPanel() {
        transactionHistory = new ArrayList<>();
        setLayout(new BorderLayout());

        JTextArea historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton clearButton = new JButton("Clear History");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transactionHistory.clear();
                historyTextArea.setText("");
            }
        });
        add(clearButton, BorderLayout.SOUTH);
    }

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
        updateHistoryTextArea();
    }

    private void updateHistoryTextArea() {
        StringBuilder sb = new StringBuilder();
        for (String transaction : transactionHistory) {
            sb.append(transaction).append("\n");
        }
        JTextArea historyTextArea = (JTextArea) ((JScrollPane) getComponent(0)).getViewport().getView();
        historyTextArea.setText(sb.toString());
    }
}
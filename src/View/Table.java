package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Table {
    public void addTable(JPanel panel, DefaultTableModel model) {
        JTable table = new JTable();
        JTableHeader header = table.getTableHeader();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
    }
}

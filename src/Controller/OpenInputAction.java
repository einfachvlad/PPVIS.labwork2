package Controller;

import Model.Students;
import View.Input;
import View.SearchDelete;
import View.Window;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OpenInputAction implements ActionListener {
    Input dialog;
    TableModel model;
    Students students=new Students();
    JTable table = new JTable();

    public OpenInputAction(Input dialog, TableModel model, Students students) {
        this.dialog = dialog;
        this.model = model;
        this.students=students;
    }

    public void actionPerformed(ActionEvent event) {
        if (dialog == null) // в первый раз
        {
            table.setModel(model);
            dialog = new Input(dialog.frame, "Ввод", table, students);
        }
        dialog.dialog.setVisible(true); // отобразить диалог

        /*JTable table = new JTable(model);
        JTableHeader header = table.getTableHeader();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);*/
    }
}

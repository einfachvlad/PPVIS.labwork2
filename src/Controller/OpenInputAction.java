package Controller;

import Model.Students;
import View.Input;
import View.SearchDelete;
import View.StudentsModel;
import View.Window;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class OpenInputAction implements ActionListener {
    Input dialog=null;
    Students students;
    JTable mainTable;

    public OpenInputAction( Students students,JTable mainTable) {
        this.students=students;
        this.mainTable=mainTable;
    }

    public void actionPerformed(ActionEvent event) {
        if (dialog == null) // в первый раз
        {
            dialog = new Input(null, "Ввод", students,mainTable);
        }
        dialog.dialog.setVisible(true); // отобразить диалог

        /*JTable table = new JTable(model);
        JTableHeader header = table.getTableHeader();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);*/
    }
}

package Controller;

import Model.Students;
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


public class SearchDeleteAction implements ActionListener {
    SearchDelete dialog=null;
    DefaultTableModel model=new DefaultTableModel();
    StudentsModel studentsModel;
    Students students;
    String name;
    JTable table=new JTable();

    public SearchDeleteAction(String name, Students students) {
      // this.dialog = dialog;
        this.name=name;
        this.students = students;
       // this.model = model;
    }

    public void actionPerformed(ActionEvent event) {
        if (dialog == null) // в первый раз
        {
            dialog = new SearchDelete(null, name, table);
        }
        studentsModel = new StudentsModel(students);
        model = studentsModel.getModel();
        table.setModel(model);
        dialog.dialog.setVisible(true); // отобразить диалог

        /*JTable table = new JTable(model);
        JTableHeader header = table.getTableHeader();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);*/
    }
}

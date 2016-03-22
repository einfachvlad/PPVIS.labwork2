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


public class OpenInputAction implements ActionListener {
    Input dialog=null;
    DefaultTableModel model=new DefaultTableModel();
    StudentsModel studentsModel;
    Students students;
    JTable table = new JTable();
    JTable mainTable;

    public OpenInputAction( Students students,JTable mainTable) {
        //this.dialog = dialog;
      //  this.model = model;
        this.students=students;
        this.mainTable=mainTable;
    }

    public void actionPerformed(ActionEvent event) {
        if (dialog == null) // в первый раз
        {
            dialog = new Input(null, "Ввод", table, students,mainTable);
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

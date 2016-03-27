package Controller.Search;

import Model.Students;
import View.Search;
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


public class OpenSearchAction implements ActionListener {
    Search dialog=null;
    Students students;

    public OpenSearchAction(Students students) {
        this.students = students;
    }

    public void actionPerformed(ActionEvent event) {
        if (dialog == null) // в первый раз
        {
            dialog = new Search(null,students);
        }
        dialog.dialog.setVisible(true); // отобразить диалог


    }
}

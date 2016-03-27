package Controller.Delete;

import Model.Students;
import View.Delete;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OpenDeleteAction implements ActionListener {
    Delete dialog=null;
    Students students;
    JTable mainTable;

    public OpenDeleteAction(Students students,JTable mainTable) {
        this.students = students;
        this.mainTable=mainTable;
    }

    public void actionPerformed(ActionEvent event) {
        if (dialog == null) // в первый раз
        {
            dialog = new Delete(null,students,mainTable);
        }
        dialog.dialog.setVisible(true); // отобразить диалог


    }
}

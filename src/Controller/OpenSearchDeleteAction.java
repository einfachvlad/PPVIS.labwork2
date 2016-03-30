package Controller;

import Model.Students;
import View.SearchDelete;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OpenSearchDeleteAction implements ActionListener {
    SearchDelete dialog=null;
    Students students;
    JTable mainTable;
    String name;

    public OpenSearchDeleteAction(Students students,JTable mainTable,String name) {
        this.students = students;
        this.mainTable=mainTable;
        this.name=name;
    }

    public void actionPerformed(ActionEvent event) {
        if (dialog == null) // в первый раз
        {
            dialog = new SearchDelete(null,students,name,mainTable);
        }
        dialog.dialog.setVisible(true); // отобразить диалог


    }
}

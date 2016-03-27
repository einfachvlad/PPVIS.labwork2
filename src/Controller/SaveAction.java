package Controller;

import Controller.Parsers.DOM;
import Model.Students;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveAction implements ActionListener {
    JFileChooser fileChooser;
    Students students;

    public SaveAction(Students students) {
        this.students = students;
    }

    public void actionPerformed(ActionEvent event) {
        fileChooser = new JFileChooser(".//.//");
        int openFile = fileChooser.showDialog(null, "Сохранить файл");
        if (openFile == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();


                DOM DOMparser = new DOM(file, students);
                DOMparser.save();

        }
    }
}
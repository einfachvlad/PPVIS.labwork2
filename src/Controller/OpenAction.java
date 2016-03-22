package Controller;

import Model.Students;
import View.StudentsModel;
import View.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

public class OpenAction implements ActionListener {
    JFileChooser fileChooser;
    Students students;
    DefaultTableModel model;
    StudentsModel studentsModel;
    JTable table;
    final Random random = new Random();

    public OpenAction(Students students, JTable table, DefaultTableModel model) {
        this.students = students;
        this.table = table;
        this.model = model;
    }

    public void actionPerformed(ActionEvent event) {
        fileChooser = new JFileChooser(".//.//");
        int openFile = fileChooser.showDialog(null, "Открыть файл");
        if (openFile == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            int whichParser = random.nextInt(2) + 1;
            if (whichParser == 1) {
                HandlerSAX handlerSAX = new HandlerSAX(file, students);
                handlerSAX.main();
            } else {
                DOM DOMparser=new DOM(file,students);
                DOMparser.parse();
            }

            studentsModel = new StudentsModel(students);
            model = studentsModel.getModel();
            table.setModel(model);
            table.validate();
        }
    }
}

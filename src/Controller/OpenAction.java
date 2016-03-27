package Controller;

import Model.Student;
import Model.Students;
import View.StudentsModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OpenAction implements ActionListener {
    JFileChooser fileChooser;
    Students students;
    StudentsModel studentsModel;
    JTable table;
    final Random random = new Random();


    public OpenAction(Students students, JTable table) {
        this.students = students;
        this.table = table;
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
                DOM DOMparser = new DOM(file, students);
                DOMparser.parse();
            }

            if(students.students.size()%students.visibleCount!=0)
                students.numberOfPages=students.students.size()/students.visibleCount+1;
            else
                students.numberOfPages=students.students.size()/students.visibleCount;

            students.selectedPage=1;

            List<Student> studentsList=students.students.subList(0,students.visibleCount);
            Students newStudents = new Students(studentsList);

            studentsModel = new StudentsModel(newStudents);
            table.setModel(studentsModel.getModel());


        }
    }
}

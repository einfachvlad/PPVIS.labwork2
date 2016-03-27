package Controller.TableButtons;

import Model.Student;
import Model.Students;
import View.StudentsModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FirstPage implements ActionListener {
    Students students;
    StudentsModel studentsModel;
    JTable table;

    public FirstPage(Students students, JTable table) {
        this.students = students;
        this.table = table;

    }

    public void actionPerformed(ActionEvent event) {
        students.selectedPage = 1;
        List<Student> studentsList;
        if (students.numberOfPages == 1)
            studentsList = students.students.subList(0, students.students.size());
        else studentsList = students.students.subList(0, students.visibleCount);
        Students newStudents = new Students(studentsList);

        studentsModel = new StudentsModel(newStudents);
        table.setModel(studentsModel.getModel());
    }
}

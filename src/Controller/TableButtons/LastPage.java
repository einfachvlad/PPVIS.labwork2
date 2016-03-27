package Controller.TableButtons;


import Model.Student;
import Model.Students;
import View.StudentsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LastPage implements ActionListener {
    Students students;
    StudentsModel studentsModel;
    JTable table;

    public LastPage(Students students, JTable table) {
        this.students = students;
        this.table = table;
    }

    public void actionPerformed(ActionEvent event) {
        students.selectedPage=students.numberOfPages;

        List<Student> studentsList=students.students.subList((students.selectedPage-1)*students.visibleCount,students.students.size());
        Students newStudents = new Students(studentsList);

        studentsModel = new StudentsModel(newStudents,students);
        table.setModel(studentsModel.getModel());
    }
}

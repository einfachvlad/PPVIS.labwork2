package Controller.TableButtons;

import Model.Student;
import Model.Students;
import View.StudentsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VisibleCount implements ActionListener {

    Students students;
    StudentsModel studentsModel;
    int visibleCount;
    JTable mainTable = new JTable();

    public VisibleCount(Students students, int visibleCount, JTable mainTable) {
        this.students = students;
        this.visibleCount = visibleCount;
        this.mainTable = mainTable;
    }

    public void actionPerformed(ActionEvent event) {

        students.visibleCount = visibleCount;
        if (students.students.size() % students.visibleCount != 0)
            students.numberOfPages = students.students.size() / students.visibleCount + 1;
        else
            students.numberOfPages = students.students.size() / students.visibleCount;

        students.selectedPage = 1;
        List<Student> studentsList;

        if (students.students.size() < visibleCount)
            studentsList = students.students.subList(0,students.students.size());
        else
             studentsList = students.students.subList(0, students.visibleCount);
        Students newStudents = new Students(studentsList);

        studentsModel = new StudentsModel(newStudents);
        mainTable.setModel(studentsModel.getModel());
    }
}

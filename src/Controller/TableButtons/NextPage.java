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

public class NextPage implements ActionListener {
    Students students;
    StudentsModel studentsModel;
    JTable table;

    public NextPage(Students students, JTable table) {
        this.students = students;
        this.table = table;

    }

    public void actionPerformed(ActionEvent event) {
        try {
            students.selectedPage++;
            List<Student> studentsList;
            if (students.selectedPage != students.numberOfPages)
                studentsList = students.students.subList(students.selectedPage * students.visibleCount, (students.selectedPage + 1) * students.visibleCount);
            else
                studentsList = students.students.subList((students.selectedPage - 1) * students.visibleCount, students.students.size());

            Students newStudents = new Students(studentsList);

            studentsModel = new StudentsModel(newStudents,students);
            table.setModel(studentsModel.getModel());
        } catch (Exception e) {
            JOptionPane.showMessageDialog
                    (null, "Больше нет страниц", "Ошибка", JOptionPane.ERROR_MESSAGE);
            students.selectedPage--;

        }
    }
}

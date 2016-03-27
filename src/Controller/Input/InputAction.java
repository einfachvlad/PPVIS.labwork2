package Controller.Input;

import Model.Student;
import Model.Students;
import View.Input;
import View.StudentsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class InputAction implements ActionListener {
    Input input;
    Students students = new Students();
    StudentsModel model = new StudentsModel(students);
    JTable mainTable = new JTable();

    public InputAction(Input input, Students students, JTable mainTable) {
        this.input = input;
        this.students = students;
        this.mainTable = mainTable;
    }

    public void actionPerformed(ActionEvent event) {
        Student student = new Student();
        student.addName(input.nameOfStudent.getText());
        student.addenteringYear((int) input.enteringYear.getSelectedItem());
        student.addgraduateYear((int) input.graduateYear.getSelectedItem());

        int numberOfMonth = 0;
        for (String month : input.months) {
            if (month == input.month.getSelectedItem().toString()) {
                numberOfMonth = input.months.indexOf(month) + 1;
                break;
            }
        }
        String day;
        if ((int) input.day.getSelectedItem() < 10)
            day = "0" + input.day.getSelectedItem().toString();
        else day = input.day.getSelectedItem().toString();

        String month;
        if (numberOfMonth < 10)
            month = "0" + Integer.toString(numberOfMonth);
        else month = Integer.toString(numberOfMonth);

        student.addBirthDate(day + "."
                + month + "."
                + input.year.getSelectedItem().toString());
        students.students.add(student);

        if (students.selectedPage == students.numberOfPages) {
            List<Student> studentsList = students.students.subList((students.selectedPage - 1) * students.visibleCount, students.students.size());
            Students newStudents = new Students(studentsList);
            if (studentsList.size() < students.visibleCount + 1) {
                model = new StudentsModel(newStudents);
                mainTable.setModel(model.getModel());
            }
            else students.numberOfPages++;
        }
        JOptionPane.showMessageDialog
                (null, "Студент добавлен", "Успех", JOptionPane.INFORMATION_MESSAGE);
    }
}

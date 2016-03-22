package Controller;

import Model.Student;
import Model.Students;
import View.Input;
import View.StudentsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class InputAction implements ActionListener {
    Input input;
    Students students = new Students();
    JTable table=new JTable();
    StudentsModel model;

    public InputAction(Input input, Students students,JTable table) {
        this.input = input;
        this.students = students;
        this.table=table;
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

        student.addBirthDate("0"+input.day.getSelectedItem().toString() + "."
                + "0" + Integer.toString(numberOfMonth) + "."
                + input.year.getSelectedItem().toString());
        students.students.add(student);
        model=new StudentsModel(students);
        table.setModel(model.getModel());
    }
}

package Controller;

import Model.Student;
import Model.Students;
import View.Input;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputAction implements ActionListener {
    Input input;
    Students students=new Students();
    Student student=new Student();

    public InputAction(Input input, Students students) {
        this.input = input;
        this.students = students;
    }

    public void actionPerformed(ActionEvent event) {
        student.addName(input.nameOfStudent.getText());
        student.addenteringYear((int) input.enteringYear.getSelectedItem());
        student.addgraduateYear((int) input.graduateYear.getSelectedItem());
        student.addBirthDate((String) input.day.getSelectedItem() + (String) input.month.getSelectedItem() + (String) input.year.getSelectedItem());
        students.students.add(student);
    }
}

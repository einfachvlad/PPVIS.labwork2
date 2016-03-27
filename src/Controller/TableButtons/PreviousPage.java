package Controller.TableButtons;


import Model.Student;
import Model.Students;
import View.StudentsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PreviousPage implements ActionListener {
    Students students;
    StudentsModel studentsModel;
    JTable table;

    public PreviousPage(Students students, JTable table) {
        this.students = students;
        this.table = table;

    }

    public void actionPerformed(ActionEvent event) {
        try {
            students.selectedPage--;

            List studentsList = students.students.subList((students.selectedPage - 1) * students.visibleCount, students.selectedPage * students.visibleCount);
            Students newStudents = new Students(studentsList);


            studentsModel = new StudentsModel(newStudents,students);
            table.setModel(studentsModel.getModel());
        }catch(Exception e){
            JOptionPane.showMessageDialog
                    (null, "Больше нет страниц", "Ошибка", JOptionPane.ERROR_MESSAGE);
            students.selectedPage++;
        }
    }
}
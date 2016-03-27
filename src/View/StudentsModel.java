package View;

import Model.Student;
import Model.Students;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class StudentsModel {
    private DefaultTableModel model;

    public StudentsModel(Students students) {
        model = new DefaultTableModel(students.students.size(), 5);
        Vector<String> header = new Vector<>();
       // Vector<Object> data = new Vector<>();

        header.add("№");
        header.add("ФИО");
        header.add("Дата Рождения");
        header.add("Год поступления");
        header.add("Год выпуска");

        for (Student student : students.students) {
           model.setValueAt(students.students.indexOf(student) + 1, students.students.indexOf(student), 0);
            model.setValueAt(student.getName(), students.students.indexOf(student), 1);
            model.setValueAt(student.getBirthDate(student.FULL), students.students.indexOf(student), 2);
            model.setValueAt(student.getEnteringYear(), students.students.indexOf(student), 3);
            model.setValueAt(student.getGraduateYear(), students.students.indexOf(student), 4);
            /*data.add(students.students.indexOf(student) + 1);
            data.add(student.getName());
            data.add(student.getBirthDate());
            data.add(student.getEnteringYear());
            data.add(student.getGraduateYear());*/

        }
        model.setColumnIdentifiers(header);
    }
    public DefaultTableModel getModel() {
        return model;
    }
}

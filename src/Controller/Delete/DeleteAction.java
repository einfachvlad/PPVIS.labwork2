package Controller.Delete;

import Model.Student;
import Model.Students;
import View.SearchDelete;
import View.StudentsModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteAction implements ActionListener {

    SearchDelete delete;
    Students students;
    Students newStudents;
    StudentsModel model;
    JTable table = new JTable();
    JTable mainTable = new JTable();

    public DeleteAction(SearchDelete delete, Students students, JTable table, JTable mainTable,Students newStudents) {
        this.delete = delete;
        this.students = students;
        this.newStudents=newStudents;
        this.table = table;
        this.mainTable = mainTable;
    }

    public void actionPerformed(ActionEvent event) {
        List<Student> filterStudents = new ArrayList<>();
        filterStudents.addAll(students.students);


        if (delete.cbName.isSelected()) {
            for (int index = 0; index < filterStudents.size(); index++) {
                Pattern pattern = Pattern.compile("[\\s]*" + delete.nameOfStudent.getText() + "[\\s]*");
                Matcher matcher = pattern.matcher(filterStudents.get(index).getName());
                if (!matcher.find()) {
                    filterStudents.remove(index);
                    index--;
                }
            }
        }

        if (delete.cbBYear.isSelected()) {
            for (int index = 0; index < filterStudents.size(); index++) {
                if (filterStudents.get(index).getBirthYear() <
                        (int) delete.fromBirthYear.getSelectedItem()
                        || filterStudents.get(index).getBirthYear() >
                        (int) delete.tillBirthYear.getSelectedItem()) {
                    filterStudents.remove(index);
                    index--;
                }
            }
        }

        if (delete.cbEYear.isSelected()) {
            for (int index = 0; index < filterStudents.size(); index++) {
                if (filterStudents.get(index).getEnteringYear() <
                        (int) delete.fromEnteringYear.getSelectedItem()
                        || filterStudents.get(index).getEnteringYear() >
                        (int) delete.tillEnteringYear.getSelectedItem()) {
                    filterStudents.remove(index);
                    index--;
                }
            }
        }

        if (delete.cbGYear.isSelected()) {
            for (int index = 0; index < filterStudents.size(); index++) {
                if (filterStudents.get(index).getGraduateYear() <
                        (int) delete.fromGraduateYear.getSelectedItem()
                        || filterStudents.get(index).getGraduateYear() >
                        (int) delete.tillGraduateYear.getSelectedItem()) {
                    filterStudents.remove(index);
                    index--;
                }
            }
        }

        if (delete.cbBirthDate.isSelected()) {
            int numberOfMonth = 0;
            for (String month : delete.months) {
                if (month == delete.month.getSelectedItem().toString()) {
                    numberOfMonth = delete.months.indexOf(month) + 1;
                    break;
                }
            }
            String day;
            if ((int) delete.day.getSelectedItem() < 10)
                day = "0" + delete.day.getSelectedItem().toString();
            else day = delete.day.getSelectedItem().toString();

            String month;
            if (numberOfMonth < 10)
                month = "0" + Integer.toString(numberOfMonth);
            else month = Integer.toString(numberOfMonth);

            String date = day + "."
                    + month + "."
                    + delete.year.getSelectedItem().toString();

            for (int index = 0; index < filterStudents.size(); index++) {
                if (!date.equals(filterStudents.get(index).getBirthDate(Student.MEDIUM))) {
                    filterStudents.remove(index);
                    index--;
                }
            }
        }

        if (filterStudents.isEmpty()) {
            table.setModel(new DefaultTableModel());
            JOptionPane.showMessageDialog
                    (null, "Ничего не найдено", "Ошибка", JOptionPane.ERROR_MESSAGE);
        } else {
            Students newStudents = new Students(filterStudents);
            model = new StudentsModel(newStudents);
            table.setModel(model.getModel());
            if (JOptionPane.showConfirmDialog(null, "Вы точно хотите удалить элементы?") == JOptionPane.YES_OPTION) {
                students.students.removeAll(filterStudents);

                List<Student> studentsList;
                if (students.students.size() > students.visibleCount) {
                    if (students.selectedPage == students.numberOfPages)
                        studentsList = students.students.subList((students.selectedPage - 1) * students.visibleCount, students.students.size());
                    else
                        studentsList = students.students.subList((students.selectedPage - 1) * students.visibleCount, students.selectedPage * students.visibleCount);
                } else {
                    studentsList = students.students;
                    students.numberOfPages--;
                }

                newStudents.students = studentsList;
                if (students.numberOfPages == 1)
                    model = new StudentsModel(newStudents);
                else
                    model = new StudentsModel(newStudents, students);
                mainTable.setModel(model.getModel());

                JOptionPane.showMessageDialog
                        (null, "Удалено " + filterStudents.size() + " элементов", "Успех", JOptionPane.INFORMATION_MESSAGE);

            }


        }
    }

}

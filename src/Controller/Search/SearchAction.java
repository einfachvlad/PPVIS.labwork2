package Controller.Search;

import Model.Student;
import Model.Students;
import View.Search;
import View.StudentsModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchAction implements ActionListener {

    Search search;
    Students students;
    StudentsModel model;
    JTable table = new JTable();

    public SearchAction(Search search, Students students, JTable table) {
        this.search = search;
        this.students = students;
        this.table = table;
    }

    public void actionPerformed(ActionEvent event) {
        List<Student> filterStudents = new ArrayList<>();
        filterStudents.addAll(students.students);


        if (search.cbName.isSelected()) {
            for (int index = 0; index < filterStudents.size(); index++) {
                Pattern pattern = Pattern.compile("[\\s]*" + search.nameOfStudent.getText() + "[\\s]*");
                Matcher matcher = pattern.matcher(filterStudents.get(index).getName());
                if (!matcher.find()) {
                    filterStudents.remove(index);
                    index--;
                }
            }
        }

        if (search.cbBYear.isSelected()) {
            for (int index = 0; index < filterStudents.size(); index++) {
                if (filterStudents.get(index).getBirthYear()<
                        (int)search.fromBirthYear.getSelectedItem()
                        ||filterStudents.get(index).getBirthYear()>
                        (int)search.tillBirthYear.getSelectedItem()) {
                    filterStudents.remove(index);
                    index--;
                }
            }
        }

        if (search.cbEYear.isSelected()) {
            for (int index = 0; index < filterStudents.size(); index++) {
                if (filterStudents.get(index).getEnteringYear()<
                        (int)search.fromEnteringYear.getSelectedItem()
                        ||filterStudents.get(index).getEnteringYear()>
                        (int)search.tillEnteringYear.getSelectedItem()) {
                    filterStudents.remove(index);
                    index--;
                }
            }
        }

        if (search.cbGYear.isSelected()) {
            for (int index = 0; index < filterStudents.size(); index++) {
                if (filterStudents.get(index).getGraduateYear()<
                        (int)search.fromGraduateYear.getSelectedItem()
                        ||filterStudents.get(index).getGraduateYear()>
                        (int)search.tillGraduateYear.getSelectedItem()) {
                    filterStudents.remove(index);
                    index--;
                }
            }
        }

        if (search.cbBirthDate.isSelected()) {
            int numberOfMonth = 0;
            for (String month : search.months) {
                if (month == search.month.getSelectedItem().toString()) {
                    numberOfMonth = search.months.indexOf(month) + 1;
                    break;
                }
            }
            String day;
            if ((int) search.day.getSelectedItem() < 10)
                day = "0" + search.day.getSelectedItem().toString();
            else day = search.day.getSelectedItem().toString();

            String month;
            if (numberOfMonth < 10)
                month = "0" + Integer.toString(numberOfMonth);
            else month = Integer.toString(numberOfMonth);

            String date=day + "."
                    + month + "."
                    + search.year.getSelectedItem().toString();

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
        }
    }

}

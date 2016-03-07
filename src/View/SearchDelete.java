package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.Vector;

import Controller.*;

public class SearchDelete {
   public JDialog dialog;

    public SearchDelete(Window owner, String dialogName) {
        dialog=new JDialog(owner.mainwindow, dialogName, true);
        components();
        dialog.pack();
    }

    private void components() {
        Box mainBox = Box.createVerticalBox();
        Box nameAndBirth = Box.createHorizontalBox();
        Box enteringAndGraduate = Box.createHorizontalBox();

        nameAndBirth.add(name());
        nameAndBirth.add(Box.createHorizontalStrut(6));
        nameAndBirth.add(birthDate());

        enteringAndGraduate.add(enteringYear());
        enteringAndGraduate.add(Box.createHorizontalStrut(6));
        enteringAndGraduate.add(graduateYear());

        JButton ok = new JButton("OK");
        ok.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        ok.addActionListener(new OkDialogAction(dialog));

        mainBox.add(nameAndBirth);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(birthYear());
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(enteringAndGraduate);
        mainBox.add(Box.createHorizontalStrut(12));
        mainBox.add(ok);
        dialog.setContentPane(mainBox);
    }

    private Box birthDate() {
        Box birthDate = Box.createHorizontalBox();
        birthDate.setBorder(new TitledBorder("Дата рождения"));

        Vector<Integer> days = new Vector<>();
        for (int day = 1; day < 32; day++)
            days.add(day);
        JComboBox day = new JComboBox(days);

        Vector<String> months = new Vector<>();
        months.add("Январь");
        months.add("Февраль");
        months.add("Март");
        months.add("Апрель");
        months.add("Май");
        months.add("Июнь");
        months.add("Июль");
        months.add("Август");
        months.add("Сентябрь");
        months.add("Октябрь");
        months.add("Ноябрь");
        months.add("Декабрь");
        JComboBox month = new JComboBox(months);

        Vector<Integer> years = new Vector<>();
        for (int year = 1950; year < 2017; year++)
            years.add(year);
        JComboBox year = new JComboBox(years);


        birthDate.add(day);
        birthDate.add(Box.createHorizontalStrut(6));
        birthDate.add(month);
        birthDate.add(Box.createHorizontalStrut(6));
        birthDate.add(year);
        return birthDate;
    }

    private Box name() {
        Box name = Box.createHorizontalBox();
        name.setBorder(new TitledBorder("ФИО студента"));
        JTextField nameOfStudent = new JTextField(20);
        name.add(nameOfStudent);
        return name;
    }

    private Box birthYear() {
        Box birthYear = Box.createHorizontalBox();
        birthYear.setBorder(new TitledBorder("Год Рождения"));

        Vector<Integer> years = new Vector<>();
        for (int year = 1950; year < 2017; year++)
            years.add(year);

        JLabel from = new JLabel("От");
        JLabel till = new JLabel("До");
        JComboBox fromYear = new JComboBox(years);
        JComboBox tillYear = new JComboBox(years);

        birthYear.add(from);
        birthYear.add(Box.createHorizontalStrut(3));
        birthYear.add(fromYear);
        birthYear.add(Box.createHorizontalStrut(6));
        birthYear.add(till);
        birthYear.add(Box.createHorizontalStrut(3));
        birthYear.add(tillYear);
        return birthYear;
    }

    private Box enteringYear() {
        Box enteringYear = Box.createHorizontalBox();
        enteringYear.setBorder(new TitledBorder("Год поступления"));

        Vector<Integer> years = new Vector<>();
        for (int year = 1950; year < 2017; year++)
            years.add(year);

        JLabel from = new JLabel("От");
        JLabel till = new JLabel("До");
        JComboBox fromYear = new JComboBox(years);
        JComboBox tillYear = new JComboBox(years);

        enteringYear.add(from);
        enteringYear.add(Box.createHorizontalStrut(3));
        enteringYear.add(fromYear);
        enteringYear.add(Box.createHorizontalStrut(6));
        enteringYear.add(till);
        enteringYear.add(Box.createHorizontalStrut(3));
        enteringYear.add(tillYear);
        return enteringYear;
    }

    private Box graduateYear() {
        Box graduateYear = Box.createHorizontalBox();
        graduateYear.setBorder(new TitledBorder("Год окончания"));

        Vector<Integer> years = new Vector<>();
        for (int year = 1950; year < 2017; year++)
            years.add(year);

        JLabel from = new JLabel("От");
        JLabel till = new JLabel("До");
        JComboBox fromYear = new JComboBox(years);
        JComboBox tillYear = new JComboBox(years);

        graduateYear.add(from);
        graduateYear.add(Box.createHorizontalStrut(3));
        graduateYear.add(fromYear);
        graduateYear.add(Box.createHorizontalStrut(6));
        graduateYear.add(till);
        graduateYear.add(Box.createHorizontalStrut(3));
        graduateYear.add(tillYear);
        return graduateYear;
    }
}

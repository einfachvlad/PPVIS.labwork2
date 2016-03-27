package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.time.format.TextStyle;
import java.util.*;
import java.util.List;
import java.time.*;

import Controller.*;
import Model.Students;

public class Input {
    public JDialog dialog;
    public JPanel panel;
    public JTextField nameOfStudent;
    public JComboBox enteringYear;
    public JComboBox graduateYear;
    public JComboBox day;
    public JComboBox month;
    public JComboBox year;
    JTable mainTable;
    Students students=new Students();
    public List<String> months;

    public Input(JFrame owner, String dialogName,Students students,JTable mainTable) {
        dialog = new JDialog(owner, dialogName, true);
        this.students=students;
        this.mainTable=mainTable;
        components();
        dialog.pack();
    }

    private void components() {
        panel = new JPanel();
        JPanel info = new JPanel();

        info.setLayout(new GridLayout(2, 2, 6, 12));

        info.add(name());
        info.add(birthDate());
        info.add(enteringYear());
        info.add(graduateYear());

        panel.add(info, BorderLayout.NORTH);

        panel.add(buttons(), BorderLayout.SOUTH);

        dialog.setContentPane(panel);
    }

    private Box buttons() {
        Box buttons = Box.createHorizontalBox();

        JButton ok = new JButton("OK");
        ok.addActionListener(new OkDialogAction(dialog));
        JButton input = new JButton("Ввести");
        input.addActionListener(new InputAction(this, students,mainTable));

        buttons.add(ok);
        buttons.add(Box.createHorizontalStrut(3));
        buttons.add(input);
        return buttons;
    }

    private Box birthDate() {
        Box birthDate = Box.createHorizontalBox();
        birthDate.setBorder(new TitledBorder("Дата рождения"));

        List<Integer> days = new ArrayList<>();
        for (int day = 1; day < 32; day++)
            days.add(day);
        day = new JComboBox(days.toArray());


        months = new ArrayList<>();
        months.add(Month.JANUARY.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")));
        months.add(Month.FEBRUARY.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")));
        months.add(Month.MARCH.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")));
        months.add(Month.APRIL.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")));
        months.add(Month.MAY.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")));
        months.add(Month.JUNE.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")));
        months.add(Month.JULY.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")));
        months.add(Month.AUGUST.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")));
        months.add(Month.SEPTEMBER.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")));
        months.add(Month.OCTOBER.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")));
        months.add(Month.NOVEMBER.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")));
        months.add(Month.DECEMBER.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")));
        month = new JComboBox(months.toArray());

        List<Integer> years = new ArrayList<>();
        for (int year = 1950; year < 2017; year++)
            years.add(year);
        year = new JComboBox(years.toArray());


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
        nameOfStudent = new JTextField(20);
        name.add(nameOfStudent);
        return name;
    }


    private Box enteringYear() {
        Box enteringYearBox = Box.createHorizontalBox();
        enteringYearBox.setBorder(new TitledBorder("Год поступления"));

        List<Integer> years = new ArrayList<>();
        for (int year = 1950; year < 2017; year++)
            years.add(year);

        enteringYear = new JComboBox(years.toArray());

        enteringYearBox.add(enteringYear);

        return enteringYearBox;
    }

    private Box graduateYear() {
        Box graduateYearBox = Box.createHorizontalBox();
        graduateYearBox.setBorder(new TitledBorder("Год окончания"));

        List<Integer> years = new ArrayList<>();
        for (int year = 1950; year < 2020; year++)
            years.add(year);

         graduateYear = new JComboBox(years.toArray());

        graduateYearBox.add(graduateYear);

        return graduateYearBox;
    }
}

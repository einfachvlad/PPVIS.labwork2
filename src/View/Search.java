package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.TextStyle;
import java.util.*;
import java.util.List;
import java.time.*;

import Controller.*;
import Controller.Search.SearchAction;
import Model.Students;

public class Search {
    public JDialog dialog;
    public JPanel panel;
    public JComboBox day;
    public JComboBox month;
    public List<String> months;
    public JComboBox year;
    public JTextField nameOfStudent;
    public JComboBox fromBirthYear;
    public JComboBox tillBirthYear;
    public JComboBox fromEnteringYear;
    public JComboBox tillEnteringYear;
    public JComboBox fromGraduateYear;
    public JComboBox tillGraduateYear;
    public JCheckBox cbName;
    public JCheckBox cbBYear;
    public JCheckBox cbBirthDate;
    public JCheckBox cbEYear;
    public JCheckBox cbGYear;

    JTable table = new JTable();
    Students students;

    public Search(JFrame owner, Students students) {
        dialog = new JDialog(owner, "Поиск", true);
        this.students = students;
        components();
        dialog.pack();
    }

    private void components() {
        panel = new JPanel();
        JPanel info = new JPanel();

        info.setLayout(new GridLayout(3, 2, 6, 12));

        JButton ok = new JButton("OK");
        ok.addActionListener(new OkDialogAction(dialog));
        JButton search = new JButton("Найти");
        search.addActionListener(new SearchAction(this, students, table));

        info.add(name());
        info.add(birthDate());
        info.add(birthYear());
        info.add(enteringYear());
        info.add(graduateYear());
        panel.add(checkBoxes(), BorderLayout.WEST);

        panel.add(info, BorderLayout.WEST);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        panel.add(ok);
        panel.add(search);

        dialog.setContentPane(panel);
    }

    private Box birthDate() {
        Box birthDate = Box.createHorizontalBox();
        birthDate.setBorder(new TitledBorder("Дата рождения"));

        List<Integer> days = new ArrayList<>();
        for (int day = 1; day < 32; day++)
            days.add(day);
        day = new JComboBox(days.toArray());


        months = new ArrayList<>();
        months.add(Month.FEBRUARY.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru")));
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

    private Box birthYear() {
        Box birthYear = Box.createHorizontalBox();
        birthYear.setBorder(new TitledBorder("Год Рождения"));

        List<Integer> years = new ArrayList<>();
        for (int year = 1950; year < 2017; year++)
            years.add(year);

        JLabel from = new JLabel("От");
        JLabel till = new JLabel("До");
        fromBirthYear = new JComboBox(years.toArray());
        tillBirthYear = new JComboBox(years.toArray());

        birthYear.add(from);
        birthYear.add(Box.createHorizontalStrut(3));
        birthYear.add(fromBirthYear);
        birthYear.add(Box.createHorizontalStrut(6));
        birthYear.add(till);
        birthYear.add(Box.createHorizontalStrut(3));
        birthYear.add(tillBirthYear);
        return birthYear;
    }

    private Box enteringYear() {
        Box enteringYear = Box.createHorizontalBox();
        enteringYear.setBorder(new TitledBorder("Год поступления"));


        List<Integer> years = new ArrayList<>();
        for (int year = 1950; year < 2016; year++)
            years.add(year);

        JLabel from = new JLabel("От");
        JLabel till = new JLabel("До");
        fromEnteringYear = new JComboBox(years.toArray());
        tillEnteringYear = new JComboBox(years.toArray());

        enteringYear.add(from);
        enteringYear.add(Box.createHorizontalStrut(3));
        enteringYear.add(fromEnteringYear);
        enteringYear.add(Box.createHorizontalStrut(6));
        enteringYear.add(till);
        enteringYear.add(Box.createHorizontalStrut(3));
        enteringYear.add(tillEnteringYear);
        return enteringYear;
    }

    private Box graduateYear() {
        Box graduateYear = Box.createHorizontalBox();
        graduateYear.setBorder(new TitledBorder("Год окончания"));


        List<Integer> years = new ArrayList<>();
        for (int year = 1950; year < 2020; year++)
            years.add(year);

        JLabel from = new JLabel("От");
        JLabel till = new JLabel("До");
        fromGraduateYear = new JComboBox(years.toArray());
        tillGraduateYear = new JComboBox(years.toArray());

        graduateYear.add(from);
        graduateYear.add(Box.createHorizontalStrut(3));
        graduateYear.add(fromGraduateYear);
        graduateYear.add(Box.createHorizontalStrut(6));
        graduateYear.add(till);
        graduateYear.add(Box.createHorizontalStrut(3));
        graduateYear.add(tillGraduateYear);
        return graduateYear;
    }

    private Box checkBoxes() {
        Box checkBoxes = Box.createVerticalBox();
        checkBoxes.setBorder(new TitledBorder("Критерии поиска"));

        cbName = new JCheckBox("ФИО");
        cbBirthDate = new JCheckBox("Дата Рождения");
        cbBYear = new JCheckBox("Год Рождения");
        cbEYear = new JCheckBox("Год поступления");
        cbGYear = new JCheckBox("Год выпуска");

        checkBoxes.add(cbName);
        checkBoxes.add(cbBirthDate);
        checkBoxes.add(cbBYear);
        checkBoxes.add(cbEYear);
        checkBoxes.add(cbGYear);

        return checkBoxes;
    }

}



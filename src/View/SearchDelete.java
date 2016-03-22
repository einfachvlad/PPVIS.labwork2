package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.time.format.TextStyle;
import java.util.*;
import java.util.List;
import java.time.*;

import Controller.*;

public class SearchDelete {
    public JDialog dialog;
    public String name;
    public JPanel panel;
    JTable table;// = new JTable();

    public SearchDelete(JFrame owner, String dialogName, JTable table) {
        dialog = new JDialog(owner, dialogName, true);
        name = dialogName;
        this.table = table;
        components();
        dialog.pack();
    }

    private void components() {
        panel = new JPanel();
        JPanel info = new JPanel();

        info.setLayout(new GridLayout(3, 2, 6, 12));

        JButton ok = new JButton("OK");
        // ok.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        ok.addActionListener(new OkDialogAction(dialog));

        info.add(name());
        info.add(birthDate());
        info.add(birthYear());
        info.add(enteringYear());
        info.add(graduateYear());

        panel.add(info, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        panel.add(ok, BorderLayout.SOUTH);

        /*Box mainBox = Box.createVerticalBox();
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
        mainBox.add(table());
        mainBox.add(Box.createHorizontalStrut(12));
        mainBox.add(ok);
        dialog.setContentPane(mainBox);*/
        dialog.setContentPane(panel);
    }

    private Box birthDate() {
        Box birthDate = Box.createHorizontalBox();
        birthDate.setBorder(new TitledBorder("Дата рождения"));

        List<Integer> days = new ArrayList<>();
        for (int day = 1; day < 32; day++)
            days.add(day);
        JComboBox day = new JComboBox(days.toArray());


        List<String> months = new ArrayList<>();
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
        JComboBox month = new JComboBox(months.toArray());

        List<Integer> years = new ArrayList<>();
        for (int year = 1950; year < 2017; year++)
            years.add(year);
        JComboBox year = new JComboBox(years.toArray());


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

        List<Integer> years = new ArrayList<>();
        for (int year = 1950; year < 2017; year++)
            years.add(year);

        JLabel from = new JLabel("От");
        JLabel till = new JLabel("До");
        JComboBox fromYear = new JComboBox(years.toArray());
        JComboBox tillYear = new JComboBox(years.toArray());

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


        List<Integer> years = new ArrayList<>();
        for (int year = 1950; year < 2017; year++)
            years.add(year);

        JLabel from = new JLabel("От");
        JLabel till = new JLabel("До");
        JComboBox fromYear = new JComboBox(years.toArray());
        JComboBox tillYear = new JComboBox(years.toArray());

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


        List<Integer> years = new ArrayList<>();
        for (int year = 1950; year < 2017; year++)
            years.add(year);

        JLabel from = new JLabel("От");
        JLabel till = new JLabel("До");
        JComboBox fromYear = new JComboBox(years.toArray());
        JComboBox tillYear = new JComboBox(years.toArray());

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

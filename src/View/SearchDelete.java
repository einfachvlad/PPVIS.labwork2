package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.Vector;

import Controller.*;

public class SearchDelete extends JDialog{
   // JDialog dialog;

    public SearchDelete(Window owner, String dialogName) {
        super(owner, dialogName, true);
        components();
        pack();
    }

    private void components() {
        Box mainBox = Box.createVerticalBox();
        mainBox.add(birthDate());
        mainBox.add(Box.createVerticalStrut(12));
        JButton ok = new JButton("OK");
        ok.addActionListener(new OkDialogAction(this));
        mainBox.add(ok);
        setContentPane(mainBox);
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

}

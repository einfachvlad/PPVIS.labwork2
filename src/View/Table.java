package View;

import Controller.TableButtons.*;
import Model.Students;

import javax.swing.*;
import java.awt.*;

public class Table {
    void table(JTable table, Students newStudents,JPanel panel) {
        Box tablePanel = Box.createVerticalBox();
        JScrollPane scrollPane = new JScrollPane(table);

        Box visibleCount = Box.createHorizontalBox();

        JButton no15 = new JButton("15");
        no15.addActionListener(new VisibleCount(newStudents, 15,table));

        JButton no20 = new JButton("20");
        no20.addActionListener(new VisibleCount(newStudents, 20,table));

        JButton no30 = new JButton("30");
        no30.addActionListener(new VisibleCount(newStudents, 30,table));

        visibleCount.add(no15);
        visibleCount.add(Box.createHorizontalStrut(3));
        visibleCount.add(no20);
        visibleCount.add(Box.createHorizontalStrut(3));
        visibleCount.add(no30);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 3, 1));

        JButton first = new JButton("<<");
        first.addActionListener(new FirstPage(newStudents, table));

        JButton previous = new JButton("Previous");
        previous.addActionListener(new PreviousPage(newStudents, table));

        JButton next = new JButton("Next");
        next.addActionListener(new NextPage(newStudents, table));

        JButton last = new JButton(">>");
        last.addActionListener(new LastPage(newStudents, table));

        buttonPanel.add(first);
        buttonPanel.add(previous);
        buttonPanel.add(next);
        buttonPanel.add(last);

        tablePanel.add(scrollPane);
        tablePanel.add(Box.createVerticalStrut(12));
        tablePanel.add(visibleCount);
        tablePanel.add(Box.createVerticalStrut(12));
        tablePanel.add(buttonPanel);

        panel.add(tablePanel);

    }

}

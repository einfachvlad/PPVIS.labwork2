package View;

import javax.swing.*;

import Controller.*;
import Controller.Delete.OpenDeleteAction;
import Controller.Input.OpenInputAction;
import Controller.Search.OpenSearchAction;
import Controller.TableButtons.*;
import Model.Students;

import java.awt.*;

public class Window {
    public JFrame mainwindow;
    JPanel panel;
    JMenuBar menuBar;
    JToolBar toolBar;
    Students students;
    JTable table = new JTable();

    public Window(Students students) {
        this.students = students;

        mainwindow = new JFrame("Лабораторная работа №2");
        mainwindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel = new JPanel();
        menuBar();
        toolBar();
        table();
        mainwindow.setContentPane(panel);
        mainwindow.pack();
        mainwindow.setVisible(true);
    }

    void menuBar() {
        menuBar = new JMenuBar();
        mainwindow.setJMenuBar(menuBar);

        JMenu file = new JMenu("Файл");
        JMenuItem open = new JMenuItem("Открыть файл", new ImageIcon(".//.//res//open.png"));
        open.addActionListener(new OpenAction(students, table));
        JMenuItem save = new JMenuItem("Сохранить файл", new ImageIcon(".//.//res//save.png"));
        save.addActionListener(new SaveAction(students));
        JMenuItem exit = new JMenuItem("Выход", new ImageIcon(".//.//res//exit.png"));
        exit.addActionListener(new ExitAction());

        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);

        menuBar.add(file);

        JMenu array = new JMenu("Массив");
        JMenuItem input = new JMenuItem("Ввод в массив", new ImageIcon(".//.//res//input.png"));
        input.addActionListener(new OpenInputAction(students, table));
        JMenuItem search = new JMenuItem("Поиск в массиве", new ImageIcon(".//.//res//search.png"));
        search.addActionListener(new OpenSearchAction(students));
        JMenuItem delete = new JMenuItem("Удаление в массиве", new ImageIcon(".//.//res//delete.png"));
        delete.addActionListener(new OpenDeleteAction(students,table));

        array.add(input);
        array.add(search);
        array.add(delete);

        menuBar.add(array);
    }

    void toolBar() {
        toolBar = new JToolBar(SwingConstants.VERTICAL);
        panel.add(toolBar, BorderLayout.WEST);

        JButton open = new JButton(new ImageIcon(".//.//res//open.png"));
        open.setToolTipText("Открыть файл");
        open.addActionListener(new OpenAction(students, table));
        JButton save = new JButton(new ImageIcon(".//.//res//save.png"));
        save.setToolTipText("Сохранить файл");
        save.addActionListener(new SaveAction(students));
        JButton input = new JButton(new ImageIcon(".//.//res//input.png"));
        input.setToolTipText("Ввод в массив");
        input.addActionListener(new OpenInputAction(students, table));
        JButton search = new JButton(new ImageIcon(".//.//res//search.png"));
        search.setToolTipText("Поиск в массиве");
        search.addActionListener(new OpenSearchAction(students));
        JButton delete = new JButton(new ImageIcon(".//.//res//delete.png"));
        delete.setToolTipText("Удаление в массиве");
        delete.addActionListener(new OpenDeleteAction(students,table));

        toolBar.add(open);
        toolBar.add(save);
        toolBar.add(input);
        toolBar.add(search);
        toolBar.add(delete);
    }

    void table() {
        Box tablePanel = Box.createVerticalBox();
        JScrollPane scrollPane = new JScrollPane(table);

        Box visibleCount = Box.createHorizontalBox();

        JButton no15 = new JButton("15");
        no15.addActionListener(new VisibleCount(students, 15,table));

        JButton no20 = new JButton("20");
        no20.addActionListener(new VisibleCount(students, 20,table));

        JButton no30 = new JButton("30");
        no30.addActionListener(new VisibleCount(students, 30,table));

        visibleCount.add(no15);
        visibleCount.add(Box.createHorizontalStrut(3));
        visibleCount.add(no20);
        visibleCount.add(Box.createHorizontalStrut(3));
        visibleCount.add(no30);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 3, 1));

        JButton first = new JButton("<<");
        first.addActionListener(new FirstPage(students, table));

        JButton previous = new JButton("Previous");
        previous.addActionListener(new PreviousPage(students, table));

        JButton next = new JButton("Next");
        next.addActionListener(new NextPage(students, table));

        JButton last = new JButton(">>");
        last.addActionListener(new LastPage(students, table));

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

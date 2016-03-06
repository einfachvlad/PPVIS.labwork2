package View;

import javax.swing.*;
import Controller.*;

import java.awt.*;

public class Window extends JFrame {
   // JFrame mainwindow;
    JPanel panel;
    JMenuBar menuBar;
    JToolBar toolBar;

    public Window() {
       setTitle("Лабораторная работа №2");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel=new JPanel();
        menuBar();
        toolBar();
        //mainwindow.setContentPane(panel);
         pack();
        setVisible(true);
    }

    void menuBar() {
        menuBar=new JMenuBar();
        setJMenuBar(menuBar);

        JMenu file=new JMenu("Файл");
        JMenuItem open=new JMenuItem("Открыть файл",new ImageIcon(".//.//res//open.png"));
        JMenuItem save=new JMenuItem("Сохранить файл",new ImageIcon(".//.//res//save.png"));
        JMenuItem exit=new JMenuItem("Выход",new ImageIcon(".//.//res//exit.png"));
        exit.addActionListener(new ExitAction());

        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);

        menuBar.add(file);

        JMenu array=new JMenu("Массив");
        JMenuItem input=new JMenuItem("Ввод в массив",new ImageIcon(".//.//res//input.png"));
        JMenuItem search=new JMenuItem("Поиск в массиве",new ImageIcon(".//.//res//search.png"));
        JMenuItem delete=new JMenuItem("Удаление в массиве",new ImageIcon(".//.//res//delete.png"));

        array.add(input);
        array.add(search);
        array.add(delete);

        menuBar.add(array);
    }
    void toolBar(){
         toolBar=new JToolBar(SwingConstants.VERTICAL);
        getContentPane().add(toolBar, BorderLayout.WEST);

        JButton open=new JButton(new ImageIcon(".//.//res//open.png"));
        open.setToolTipText("Открыть файл");
        JButton save=new JButton(new ImageIcon(".//.//res//save.png"));
        save.setToolTipText("Сохранить файл");
        JButton input=new JButton(new ImageIcon(".//.//res//input.png"));
        input.setToolTipText("Ввод в массив");
        JButton search=new JButton(new ImageIcon(".//.//res//search.png"));
        search.setToolTipText("Поиск в массиве");
        search.addActionListener(new SearchDeleteAction(new SearchDelete(this,"Поиск"),this,"Поиск"));
        JButton delete=new JButton(new ImageIcon(".//.//res//delete.png"));
        delete.setToolTipText("Удаление в массиве");

        toolBar.add(open);
        toolBar.add(save);
        toolBar.add(input);
        toolBar.add(search);
        toolBar.add(delete);
    }
}

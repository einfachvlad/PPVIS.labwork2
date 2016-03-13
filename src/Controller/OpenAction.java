package Controller;

import Model.Students;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.*;

public class OpenAction implements ActionListener {
    JFileChooser fileChooser;
    Students students;

   public OpenAction(Students students) {
        this.students=students;
    }

    public void actionPerformed(ActionEvent event) {
        fileChooser = new JFileChooser(".//.//");
        int openFile = fileChooser.showDialog(null, "Открыть файл");
        if (openFile == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            HandlerSAX handlerSAX = new HandlerSAX(file,students);
            handlerSAX.main();
        }
    }
}

package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenAction implements ActionListener{
    JFileChooser fileChooser;
    public void actionPerformed(ActionEvent event){
        fileChooser=new JFileChooser();
        int openFile=fileChooser.showDialog(null,"Открыть файл");
        if(openFile==JFileChooser.APPROVE_OPTION){
            File file=fileChooser.getSelectedFile();
            SAXparser parser=new SAXparser (file.getAbsolutePath());
            System.out.println(parser.startElement("student"));
            System.out.println(parser.lastElement("student"));

        }
    }
}

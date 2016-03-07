import javax.swing.*;

import Controller.SAXparser;
import View.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
       try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        Window mainwindow=new Window();



    }
}

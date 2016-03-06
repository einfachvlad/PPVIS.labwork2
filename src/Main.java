import javax.swing.*;
import View.*;

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

package Controller;

import View.SearchDelete;
import View.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SearchDeleteAction implements ActionListener {
    SearchDelete dialog;
    String name;
    Window window;
    public SearchDeleteAction(SearchDelete dialog,Window window, String name){
        this.dialog=dialog;
        this.name=name;
        this.window=window;
    }
    public void actionPerformed(ActionEvent event) {
        if(dialog == null) // в первый раз
            dialog = new SearchDelete(window,name);
        dialog.dialog.setVisible(true); // отобразить диалог
    }
}

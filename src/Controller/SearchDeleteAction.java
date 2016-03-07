package Controller;

import View.SearchDelete;
import View.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SearchDeleteAction implements ActionListener {
    SearchDelete dialog;
    public SearchDeleteAction(SearchDelete dialog){
        this.dialog=dialog;
    }
    public void actionPerformed(ActionEvent event) {
        if(dialog == null) // в первый раз
            dialog = new SearchDelete(dialog.frame,dialog.name);
        dialog.dialog.setVisible(true); // отобразить диалог
    }
}

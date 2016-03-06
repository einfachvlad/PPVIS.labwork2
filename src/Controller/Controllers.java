package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controllers {
   public ActionListener exitAction = new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    };

}


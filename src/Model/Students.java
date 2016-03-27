package Model;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Students {
    public List<Student> students;
    public int numberOfPages;
    public int selectedPage;
    public int visibleCount=15;
    public Students() {
        students = new ArrayList<>();
    }
    public Students(List students) {
        this.students =students ;
    }

}

package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student {
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    String name;
    Date birthDate;
    int enteringYear;
    int graduateYear;


    public String addName(String name) {

        this.name = name;
        return this.name;
    }

    public void addBirthDate(String string) {
        try {
            birthDate = format.parse(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int addenteringYear(int enteringYear) {

        this.enteringYear = enteringYear;
        return this.enteringYear;
    }

    public int addgraduateYear(int graduateYear) {

        this.graduateYear = graduateYear;
        return this.graduateYear;
    }

    public String getName() {
        return name;
    }

    public int getEnteringYear() {
        return enteringYear;
    }

    public int getGraduateYear() {
        return graduateYear;
    }

    public String getBirthDate() {
        Locale local = new Locale("ru", "RU");
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, local);
        return df.format(birthDate);
    }

}

package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class Student {
    public static final String FULL ="FULL";
    public static final String MEDIUM ="MEDIUM";

    String name;
    LocalDate birthDate = LocalDate.of(1970, 01, 01);
    int enteringYear;
    int graduateYear;
    public static final int numberOfField = 4;

    public String addName(String name) {

        this.name = name;
        return this.name;
    }

    public void addBirthDate(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        birthDate = LocalDate.parse(string, formatter);
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

    public String getBirthDate(String type) {
        String date = null;
        if (!birthDate.isEqual(LocalDate.of(1970, 01, 01)))
            if(type==FULL)
            { date =
                    DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                            .withLocale(new Locale("ru"))
                            .format(birthDate);}
        else {
                date =
                        DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                                .withLocale(new Locale("ru"))
                                .format(birthDate);
            }
        return date;
    }


}

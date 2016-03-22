package Controller;

import java.io.File;

import Model.*;

public class HandlerSAX {
    File file;
    Students students;

    public HandlerSAX(File file, Students students) {
        this.file = file;
        this.students = students;
    }

    public void main() {

        SAXparser parser = new SAXparser(file.getAbsolutePath());
        String line = parser.startElement("students");
        if (line != parser.notFound)
            while (line != parser.lastElement("students")) {
                Student student = new Student();
                if (line == parser.startElement("students"))
                    line = parser.nextElement(line);
                else line = parser.nextElement();
                if (line == parser.startElement("student") && line != parser.notFound) {
                    while (line != parser.lastElement("student")) {

                        if (line == parser.startElement("name") && line != parser.notFound) {
                            student.addName(parser.characters(parser.startTag("name"), parser.lastTag("name")));
                            System.out.println(student.getName());
                        } else if (line == parser.startElement("birthDate") && line != parser.notFound) {
                            student.addBirthDate(parser.characters(parser.startTag("birthDate"), parser.lastTag("birthDate")));
                            System.out.println(student.getBirthDate());
                        } else if (line == parser.startElement("enteringYear") && line != parser.notFound) {
                            student.addenteringYear(Integer.valueOf(parser.characters(parser.startTag("enteringYear"), parser.lastTag("enteringYear"))));
                            System.out.println(student.getEnteringYear());
                        } else if (line == parser.startElement("graduateYear") && line != parser.notFound) {
                            student.addgraduateYear(Integer.valueOf(parser.characters(parser.startTag("graduateYear"), parser.lastTag("graduateYear"))));
                            System.out.println(student.getGraduateYear());
                        }
                        line = parser.nextElement();
                    }
                    students.students.add(student);
                }
            }

    }
}

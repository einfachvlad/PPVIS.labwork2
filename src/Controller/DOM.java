package Controller;

import Model.Student;
import Model.Students;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class DOM {
    DocumentBuilderFactory documentBuilderFactory;
    Document doc = null;
    Document newDoc = null;
    Students students = new Students();
    File file;


    public DOM(File file, Students students) {

        this.students = students;
        this.file = file;
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            doc = documentBuilder.parse(file);
        } catch (SAXException e) {
            System.exit(1);
        } catch (ParserConfigurationException e) {
            System.err.println(e);
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stepThrough(Node start, Student student) {
        if (start.getParentNode().getNodeName() == "name") {
            System.out.println(start.getNodeValue());
            student.addName(start.getNodeValue());
        } else if (start.getParentNode().getNodeName() == "birthDate") {
            System.out.println(start.getNodeValue());
            student.addBirthDate(start.getNodeValue());
        } else if (start.getParentNode().getNodeName() == "enteringYear") {
            System.out.println(start.getNodeValue());
            student.addenteringYear(Integer.valueOf(start.getNodeValue()));
        } else if (start.getParentNode().getNodeName() == "graduateYear") {
            System.out.println(start.getNodeValue());
            student.addgraduateYear(Integer.valueOf(start.getNodeValue()));
        }
        for (Node child = start.getFirstChild();
             child != null;
             child = child.getNextSibling()) {
            if (student.getName() != null && student.getBirthDate(student.FULL) != null && student.getEnteringYear() != 0 && student.getGraduateYear() != 0) {
                {
                    students.students.add(student);
                    student = new Student();
                }
            }
            stepThrough(child, student);

        }
    }

    public void parse() {
        Element root = doc.getDocumentElement();
        System.out.println("The root element is " + root.getNodeName());
        NodeList children = root.getChildNodes(); //root.getElementsByTagName("student");
        System.out.println("There are " + children.getLength()
                + " nodes in this документ.");

        Student student = new Student();
        stepThrough(root, student);
        Iterator iterator = students.students.iterator();
        for (int current = 0, next = 1; next < students.students.size(); current++, next++) {
            if (students.students.get(current) == students.students.get(next))
                students.students.remove(next);
        }


    }

    public void save() {

        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter
                    (new FileWriter(file));
            writer.writeStartDocument("utf-8", "1.0");
            writer.writeCharacters("\n");
            writer.writeStartElement("students");
            writer.writeCharacters("\n");

            for (Student student : students.students) {
                writer.writeStartElement("student");
                writer.writeCharacters("\n");

                writer.writeStartElement("name");
                writer.writeCharacters(student.getName());
                writer.writeEndElement();
                writer.writeCharacters("\n");


                writer.writeStartElement("birthDate");
                writer.writeCharacters(student.getBirthDate(student.MEDIUM));
                writer.writeEndElement();
                writer.writeCharacters("\n");


                writer.writeStartElement("enteringYear");
                writer.writeCharacters(Integer.toString(student.getEnteringYear()));
                writer.writeEndElement();
                writer.writeCharacters("\n");


                writer.writeStartElement("graduateYear");
                writer.writeCharacters(Integer.toString(student.getGraduateYear()));
                writer.writeEndElement();
                writer.writeCharacters("\n");


                writer.writeEndElement();
                writer.writeCharacters("\n");

            }
            writer.writeEndElement();
            writer.writeCharacters("\n");
            writer.writeEndDocument();
            writer.flush();

        } catch (UnsupportedOperationException UnsupportedOperationException) {

        } catch (Exception eSave) {
            JOptionPane.showMessageDialog
                    (null, "Невозможно сохранить файл", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog
                (null, "Файл сохранен", "Успех", JOptionPane.INFORMATION_MESSAGE);


    }
}

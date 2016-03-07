package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SAXparser {
    ArrayList<String> lines = new ArrayList<>();

    public SAXparser(String name)  {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(name));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            for(String student:lines)
                System.out.println(student);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String startElement(String name){

        int index=0;
        for(String line: lines)
        {
            if(line.contains(name)&&!line.contains(name+"s")) {
                index = lines.indexOf(line);
                break;
            }
        }
        return lines.get(index);
    }
    public String lastElement(String name){

        int index=0;
        String element=startElement(name);
        ArrayList<String> part=new ArrayList<>(
                lines.subList(
                        lines.indexOf(element),lines.lastIndexOf(
                                lines.get(
                                        lines.size()-2))));
        for(String line: part)
        {
            if(line.contains("</"+name+">")) {
                index = lines.indexOf(line);
                break;
            }
        }
        return lines.get(index);
    }
    public void test(String name){
       String start= startElement(name);
       String last=lastElement(name);
    }
}

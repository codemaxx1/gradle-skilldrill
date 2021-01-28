package edu.isu.cs.cs2263;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOManager implements Serializable {

/*
    public static void writeData(String file, Student data){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(data);
        System.out.println(data);

        try{
            Files.writeString(Paths.get("./student.json"), json);  }
        catch (IOException ex){ex.printStackTrace(); }

        String json2 = "";
    }



    public static Student readData(String file) {
        //Student other = null;
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json2 = "";
        try {
            json2 = Files.readString(Paths.get("./student.json")); }
        catch (IOException ex) {ex.printStackTrace();}

        Student other = gson.fromJson(json2, Student.class);
        return other;
    }


 */
    public static void writeData(List<Student> list) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(list);

        System.out.println(json);

        try {Files.writeString(Paths.get("./students.json"), json);}
        catch (IOException ex) {ex.printStackTrace(); }

    }

    public static List readData(String file) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json2 = "";
        try {json2 = Files.readString(Paths.get("./students.json"));}
        catch (IOException ex) {ex.printStackTrace();}
        Type listType = new TypeToken<ArrayList<Student>>() {}.getType();
        List<Student> other = gson.fromJson(json2, listType);

        for (Student p : other)
            System.out.println(p);
        return other;
    }

}

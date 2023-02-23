package kz.attractor.java;


import kz.attractor.java.lesson44.FileService;
import kz.attractor.java.lesson44.Lesson44Server;
import kz.attractor.java.lesson44.Lesson45Server;
import kz.attractor.java.lesson44.LibraryDataModel;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {



        FileService fs = new FileService();
        System.out.println(fs.readBooks());


        try {
            new Lesson45Server("localhost", 9889).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

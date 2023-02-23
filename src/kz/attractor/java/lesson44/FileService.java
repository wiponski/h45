
package kz.attractor.java.lesson44;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import kz.attractor.java.lesson44.BookData;
import kz.attractor.java.lesson44.CustomerData;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static List readBooks(){
        Path path = Paths.get("./src/kz/attractor/java/lesson44/books.json");
        String json;
        try {
            json = Files.readString(path);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return gson.fromJson(json,List.class);
    }
    public static List readCustomers(){
        Path path = Paths.get("./src/kz/attractor/java/lesson44/customers.json");
        String json;
        try {
            json = Files.readString(path);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return gson.fromJson(json,List.class);
    }
    public static List<UserData> readUsers(){
        Path path = Paths.get("users.json");
        String json;
        try {
            json = Files.readString(path);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        UserData[] userData = gson.fromJson(json, UserData[].class);
        return new ArrayList<>(List.of(userData));
    }

    public static void writeFile(List<UserData> data){
        try (PrintWriter out = new PrintWriter(new FileWriter("users.json"))) {
            String jsonString = gson.toJson(data);
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

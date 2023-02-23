package kz.attractor.java.lesson44;

import com.google.gson.stream.JsonWriter;
import com.sun.net.httpserver.HttpExchange;
import kz.attractor.java.server.ContentType;
import kz.attractor.java.server.ResponseCodes;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownServiceException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Lesson45Server extends Lesson44Server {

    public Lesson45Server(String host, int port) throws IOException {
        super(host, port);

        registerGet("/login", this::loginGet);
        registerPost("/login", this::loginPost);

        registerGet("/register", this::registerGet);
        registerPost("/register", this::registerPost);
    }

    protected void loginPost(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");
        try {
            if (parsed.size() == 2) {
                String email = parsed.get("email");
                String pass = parsed.get("user-password");
                List<UserData> data = FileService.readUsers();
                for (UserData user : data) {
                    if (user.getMail().equals(email)&&user.getPass().equals(pass)) {
                        redirect303(exchange, "/");
                    }
                }
                    throw new RuntimeException("Не корректные данные пользователя!");

            } else {
                throw new RuntimeException("\"Заполнить поля! <a href=\\\"/register\\\"> вернутся </a>\"");
            }

            } catch (RuntimeException exception) {
            try {
                sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, exception.getMessage().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void loginGet(HttpExchange exchange) {
        Path path = makeFilePath("login.html");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }

    private void registerPost(HttpExchange exchange) {

        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");

        try {

            if (parsed.size() == 3) {

                String email = parsed.get("email");
                String name = parsed.get("name");
                String pass = parsed.get("user-password");

                List<UserData> data = FileService.readUsers();

                for (UserData user : data) {
                    if (user.getMail().equals(email)) {
                        throw new RuntimeException("Почта занята!");
                    }
                }

                data.add(new UserData(email, name, pass));
                FileService.writeFile(data);

                redirect303(exchange, "/login");
            } else {
               throw new RuntimeException("Заполнить поля! <a href=\"/register\"> вернутся </a>");
            }

        } catch (RuntimeException exception) {
            try {
                sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, exception.getMessage().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private void registerGet(HttpExchange exchange) {
        Path path = makeFilePath("register.html");
        sendFile(exchange, path, ContentType.TEXT_HTML);

    }


}

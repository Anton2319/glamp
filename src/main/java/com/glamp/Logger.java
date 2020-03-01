package main.java.com.glamp;

import java.io.*;

public class Logger {

    public Boolean writeConsole = true;
    public Boolean timePrefix = false;
    public String filename = "log.txt";


    private static void writeFile(String filename, String text) {
        if(!filename.equals("")||filename!=null) {
            try (FileWriter fileWriter = new FileWriter(filename, false)) {
                fileWriter.write(text);
                fileWriter.flush();
            } catch (Exception e) {
                System.out.println("[CRITICAL] Cannot write logs to file " + e.getStackTrace());
            }
        }
    }
    public void message(String message) {
        writeFile(filename, message);
        System.out.println("[log] " + message);
    }
    public void warn(String message) {
        writeFile(filename, message);
        System.out.println("[WARN] " + message);
    }
    public void critical(String message) {
        writeFile(filename, message);
        System.out.println("[CRITICAL] " + message);
    }
}

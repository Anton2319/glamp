package test.java;

import main.java.com.glamp.Logger;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @org.junit.jupiter.api.Test
    static void message(String message) {
        Logger log = new Logger();
        log.filename = "testlog.txt";
        log.message(message);
    }

    @org.junit.jupiter.api.Test
    static void warn() {
    }

    @org.junit.jupiter.api.Test
    static void critical() {
    }
}
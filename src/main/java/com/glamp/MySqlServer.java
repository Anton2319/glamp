package main.java.com.glamp;

import java.io.IOException;

public class MySqlServer extends com.glamp.Server {

    int port = 80;
    String status;

    public void run() {
        status = "Running";
    }
    public void shutdown() {}
    public String status() {
        return status;
    }
}

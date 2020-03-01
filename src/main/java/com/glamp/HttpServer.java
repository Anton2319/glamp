package main.java.com.glamp;

import com.jsunsoft.http.*;

import java.io.IOException;

public class HttpServer extends com.glamp.Server {

    int port = 80;
    String status;
    Logger log = new Logger();

    public void run() {
        if(port==80) {
            try {
                log.message("Apache2 running normally");
                Runtime.getRuntime().exec("systemctl start apache2");
            } catch (IOException e) {
                String error = "An error has occured in http server:" + e;
                log.critical(error);
                status = "Failed";
            }
        }
    }
    public void shutdown() {
        try {
            Runtime.getRuntime().exec("systemctl stop apache2");
        } catch (IOException e) {
            System.out.println("Cannot stop apache http server! Check logs!");
        }
    }
    public String status() {
        return status;
    }
}

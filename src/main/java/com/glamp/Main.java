package main.java.com.glamp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.com.glamp.HttpServer;
import main.java.com.glamp.MySqlServer;


import static javafx.application.Application.launch;

public class Main extends Application {


    HttpServer apache = new HttpServer();
    MySqlServer mysql = new MySqlServer();



    public static void main(String[] args)  {
           launch(args);
    }
    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("gLAMP");
        window.toFront();
        //Кнопка для запуска
        Button btnStart = new Button();
        btnStart.setText("Запустить локальный сервер  ");
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startServer();
                btnStart.cancelButtonProperty();
            }
        });
        //Кнопка для остановки
        Button btnStop = new Button();
        btnStop.setText("Остановить локальный сервер");
        btnStop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 btnStart.defaultButtonProperty();
                 apache.shutdown();
                 mysql.shutdown();
            }
        });
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.add(btnStart, 1 , 1);
        root.add(btnStop, 1, 2);
        window.setScene(new Scene(root, 500, 400));
        window.show();
    }
    private void startServer() {
        apache.start();
        mysql.start();
    }
}

package com.example.plantsvszombies;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane=new Pane();
        Scene scene=new Scene(pane,600,600);
        stage.setTitle("Plants-Vs-Zombies");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

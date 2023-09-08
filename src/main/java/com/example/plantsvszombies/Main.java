package com.example.plantsvszombies;

import UI.GameHall.GameHall;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GameHall gameHall=new GameHall();
        gameHall.start(stage);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

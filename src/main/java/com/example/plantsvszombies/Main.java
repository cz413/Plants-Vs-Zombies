package com.example.plantsvszombies;

import UI.GameHall;
import UI.GameStart;
import UI.GameWelcome;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ServiceConfigurationError;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main extends Application {
    //场景1————welcome页面
    private static Scene scene_Welcome;
    //场景2————GameHall页面
    private static Scene scene_GameHall;
    //场景3————Game页面
    private static Scene scene_Game;
    //按钮音效
    private static AudioClip audioClip_Button;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Plants-Vs-Zombies");
        /*
        * ---------------------------------------------初始化界面----------------------------------------------------
        * */
        //三个场景类实例化
        GameStart gameStart=new GameStart();
        GameWelcome gameWelcome=new GameWelcome();
        GameHall gameHall=new GameHall();
        //将三个场景进行赋值
        scene_Welcome=gameWelcome.getScene();
        scene_Game=gameStart.getScene();
        scene_GameHall=gameHall.getScene();

        //进行场景跳转的按钮的槽函数
        //欢迎界面的按钮的槽函数
        gameWelcome.button_GameStart.setOnMouseClicked(mouseEvent -> {
            stage.setScene(scene_GameHall);
        });
        //游戏大厅界面的槽函数
        //判断界面是否已经移动过
        final boolean[] tranFlag = {true};
        gameHall.button_Start.setOnMouseClicked(mouseEvent -> {
            stage.setScene(scene_Game);
            if(tranFlag[0] ==true) {
                gameStart.translateTransition1.play();
                tranFlag[0] =false;
            }
        });
        //游戏菜单按钮中的槽函数
        gameStart.button_returnMainMenu.setOnMouseClicked(mouseEvent -> {
            //gameStart.Pane_Game.getChildren().remove(gameStart.pane_Menubar);
            stage.setScene(scene_GameHall);
        });
        stage.setScene(scene_Welcome);
        stage.show();

        /*
         * -----------------------------------------------音乐添加---------------------------------------------------
         * */
        //背景音乐
        AudioClip audioClip_BackGround=new AudioClip("file:resourses/Music/Background_BGM.wav");
        audioClip_BackGround.setCycleCount(AudioClip.INDEFINITE);
        audioClip_BackGround.setPriority(Thread.MAX_PRIORITY);
        audioClip_BackGround.play();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

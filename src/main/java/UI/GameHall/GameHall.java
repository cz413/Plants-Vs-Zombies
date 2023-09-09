package UI.GameHall;

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
//import javafx.scene.media.AudioClip;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.FileInputStream;
import java.io.InputStream;


public class GameHall extends Application {
    @Override
    public void start(Stage stage) throws Exception {


/*
* ---------------------------------------------Welcome界面设计-----------------------------q-----------------------------
* */
        // 创建一个ImageView_Welcome用于显示开瓶动画图片
        ImageView imageView_Welcome = new ImageView();

        //开始游戏按钮
        Button button_GameStart=new Button("");
        button_GameStart.setLayoutX(250);
        button_GameStart.setLayoutY(541);
        button_GameStart.setPrefWidth(301);
        button_GameStart.setPrefHeight(30);
        button_GameStart.setOpacity(0.0);
        button_GameStart.setDisable(true);
        button_GameStart.setCursor(Cursor.HAND);



        // 加载图片序列
        String[] imageFiles = {
                "file:resourses/GameWelcome_Resourses/load (1).png",  "file:resourses/GameWelcome_Resourses/load (2).png",
                "file:resourses/GameWelcome_Resourses/load (3).png",  "file:resourses/GameWelcome_Resourses/load (4).png",
                "file:resourses/GameWelcome_Resourses/load (5).png",  "file:resourses/GameWelcome_Resourses/load (6).png",
                "file:resourses/GameWelcome_Resourses/load (7).png",  "file:resourses/GameWelcome_Resourses/load (8).png",
                "file:resourses/GameWelcome_Resourses/load (9).png",  "file:resourses/GameWelcome_Resourses/load (10).png",
                "file:resourses/GameWelcome_Resourses/load (11).png", "file:resourses/GameWelcome_Resourses/load (12).png",
                "file:resourses/GameWelcome_Resourses/load (13).png", "file:resourses/GameWelcome_Resourses/load (14).png",
                "file:resourses/GameWelcome_Resourses/load (15).png", "file:resourses/GameWelcome_Resourses/load (16).png",
                "file:resourses/GameWelcome_Resourses/load (17).png", "file:resourses/GameWelcome_Resourses/load (18).png",
                "file:resourses/GameWelcome_Resourses/load (19).png", "file:resourses/GameWelcome_Resourses/load (20).png",
                "file:resourses/GameWelcome_Resourses/load (21).png", "file:resourses/GameWelcome_Resourses/load (22).png",
                "file:resourses/GameWelcome_Resourses/load (23).png", "file:resourses/GameWelcome_Resourses/load (24).png",
                "file:resourses/GameWelcome_Resourses/load (25).png", "file:resourses/GameWelcome_Resourses/load (26).png",
                "file:resourses/GameWelcome_Resourses/load (27).png", "file:resourses/GameWelcome_Resourses/load (28).png",
                "file:resourses/GameWelcome_Resourses/load (29).png", "file:resourses/GameWelcome_Resourses/load (30).png",
                "file:resourses/GameWelcome_Resourses/load (31).png", "file:resourses/GameWelcome_Resourses/load (32).png",
                "file:resourses/GameWelcome_Resourses/load (33).png", "file:resourses/GameWelcome_Resourses/load (34).png",
                "file:resourses/GameWelcome_Resourses/load (35).png", "file:resourses/GameWelcome_Resourses/load (36).png",
                "file:resourses/GameWelcome_Resourses/load (37).png", "file:resourses/GameWelcome_Resourses/load (38).png",
                "file:resourses/GameWelcome_Resourses/load (39).png", "file:resourses/GameWelcome_Resourses/load (40).png",
                "file:resourses/GameWelcome_Resourses/load (41).png", "file:resourses/GameWelcome_Resourses/load (42).png",
                "file:resourses/GameWelcome_Resourses/load (43).png", "file:resourses/GameWelcome_Resourses/load (44).png",
                "file:resourses/GameWelcome_Resourses/load (45).png", "file:resourses/GameWelcome_Resourses/load (46).png",
                "file:resourses/GameWelcome_Resourses/load (47).png", "file:resourses/GameWelcome_Resourses/load (48).png",
                "file:resourses/GameWelcome_Resourses/load (49).png", "file:resourses/GameWelcome_Resourses/load (50).png",
                "file:resourses/GameWelcome_Resourses/load (51).png", "file:resourses/GameWelcome_Resourses/load (52).png",
                "file:resourses/GameWelcome_Resourses/load (53).png", "file:resourses/GameWelcome_Resourses/load (54).png",
                "file:resourses/GameWelcome_Resourses/load (55).png", "file:resourses/GameWelcome_Resourses/load (56).png",
                "file:resourses/GameWelcome_Resourses/load (57).png", "file:resourses/GameWelcome_Resourses/load (58).png",
                "file:resourses/GameWelcome_Resourses/load (59).png", "file:resourses/GameWelcome_Resourses/load (60).png",
                "file:resourses/GameWelcome_Resourses/load (61).png", "file:resourses/GameWelcome_Resourses/load (62).png",
                "file:resourses/GameWelcome_Resourses/load (63).png", "file:resourses/GameWelcome_Resourses/load (64).png",
                "file:resourses/GameWelcome_Resourses/load (65).png", "file:resourses/GameWelcome_Resourses/load (66).png",
                "file:resourses/GameWelcome_Resourses/load (67).png", "file:resourses/GameWelcome_Resourses/load (68).png",
                "file:resourses/GameWelcome_Resourses/load (69).png", "file:resourses/GameWelcome_Resourses/load (70).png",
                "file:resourses/GameWelcome_Resourses/load (71).png", "file:resourses/GameWelcome_Resourses/load (72).png",
                "file:resourses/GameWelcome_Resourses/load (73).png", "file:resourses/GameWelcome_Resourses/load (74).png",
                "file:resourses/GameWelcome_Resourses/load (75).png", "file:resourses/GameWelcome_Resourses/load (76).png",
                "file:resourses/GameWelcome_Resourses/load (77).png", "file:resourses/GameWelcome_Resourses/load (78).png",
                "file:resourses/GameWelcome_Resourses/load (79).png", "file:resourses/GameWelcome_Resourses/load (80).png",
                "file:resourses/GameWelcome_Resourses/load (81).png", "file:resourses/GameWelcome_Resourses/load (82).png",
                "file:resourses/GameWelcome_Resourses/load (83).png", "file:resourses/GameWelcome_Resourses/load (84).png",
                "file:resourses/GameWelcome_Resourses/load (85).png", "file:resourses/GameWelcome_Resourses/load (86).png",
                "file:resourses/GameWelcome_Resourses/load (87).png", "file:resourses/GameWelcome_Resourses/load (88).png",
                "file:resourses/GameWelcome_Resourses/load (89).png", "file:resourses/GameWelcome_Resourses/load (90).png",
                "file:resourses/GameWelcome_Resourses/load (91).png", "file:resourses/GameWelcome_Resourses/load (92).png",
                "file:resourses/GameWelcome_Resourses/load (93).png", "file:resourses/GameWelcome_Resourses/load (94).png",
                "file:resourses/GameWelcome_Resourses/load (95).png", "file:resourses/GameWelcome_Resourses/load (96).png",
                "file:resourses/GameWelcome_Resourses/load (97).png", "file:resourses/GameWelcome_Resourses/load (98).png",
                "file:resourses/GameWelcome_Resourses/load (99).png", "file:resourses/GameWelcome_Resourses/load (100).png",
                "file:resourses/GameWelcome_Resourses/load (101).png","file:resourses/GameWelcome_Resourses/load (102).png",
                "file:resourses/GameWelcome_Resourses/load (103).png"
        };

        // 创建一个时间轴对象
        Timeline timeline = new Timeline();

        // 添加关键帧到时间轴
        for (int i = 0; i < imageFiles.length; i++) {
            String imagePath = imageFiles[i];
            Image image = new Image(imagePath);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(90 * (i + 1)),
                    event -> imageView_Welcome.setImage(image));
            timeline.getKeyFrames().add(keyFrame);
//            if(i==imageFiles.length-1){
//
//            }
        }

        // 设置循环次数
        timeline.setCycleCount(1);

        //让图片播放完之后可以点击按钮



        /*
        * --------------------------------------------游戏大厅界面设计----------------------------------------------------
        * */

        //大厅场景以及按钮高亮的图片
        Image image_GameHall = new Image("file:resourses/GameHall_Resourses/GameHall.png");
        Image image_Start=new Image("file:resourses/GameHall_Resourses/START_ADVENTURE.png");
        Image image_Mini=new Image("file:resourses/GameHall_Resourses/MINI_GAMES.png");
        Image image_Puzzle=new Image("file:resourses/GameHall_Resourses/PUZZLE.png");
        Image image_Survival=new Image("file:resourses/GameHall_Resourses/SURVIVAL.png");
        ImageView imageView_Hall = new ImageView(image_GameHall);
        //开始游戏  迷你游戏等按钮 从上往下依次
        Button button_Start=new Button();
        Button button_Mini=new Button();
        Button button_Puzzle=new Button();
        Button button_Survival=new Button();
        /*
        * 设置按钮样式
        * */
        //开始按钮
        button_Start.setLayoutX(447);
        button_Start.setLayoutY(156);
        button_Start.setMinWidth(301);
        button_Start.setMinHeight(69);
        button_Start.setRotate(7);
        button_Start.setOpacity(0.0);
        button_Start.setCursor(Cursor.HAND);
        button_Start.setOnMouseEntered(event->{
            imageView_Hall.setImage(image_Start);

        });
        button_Start.setOnMouseExited(event->{
            imageView_Hall.setImage(image_GameHall);
        });
        //迷你游戏按钮
        button_Mini.setLayoutX(459);
        button_Mini.setLayoutY(236);
        button_Mini.setMinWidth(265);
        button_Mini.setMinHeight(69);
        button_Mini.setRotate(9);
        button_Mini.setOpacity(0.0);
        button_Mini.setCursor(Cursor.HAND);
        button_Mini.setOnMouseEntered(event->{
            imageView_Hall.setImage(image_Mini);

        });
        button_Mini.setOnMouseExited(event->{
            imageView_Hall.setImage(image_GameHall);
        });
        //Puzzlle
        button_Puzzle.setLayoutX(460);
        button_Puzzle.setLayoutY(313);
        button_Puzzle.setMinWidth(263);
        button_Puzzle.setMinHeight(53);
        button_Puzzle.setRotate(12);
        button_Puzzle.setOpacity(0.0);
        button_Puzzle.setCursor(Cursor.HAND);
        button_Puzzle.setOnMouseEntered(event->{
            imageView_Hall.setImage(image_Puzzle);

        });
        button_Puzzle.setOnMouseExited(event->{
            imageView_Hall.setImage(image_GameHall);
        });
        //SUrvival
        button_Survival.setLayoutX(459);
        button_Survival.setLayoutY(384);
        button_Survival.setMinWidth(221);
        button_Survival.setMinHeight(46);
        button_Survival.setRotate(15);
        button_Survival.setOpacity(0.0);
        button_Survival.setCursor(Cursor.HAND);
        button_Survival.setOnMouseEntered(event->{
            imageView_Hall.setImage(image_Survival);

        });
        button_Survival.setOnMouseExited(event->{
            imageView_Hall.setImage(image_GameHall);
        });

        //场景显示
        Pane Pane_Hall = new Pane();
        Pane Pane_Welcome=new Pane();
        Pane_Hall.getChildren().addAll(imageView_Hall,button_Start,button_Mini,button_Puzzle,button_Survival);
        Pane_Welcome.getChildren().addAll(imageView_Welcome,button_GameStart);
        Scene scene_Hall=new Scene(Pane_Hall, 800, 600);
        Scene scene_Welcome =new Scene(Pane_Welcome,800,600);

        //开始进入游戏大厅界面的按钮特效
        timeline.statusProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == Animation.Status.STOPPED) {
                button_GameStart.setDisable(false);
                button_GameStart.setOnMouseEntered(mouseEvent -> {
                imageView_Welcome.setImage(new Image("file:resourses/GameWelcome_Resourses/load (104).png"));
                });
                button_GameStart.setOnMouseExited(mouseEvent -> {
                    imageView_Welcome.setImage(new Image("file:resourses/GameWelcome_Resourses/load (103).png"));
                });
            }
        });


/*
* -------------------------------------------------------游戏界面-------------------------------------------------------
* */
        Image Background_Game = new Image("file:resourses/GameStarting_Resourses/Background0.jpg");
        ImageView imageView_Game = new ImageView(Background_Game);

        // 创建平移动画1（从原始位置平移到目标位置）
        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(2), imageView_Game);
        translateTransition1.setFromX(0);  // 起始位置的X坐标
        translateTransition1.setFromY(0);  // 起始位置的Y坐标
        translateTransition1.setToX(-520);  // 结束位置的X坐标
        translateTransition1.setToY(0);  // 结束位置的Y坐标

        // 创建平移动画2（从目标位置平移到起始位置）
        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(2), imageView_Game);
        translateTransition2.setFromX(-520);  // 起始位置的X坐标
        translateTransition2.setFromY(0);  // 起始位置的Y坐标
        translateTransition2.setToX(-220);      // 结束位置的X坐标
        translateTransition2.setToY(0);      // 结束位置的Y坐标

        Pane Pane_Game=new Pane(imageView_Game);
        // 设置动画完成后的操作
        translateTransition1.setOnFinished(event -> {
            // 播放动画2（从目标位置平移到起始位置）
            translateTransition2.play();
        });

        //阳光数目显示
        Label numSun=new Label("50");
        numSun.setPrefWidth(50);
        numSun.setPrefHeight(23);
        numSun.setLayoutX(25);
        numSun.setLayoutY(60);
        numSun.setAlignment(Pos.CENTER);
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        numSun.setFont(font);

        //菜单按钮
        Button back0=new Button();
        back0.setLayoutX(690);
        back0.setLayoutY(0);
        back0.setPrefHeight(42);
        back0.setPrefWidth(108);
        back0.setOpacity(0.0);


        //小推车
        Image miniCar=new Image("file:resourses/GameStarting_Resourses/car.png");
        ImageView car1=new ImageView(miniCar);
        ImageView car2=new ImageView(miniCar);
        ImageView car3=new ImageView(miniCar);
        ImageView car4=new ImageView(miniCar);
        ImageView car5=new ImageView(miniCar);
        car1.setLayoutX(-50);
        car1.setLayoutY(80);
        car2.setLayoutX(-50);
        car2.setLayoutY(170);
        car3.setLayoutX(-50);
        car3.setLayoutY(260);
        car4.setLayoutX(-50);
        car4.setLayoutY(370);
        car5.setLayoutX(-50);
        car5.setLayoutY(460);



        translateTransition2.setOnFinished(event -> {
            // 动画结束,出现卡槽等
            Image slot0=new Image("file:resourses/GameStarting_Resourses/Plant_Slot.png");
            Image shoveBank0=new Image("file:resourses/GameStarting_Resourses/ShovelBank.png");
            Image shove0=new Image("file:resourses/GameStarting_Resourses/shovel.png");
            Image back1=new Image("file:resourses/GameStarting_Resourses/Menu_Background.png");
            Image back2=new Image("file:resourses/GameStarting_Resourses/Menu_Background_Clicked.png");
            ImageView plantSlot=new ImageView(slot0);
            ImageView shoveBank=new ImageView(shoveBank0);
            ImageView shove=new ImageView(shove0);
            ImageView back01=new ImageView(back1);
            plantSlot.setLayoutX(10);
            plantSlot.setLayoutY(0);
            shoveBank.setLayoutX(512);
            shoveBank.setLayoutY(0);
            shove.setLayoutX(513);
            shove.setLayoutY(0);
            back01.setLayoutX(685);
            back01.setLayoutY(0);
            back0.setOnMouseEntered(Event->{
                back01.setImage(back2);
            });
            back0.setOnMouseExited(Event->{
                back01.setImage(back1);
            });
            Pane_Game.getChildren().addAll(plantSlot,shoveBank,shove,back01,back0,numSun,car1,car2
                    ,car3,car4,car5);

        });

        // 播放动画1（从原始位置平移到目标位置）

        Scene Game = new Scene(Pane_Game,800,600);

        //舞台显示
        stage.setScene(scene_Welcome);
        stage.setTitle("Plants-Vs-Zombies");
        stage.show();
        timeline.play();
        //切换场景按钮功能
        //从欢迎界面到游戏大厅
        button_GameStart.setOnMouseClicked(event->{
            stage.setScene(scene_Hall);
            //mediaPlayer.play();
        });
        //从游戏大厅开始游戏
        button_Start.setOnMouseClicked(mouseEvent -> {
            stage.setScene(Game);
            translateTransition1.play();//界面平移操作
        });


    }

//    public static void main(String[] args) {
//        launch(args);
//    }

}

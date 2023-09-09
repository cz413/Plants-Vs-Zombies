package com.example.plantsvszombies;

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
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main extends Application {
    //场景1————welcome页面
    private static Scene scene_Welcome;
    //场景2————GameHall页面
    private static Scene scene_GameHall;
    //场景3————Game页面
    private static Scene scene_Game;

    @Override
    public void start(Stage stage) throws Exception {

        /*
         * -----------------------------------------------音乐添加---------------------------------------------------------------
         * */
        //背景音乐
        AudioClip audioClip_BackGround=new AudioClip("file:resourses/Music/Background_BGM.wav");
        audioClip_BackGround.setCycleCount(AudioClip.INDEFINITE);
        audioClip_BackGround.play();
        init_WelcomeScene(stage);
        init_GameHallScene(stage);
        stage.setScene(scene_Welcome);
        stage.setTitle("Plants-Vs-Zombies");
        stage.show();
    }

    /*
    * 初始化Welcome界面的方法函数
    * */
    public void init_WelcomeScene(Stage stage){
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

        //加载图片序列
        String[] imageFiles=new String[103];
        for(int i=1;i<104;i++)
        {
            imageFiles[i-1]="file:resourses/GameWelcome_Resourses/load ("+i+").png";
        }
        // 创建一个时间轴对象
        Timeline timeline = new Timeline();

        // 添加关键帧到时间轴
        for (int i = 0; i < imageFiles.length; i++) {
            String imagePath = imageFiles[i];
            Image image = new Image(imagePath);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(90 * (i + 1)),
                    event -> imageView_Welcome.setImage(image));
            timeline.getKeyFrames().add(keyFrame);
            if(i==imageFiles.length-1){

            }
        }

        // 设置循环次数
        timeline.setCycleCount(1);

        //让图片播放完之后可以点击按钮


        //welcome场景显示，及容器添加
        Pane Pane_Welcome=new Pane();
        Pane_Welcome.getChildren().addAll(imageView_Welcome,button_GameStart);
        scene_Welcome=new Scene(Pane_Welcome, 800, 600);
        //时间轴播放
        timeline.play();

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

        //切换场景按钮功能
        //从欢迎界面到游戏大厅
        button_GameStart.setOnMouseClicked(event->{
            stage.setScene(scene_GameHall);
            //mediaPlayer.play();
        });
    }

    /*
    * 初始化GameHall界面的方法函数
    * */
    public void init_GameHallScene(Stage stage){
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
        Pane_Hall.getChildren().addAll(imageView_Hall,button_Start,button_Mini,button_Puzzle,button_Survival);
        scene_GameHall=new Scene(Pane_Hall,800,600);

        //从游戏大厅开始游戏
        button_Start.setOnMouseClicked(mouseEvent -> {
            //鼠标点击初始化游戏界面场景
            init_Scene_Game();
            stage.setScene(scene_Game);
        });
    }

    public static void init_Scene_Game() {
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
            Image slot0=new Image("file:resourses/GameStarting_Resourses/slot01.png");
            Image shoveBank0=new Image("file:resourses/GameStarting_Resourses/ShovelBank.png");
            Image shove0=new Image("file:resourses/GameStarting_Resourses/showel.png");
            Image back1=new Image("file:resourses/GameStarting_Resourses/back02.png");
            Image back2=new Image("file:resourses/GameStarting_Resourses/back03.png");
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
            //游戏页面菜单部分的鼠标悬停，菜单按钮颜色变化
            back0.setOnMouseEntered(Event->{
                back01.setImage(back2);
            });
            back0.setOnMouseExited(Event->{
                back01.setImage(back1);
            });
            Pane_Game.getChildren().addAll(plantSlot,shoveBank,shove,back01,back0,numSun,car1,car2,car3,car4,car5);

            /*
            * 临时代码
            * 作用：设置卡槽出现时候自带一个植物卡片
            * */
            ImageView img_peaShooterCard=new ImageView(new Image("file:resourses/PlantsCard/PeaShooter.png"));
            img_peaShooterCard.setFitHeight(76);
            img_peaShooterCard.setFitWidth(63);
            Label label_peaShooter=new Label();
            label_peaShooter.setGraphic(img_peaShooterCard);
            label_peaShooter.setLayoutX(87);
            label_peaShooter.setLayoutY(2);
            Pane_Game.getChildren().add(label_peaShooter);

            label_peaShooter.setOnMouseClicked(label_peaShooter_event->{
                System.out.println("我被点击楽");
                ImageView peaShooterPre=new ImageView(new Image("file:resourses/Plant/img.png"));
                peaShooterPre.setOpacity(0.7);
                scene_Game.setOnMouseMoved(peaShooterPre_event->{
                    AtomicBoolean isClicked= new AtomicBoolean(false);
                    if(isClicked.get() ==false){
                        peaShooterPre.setLayoutX(peaShooterPre_event.getX());
                        peaShooterPre.setLayoutY(peaShooterPre_event.getY());
                    }
                    scene_Game.setOnMouseClicked(e->{
                        isClicked.set(true);
                    });
                });
                Pane_Game.getChildren().add(peaShooterPre);
            });

        });

        // 播放动画1（从原始位置平移到目标位置）
        scene_Game= new Scene(Pane_Game,800,600);

        translateTransition1.play();//界面平移操作
    }

    public static void main(String[] args) {
        Application.launch(args);
    }



}

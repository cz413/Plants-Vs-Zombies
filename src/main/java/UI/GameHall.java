package UI;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;

public class GameHall {

    private Scene scene;

    public Button button_Start;
    public Button button_Mini;
    public Button button_Puzzle;
    public Button button_Survival;

    public Scene getScene() {
        return scene;
    }

    public GameHall(){
        //大厅场景以及按钮高亮的图片
        AudioClip audioClip_Button=new AudioClip("file:resourses/Music/Button_BGM.wav");
        Image image_GameHall = new Image("file:resourses/GameHall_Resourses/GameHall.png");
        Image image_Start=new Image("file:resourses/GameHall_Resourses/START_ADVENTURE.png");
        Image image_Mini=new Image("file:resourses/GameHall_Resourses/MINI_GAMES.png");
        Image image_Puzzle=new Image("file:resourses/GameHall_Resourses/PUZZLE.png");
        Image image_Survival=new Image("file:resourses/GameHall_Resourses/SURVIVAL.png");
        ImageView imageView_Hall = new ImageView(image_GameHall);
        //开始游戏  迷你游戏等按钮 从上往下依次
        button_Start=new Button();
        button_Mini=new Button();
        button_Puzzle=new Button();
        button_Survival=new Button();
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
            audioClip_Button.play();
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
            audioClip_Button.play();
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
            audioClip_Button.play();
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
            audioClip_Button.play();
        });
        button_Survival.setOnMouseExited(event->{
            imageView_Hall.setImage(image_GameHall);
        });

        //场景显示
        Pane Pane_Hall = new Pane();
        Pane_Hall.getChildren().addAll(imageView_Hall,button_Start,button_Mini,button_Puzzle,button_Survival);
        scene=new Scene(Pane_Hall,800,600);

    }
}

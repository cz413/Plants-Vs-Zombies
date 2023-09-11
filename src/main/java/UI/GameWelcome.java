package UI;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class GameWelcome {
    private  Scene scene;

    public Button button_GameStart;

    public Scene getScene() {
        return scene;
    }
    public GameWelcome(){
        AudioClip audioClip_Button=new AudioClip("file:resourses/Music/Button_BGM.wav");
        // 创建一个ImageView_Welcome用于显示开瓶动画图片
        ImageView imageView_Welcome = new ImageView();
        //开始游戏按钮
        button_GameStart=new Button("");
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

        //welcome场景显示，及容器添加
        Pane Pane_Welcome=new Pane();
        Pane_Welcome.getChildren().addAll(imageView_Welcome,button_GameStart);
        scene=new Scene(Pane_Welcome, 800, 600);
        //时间轴播放
        timeline.play();

        //开始进入游戏大厅界面的按钮特效
        timeline.statusProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == Animation.Status.STOPPED) {
                button_GameStart.setDisable(false);
                button_GameStart.setOnMouseEntered(mouseEvent -> {
                    imageView_Welcome.setImage(new Image("file:resourses/GameWelcome_Resourses/load (104).png"));
                    audioClip_Button.play();
                });
                button_GameStart.setOnMouseExited(mouseEvent -> {
                    imageView_Welcome.setImage(new Image("file:resourses/GameWelcome_Resourses/load (103).png"));
                });
            }
        });

        //切换场景按钮功能
        //从欢迎界面到游戏大厅
        button_GameStart.setOnMouseClicked(event->{

        });
    }

}

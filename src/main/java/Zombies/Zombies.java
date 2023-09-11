package Zombies;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Zombies {
    private ImageView imageView;
    private Image[] images;
    private int numFrames; //每个僵尸的静态图数量
    private int currentFrame;//每个僵尸的静态图索引

    private static final Duration FRAME_DURATION = Duration.millis(100); // 每个静态图的持续时间
    public Zombies(){}

    public Zombies(String[] imagePaths){
        images = new Image[imagePaths.length];
        for(int i=0;i<imagePaths.length;i++){
            images[i] = new Image(imagePaths[i]);
        }
        //一共传入的静态图数量
        numFrames = imagePaths.length;
        //用于显示僵尸的第一张静态图像
        imageView = new ImageView(images[0]);
    }

    public void showAnimation(){
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(20), imageView);
        translateTransition.setFromX(600);//起始位置
        translateTransition.setFromY(0);//起始位置
        translateTransition.setToX(0);//结束位置 -imageView.getImage().getWidth()
        translateTransition.setToY(0);//结束位置
        translateTransition.setCycleCount(1);//循环一次
        translateTransition.setAutoReverse(false);//通过setAutoReverse方法将自动反转设置为false，这意味着动画在到达结束位置后不会自动反转回起始位置。
        translateTransition.play();
//        root.getChildren().add(imageView);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE); // 无限次

        KeyFrame keyFrame = new KeyFrame(FRAME_DURATION, event->{
            imageView.setImage(images[currentFrame]);
            currentFrame = (currentFrame + 1) % numFrames;
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public ImageView getImageView() {
        return imageView;
    }
}
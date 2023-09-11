package Plants;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Plants {

    private ImageView imageView;
    private Image[] images;
    private int numFrames; //每个植物的静态图数量
    private int currentFrame;//每个植物的静态图索引

    private static final Duration FRAME_DURATION = Duration.millis(100); // 每个静态图的持续时间
    public Plants(){}

    public Plants(String[] imagePaths){
        images = new Image[imagePaths.length];
        for(int i=0;i<imagePaths.length;i++){
            images[i] = new Image(imagePaths[i]);
        }
        //一共传入的静态图数量
        numFrames = imagePaths.length;
        //用于显示植物的第一张静态图像
        imageView = new ImageView(images[0]);
    }

    public void showAnimation(){
        imageView.setTranslateX(0);
        imageView.setTranslateY(50);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE); // 无限次

        KeyFrame keyFrame = new KeyFrame(FRAME_DURATION, event->{
            imageView.setImage(images[currentFrame]);
            currentFrame = (currentFrame + 1) % numFrames;
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public void shoot(){
        // 创建TranslateTransition来控制豌豆的水平移动
        TranslateTransition peaTransition = new TranslateTransition(Duration.seconds(3),imageView);
        peaTransition.setFromX(imageView.getTranslateX()); // 起始X坐标为植物的位置
        peaTransition.setToX(700); // 结束X坐标为700
        peaTransition.setCycleCount(Timeline.INDEFINITE); // 设置循环次数为无限
        peaTransition.setAutoReverse(false); // 设置不自动反向播放

        // 创建Timeline来切换豌豆的静态图
        Timeline peaTimeline1 = new Timeline();
        peaTimeline1.setCycleCount(Timeline.INDEFINITE);

        KeyFrame peaKeyFrame1 = new KeyFrame(FRAME_DURATION, event -> {
            // 更新豌豆的图像
            imageView.setImage(images[currentFrame]);

            // 更新当前静态图的索引
            currentFrame = (currentFrame + 1) % numFrames;
        });
        peaTimeline1.getKeyFrames().add(peaKeyFrame1);
        peaTimeline1.setOnFinished(event -> peaTransition.stop()); // 当豌豆的Timeline完成时停止豌豆的移动
        peaTimeline1.play();


//        Timeline peaTimeline2 = new Timeline();
//        peaTimeline2.setCycleCount(Timeline.INDEFINITE);
//        KeyFrame peaKeyFrame2 = new KeyFrame(FRAME_DURATION, event -> {
//            // 更新豌豆的图像
//            imageView.setImage(images[currentFrame]);
//            // 更新当前静态图的索引
//            currentFrame = (currentFrame + 1) % numFrames;
//        });
//        peaTimeline2.getKeyFrames().add(peaKeyFrame2);
//        peaTimeline2.setOnFinished(event -> peaTransition.stop()); // 当豌豆的Timeline完成时停止豌豆的移动
//        peaTimeline2.play();

        peaTransition.play();
    }
    public ImageView getImageView() {
        return imageView;
    }
}
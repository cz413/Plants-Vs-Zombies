package Other;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlantsCard {
    private String name;    //植物名字
    private static String path="file:resourses/PlantsCard/";     //共享的资源文件路径
    private Label plantsCards_lab;
    private ImageView plantsCards_img;

    public PlantsCard(String name){
        this.name=name;
        plantsCards_lab=new Label();
        plantsCards_lab.setId(name);
        plantsCards_img=new ImageView(new Image(path+name+".png"));
        plantsCards_img.setFitHeight(76);
        plantsCards_img.setFitWidth(54);
        plantsCards_lab.setGraphic(plantsCards_img);
    }

    public Label getPlantsCards_lab() {
        return plantsCards_lab;
    }
    public void setPlantsCards_lab_position(int x,int y){
        plantsCards_lab.setLayoutY(y);
        plantsCards_lab.setLayoutX(x);
    }
}

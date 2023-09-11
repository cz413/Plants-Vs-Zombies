package UI;

import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import Plants.PlantsCard.PlantsCard;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameStart {
    private  Scene scene;
    public TranslateTransition translateTransition1;
    public TranslateTransition translateTransition2;
    public Button button_returnMainMenu;
    public Button button_restartGame;
    public Button button_continue;
    public Pane Pane_Game;
    public Pane pane_menu;
    public StackPane pane_Menubar;
    private static int planttimes=0;            //变量用来和植物的点击事件相联系
    private static int shovletimes=0;
    private ImageView imageView_shovel;
    //变量用来和铁铲的点击事件相联系
    public Scene getScene() {
        return scene;
    }
    public GameStart(){
        AudioClip audioClip_Button=new AudioClip("file:resourses/Music/Button_BGM.wav");
        Image Background_Game = new Image("file:resourses/GameStarting_Resourses/Game_Background.jpg");
        ImageView imageView_Game = new ImageView(Background_Game);
        Pane_Game=new Pane();
        /*
         * -----------------------------------------------------------界面组件创建-------------------------------------------------
         * */

        //菜单按钮
        Button Button_Menu=new Button();
        Button_Menu.setLayoutX(690);
        Button_Menu.setLayoutY(0);
        Button_Menu.setPrefHeight(42);
        Button_Menu.setPrefWidth(108);
        Button_Menu.setOpacity(0.0);

        //阳光数目显示
        Label numSun=new Label("50");
        numSun.setPrefWidth(50);
        numSun.setPrefHeight(23);
        numSun.setLayoutX(25);
        numSun.setLayoutY(60);
        numSun.setAlignment(Pos.CENTER);
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        numSun.setFont(font);

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

        //选择植物界面上开始游戏按钮
        Button Button_StartGame=new Button();
        Button_StartGame.setPrefHeight(30);
        Button_StartGame.setPrefWidth(150);
        Button_StartGame.setLayoutX(157);
        Button_StartGame.setLayoutY(463);
        Button_StartGame.setOpacity(0.0);
        Button_StartGame.setCursor(Cursor.HAND);

        //菜单栏
        pane_Menubar=new StackPane();
        Image png_Menubar1=new Image("file:resourses/GameStarting_Resourses/menubar1.png");
        Image png_Menubar2=new Image("file:resourses/GameStarting_Resourses/menubar2.png");
        Image png_Menubar3=new Image("file:resourses/GameStarting_Resourses/menubar3.png");
        Image png_Menubar4=new Image("file:resourses/GameStarting_Resourses/menubar4.png");
        ImageView IV_menubar=new ImageView(png_Menubar1);
        pane_Menubar.getChildren().add(IV_menubar);

        Button_Menu.setOnMouseClicked(Event->{
            Pane_Game.getChildren().add(pane_Menubar);
        });

        //设置菜单栏上的按钮
        pane_menu=new Pane();
        button_returnMainMenu=new Button();
        button_restartGame=new Button();
        button_continue=new Button();
        button_returnMainMenu.setPrefHeight(30);
        button_returnMainMenu.setPrefWidth(200);
        button_returnMainMenu.setLayoutX(295);
        button_returnMainMenu.setLayoutY(310);
        button_restartGame.setPrefWidth(200);
        button_restartGame.setPrefHeight(30);
        button_restartGame.setLayoutX(295);
        button_restartGame.setLayoutY(360);
        button_continue.setPrefHeight(60);
        button_continue.setPrefWidth(310);
        button_continue.setLayoutX(240);
        button_continue.setLayoutY(433);
        button_returnMainMenu.setCursor(Cursor.HAND);
        button_restartGame.setCursor(Cursor.HAND);
        button_continue.setCursor(Cursor.HAND);
        button_returnMainMenu.setOpacity(0.0);
        button_restartGame.setOpacity(0.0);
        button_continue.setOpacity(0.0);
        button_returnMainMenu.setOnMouseEntered(Event->{
            IV_menubar.setImage(png_Menubar2);
        });
        button_returnMainMenu.setOnMouseExited(Event->{
            IV_menubar.setImage(png_Menubar1);
        });
        button_restartGame.setOnMouseEntered(Event->{
            IV_menubar.setImage(png_Menubar3);
        });
        button_restartGame.setOnMouseExited(Event->{
            IV_menubar.setImage(png_Menubar1);
        });
        button_continue.setOnMouseEntered(Event->{
            IV_menubar.setImage(png_Menubar4);
        });
        button_continue.setOnMouseExited(Event->{
            IV_menubar.setImage(png_Menubar1);
        });

        pane_menu.getChildren().addAll(button_returnMainMenu,button_restartGame,button_continue);
        pane_Menubar.getChildren().add(pane_menu);


        //选择植物界面
        Pane Pane_plantChoose=new Pane();
        Pane_plantChoose.setLayoutX(10);
        Pane_plantChoose.setLayoutY(87);
        Image image_PlantChoose=new Image("file:resourses/GameStarting_Resourses/PanelBackground.png");
        ImageView ImageView_PlantChoose=new ImageView(image_PlantChoose);

        Pane_plantChoose.getChildren().addAll(ImageView_PlantChoose,Button_StartGame);

        // 创建平移动画1（从原始位置平移到目标位置）
        translateTransition1 = new TranslateTransition(Duration.seconds(2), imageView_Game);
        translateTransition1.setFromX(0);  // 起始位置的X坐标
        translateTransition1.setFromY(0);  // 起始位置的Y坐标
        translateTransition1.setToX(-520);  // 结束位置的X坐标
        translateTransition1.setToY(0);  // 结束位置的Y坐标

        // 创建平移动画2（从目标位置平移到起始位置）
        translateTransition2 = new TranslateTransition(Duration.seconds(2), imageView_Game);
        translateTransition2.setFromX(-520);  // 起始位置的X坐标
        translateTransition2.setFromY(0);  // 起始位置的Y坐标
        translateTransition2.setToX(-220);      // 结束位置的X坐标
        translateTransition2.setToY(0);      // 结束位置的Y坐标

        /*
         * 创建植物卡槽中的Hbox布局用来存放植物卡片
         *
         * */
        HBox slotHBox=new HBox();
        slotHBox.setLayoutX(87);
        slotHBox.setLayoutY(2);

        /*
         * 创建GridPane布局
         * GridPane布局放置Pane_Game上，与草坪位置相重合，布局中的每一个格子用来存放种植的植物
         * */
        GridPane plantGrid=new GridPane();
        plantGrid.setAlignment(Pos.CENTER); //设置plantgrid居中显示
//        设置plantgrid的位置
        plantGrid.setLayoutX(31);
        plantGrid.setLayoutY(82);
//        plantGrid.setGridLinesVisible(true);
//        向gridpane中添加label
        for(int i=0;i<9;i++){
            for(int j=0;j<5;j++){
                Label girdlabel=new Label();
                girdlabel.setPrefSize(80.8,97.4);
                girdlabel.setPrefSize(80.8,97.4);
                plantGrid.add(girdlabel,i,j);
            }
        }

        Pane_Game.getChildren().add(imageView_Game);
        /*
         * ---------------------------------------------------界面动画------------------------------------------------------------
         * */

        // 设置动画完成后的操作
        translateTransition1.setOnFinished(event -> {
            // 播放动画2（从目标位置平移到起始位置）
            // 动画结束,出现卡槽等
            Image image_Plant_Slot=new Image("file:resourses/GameStarting_Resourses/Plant_Slot.png");
            Image image_shove_Background=new Image("file:resourses/GameStarting_Resourses/ShovelBank.png");
            Image image_shovel=new Image("file:resourses/GameStarting_Resourses/shovel.png");
            Image image_Menu_BackGround=new Image("file:resourses/GameStarting_Resourses/Menu_Background.png");
            Image image_Menu_Background_Clicked=new Image("file:resourses/GameStarting_Resourses/Menu_Background_Clicked.png");

            ImageView imageView_plantSlot=new ImageView(image_Plant_Slot);
            ImageView imageView_shoveBank=new ImageView(image_shove_Background);
            imageView_shovel=new ImageView(image_shovel);
            ImageView imageView_Menu_BackGround=new ImageView(image_Menu_BackGround);
            imageView_plantSlot.setLayoutX(10);
            imageView_plantSlot.setLayoutY(0);
            imageView_shoveBank.setLayoutX(512);
            imageView_shoveBank.setLayoutY(0);
            imageView_shovel.setLayoutX(513);
            imageView_shovel.setLayoutY(0);
            imageView_Menu_BackGround.setLayoutX(685);
            imageView_Menu_BackGround.setLayoutY(0);

            /*
             * 选择植物的卡槽————固定植物卡片
             * */
//            固定豌豆射手卡片
            PlantsCard peaShooter_card=new PlantsCard("PeaShooter");
            peaShooter_card.setPlantsCards_lab_position(18,35);
//          固定向日葵卡片
            PlantsCard sunFlower_card=new PlantsCard("SunFlower");
            sunFlower_card.setPlantsCards_lab_position(72,35);
//          固定樱桃炸弹卡片
            PlantsCard cherry_card=new PlantsCard("Cherry");
            cherry_card.setPlantsCards_lab_position(126,35);
            Pane_plantChoose.getChildren().addAll(peaShooter_card.getPlantsCards_lab(),sunFlower_card.getPlantsCards_lab(),
                    cherry_card.getPlantsCards_lab());

            //对植物选择卡槽容器中所有的卡片添加点击事件
            // 遍历所有Label，为每个Label添加事件处理程序
            for (Node node : Pane_plantChoose.getChildren()) {
                if (node instanceof Label) {
                    Label label = (Label) node;
                    label.setOnMouseClicked(label_clickedevent -> {
                        ColorAdjust colorAdjust=new ColorAdjust();
                        colorAdjust.setBrightness(-0.5);
                        colorAdjust.setSaturation(0);

                        ColorAdjust colorAdjust_clicked=new ColorAdjust();
                        colorAdjust_clicked.setBrightness(0);
                        colorAdjust_clicked.setSaturation(0);
                        label.getGraphic().setEffect(colorAdjust);
                        if(Objects.equals(label.getId(), "PeaShooter")&&peaShooter_card.isIschoose()==false){
                            PlantsCard peaShooter_card_inslot=new PlantsCard("PeaShooter");
                            slotHBox.getChildren().add(peaShooter_card_inslot.getPlantsCards_lab());
                            peaShooter_card.setIschoose(true);
                            //设置上方卡槽中的卡片的点击事件
                            peaShooter_card_inslot.getPlantsCards_lab().setOnMouseClicked(peaShooter_card_inslot_e->{
                                peaShooter_card.getPlantsCards_lab().getGraphic().setEffect(colorAdjust_clicked);
                                slotHBox.getChildren().remove(peaShooter_card_inslot.getPlantsCards_lab());
                                peaShooter_card.setIschoose(false);
                            });
                        }
                        else if(Objects.equals(label.getId(), "SunFlower")&&sunFlower_card.isIschoose()==false){
                            PlantsCard sunFlower_card_inslot=new PlantsCard("SunFlower");
                            slotHBox.getChildren().add(sunFlower_card_inslot.getPlantsCards_lab());
                            sunFlower_card.setIschoose(true);
                            sunFlower_card_inslot.getPlantsCards_lab().setOnMouseClicked(sunFlower_card_inslot_e->{
                                sunFlower_card.getPlantsCards_lab().getGraphic().setEffect(colorAdjust_clicked);
                                slotHBox.getChildren().remove(sunFlower_card_inslot.getPlantsCards_lab());
                                sunFlower_card.setIschoose(false);
                            });

                        }
                        else if(Objects.equals(label.getId(), "Cherry")&&cherry_card.isIschoose()==false){
                            PlantsCard cherry_card_inslot=new PlantsCard("Cherry");
                            slotHBox.getChildren().add(cherry_card_inslot.getPlantsCards_lab());
                            cherry_card.setIschoose(true);
                            cherry_card_inslot.getPlantsCards_lab().setOnMouseClicked(cherry_card_inslot_e->{
                                cherry_card.getPlantsCards_lab().getGraphic().setEffect(colorAdjust_clicked);
                                slotHBox.getChildren().remove(cherry_card_inslot.getPlantsCards_lab());
                                cherry_card.setIschoose(false);
                            });
                        }
                    });
                }
            }



            //游戏页面菜单部分的鼠标悬停，菜单按钮颜色变化
            Button_Menu.setOnMouseEntered(Event->{
                imageView_Menu_BackGround.setImage(image_Menu_Background_Clicked);
                audioClip_Button.play();
            });
            Button_Menu.setOnMouseExited(Event->{
                imageView_Menu_BackGround.setImage(image_Menu_BackGround);
            });
            if(Pane_Game.getChildren().contains(imageView_plantSlot)==false) {
                Pane_Game.getChildren().addAll(imageView_plantSlot, imageView_shoveBank, imageView_shovel, imageView_Menu_BackGround, Button_Menu, numSun, Pane_plantChoose,slotHBox);
            }
        });
        //菜单栏上的槽
//        button_returnMainMenu.setOnMouseClicked(Event->{
//
//        });
        button_restartGame.setOnMouseClicked(Event->{
            Pane_Game.getChildren().remove(pane_Menubar);
        });
        button_continue.setOnMouseClicked(Event->{
            Pane_Game.getChildren().remove(pane_Menubar);
        });


        //回到草坪显示卡槽小推车等
        //回到草坪显示卡槽小推车等 同时设置卡槽中的卡片的事件
        translateTransition2.setOnFinished(event -> {
            Pane_Game.getChildren().addAll(car1,car2,car3,car4,car5,plantGrid);
            slotHBox.getChildren().forEach(node -> {
                if (node instanceof Label) {
                    Label label = (Label) node;
                    label.setOnMouseClicked(slotHbox_clicked_event -> {
                        planttimes=0;
                        System.out.println(label.getId() + "被点击了！");
                        ImageView prePlant=new ImageView(new Image("file:resourses/Plant/"+label.getId()+".gif"));
//                        prePlant.setOpacity(0.7);
                        prePlant.setLayoutY(label.getLayoutY()+40);
                        prePlant.setLayoutX(label.getLayoutX()+75);
                        Pane_Game.getChildren().add(prePlant);
                        Pane_Game.setOnMouseMoved(prePlant_move_event->{
                            prePlant.setLayoutX(prePlant_move_event.getX()-20);
                            prePlant.setLayoutY(prePlant_move_event.getY()-30);



                            Pane_Game.setOnMouseClicked(PrePlant_moved_click_event->{

                                //判断鼠标点击的位置，是GridPane布局中的行数和列数
                                double mouse_x=prePlant_move_event.getX();
                                double mouse_y=prePlant_move_event.getY();
                                int col=(int)((mouse_x-31)/80.8);
                                int row=(int)((mouse_y-82)/97.4);
                                //判断指定的位置的节点的个数
                                long nodeCount = plantGrid.getChildren().stream()
                                        .filter(n -> GridPane.getRowIndex(n) == row && GridPane.getColumnIndex(n) == col)
                                        .count();


                                //位置中存在的节点数大于1不能种植植物
                                if (nodeCount>1||planttimes>0) {
                                    System.out.println("已存在植物或植物已被种植下去");
                                    System.out.println(planttimes);
                                } else {
                                    ++planttimes;
                                    System.out.println(planttimes);
                                    Pane_Game.getChildren().remove(prePlant);
                                    ImageView plantedPlant=new ImageView(new Image("file:resourses/Plant/"+label.getId()+".gif"));
//                                plantedPlant.setOpacity(1);
                                    System.out.println(col);
                                    System.out.println(row);
                                    plantGrid.add(plantedPlant,col,row);

                                }

                            });
//                            Pane_Game.setOnMouseClicked(null);
                        });
                        Pane_Game.setOnMouseClicked(null);

                    });
                }
            });


            /*
             * 设置铁铲的点击事件
             *
             * */
            imageView_shovel.setOnMouseClicked(shovel_clicked_event->{
                shovletimes=0;
                Pane_Game.setOnMouseMoved(shovel_move_event->{
                    imageView_shovel.setLayoutX(shovel_move_event.getX()-20);
                    imageView_shovel.setLayoutY(shovel_move_event.getY()-20);
                    Pane_Game.setOnMouseClicked(shovel_click_event->{
                        //判断鼠标点击的位置，是GridPane布局中的行数和列数
                        double mouse_x=shovel_click_event.getX();
                        double mouse_y=shovel_click_event.getY();
                        int col=(int)((mouse_x-31)/80.8);
                        int row=(int)((mouse_y-82)/97.4);
                        long nodeCount = plantGrid.getChildren().stream()
                                .filter(n -> GridPane.getRowIndex(n) == row && GridPane.getColumnIndex(n) == col)
                                .count();
                        //位置中存在的节点数大于1不能种植植物
                        if (nodeCount>1&&shovletimes==0) {
                            shovletimes++;
                            System.out.println(planttimes);
                            // 获取第二行第三列的节点
                            ObservableList<Node> nodes = plantGrid.getChildren();
                            for (Node node1 : nodes) {
                                if (GridPane.getRowIndex(node1) == row && GridPane.getColumnIndex(node1) == col) {
                                    // 如果节点是指定格子中的节点，继续处理
                                    if (node1 instanceof ImageView) {
                                        // 如果节点是Label节点，删除它
                                        plantGrid.getChildren().remove(node1);
                                        imageView_shovel.setLayoutX(513);
                                        imageView_shovel.setLayoutY(0);
                                        Pane_Game.setOnMouseMoved(null);
                                        break;
                                    }
                                }
                            }
                        }
                    });
                });
            });

        });

        Button_StartGame.setOnAction(Event->{
            Pane_Game.getChildren().remove(Pane_plantChoose);
            translateTransition2.play();
        });

        // 播放动画1（从原始位置平移到目标位置）
        scene= new Scene(Pane_Game,800,600);
    }


}

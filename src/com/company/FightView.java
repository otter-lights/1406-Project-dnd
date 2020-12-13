package com.company;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;


public class FightView extends GamePane {
    private Game model;
    private Player p1;
    private Player p2;
    private PlayerInfo p1Pane;
    private PlayerInfo p2Pane;
    private TextArea dialogBox;
    private Button p1Attack, p1Move, p1EndTurn, p2Attack, p2Move, p2EndTurn;
    private TextField p1Right, p1Up, p2Right, p2Up;
    public FightView(Game model){
        this.model = model;

        p1 = model.getPrimaryPlayer();
        p2 = model.getSecondaryPlayer();

        setPlayers();

        System.out.println(model.getPrimaryPlayer());
        System.out.println(model.getSecondaryPlayer());

        setStyle("-fx-background-color: white;");
        setPrefSize(800, 600);

        dialogBox = new TextArea("Dialog Box: \n");
        dialogBox.relocate(250, 25);
        dialogBox.setPrefSize(300, 250);
        dialogBox.setEditable(false);
        dialogBox.setStyle("-fx-control-inner-background: #" + Paint.valueOf("808080").toString().substring(2));

        getChildren().add(dialogBox);

        p1Attack = new Button("Attack");
        p1Attack.relocate(230, 300);
        p1Attack.setPrefSize(150, 30);

        p1Move = new Button("Move");
        p1Move.relocate(230,340);
        p1Move.setPrefSize(50,100);

        Label p1RightLabel = new Label("Right/Left");
        p1RightLabel.relocate(290,340);

        p1Right = new TextField("Right (+), Left (-)");
        p1Right.relocate(290,360);
        p1Right.setPrefWidth(100);

        Label p1UpLabel = new Label("Up/Down");
        p1UpLabel.relocate(290, 390);

        p1Up = new TextField("Up (+), Down (-)");
        p1Up.relocate(290,410);
        p1Up.setPrefWidth(100);

        p1EndTurn = new Button("End Turn");
        p1EndTurn.relocate(230, 450);
        p1EndTurn.setPrefSize(150, 30);

        getChildren().addAll(p1Attack, p1Move, p1EndTurn, p1RightLabel, p1UpLabel, p1Right, p1Up);

        p2Attack = new Button("Attack");
        p2Attack.relocate(420, 300);
        p2Attack.setPrefSize(150, 30);

        p2Move = new Button("Move");
        p2Move.relocate(520,340);
        p2Move.setPrefSize(50,100);

        Label p2RightLabel = new Label("Right/Left");
        p2RightLabel.relocate(455,340);

        p2Right = new TextField("Right (+), Left (-)");
        p2Right.relocate(410,360);
        p2Right.setPrefWidth(100);

        Label p2UpLabel = new Label("Up/Down");
        p2UpLabel.relocate(455, 390);

        p2Up = new TextField("Up (+), Down (-)");
        p2Up.relocate(410,410);
        p2Up.setPrefWidth(100);

        p2EndTurn = new Button("End Turn");
        p2EndTurn.relocate(420, 450);
        p2EndTurn.setPrefSize(150, 30);

        getChildren().addAll(p2Attack, p2Move, p2EndTurn, p2RightLabel, p2UpLabel, p2Right, p2Up);
    }

    public Button getP1Attack(){return p1Attack;}
    public Button getP1Move(){return p1Move;}
    public Button getP1EndTurn(){return p1EndTurn;}
    public TextField getP1Right(){return p1Right;}
    public TextField getP1Up(){return p1Up;}

    public Button getP2Attack(){return p2Attack;}
    public Button getP2Move(){return p2Move;}
    public Button getP2EndTurn(){return p2EndTurn;}
    public TextField getP2Right(){return p2Right;}
    public TextField getP2Up(){return p2Up;}

    public void update(){
        p1 = model.getPrimaryPlayer();
        p2 = model.getSecondaryPlayer();
        setPlayers();
    }
    public void setPlayers(){
        p1Pane = new PlayerInfo(p1);
        p1Pane.relocate(0,0);
        p2Pane = new PlayerInfo(p2);
        p2Pane.relocate(575,0);
        getChildren().addAll(p1Pane, p2Pane);
    }

}

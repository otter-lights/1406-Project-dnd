package com.company;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.text.TextAlignment;

public class StoreView extends Pane{
    private ListView<String> armorList, meleeList, rangedList, inventoryList;
//DONT FORGET TO ADD MONEY  TO SCREEN!!!!!!!
    public StoreView(){
        Pane storeView = new Pane();
        storeView.setStyle("-fx-background-color: white;");
        storeView.setPrefSize(800, 600);

        //create things :)
        Label armorLabel = new Label("Armor");
        armorLabel.relocate(20, 20);
        armorLabel.setPrefSize(150, 30);

        Label meleeLabel = new Label("Melee");
        meleeLabel.relocate(190, 20);
        meleeLabel.setPrefSize(150, 30);

        Label rangedLabel = new Label("Ranged");
        rangedLabel.relocate(360, 20);
        rangedLabel.setPrefSize(150, 30);

        Label inventoryLabel = new Label("Inventory");
        inventoryLabel.relocate(530, 20);
        inventoryLabel.setPrefSize(150, 30);

        Label goldPiecesLabel = new Label("Gold pieces available:");
        goldPiecesLabel.relocate(530, 395);
        goldPiecesLabel.setPrefSize(150, 30);

        armorList = new ListView<String>();
        armorList.relocate(20, 60);
        armorList.setPrefSize(150, 375);

        meleeList = new ListView<String>();
        meleeList.relocate(190, 60);
        meleeList.setPrefSize(150, 375);

        rangedList = new ListView<String>();
        rangedList.relocate(360, 60);
        rangedList.setPrefSize(150, 375);

        inventoryList = new ListView<String>();
        inventoryList.relocate(530, 60);
        inventoryList.setPrefSize(250, 325);

        TextField descriptionBox = new TextField();
        descriptionBox.relocate(20, 455);
        descriptionBox.setPrefSize(490, 125);
        descriptionBox.setEditable(false);

        TextField goldPieces = new TextField();
        goldPieces.relocate(675, 395);
        goldPieces.setPrefSize(105, 30);
        goldPieces.setEditable(false);

        storeView.getChildren().addAll(armorLabel, meleeLabel, rangedLabel, inventoryLabel, goldPiecesLabel, armorList, meleeList, rangedList, inventoryList, descriptionBox, goldPieces);

        getChildren().addAll(storeView);
    }
}

package com.company;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;

public class StoreView extends Pane{
    private ListView<String> armorList, meleeList, rangedList, inventoryList;

    public StoreView(){
        Pane storeView = new Pane();
        storeView.setStyle("-fx-background-color: white;");
        storeView.setPrefSize(800, 600);

        //create things :)
        Label armorLabel = new Label("Armor");
        armorLabel.relocate(20, 20);
        armorLabel.setPrefSize(125, 30);

        Label meleeLabel = new Label("Melee");
        meleeLabel.relocate(165, 20);
        meleeLabel.setPrefSize(125, 30);

        Label rangedLabel = new Label("Ranged");
        rangedLabel.relocate(310, 20);
        rangedLabel.setPrefSize(125, 30);

        Label inventoryLabel = new Label("Inventory");
        inventoryLabel.relocate(455, 20);
        inventoryLabel.setPrefSize(125, 30);

        armorList = new ListView<String>();
        armorList.relocate(20, 60);
        armorList.setPrefSize(125, 375);

        meleeList = new ListView<String>();
        meleeList.relocate(165, 60);
        meleeList.setPrefSize(125, 375);

        rangedList = new ListView<String>();
        rangedList.relocate(310, 60);
        rangedList.setPrefSize(125, 375);

        inventoryList = new ListView<String>();
        inventoryList.relocate(455, 60);
        inventoryList.setPrefSize(125, 375);
    }
}

package com.company;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.SelectionMode;

public class StoreView extends GamePane{
    private ListView<Item> armorList, meleeList, rangedList, inventoryList;
    private Button purchaseButton, exitButton;
    private Game model;

    public StoreView(Game model){
        this.model = model;

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

        armorList = new ListView<Item>();
        armorList.relocate(20, 60);
        armorList.setPrefSize(150, 375);
        armorList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        meleeList = new ListView<Item>();
        meleeList.relocate(190, 60);
        meleeList.setPrefSize(150, 375);
        meleeList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        rangedList = new ListView<Item>();
        rangedList.relocate(360, 60);
        rangedList.setPrefSize(150, 375);
        rangedList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        inventoryList = new ListView<Item>();
        inventoryList.relocate(530, 60);
        inventoryList.setPrefSize(250, 325);
        inventoryList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        TextField descriptionBox = new TextField();
        descriptionBox.relocate(20, 455);
        descriptionBox.setPrefSize(490, 125);
        descriptionBox.setEditable(false);

        TextField goldPieces = new TextField();
        goldPieces.relocate(675, 395);
        goldPieces.setPrefSize(105, 30);
        goldPieces.setEditable(false);

        purchaseButton = new Button("Purchase");
        purchaseButton.relocate(530,455);
        purchaseButton.setPrefSize(150,45);
        //purchaseButton.disableProperty().bind(armorList.getSelectionModel().selectedItemProperty().isNull());
        //purchaseButton.disableProperty().bind(meleeList.getSelectionModel().selectedItemProperty().isNull());
        //purchaseButton.disableProperty().bind(rangedList.getSelectionModel().selectedItemProperty().isNull());
        BooleanBinding booleanBinding = armorList.getSelectionModel().selectedItemProperty().isNull().and(
                rangedList.getSelectionModel().selectedItemProperty().isNull().and(
                        meleeList.getSelectionModel().selectedItemProperty().isNull()));
        purchaseButton.disableProperty().bind(booleanBinding);

        exitButton = new Button("Leave Store");
        exitButton.relocate(530, 535);
        exitButton.setPrefSize(150, 45);

        storeView.getChildren().addAll(armorLabel, meleeLabel, rangedLabel, inventoryLabel, goldPiecesLabel, armorList, meleeList, rangedList, inventoryList, descriptionBox, goldPieces, purchaseButton, exitButton);

        getChildren().addAll(storeView);
    }
    public Button getPurchaseButton(){return purchaseButton;}
    public Button getExitButton(){return exitButton;}
    public ListView<Item> getArmorList() {return armorList;}
    public ListView<Item> getMeleeList() {return meleeList;}
    public ListView<Item> getRangedList() {return rangedList;}
    public void purchase(Item item){ model.getGeneralStore().purchase(item, model.getPrimaryPlayer());}

    public void update(){
        armorList.setItems(FXCollections.observableArrayList(model.getGeneralStore().getArmor()));
        meleeList.setItems(FXCollections.observableArrayList(model.getGeneralStore().getMeleeWeapons()));
        rangedList.setItems(FXCollections.observableArrayList(model.getGeneralStore().getRangedWeapons()));
        inventoryList.setItems(FXCollections.observableArrayList(model.getPrimaryPlayer().getInventory()));
    }
}

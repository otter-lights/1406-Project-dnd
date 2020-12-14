package com.company;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.SelectionMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javafx.scene.control.TextArea;

public class StoreView extends Pane implements GamePane{
    private ListView<String> armorList, meleeList, rangedList, inventoryList;
    private Button purchaseButton, exitButton;
    private TextArea descriptionBox = new TextArea();
    private Game model;
    private TextField goldPieces = new TextField();


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

        armorList = new ListView<String>();
        armorList.relocate(20, 60);
        armorList.setPrefSize(150, 375);
        armorList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        meleeList = new ListView<String>();
        meleeList.relocate(190, 60);
        meleeList.setPrefSize(150, 375);
        meleeList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        rangedList = new ListView<String>();
        rangedList.relocate(360, 60);
        rangedList.setPrefSize(150, 375);
        rangedList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        inventoryList = new ListView<String>();
        inventoryList.relocate(530, 60);
        inventoryList.setPrefSize(250, 325);
        inventoryList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        descriptionBox.relocate(20, 455);
        descriptionBox.setPrefSize(490, 125);
        descriptionBox.setEditable(false);
        descriptionBox.setWrapText(true);

        goldPieces.relocate(675, 395);
        goldPieces.setPrefSize(105, 30);
        goldPieces.setEditable(false);

        purchaseButton = new Button("Purchase");
        purchaseButton.relocate(530,455);
        purchaseButton.setPrefSize(150,45);
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
    public ListView<String> getArmorList() {return armorList;}
    public ListView<String> getMeleeList() {return meleeList;}
    public ListView<String> getRangedList() {return rangedList;}
    public ListView<String> getInventoryList() { return inventoryList; }
    public Boolean purchase(Item item){
        if (model.getGeneralStore().purchase(item, model.getPrimaryPlayer())){
            return true;
        } else {
            return false;
        }
    }

    public void update(){
        armorList.getItems().clear();
        meleeList.getItems().clear();
        rangedList.getItems().clear();
        updateListView(new ArrayList<Item>(Arrays.asList(model.getGeneralStore().getArmor())), armorList);
        updateListView(new ArrayList<Item>(Arrays.asList(model.getGeneralStore().getMeleeWeapons())), meleeList);
        updateListView(new ArrayList<Item>(Arrays.asList(model.getGeneralStore().getRangedWeapons())), rangedList);
    }

    public void updateAfterPurchase(){
        setGoldPiecesBox();
        updateInventoryListView(model.getPrimaryPlayer().getInventory().get(model.getPrimaryPlayer().getInventory().size() - 1).getName(), getInventoryList());
    }

    protected void updateListView(ArrayList<Item> itemList, ListView<String> listView){
        for(Item i: itemList){
            listView.getItems().add(i.getName());
        }
        setGoldPiecesBox();
    }

    protected void updateInventoryListView(String name, ListView<String> listView){
        listView.getItems().add(name);
    }

    public void setGoldPiecesBox(){
        goldPieces.setText(String.valueOf(model.getPrimaryPlayer().getPurse()));
    }

    public Item getItem(String item){ return Store.getItemFromHashMap(item); }

    public void setDescription(String item){
        descriptionBox.setText(Store.getItemFromHashMap(item).toString());
    }


}

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

public class StoreView extends GamePane{
    private ListView<String> armorList, meleeList, rangedList, inventoryList;
    private Button purchaseButton, exitButton;
    private TextArea descriptionBox = new TextArea();
    private Game model;
    private HashMap<String, Item> items = new HashMap<String, Item>(){{
        put("Cloth Armor", new Armor("Cloth Armor", 1, 2.0, 11, 1, "Light", 20));
        put("Padded Armor", new Armor("Padded Armor", 5, 8.0, 11, 1, "Light", 50));
        put("Assassin's Garb", new Armor("Assassin's Garb", 120, 6.0, 12, 1,"Light", -1));
        put("Leather Armor", new Armor("Leather Armor", 10, 10.0, 11, 1, "Light", -1));
        put("Light Wooden Armor", new Armor("Light Wooden Armor", 50, 13.0, 12, 1, "Light", -1));
        put("Battle Robe", new Armor("Battle Robe", 100, 10.0, 11, 1, "Light", -1));
        put("Hide", new Armor("Hide", 10, 12.0, 12, 1, "Medium", -1));
        put("Wood Armor", new Armor("Wood Armor", 30, 20.0, 13, 1, "Medium", -1));
        put("Scale Mail", new Armor("Scale Mail", 50, 45.0, 14, 1, "Medium", -1));
        put("Breastplate", new Armor("Breastplate", 400, 20.0, 14, 1, "Medium", -1));
        put("Half plate", new Armor("Half plate", 750, 20.0, 15, 1, "Medium", -1));
        put("Ring Mail", new Armor("Ring Mail", 30, 40.0, 14, 0, "Heavy", -1));
        put("Chain Mail", new Armor("Chain Mail", 75, 55.0, 15, 0, "Heavy", -1));
        put("Splint", new Armor("Splint", 200, 60.0, 17, 0, "Heavy", -1));
        put("Tinkerer's Armor", new Armor("Tinkerer's Armor", 35, 20.0, 13, 0, "Heavy", -1));
        put("Stone", new Armor("Stone", 25, 90.0, 16, 0, "Heavy", -1));
        put("Samurai Armor", new Armor("Samurai Armor", 1350, 75.0, 17, 0, "Heavy", -1));
        put("Wyvern Bone Armor", new Armor("Wyvern Bone Armor", 600, 40.0, 17, 0, "Heavy", -1));
        put("Acrobat's Staff", new Melee("Acrobat's Staff", 3, 2.0, 4,"bludgeoning", false));
        put("Bladed Knuckle Duster", new Melee("Bladed Knuckle Duster", 2, 1.0, 4, "slashing", false));
        put("Brandistoc", new Melee("Brandistock", 10, 4.0, 8, "piercing", true));
        put("Broad Claw", new Melee("Broad Claw", 25, 3.0, 4, "slashing", false));
        put("Horn Knife", new Melee("Horn Knife", 10, 2.0, 4, "piercing", false));
        put("Motherwrench", new Melee("Motherwrench", 6, 10.0, 6, "bludgeoning", false));
        put("Three-Section Staff", new Melee("Three-Section Staff", 2, 5.0, 4, "bludgeoning", true));
        put("Umbrella", new Melee("Umbrella", 5, 2.5, 6, "bludgeoning", false));
        put("Wakizashi", new Melee("Wakizashi", 5, 1.0, 6, "slashing", false));
        put("Spiked Staff", new Melee("Spiked Staff", 2, 8, 8, "piercing", true));
        put("Mattock", new Melee("Mattock", 7, 3.0, 6, "slashing", false));
        put("Crab Claw", new Melee("Crab Claw", 10, 8.0, 4, "slashing", false));
        put("Bonesaw", new Melee("Bonesaw", 15, 8, 8, "slashing", false));
        put("Broken Greatsword", new Melee("Broken Greatsword", 1, 10.0, 8, "slashing", true));
        put("Anchor", new Melee("Anchor", 90, 60.0, 10, "bludgeoning", true));
        put("Arming Swor", new Melee("Arming Sword", 20, 3.0, 6, "piercing", false));
        put("Ball and Chain", new Melee("Ball and Chain", 55, 12.0, 8, "bludgeoning", false));
        put("Battle Fan", new Melee("Battle Fan", 20, 2.0, 6, "slashing", false));
        put("Battle Wire", new Melee("Battle Wire", 10, 1.0, 3, "slashing", false));
        put("Bladed-Staff", new Melee("Bladed-Staff", 30, 2.0, 8, "slashing", false));
        put("Boar Spear", new Melee("Boar Spear", 10, 5.0, 8, "piercing", true));
        put("Boom Hammer", new Melee("Boom Hammer", 50, 10.0, 8, "bludgeoning", false));
        put("Dagger Whip", new Melee("Dagger Whip", 2, 2.0, 2, "slashing", false));
        put("Double Axe", new Melee("Double Axe", 30, 10.0, 6, "slashing", true));
        put("Double Scythe", new Melee("Double Scythe", 15, 3.0, 10, "slashing", true));
        put("Elvish Warsword", new Melee("Elvish Warsword", 100, 5.0, 10, "slashing", false));
        put("Great-Cleaver", new Melee("Great-Cleaver", 23, 11.0, 10, "slashing", true));
        put("Axe Crossbow", new Ranged("Axe Crossbow", 100, 28.0, 10, "piercing", true, 60));
        put("Bladed Long Bow", new Ranged("Bladed Long Bow", 150, 5.5, 6, "piercing", true, 100));
        put("Bolas", new Ranged("Bolas", 1, 2.0, 4, "bludgeoning", false, 20));
        put("Bowblade", new Ranged("Bowblade", 250, 10.0, 10, "piercing", true, 100));
        put("Chakri", new Ranged("Chakri", 5, 0.5, 4, "slashing", false, 20));
        put("Crossbow", new Ranged("Crossbow", 300, 2.0, 6, "piercing", false, 30));
        put("Greatbow", new Ranged("Greatbow", 65, 5.0, 10, "piercing", true, 200));
        put("War Sling", new Ranged("War Sling", 5, 0.5, 8, "bludgeoning", false, 60));
        put("Spear-thrower", new Ranged("Spear-thrower", 5, 1.0, 8, "piercing", true, 50));
        put("Blowgun", new Ranged("Blowgun", 1, 1.0, 1, "piercing", false, 25));
        put("Boomerang", new Ranged("Boomerang", 1, 1.0, 4, "bludgeoning", false, 30));
        put("Wrist Bow", new Ranged("Wrist Bow", 100, 3.0, 4, "piercing", false, 20));
        put("Corded Harpoon Launcher", new Ranged("Corded Harpoon Launcher", 15, 6.0, 8, "piercing", true, 45));
    }};

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
    public ListView<String> getArmorList() {return armorList;}
    public ListView<String> getMeleeList() {return meleeList;}
    public ListView<String> getRangedList() {return rangedList;}
    public void purchase(Item item){ model.getGeneralStore().purchase(item, model.getPrimaryPlayer());}

    public void update(){
        updateListView(new ArrayList<Item>(Arrays.asList(model.getGeneralStore().getArmor())), armorList);
        updateListView(new ArrayList<Item>(Arrays.asList(model.getGeneralStore().getMeleeWeapons())), meleeList);
        updateListView(new ArrayList<Item>(Arrays.asList(model.getGeneralStore().getRangedWeapons())), rangedList);
        updateListView(model.getPrimaryPlayer().getInventory(), inventoryList);
    }

    private void updateListView(ArrayList<Item> itemList, ListView<String> listView){
        for(Item i: itemList){
            listView.getItems().add(i.getName());
        }
    }

    public Item getItem(String itemName){ return items.get(itemName); }

    public void setDescription(String item){
        descriptionBox.setText(items.get(item).toString());
    }
}

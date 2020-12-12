package com.company;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.TilePane;

public class CharacterCreatorView extends Pane {
    private String[] races = new String[] {"Dragonborn", "Dwarf", "Gnome", "Elf", "Half Elf", "Half Orc", "Halfling", "Human", "Tiefling"};
    private String[] classes = new String[] {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Rouge", "Sorcerer", "Wizard"};

    public CharacterCreatorView() {
        Pane storeView = new Pane();
        storeView.setStyle("-fx-background-color: white;");
        storeView.setPrefSize(800, 600);

        /*things to add
            race
            class
            lvl
            name
            that's it :)

            make race & class drop down menus!!
         */

        Label raceLabel = new Label("Race");
        raceLabel.relocate(100, 65);
        raceLabel.setPrefSize(150, 30);

        ComboBox raceSelection = new ComboBox(FXCollections.observableArrayList(races));
        raceSelection.setPrefSize(150, 45);
        raceSelection.relocate(100,100);

        Label classLabel = new Label("Class");
        classLabel.relocate(100, 165);
        classLabel.setPrefSize(150, 30);

        ComboBox classSelection = new ComboBox(FXCollections.observableArrayList(classes));
        classSelection.setPrefSize(150, 45);
        classSelection.relocate(100,200);

        TextField raceDescriptionBox = new TextField();
        raceDescriptionBox.relocate(300, 100);
        raceDescriptionBox.setPrefSize(400, 45);
        raceDescriptionBox.setEditable(false);

        TextField classDescriptionBox = new TextField();
        classDescriptionBox.relocate(300, 200);
        classDescriptionBox.setPrefSize(400, 45);
        classDescriptionBox.setEditable(false);


        //add ze children
        storeView.getChildren().addAll(raceSelection, classSelection, raceDescriptionBox, classDescriptionBox, raceLabel, classLabel);

        getChildren().addAll(storeView);
    }
}

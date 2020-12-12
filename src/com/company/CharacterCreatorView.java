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

        ComboBox raceSelection = new ComboBox(FXCollections.observableArrayList(races));
        raceSelection.setPrefSize(150, 45);
        raceSelection.relocate(100,100);

        ComboBox classSelection = new ComboBox(FXCollections.observableArrayList(classes));
        classSelection.setPrefSize(150, 45);
        classSelection.relocate(100,200);


        //add ze children
        storeView.getChildren().addAll(raceSelection, classSelection);

        getChildren().addAll(storeView);
    }
}

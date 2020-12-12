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
import java.util.HashMap;

public class CharacterCreatorView extends Pane {
    private String[] races = new String[] {"Dragonborn", "Dwarf", "Gnome", "Elf", "Half Elf", "Half Orc", "Halfling", "Human", "Tiefling"};
    private String[] classes = new String[] {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Rogue", "Sorcerer", "Wizard"};
    HashMap<String, String> descriptons = new HashMap<String,String>() {{
        put("Dragonborn", "Dragonborn look very much like dragons standing erect in humanoid form, though they lack wings or a tail.");
        put("Dwarf", "Bold and hardy, dwarves are known as skilled warriors, minors, and workers of stone and metal.");
        put("Gnome", "A gnome's energy and enthusiasm for living shines through every inch of their tiny body.");
        put("Elf", "Elves are a magical people of otherworldly grace, living in the world but not entirely part of it.");
        put("Half-Elf", "Half-elves combine what some say are the best qualities of their elf and human parents.");
        put("Half-Orc", "Half-orcs' grayist pigmentation, sloping foreheads, jutting jaws, prominent teeth, and towering builds make their orcish heritage plain for all to see.");
        put("Halfling", "The diminutive halflings survive in a world full of larger creatures by avoiding notice or, barring that, avoiding offense.");
        put("Human", "Humans are the most adaptable and ambitious people among the common races. Whatever drives them, humans are the innovators, the achievers, and the pioneers of the worlds.");
        put("Tielfing", "To be greeted with stares and whispers, to suffer violence and insult on the street, to see mistrust and fear in every eye: this is the lot of the tiefling.");
        put("Barbarian", "A fierce warrior of primitive background who can enter a battle rage.");
        put("Bard", "An inspiring magician whose power echoes the music of creation.");
        put("Cleric", "A priestly champion who wields divine magic in service of a higher power.");
        put("Druid", "A priest of the Old Faith, wielding the powers of nature and adopting animal forms.");
        put("Fighter", "A master of martial combat, skilled with a variety of weapons and armor.");
        put("Monk", "A master of martial arts, harnessing the power of the body in pursuit of physical and spiritual perfection.");
        put("Rogue", "A scoundrel who uses stealth and trickery to overcome obstacles and enemies.");
        put("Sorcerer", "A spell-caster who draws on inherent magic from a gift or bloodline.");
        put("Wizard", "A scholarly magic-user capable of manipulating the structures of reality.");
    }};

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

package com.company;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ListView;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.TilePane;
import java.util.Random;

import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;

public class CharacterCreatorView extends GamePane {
    private String[] races = new String[] {"Dragonborn", "Dwarf", "Gnome", "Elf", "HalfElf", "HalfOrc", "Halfling", "Human", "Tiefling"};
    private String[] classes = new String[] {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Rogue", "Sorcerer", "Wizard"};
    private Integer[] level = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    HashMap<String, String> descriptions = new HashMap<String,String>() {{
        put("Dragonborn", "Dragonborn look very much like dragons standing erect in humanoid form, though they lack wings or a tail.");
        put("Dwarf", "Bold and hardy, dwarves are known as skilled warriors, minors, and workers of stone and metal.");
        put("Gnome", "A gnome's energy and enthusiasm for living shines through every inch of their tiny body.");
        put("Elf", "Elves are a magical people of otherworldly grace, living in the world but not entirely part of it.");
        put("HalfElf", "Half-elves combine what some say are the best qualities of their elf and human parents.");
        put("HalfOrc", "Half-orcs' grayish pigmentation, sloping foreheads, jutting jaws, prominent teeth, and towering builds make their orcish heritage plain for all to see.");
        put("Halfling", "The diminutive halflings survive in a world full of larger creatures by avoiding notice or, barring that, avoiding offense.");
        put("Human", "Humans are the most adaptable and ambitious people among the common races. Whatever drives them, humans are the innovators, the achievers, and the pioneers of the worlds.");
        put("Tiefling", "To be greeted with stares and whispers, to suffer violence and insult on the street, to see mistrust and fear in every eye: this is the lot of the tiefling.");
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

    private ComboBox raceSelection = new ComboBox(FXCollections.observableArrayList(races));
    private ComboBox classSelection = new ComboBox(FXCollections.observableArrayList(classes));
    private Label nameLabel = new Label("Name");
    private ComboBox levelSelection = new ComboBox(FXCollections.observableArrayList(level));
    private TextField nameBox = new TextField();
    private String[] names = new String[135];
    private TextArea raceDescriptionBox = new TextArea();
    private TextArea classDescriptionBox = new TextArea();
    Button createButton, nameButton;

    public CharacterCreatorView() {
        Pane storeView = new Pane();
        storeView.setStyle("-fx-background-color: white;");
        storeView.setPrefSize(800, 600);

        Label raceLabel = new Label("Race");
        raceLabel.relocate(100, 65);
        raceLabel.setPrefSize(150, 30);


        raceSelection.setPrefSize(150, 45);
        raceSelection.relocate(100,100);

        Label classLabel = new Label("Class");
        classLabel.relocate(100, 165);
        classLabel.setPrefSize(150, 30);

        classSelection.setPrefSize(150, 45);
        classSelection.relocate(100,200);

        raceDescriptionBox.relocate(300, 95);
        raceDescriptionBox.setPrefSize(400, 55);
        raceDescriptionBox.setEditable(false);
        raceDescriptionBox.setWrapText(true);

        classDescriptionBox.relocate(300, 195);
        classDescriptionBox.setPrefSize(400, 55);
        classDescriptionBox.setEditable(false);
        classDescriptionBox.setWrapText(true);

        nameLabel.relocate(300, 265);
        nameLabel.setPrefSize(150, 30);

        nameBox.relocate(300, 300);
        nameBox.setPrefSize(300, 45);

        Label levelLabel = new Label("Starting Level");
        levelLabel.relocate(325, 365);
        levelLabel.setPrefSize(150, 30);

        levelSelection.setPrefSize(150, 45);
        levelSelection.relocate(325,400);

        createButton = new Button("Create Character");
        createButton.relocate(325, 500);
        createButton.setPrefSize(150, 45);

        nameButton = new Button("Random");
        nameButton.relocate(200, 300);
        nameButton.setPrefSize(75, 45);

        //add ze children
        storeView.getChildren().addAll(raceSelection, classSelection, raceDescriptionBox, classDescriptionBox, raceLabel, classLabel, nameBox, nameLabel, levelSelection, levelLabel, createButton, nameButton);

        getChildren().addAll(storeView);


    }

    public Player createPlayer(){
        if(classSelection.getValue().equals("Barbarian")){
            return new Barbarian((String)raceSelection.getValue(), nameBox.getText(), (int)levelSelection.getValue());
        }
        else if(classSelection.getValue().equals("Bard")){
            return new Bard((String)raceSelection.getValue(), nameBox.getText(), (int)levelSelection.getValue());
        }
        else if(classSelection.getValue().equals("Cleric")){
            return new Cleric((String)raceSelection.getValue(), nameBox.getText(), (int)levelSelection.getValue());
        }
        else if(classSelection.getValue().equals("Druid")){
            return new Druid((String)raceSelection.getValue(), nameBox.getText(), (int)levelSelection.getValue());
        }
        else if(classSelection.getValue().equals("Fighter")){
            return new Fighter((String)raceSelection.getValue(), nameBox.getText(), (int)levelSelection.getValue());
        }
        else if(classSelection.getValue().equals("Monk")){
            return new Monk((String)raceSelection.getValue(), nameBox.getText(), (int)levelSelection.getValue());
        }
        else if(classSelection.getValue().equals("Rogue")){
            return new Rogue((String)raceSelection.getValue(), nameBox.getText(), (int)levelSelection.getValue());
        }
        else if(classSelection.getValue().equals("Sorcerer")){
            return new Sorcerer((String)raceSelection.getValue(), nameBox.getText(), (int)levelSelection.getValue());
        }
        else if(classSelection.getValue().equals("Wizard")){
            return new Wizard((String)raceSelection.getValue(), nameBox.getText(), (int)levelSelection.getValue());
        }
        return null;
    }

    private String getNames(String fileName){
        int pos = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String currentLine;
            while ((currentLine = br.readLine()) != null){
                names[pos] = currentLine;
                pos++;
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return chooseName();
    }

    private String chooseName(){
        Random random = new Random();
        return names[random.nextInt(135)];
    }

    public void getRandomName(){
        if (names[0] == null){
            String file = "/Users/awildecat/documents/GitHub/1406-Project-dnd/src/com/company/names.txt";
            nameBox.setText(getNames(file));
        } else{
            nameBox.setText(chooseName());
        }
    }

    public void setRaceDescription(String race){
        raceDescriptionBox.setText(descriptions.get(race));
    }

    public void setClassDescription(String dndClass){
        classDescriptionBox.setText(descriptions.get(dndClass));
    }

    public Button getCreateButton(){return createButton;}
    public Button getNameButton(){return nameButton;}
    public void update(){

    }
    public ComboBox getRaceSelection(){ return raceSelection; }
    public ComboBox getClassSelection(){ return classSelection; }

    public String[] getRaces(){return races;}
}

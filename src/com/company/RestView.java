package com.company;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class RestView extends GamePane {
    private ListView<Player> playerOptions;
    private Button newCharacter;
    private Button visitStore;
    private Button endProgram;
    Game model;

    public RestView(Game model, Player p){
        this.model = model;
        setStyle("-fx-background-color: white;");
        setPrefSize(800, 600);

        visitStore = new Button("Visit Store");
        visitStore.relocate(10,10);
        visitStore.setPrefSize(250,30);

        newCharacter = new Button("Make New Character");
        newCharacter.relocate(275,10);
        newCharacter.setPrefSize(250,30);

        endProgram = new Button("End Program");
        endProgram.relocate(540,10);
        endProgram.setPrefSize(250,30);

        Label currentCharacter = new Label("Current Character");
        currentCharacter.relocate(10,75);

        Label name = new Label(p.getName());
        name.relocate(10,120);
        name.setPrefSize(200,30);

        Label playerClass = new Label("Class: " + p.getClassName());
        playerClass.relocate(20,150);
        playerClass.setPrefSize(100, 20);

        Label playerRace = new Label("Race: " + p.getPlayerRace().getRaceName());
        playerRace.relocate(20,170);
        playerRace.setPrefSize(100, 20);

        Label playerLevel = new Label("Level: " + p.getLevel());
        playerLevel.relocate(20,190);
        playerLevel.setPrefSize(100, 20);

        Label health = new Label("Hit Points: " + p.getCurrentHP() + "/" + p.getMaxHP());
        health.relocate(20,210);
        health.setPrefSize(100, 20);

        Label armorClass = new Label("AC: " + p.getAC());
        armorClass.relocate(20,230);
        armorClass.setPrefSize(100, 20);

        getChildren().addAll(name, playerClass, playerRace, playerLevel, health, armorClass);

        Label strScore = new Label("Str: " + p.getAbilityScores()[0] + "(" + p.getAbilityMods()[0] + ")");
        strScore.relocate(140,150);
        strScore.setPrefSize(70,16);
        Label dexScore = new Label("Dex: " + p.getAbilityScores()[1] + "(" + p.getAbilityMods()[1] + ")");
        dexScore.relocate(140,166);
        dexScore.setPrefSize(70,16);
        Label conScore = new Label("Con: " + p.getAbilityScores()[2] + "(" + p.getAbilityMods()[2] + ")");
        conScore.relocate(140,182);
        conScore.setPrefSize(70,16);
        Label intScore = new Label("Int: " + p.getAbilityScores()[3] + "(" + p.getAbilityMods()[3] + ")");
        intScore.relocate(140,198);
        intScore.setPrefSize(70,16);
        Label wisScore = new Label("Wis: " + p.getAbilityScores()[4] + "(" + p.getAbilityMods()[4] + ")");
        wisScore.relocate(140,214);
        wisScore.setPrefSize(70,16);
        Label chaScore = new Label("Cha: " + p.getAbilityScores()[5] + "(" + p.getAbilityMods()[5] + ")");
        chaScore.relocate(140,230);
        chaScore.setPrefSize(70,16);


        getChildren().addAll(strScore, dexScore, conScore, intScore, wisScore, chaScore);


        final ToggleGroup opponentOptions = new ToggleGroup();
        RadioButton o1 = new RadioButton("Randomly Generate Opponent");
        o1.setToggleGroup(opponentOptions);
        o1.relocate(540,200);

        RadioButton o2 = new RadioButton("Opponent with Class Specified");
        o2.setToggleGroup(opponentOptions);
        o2.relocate(540, 250);


        ObservableList<String> options = FXCollections.observableArrayList("Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Rouge", "Sorcerer", "Wizard");
        ComboBox classOptions = new ComboBox(options);
        classOptions.relocate(560, 280);
        classOptions.setPrefSize(200,20);
        getChildren().add(classOptions);

        RadioButton o3 = new RadioButton("Opponent from Character Options");
        o3.setToggleGroup(opponentOptions);
        o3.relocate(540,320);

        ListView<Player> playerOptions2 = playerOptions;
        playerOptions2 = new ListView<Player>();
        playerOptions2.relocate(560, 340);
        playerOptions2.setPrefSize(200,180);
        getChildren().add(playerOptions2);

        Button startRound = new Button("Start Fight");
        startRound.relocate(540, 540);
        startRound.setPrefSize(250, 50);

        //getChildren().addAll(visitStore, newCharacter, endProgram, currentCharacter, o1, o2, classOptions, o3, playerOptions, startRound);
        getChildren().addAll(visitStore, newCharacter, endProgram, currentCharacter, o1, o2, o3, startRound);
    }
    public Button getNewCharacter(){return newCharacter;}
    public Button getVisitStore(){return visitStore;}
    public Button getEndProgram(){return endProgram;}

    public void update(){
        ArrayList<Player> characters = model.getAllPlayers();
        playerOptions.setItems(FXCollections.observableArrayList(characters));
    }
}

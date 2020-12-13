package com.company;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

public class PlayerInfo extends Pane {
    private ListView<Weapon> weapons;
    private ListView<Spell> spells;

    public PlayerInfo(Player p){
        Pane fightView = new Pane();
        fightView.setStyle("-fx-background-color: white;");
        fightView.setPrefSize(225, 500);

        Label name = new Label(p.getName());
        name.relocate(10,10);
        name.setPrefSize(200,30);

        Label playerClass = new Label("Class: " + p.getClassName());
        playerClass.relocate(20,50);
        playerClass.setPrefSize(100, 20);

        Label playerRace = new Label("Race: " + p.getPlayerRace().getRaceName());
        playerRace.relocate(20,70);
        playerRace.setPrefSize(100, 20);

        Label playerLevel = new Label("Level: " + p.getLevel());
        playerLevel.relocate(20,90);
        playerLevel.setPrefSize(100, 20);

        Label health = new Label("Hit Points: " + p.getCurrentHP() + "/" + p.getMaxHP());
        health.relocate(20,110);
        health.setPrefSize(100, 20);

        Label armorClass = new Label("AC: " + p.getAC());
        armorClass.relocate(20,130);
        armorClass.setPrefSize(100, 20);

        fightView.getChildren().addAll(name, playerClass, playerRace, playerLevel, health, armorClass);

        Label strScore = new Label("Str: " + p.getAbilityScores()[0] + "(" + p.getAbilityMods()[0] + ")");
        strScore.relocate(140,50);
        strScore.setPrefSize(70,16);
        Label dexScore = new Label("Dex: " + p.getAbilityScores()[1] + "(" + p.getAbilityMods()[1] + ")");
        dexScore.relocate(140,66);
        dexScore.setPrefSize(70,16);
        Label conScore = new Label("Con: " + p.getAbilityScores()[2] + "(" + p.getAbilityMods()[2] + ")");
        conScore.relocate(140,82);
        conScore.setPrefSize(70,16);
        Label intScore = new Label("Int: " + p.getAbilityScores()[3] + "(" + p.getAbilityMods()[3] + ")");
        intScore.relocate(140,98);
        intScore.setPrefSize(70,16);
        Label wisScore = new Label("Wis: " + p.getAbilityScores()[4] + "(" + p.getAbilityMods()[4] + ")");
        wisScore.relocate(140,114);
        wisScore.setPrefSize(70,16);
        Label chaScore = new Label("Cha: " + p.getAbilityScores()[5] + "(" + p.getAbilityMods()[5] + ")");
        chaScore.relocate(140,130);
        chaScore.setPrefSize(70,16);


        fightView.getChildren().addAll(strScore, dexScore, conScore, intScore, wisScore, chaScore);

        Label weaponLabel = new Label("Weapons");
        weaponLabel.relocate(10,160);
        weaponLabel.setPrefSize(200,20);

        weapons = new ListView<Weapon>();
        weapons.relocate(10, 180);
        weapons.setPrefSize(200, 150);

        Label spellLabel = new Label("Spells");
        spellLabel.relocate(10,340);
        spellLabel.setPrefSize(200,20);

        spells = new ListView<Spell>();
        spells.relocate(10, 360);
        spells.setPrefSize(200, 130);

        if(p instanceof MagicUser){
            fightView.getChildren().addAll(weapons, weaponLabel, spells, spellLabel);
        }
        else{
            fightView.getChildren().addAll(weapons, weaponLabel);
        }


        getChildren().add(fightView);
    }
}

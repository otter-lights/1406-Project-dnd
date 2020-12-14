package com.company;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

public class PlayerInfo extends Pane{
    private ListView<Weapon> weapons;
    private ListView<Spell> spells;
    private Player p;
    private Game model;
    private Label name, playerClass, playerRace, playerLevel, health, armorClass, strScore, dexScore, conScore, intScore, wisScore, chaScore, spellLabel;
    private Button barbarianPerk, fighterPerk;

    public PlayerInfo(Game model, Player p){
        this.p = p;
        this.model = model;

        setStyle("-fx-background-color: white;");
        setPrefSize(225, 500);

        name = new Label();
        name.relocate(10,10);
        name.setPrefSize(200,30);

        playerClass = new Label();
        playerClass.relocate(20,50);
        playerClass.setPrefSize(100, 20);

        playerRace = new Label();
        playerRace.relocate(20,70);
        playerRace.setPrefSize(100, 20);

        playerLevel = new Label();
        playerLevel.relocate(20,90);
        playerLevel.setPrefSize(100, 20);

        health = new Label();
        health.relocate(20,110);
        health.setPrefSize(100, 20);

        armorClass = new Label();
        armorClass.relocate(20,130);
        armorClass.setPrefSize(100, 20);

        getChildren().addAll(name, playerClass, playerRace, playerLevel, health, armorClass);

        strScore = new Label();
        strScore.relocate(140,50);
        strScore.setPrefSize(70,16);
        dexScore = new Label();
        dexScore.relocate(140,66);
        dexScore.setPrefSize(70,16);
        conScore = new Label();
        conScore.relocate(140,82);
        conScore.setPrefSize(70,16);
        intScore = new Label();
        intScore.relocate(140,98);
        intScore.setPrefSize(70,16);
        wisScore = new Label();
        wisScore.relocate(140,114);
        wisScore.setPrefSize(70,16);
        chaScore = new Label();
        chaScore.relocate(140,130);
        chaScore.setPrefSize(70,16);

        getChildren().addAll(strScore, dexScore, conScore, intScore, wisScore, chaScore);

        Label weaponLabel = new Label("Weapons");
        weaponLabel.relocate(10,160);
        weaponLabel.setPrefSize(200,20);

        weapons = new ListView<Weapon>();
        weapons.relocate(10, 180);
        weapons.setPrefSize(200, 150);

        spellLabel = new Label("Spells");
        spellLabel.relocate(10,340);
        spellLabel.setPrefSize(200,20);
        spellLabel.setVisible(false);

        spells = new ListView<Spell>();
        spells.relocate(10, 360);
        spells.setPrefSize(200, 130);
        spellLabel.setVisible(false);

        fighterPerk = new Button("Second Wind");
        fighterPerk.relocate(10,360);
        fighterPerk.setPrefSize(200,30);

        barbarianPerk = new Button("Use Rage");
        barbarianPerk.relocate(10,360);
        barbarianPerk.setPrefSize(200,30);
        getChildren().addAll(spells, spellLabel, weapons, weaponLabel, barbarianPerk, fighterPerk);
    }
    public ListView<Weapon> getWeapons(){return weapons;}
    public ListView<Spell> getSpells(){return spells;}
    public Button getBarbarianPerk(){return barbarianPerk;}
    public Button getFighterPerk(){return fighterPerk;}


    public void update(Player updated){
        p = updated;
        if(p instanceof MagicUser){
            System.out.println("test");
            spells.setVisible(true);
            spellLabel.setVisible(true);
            spells.setItems(FXCollections.observableArrayList(((MagicUser) p).getUseableSpellsList()));
        }
        else{
            spells.setVisible(false);
            spellLabel.setVisible(false);
        }

        if(p instanceof Barbarian){
            if(((Barbarian) p).canRage()){
                barbarianPerk.setDisable(false);
            }
            else{
                barbarianPerk.setDisable(true);
            }
            barbarianPerk.setVisible(true);
        }
        else{
            barbarianPerk.setVisible(false);
        }
        if(p instanceof Fighter){
            if(((Fighter) p).getSecondWind()){
                fighterPerk.setDisable(false);
            }
            else{
                fighterPerk.setDisable(true);
            }
            fighterPerk.setVisible(true);
        }
        else{
            fighterPerk.setVisible(false);
        }
        weapons.setItems(FXCollections.observableArrayList(p.getWeapons()));

        name.setText(p.getName());
        playerClass.setText("Class: " + p.getClassName());
        playerRace.setText("Race: " + p.getPlayerRace().getRaceName());
        playerLevel.setText("Level: " + p.getLevel());
        health.setText("HP: " + p.getCurrentHP() + "/" + p.getMaxHP());
        armorClass.setText("AC: " + p.getAC());
        strScore.setText("Str: " + p.getAbilityScores()[0] + "(" + p.getAbilityMods()[0] + ")");
        dexScore.setText("Dex: " + p.getAbilityScores()[1] + "(" + p.getAbilityMods()[1] + ")");
        conScore.setText("Con: " + p.getAbilityScores()[2] + "(" + p.getAbilityMods()[2] + ")");
        intScore.setText("Int: " + p.getAbilityScores()[3] + "(" + p.getAbilityMods()[3] + ")");
        wisScore.setText("Wis: " + p.getAbilityScores()[4] + "(" + p.getAbilityMods()[4] + ")");
        chaScore.setText("Cha: " + p.getAbilityScores()[5] + "(" + p.getAbilityMods()[5] + ")");
    }
}

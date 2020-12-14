package com.company;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.ListView;
import javafx.beans.value.ObservableValue;

import javax.swing.*;
import java.util.Random;

public class GameController extends Application {
    private Game model;
    public void start(Stage primaryStage){
        Game model = new Game();
        this.model = model;
        Pane currentView = new Pane();

        StoreView store = new StoreView(model);
        FightView fight = new FightView(model);
        RestView rest = new RestView(model);
        CharacterCreatorView creator = new CharacterCreatorView();

        currentView.getChildren().add(creator);

        rest.getVisitStore().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model.makeStore();
                currentView.getChildren().clear();
                currentView.getChildren().add(store);
                store.update();
            }
        });

        rest.getEndProgram().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                String filename = JOptionPane.showInputDialog("Enter Filename: ");
                model.saveCharacters(filename);
                System.exit(0);
            }
        });

        rest.getNewCharacter().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                currentView.getChildren().clear();
                currentView.getChildren().add(creator);
                creator.update();
            }
        });

        rest.getChangePrimary().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model.setPrimaryPlayer(rest.getPlayerOptions().getSelectionModel().getSelectedItem());
                rest.update();
            }
        });


        rest.getPrepSpell().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                Spell s = rest.getAllSpells().getSelectionModel().getSelectedItem();
                ((MagicUser) model.getPrimaryPlayer()).prepSpell(s);
                rest.update();
            }
        });

        rest.getPlayerOptions().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){
                rest.update();
            }
        });

        rest.getAllSpells().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){
                rest.update();
            }
        });

        rest.getOpponentOptions().selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                rest.update();
            }
        });
        rest.getStartRound().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                Random rand = new Random();
                String[] classNames = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Rouge", "Sorcerer", "Wizard"};
                String[] raceNames = {"Dragonborn", "Dwarf", "Gnome", "Elf", "HalfElf", "HalfOrc", "Halfling", "Human", "Tiefling"};

                if(rest.getOption1().isSelected()){
                    characters(classNames[rand.nextInt(9)], raceNames[rand.nextInt(9)], rand.nextInt(20)+1);
                    if(model.getSecondaryPlayer() instanceof MagicUser){
                        ((MagicUser) model.getSecondaryPlayer()).randomUseableSpells();
                    }
                }
                else if(rest.getOption2().isSelected()){
                    characters(rest.getClassOptions().getSelectionModel().getSelectedItem().toString(), raceNames[rand.nextInt(9)], Integer.parseInt((String)rest.getLevelOptions().getSelectionModel().getSelectedItem()));
                    if(model.getSecondaryPlayer() instanceof MagicUser){
                        ((MagicUser) model.getSecondaryPlayer()).randomUseableSpells();
                    }
                }
                else if(rest.getOption3().isSelected()){
                    model.setSecondaryPlayer(rest.getOpponents().getSelectionModel().getSelectedItem());
                }
                currentView.getChildren().clear();
                currentView.getChildren().add(fight);
                fight.update();
            }
        });
        rest.getClassOptions().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                rest.update();
            }
        });
        rest.getLevelOptions().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                rest.update();
            }
        });


        rest.getOpponents().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                rest.update();
            }
        });

        creator.getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model.addPlayer(creator.createPlayer());
                currentView.getChildren().clear();
                currentView.getChildren().add(rest);
                rest.update();
            }
        });

        creator.getRaceSelection().setOnAction(e -> {
            creator.setRaceDescription((String)creator.getRaceSelection().getValue());
        });

        creator.getClassSelection().setOnAction(e -> {
            creator.setClassDescription((String)creator.getClassSelection().getValue());
        });

        creator.getNameButton().setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent){
                creator.getRandomName();
            }
        });
        fight.getP1Pane().getWeapons().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                fight.getP1Pane().getSpells().getSelectionModel().clearSelection();
                fight.update();
            }
        });

        fight.getP1Pane().getSpells().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                fight.getP1Pane().getWeapons().getSelectionModel().clearSelection();
                fight.update();
            }
        });
        fight.getP2Pane().getWeapons().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                fight.getP2Pane().getSpells().getSelectionModel().clearSelection();
                model.getPrimaryPlayer().addToInventory(new Melee("Acrobat's Staff", 3, 2.0, 4,"bludgeoning", false));
                fight.update();
            }
        });
        fight.getP2Pane().getSpells().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                fight.getP2Pane().getWeapons().getSelectionModel().clearSelection();
                fight.update();
            }
        });
        fight.getP1Pane().getBarbarianPerk().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                fight.getDialogBox().appendText(((Barbarian)model.getPrimaryPlayer()).startRage(model.getSecondaryPlayer()));
                fight.update();
            }
        });
        fight.getP2Pane().getBarbarianPerk().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                fight.getDialogBox().appendText(((Barbarian)model.getSecondaryPlayer()).startRage(model.getPrimaryPlayer()));
                fight.update();
            }
        });
        fight.getP1Pane().getFighterPerk().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                fight.getDialogBox().appendText(((Fighter)model.getPrimaryPlayer()).secondWind());
                fight.update();
            }
        });
        fight.getP2Pane().getFighterPerk().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                fight.getDialogBox().appendText(((Fighter)model.getSecondaryPlayer()).secondWind());
                fight.update();
            }
        });
        fight.getP1Attack().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                if(fight.getP1Pane().getSpells().getSelectionModel().getSelectedIndex() >= 0){
                    Spell s = fight.getP1Pane().getSpells().getSelectionModel().getSelectedItem();
                    String msg = ((MagicUser) model.getPrimaryPlayer()).castSpell(s, model.getSecondaryPlayer());
                    fight.getDialogBox().appendText(model.getPrimaryPlayer().getName() + " casts " + s.getName() + " " + msg + "\n");
                }
                if(fight.getP1Pane().getWeapons().getSelectionModel().getSelectedIndex() >= 0){
                    //attack with weapon
                    fight.getP1Pane().getWeapons().getSelectionModel().getSelectedItem();
                }
                if(model.getSecondaryPlayer().isAlive() == false){
                    model.getPrimaryPlayer().winsAgainst(model.getSecondaryPlayer());
                    model.getSecondaryPlayer().losesAgainst(model.getPrimaryPlayer());

                    model.getPrimaryPlayer().longRest();
                    model.getSecondaryPlayer().longRest();

                    fight.getDialogBox().clear();
                    fight.getDialogBox().setText("Dialog Box");

                    JOptionPane.showMessageDialog(null, model.getSecondaryPlayer().getName() + " has passed out. \n" + model.getPrimaryPlayer().getName() + " is the winner. \n");
                    currentView.getChildren().clear();
                    currentView.getChildren().add(rest);
                }
                fight.update();
            }
        });
        fight.getP2Attack().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                if(fight.getP2Pane().getSpells().getSelectionModel().getSelectedIndex() >= 0){
                    Spell s = fight.getP2Pane().getSpells().getSelectionModel().getSelectedItem();
                    String msg = ((MagicUser) model.getSecondaryPlayer()).castSpell(s, model.getPrimaryPlayer());
                    fight.getDialogBox().appendText(model.getSecondaryPlayer().getName() + " casts " + s.getName() + " " + msg + "\n");
                }
                if(fight.getP1Pane().getWeapons().getSelectionModel().getSelectedIndex() >= 0){
                    //attack with weapon
                    fight.getP1Pane().getWeapons().getSelectionModel().getSelectedItem();
                }
                if(model.getPrimaryPlayer().isAlive() == false){
                    model.getSecondaryPlayer().winsAgainst(model.getPrimaryPlayer());
                    model.getPrimaryPlayer().losesAgainst(model.getSecondaryPlayer());

                    model.getPrimaryPlayer().longRest();
                    model.getSecondaryPlayer().longRest();

                    fight.getDialogBox().clear();
                    fight.getDialogBox().setText("Dialog Box");

                    JOptionPane.showMessageDialog(null, model.getPrimaryPlayer().getName() + " has passed out. \n" + model.getSecondaryPlayer().getName() + " is the winner. \n");
                    currentView.getChildren().clear();
                    currentView.getChildren().add(rest);

                    //currentView.getChildren().clear();
                    //currentView.getChildren().add(rest);
                }
                fight.update();
            }
        });
        fight.getP1Move().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {

            }
        });
        fight.getP2Move().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {

            }
        });

        fight.getP1EndTurn().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model.endTurn();
                fight.getDialogBox().appendText(model.getPrimaryPlayer().getName() + " ends their turn. \n");
                fight.update();
            }
        });
        fight.getP2EndTurn().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model.endTurn();
                fight.getDialogBox().appendText(model.getSecondaryPlayer().getName() + " ends their turn. \n");
                fight.update();
            }
        });


        store.getExitButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                currentView.getChildren().clear();
                currentView.getChildren().add(rest);
                rest.update();
            }
        });

        store.getPurchaseButton().setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent){
                if (store.getArmorList().getSelectionModel().isEmpty() && store.getMeleeList().getSelectionModel().isEmpty()){
                    if (store.purchase(store.getItem(store.getRangedList().getSelectionModel().getSelectedItem()))){
                        store.updateAfterPurchase();
                    }

                } else if (store.getRangedList().getSelectionModel().isEmpty() && store.getMeleeList().getSelectionModel().isEmpty()){
                    if (store.purchase(store.getItem(store.getArmorList().getSelectionModel().getSelectedItem()))){
                        store.updateAfterPurchase();
                    }
                } else if (store.getArmorList().getSelectionModel().isEmpty() && store.getRangedList().getSelectionModel().isEmpty()){
                    if (store.purchase(store.getItem(store.getMeleeList().getSelectionModel().getSelectedItem()))) {
                        store.updateAfterPurchase();
                    }
                }

            }
        });

        store.getArmorList().setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
                store.getMeleeList().getSelectionModel().clearSelection();
                store.getRangedList().getSelectionModel().clearSelection();
            }
        });
        store.getMeleeList().setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
                store.getArmorList().getSelectionModel().clearSelection();
                store.getRangedList().getSelectionModel().clearSelection();
            }
        });
        store.getRangedList().setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
                store.getMeleeList().getSelectionModel().clearSelection();
                store.getArmorList().getSelectionModel().clearSelection();
            }
        });

        store.getArmorList().setOnMouseClicked(e -> {
            store.setDescription((String)store.getArmorList().getSelectionModel().getSelectedItem());
        });

        store.getMeleeList().setOnMouseClicked(e -> {
            store.setDescription((String)store.getMeleeList().getSelectionModel().getSelectedItem());
        });

        store.getRangedList().setOnMouseClicked(e -> {
            store.setDescription((String)store.getRangedList().getSelectionModel().getSelectedItem());
        });






        primaryStage.setTitle("Encounter Sim");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(currentView));
        primaryStage.show();

    }
    public void characters(String selection, String race, int level){
        if(selection.equals("Barbarian")){
            model.setSecondaryPlayer(new Barbarian(race, "Player 2", level));
        }
        else if(selection.equals("Bard")){
            model.setSecondaryPlayer(new Bard(race, "Player 2", level));
        }
        else if(selection.equals("Cleric")){
            model.setSecondaryPlayer(new Cleric(race, "Player 2", level));
        }
        else if(selection.equals("Druid")){
            model.setSecondaryPlayer(new Druid(race, "Player 2", level));
        }
        else if(selection.equals("Fighter")){
            model.setSecondaryPlayer(new Druid(race, "Player 2", level));
        }
        else if(selection.equals("Monk")){
            model.setSecondaryPlayer(new Monk(race, "Player 2", level));
        }
        else if(selection.equals("Rouge")){
            model.setSecondaryPlayer(new Rogue(race, "Player 2", level));
        }
        else if(selection.equals("Sorcerer")){
            model.setSecondaryPlayer(new Sorcerer(race, "Player 2", level));
        }
        else if(selection.equals("Wizard")){
            model.setSecondaryPlayer(new Wizard(race, "Player 2", level));
        }
    }

    public static void main(String[] args) { launch(args); }
}

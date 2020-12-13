package com.company;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Random;

public class GameController extends Application {
    Game model;
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
                currentView.getChildren().clear();
                currentView.getChildren().add(store);
                store.update();
            }
        });

        rest.getEndProgram().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                String filename = JOptionPane.showInputDialog("Enter Filename: ");
                model.addPlayer(new Druid("Gnome", "Gargamel"));
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
                    characters(classNames[rand.nextInt(9)], raceNames[rand.nextInt(9)]);
                }
                else if(rest.getOption2().isSelected()){
                    characters(rest.getClassOptions().getSelectionModel().getSelectedItem().toString(), raceNames[rand.nextInt(9)]);
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

        store.getExitButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                currentView.getChildren().clear();
                currentView.getChildren().add(rest);
                rest.update();
            }
        });

        primaryStage.setTitle("Encounter Sim");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(currentView));
        primaryStage.show();

    }
    public void characters(String selection, String race){
        if(selection.equals("Barbarian")){
            model.setSecondaryPlayer(new Barbarian(race, "Player 2"));
        }
        else if(selection.equals("Bard")){
            model.setSecondaryPlayer(new Bard(race, "Player 2"));
        }
        else if(selection.equals("Cleric")){
            model.setSecondaryPlayer(new Cleric(race, "Player 2"));
        }
        else if(selection.equals("Druid")){
            model.setSecondaryPlayer(new Druid(race, "Player 2"));
        }
        else if(selection.equals("Fighter")){
            model.setSecondaryPlayer(new Druid(race, "Player 2"));
        }
        else if(selection.equals("Monk")){
            model.setSecondaryPlayer(new Monk(race, "Player 2"));
        }
        else if(selection.equals("Rouge")){
            model.setSecondaryPlayer(new Rogue(race, "Player 2"));
        }
        else if(selection.equals("Sorcerer")){
            model.setSecondaryPlayer(new Sorcerer(race, "Player 2"));
        }
        else if(selection.equals("Wizard")){
            model.setSecondaryPlayer(new Wizard(race, "Player 2"));
        }
    }

    public static void main(String[] args) { launch(args); }
}

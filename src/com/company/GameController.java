package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;

public class GameController extends Application {
    public void start(Stage primaryStage){
        Game model = new Game();
        Pane currentView = new Pane();

        StoreView store = new StoreView(model);
        //FightView fight = new FightView(model.getPrimaryPlayer(), model.getSecondaryPlayer());
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
                model.addPlayer(new Druid("Gnome", "Gargamel", 1));
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
                System.out.println("test");
                Spell s = rest.getAllSpells().getSelectionModel().getSelectedItem();
                ((MagicUser) model.getPrimaryPlayer()).prepSpell(s);
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

    public static void main(String[] args) { launch(args); }
}

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

        StoreView storeView = new StoreView();
        //FightView fight = new FightView(model.getPrimaryPlayer(), model.getSecondaryPlayer());
        RestView rest = new RestView(model, model.getPrimaryPlayer());
        CharacterCreatorView creator = new CharacterCreatorView();

        currentView.getChildren().add(creator);

        rest.getVisitStore().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                currentView.getChildren().clear();
                currentView.getChildren().add(storeView);
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
                ((GamePane) currentView.getChildren().get(0)).update();
            }
        });

        creator.getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                currentView.getChildren().clear();
                currentView.getChildren().add(rest);
            }
        });

        primaryStage.setTitle("Encounter Sim");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(currentView));
        primaryStage.show();

    }

    public static void main(String[] args) { launch(args); }
}

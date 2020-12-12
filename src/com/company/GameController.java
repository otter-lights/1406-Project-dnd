package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameController extends Application {
    public void start(Stage primaryStage){
        Game model = new Game();
        Pane currentView = new Pane();

        StoreView storeView = new StoreView();
        FightView fight = new FightView(new Fighter("Dragonborn", "Player 1"), new Druid("Gnome", "Player 2"));
        RestView rest = new RestView(new Game(), new Wizard("Elf", "Player 1"));

        currentView.getChildren().add(rest);

        rest.getVisitStore().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                currentView.getChildren().clear();
                currentView.getChildren().add(storeView);
            }
        });

        rest.getEndProgram().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                //Save all the characters
                System.exit(0);
            }
        });

        primaryStage.setTitle("Encounter Sim");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(currentView));
        primaryStage.show();

    }

    public static void main(String[] args) { launch(args); }
}

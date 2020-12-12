package com.company;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.*;

public class Whatever extends Application {
    public void start(Stage primaryStage){
        Pane aPane = new Pane();

        StoreView storeView = new StoreView();
        //FightView fight = new FightView(new Fighter("Dragonborn", "Player 1"), new Druid("Gnome", "Player 2"));
        aPane.getChildren().add(storeView);

        primaryStage.setTitle("Encounter Sim");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane));
        primaryStage.show();

    }

    public static void main(String[] args) { launch(args); }
}

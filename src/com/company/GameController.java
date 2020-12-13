package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.ListView;
import javafx.beans.value.ObservableValue;

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
                    //ranged
                } else if (store.getRangedList().getSelectionModel().isEmpty() && store.getMeleeList().getSelectionModel().isEmpty()){
                    //armor
                } else if (store.getArmorList().getSelectionModel().isEmpty() && store.getRangedList().getSelectionModel().isEmpty()){
                    //melee
                }
            }
        });

        store.getArmorList().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
                store.getMeleeList().getSelectionModel().clearSelection();
                store.getRangedList().getSelectionModel().clearSelection();
            }
        });
        store.getMeleeList().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
                store.getArmorList().getSelectionModel().clearSelection();
                store.getRangedList().getSelectionModel().clearSelection();
            }
        });
        store.getRangedList().setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
                store.getMeleeList().getSelectionModel().clearSelection();
                store.getArmorList().getSelectionModel().clearSelection();
            }
        });


        primaryStage.setTitle("Encounter Sim");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(currentView));
        primaryStage.show();

    }

    public static void main(String[] args) { launch(args); }
}

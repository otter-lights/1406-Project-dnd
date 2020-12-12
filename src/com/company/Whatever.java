//package com.company;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import javafx.event.*;
//
//public class Whatever extends Application {
//    public void start(Stage primaryStage){
//        Pane aPane = new Pane();
//
//        //StoreView storeView = new StoreView();
//        //FightView fight = new FightView(new Fighter("Dragonborn", "Player 1"), new Druid("Gnome", "Player 2"));
//        RestView rest = new RestView(new Wizard("Elf", "Player 1"));
//        aPane.getChildren().add(rest);
//
//        rest.getVisitStore().setOnAction(new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent actionEvent) {
//
//            }
//        });
//
//        rest.getEndProgram().setOnAction(new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent actionEvent) {
//                //Save all the characters
//                System.exit(0);
//            }
//        });
//
//        primaryStage.setTitle("Encounter Sim");
//        primaryStage.setResizable(false);
//        primaryStage.setScene(new Scene(aPane));
//        primaryStage.show();
//
//    }
//
//    public static void main(String[] args) { launch(args); }
//}

package com.company;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.text.TextAlignment;

public class CharacterCreatorView extends Pane {

    public CharacterCreatorView() {
        Pane storeView = new Pane();
        storeView.setStyle("-fx-background-color: white;");
        storeView.setPrefSize(800, 600);

        /*things to add
            race
            class
            lvl
            name
            that's it :)

            make race & class drop down menus!!
         */

        //add ze children
        storeView.getChildren().addAll();

        getChildren().addAll(storeView);
    }
}

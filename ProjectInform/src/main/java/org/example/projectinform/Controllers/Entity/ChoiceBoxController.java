package org.example.projectinform.Controllers.Entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

public class ChoiceBoxController {

    private final static ObservableList<String> options = FXCollections.observableArrayList("Студент", "Преподаватель");

    public static void setOptions (ChoiceBox<String> box){

        box.setItems(options);

    }

}

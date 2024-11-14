package org.example.projectinform.Controllers.WindowGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsGameWindowController implements Initializable {

    @FXML
    private Button exitMenuPause;

    @FXML
    private Button returnStudentMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpecialMethodsClass.switchFromSettingsToTheWindow(returnStudentMenu, "/Fxml/Student/StudentMenu.fxml");

        SpecialMethodsClass.closeWindow(exitMenuPause);
    }
}

package org.example.projectinform.Controllers.WindowGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.projectinform.Dictionaries.DictionaryPath;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowGameNotEnoughCoins implements Initializable {

    @FXML
    private Button exitStudentMenu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SpecialMethodsClass.switchFromSettingsGameToTheWindow(exitStudentMenu, DictionaryPath.STUDENT_MENU);
    }
}

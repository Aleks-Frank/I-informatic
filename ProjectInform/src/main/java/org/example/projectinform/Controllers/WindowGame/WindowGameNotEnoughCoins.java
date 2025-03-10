package org.example.projectinform.Controllers.WindowGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.projectinform.Dictionaries.FXMLPath;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowGameNotEnoughCoins implements Initializable {

    @FXML
    private Button exitStudentMenu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SwitchWindowSMC.switchFromSettingsGameToTheWindow(exitStudentMenu, FXMLPath.STUDENT_MENU);
    }
}

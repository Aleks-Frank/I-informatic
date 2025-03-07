package org.example.projectinform.Controllers.WindowGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.projectinform.Dictionaries.FXMLPath;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsWindowGameController implements Initializable {

    @FXML
    private Button exitMenuPause;

    @FXML
    private Button exitStudentMenu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SwitchWindowSMC.switchFromSettingsToTheWindow(exitStudentMenu, FXMLPath.STUDENT_MENU);

        SwitchWindowSMC.closeWindow(exitMenuPause);
    }
}

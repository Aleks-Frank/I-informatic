package org.example.projectinform.Controllers.Student;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import org.example.projectinform.Dictionaries.FXMLPath;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsMenuController implements Initializable {

    @FXML
    private Button enterMenuGames;

    @FXML
    private Button exitMenuPause;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SwitchWindowSMC.switchFromSettingsToTheWindow(enterMenuGames, FXMLPath.WINDOW_GAME_MODE_PLAY_ONE);

        SwitchWindowSMC.closeWindow(exitMenuPause);
    }
}

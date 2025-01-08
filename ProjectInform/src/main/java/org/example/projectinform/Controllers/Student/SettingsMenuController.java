package org.example.projectinform.Controllers.Student;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;
import org.example.projectinform.Dictionaries.DictionaryPath;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsMenuController implements Initializable {

    @FXML
    private Button exitMenuPause;

    @FXML
    private Button enterMenuGames;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpecialMethodsClass.switchFromSettingsToTheWindow(enterMenuGames, DictionaryPath.WINDOW_GAME_MODE_PLAY_ONE);

        SpecialMethodsClass.closeWindow(exitMenuPause);
    }
}

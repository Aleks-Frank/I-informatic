package org.example.projectinform.Controllers.WindowWord;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.projectinform.Dictionaries.DictionaryPath;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsWindowController implements Initializable {
    @FXML
    private Button exitMenuPause;

    @FXML
    private Button enterMenuGames;

    @FXML
    private Button exitStudentMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpecialMethodsClass.switchFromSettingsToTheWindow(enterMenuGames, DictionaryPath.WINDOW_GAME_MODE_PLAY_ONE);

        SpecialMethodsClass.switchFromSettingsToTheWindow(exitStudentMenu, DictionaryPath.STUDENT_MENU);

        SpecialMethodsClass.closeWindow(exitMenuPause);
    }
}

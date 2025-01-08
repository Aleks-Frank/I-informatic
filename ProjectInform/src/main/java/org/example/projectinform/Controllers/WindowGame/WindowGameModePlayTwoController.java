package org.example.projectinform.Controllers.WindowGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.projectinform.Dictionaries.DictionaryPath;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowGameModePlayTwoController implements Initializable {

    @FXML
    private Button backMenuStudent;

    @FXML
    private Button backWindow;

    @FXML
    private Button closeButton;

    @FXML
    private Button playInGameOne;

    @FXML
    private Button settingsGame;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpecialMethodsClass.switchSettings(playInGameOne, DictionaryPath.WINDOW_GAME_ENTER_IN_GAME);

        SpecialMethodsClass.switchWindow(backMenuStudent, DictionaryPath.STUDENT_MENU);

        SpecialMethodsClass.switchSettings(settingsGame, DictionaryPath.SETTINGS_WINDOW_GAME);

        SpecialMethodsClass.switchWindow(backWindow, DictionaryPath.WINDOW_GAME_MODE_PLAY_ONE);

        SpecialMethodsClass.closeWindow(closeButton);
    }
}

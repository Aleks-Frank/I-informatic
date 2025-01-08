package org.example.projectinform.Controllers.WindowGame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.projectinform.Dictionaries.DictionaryPath;
import org.example.projectinform.GlobalEntity.GlobalGame;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WindowGameModePlayOneController implements Initializable {

    @FXML
    private Button playInGameOne;

    @FXML
    private Button closeButton;

    @FXML
    private Button backMenuStudent;

    @FXML
    private Button nextWindow;

    @FXML
    private Button settingsGame;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpecialMethodsClass.switchSettingsGame(playInGameOne, DictionaryPath.WINDOW_GAME_ENTER_IN_GAME, 1);

        SpecialMethodsClass.switchWindow(backMenuStudent, DictionaryPath.STUDENT_MENU);

        SpecialMethodsClass.switchSettings(settingsGame, DictionaryPath.SETTINGS_WINDOW_GAME);

        SpecialMethodsClass.switchWindow(nextWindow, DictionaryPath.WINDOW_GAME_MODE_PLAY_TWO);

        SpecialMethodsClass.closeWindow(closeButton);
    }
}

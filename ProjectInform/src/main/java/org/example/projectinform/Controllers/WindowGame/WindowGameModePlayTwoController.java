package org.example.projectinform.Controllers.WindowGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.projectinform.Dictionaries.FXMLPath;
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

    @FXML
    private Label countCoins;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpecialMethodsClass.switchSettingsGame(playInGameOne, FXMLPath.WINDOW_GAME_ENTER_IN_GAME, 2);

        SpecialMethodsClass.switchWindow(backMenuStudent, FXMLPath.STUDENT_MENU);

        SpecialMethodsClass.switchSettings(settingsGame, FXMLPath.SETTINGS_WINDOW_GAME);

        SpecialMethodsClass.switchWindow(backWindow, FXMLPath.WINDOW_GAME_MODE_PLAY_ONE);

        SpecialMethodsClass.closeWindow(closeButton);

        SpecialMethodsClass.viewCountCoins(countCoins);
    }
}

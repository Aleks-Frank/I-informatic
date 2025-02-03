package org.example.projectinform.Controllers.WindowGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.projectinform.Dictionaries.FXMLPath;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;
import org.example.projectinform.SpecialMethods.ViewCountCoinsSMC;

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

        SwitchWindowSMC.switchSettingsGame(playInGameOne, FXMLPath.WINDOW_GAME_ENTER_IN_GAME, 2);

        SwitchWindowSMC.switchWindow(backMenuStudent, FXMLPath.STUDENT_MENU);

        SwitchWindowSMC.switchSettings(settingsGame, FXMLPath.SETTINGS_WINDOW_GAME);

        SwitchWindowSMC.switchWindow(backWindow, FXMLPath.WINDOW_GAME_MODE_PLAY_ONE);

        SwitchWindowSMC.closeWindow(closeButton);

        ViewCountCoinsSMC.viewCountCoins(countCoins);
    }
}

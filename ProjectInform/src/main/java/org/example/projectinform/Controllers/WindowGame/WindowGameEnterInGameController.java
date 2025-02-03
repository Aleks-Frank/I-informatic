package org.example.projectinform.Controllers.WindowGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import org.example.projectinform.SpecialMethods.GameWorkerSMC;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowGameEnterInGameController implements Initializable {

    @FXML
    private Button closeSettingsGame;

    @FXML
    private Button acceptGame;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SwitchWindowSMC.closeWindow(closeSettingsGame);

        GameWorkerSMC.enterInGame(acceptGame);

    }
}

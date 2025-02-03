package org.example.projectinform.Controllers.WindowIsCorrect;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;
import org.example.projectinform.SpecialMethods.ViewCountCoinsSMC;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowTasksIsCorrectWin implements Initializable {

    @FXML
    private Label countInfocoin;

    @FXML
    private Button logOutToWordMenu;

    @FXML
    private Button nextTask;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SwitchWindowSMC.quitTaskWin(logOutToWordMenu);

        ViewCountCoinsSMC.setCountInfoCoinsToWin(countInfocoin);

        SwitchWindowSMC.nextTask(nextTask);

    }
}

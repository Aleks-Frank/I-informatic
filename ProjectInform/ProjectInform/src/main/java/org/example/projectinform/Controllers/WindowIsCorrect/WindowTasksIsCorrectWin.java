package org.example.projectinform.Controllers.WindowIsCorrect;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

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

        SpecialMethodsClass.quitTaskWin(logOutToWordMenu);

        SpecialMethodsClass.setCountInfoCoinsToWin(countInfocoin);

    }
}

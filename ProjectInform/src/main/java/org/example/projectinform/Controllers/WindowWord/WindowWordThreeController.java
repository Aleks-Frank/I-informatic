package org.example.projectinform.Controllers.WindowWord;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.projectinform.Dictionaries.FXMLPath;
import org.example.projectinform.Dictionaries.WordTaskPaths;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;
import org.example.projectinform.SpecialMethods.TaskWorkerSMC;
import org.example.projectinform.SpecialMethods.ViewCountCoinsSMC;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowWordThreeController implements Initializable {

    @FXML
    private Button task15;

    @FXML
    private Button task16;

    @FXML
    private Button task17;

    @FXML
    private Button settingsButton;

    @FXML
    private Button lastWindow;

    @FXML
    private Button nextWindow;

    @FXML
    private Button backMenuStudent;

    @FXML
    private Button closeButton;

    @FXML
    private Label countCoins;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TaskWorkerSMC.switchInfoWord(task15, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W15);
        TaskWorkerSMC.switchInfoWord(task16, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W16);
        TaskWorkerSMC.switchInfoWord(task17, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W17);

        SwitchWindowSMC.switchSettings(settingsButton, FXMLPath.SETTINGS_WINDOW_WORD);

        SwitchWindowSMC.switchWindow(lastWindow, FXMLPath.WINDOW_WORD_CONTROL_WORK_TWO);
        SwitchWindowSMC.switchWindow(nextWindow, FXMLPath.WINDOW_WORD_CONTROL_WORK_THREE);

        SwitchWindowSMC.returnMenuWindow(backMenuStudent);

        SwitchWindowSMC.closeWindow(closeButton);

        ViewCountCoinsSMC.viewCountCoins(countCoins);
    }
}

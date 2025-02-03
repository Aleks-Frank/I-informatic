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

public class WindowWordFourController implements Initializable {

    @FXML
    private Button task18;

    @FXML
    private Button task19;

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

        TaskWorkerSMC.switchInfoWord(task18, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W18);
        TaskWorkerSMC.switchInfoWord(task19, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W19);

        SwitchWindowSMC.switchSettings(settingsButton, FXMLPath.SETTINGS_WINDOW_WORD);

        SwitchWindowSMC.switchWindow(lastWindow, FXMLPath.WINDOW_WORD_CONTROL_WORK_THREE);
        SwitchWindowSMC.switchWindow(nextWindow, FXMLPath.WINDOW_WORD_CONTROL_WORK_FOUR);

        SwitchWindowSMC.returnMenuWindow(backMenuStudent);

        SwitchWindowSMC.closeWindow(closeButton);

        ViewCountCoinsSMC.viewCountCoins(countCoins);
    }
}

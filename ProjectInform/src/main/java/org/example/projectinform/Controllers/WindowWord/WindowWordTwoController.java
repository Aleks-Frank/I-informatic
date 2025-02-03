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

public class WindowWordTwoController implements Initializable {

    @FXML
    private Button task11;

    @FXML
    private Button task12;

    @FXML
    private Button task13;

    @FXML
    private Button task14;

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

        TaskWorkerSMC.switchInfoWord(task11, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W11);
        TaskWorkerSMC.switchInfoWord(task12, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W12);
        TaskWorkerSMC.switchInfoWord(task13, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W13);
        TaskWorkerSMC.switchInfoWord(task14, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W14);

        SwitchWindowSMC.switchSettings(settingsButton, FXMLPath.SETTINGS_WINDOW_WORD);

        SwitchWindowSMC.switchWindow(lastWindow, FXMLPath.WINDOW_WORD_CONTROL_WORK_ONE);
        SwitchWindowSMC.switchWindow(nextWindow, FXMLPath.WINDOW_WORD_CONTROL_WORK_TWO);

        SwitchWindowSMC.returnMenuWindow(backMenuStudent);

        SwitchWindowSMC.closeWindow(closeButton);

        ViewCountCoinsSMC.viewCountCoins(countCoins);
    }
}

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

public class WindowWordOneController implements Initializable {

    @FXML
    private Button task1;

    @FXML
    private Button task2;

    @FXML
    private Button task3;

    @FXML
    private Button task4;

    @FXML
    private Button task5;

    @FXML
    private Button task6;

    @FXML
    private Button task7;

    @FXML
    private Button task8;

    @FXML
    private Button task9;

    @FXML
    private Button task10;

    @FXML
    private Button settingsButton;

    @FXML
    private Button backMenuStudent;

    @FXML
    private Button nextWindow;

    @FXML
    private Button closeButton;

    @FXML
    private Label countCoins;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TaskWorkerSMC.switchInfoWord(task1, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W1);
        TaskWorkerSMC.switchInfoWord(task2, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W2);
        TaskWorkerSMC.switchInfoWord(task3, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W3);
        TaskWorkerSMC.switchInfoWord(task4, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W4);
        TaskWorkerSMC.switchInfoWord(task5, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W5);
        TaskWorkerSMC.switchInfoWord(task6, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W6);
        TaskWorkerSMC.switchInfoWord(task7, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W7);
        TaskWorkerSMC.switchInfoWord(task8, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W8);
        TaskWorkerSMC.switchInfoWord(task9, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W9);
        TaskWorkerSMC.switchInfoWord(task10, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W10);

        SwitchWindowSMC.switchSettings(settingsButton, FXMLPath.SETTINGS_WINDOW_WORD);

        SwitchWindowSMC.returnMenuWindow(backMenuStudent);

        SwitchWindowSMC.switchWindow(nextWindow, FXMLPath.WINDOW_WORD_CONTROL_WORK_ONE);

        SwitchWindowSMC.closeWindow(closeButton);

        ViewCountCoinsSMC.viewCountCoins(countCoins);
    }
}

package org.example.projectinform.Controllers.WindowWord;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.projectinform.Dictionaries.FXMLPath;
import org.example.projectinform.Dictionaries.WordTaskPaths;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

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

        SpecialMethodsClass.switchInfoWord(task1, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W1);
        SpecialMethodsClass.switchInfoWord(task2, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W2);
        SpecialMethodsClass.switchInfoWord(task3, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W3);
        SpecialMethodsClass.switchInfoWord(task4, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W4);
        SpecialMethodsClass.switchInfoWord(task5, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W5);
        SpecialMethodsClass.switchInfoWord(task6, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W6);
        SpecialMethodsClass.switchInfoWord(task7, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W7);
        SpecialMethodsClass.switchInfoWord(task8, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W8);
        SpecialMethodsClass.switchInfoWord(task9, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W9);
        SpecialMethodsClass.switchInfoWord(task10, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W10);

        SpecialMethodsClass.switchSettings(settingsButton, FXMLPath.SETTINGS_WINDOW_WORD);

        SpecialMethodsClass.returnMenuWindow(backMenuStudent);

        SpecialMethodsClass.switchWindow(nextWindow, FXMLPath.WINDOW_WORD_CONTROL_WORK_ONE);

        SpecialMethodsClass.closeWindow(closeButton);

        SpecialMethodsClass.viewCountCoins(countCoins);
    }
}

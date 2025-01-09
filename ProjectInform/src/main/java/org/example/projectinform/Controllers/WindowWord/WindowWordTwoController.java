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

        SpecialMethodsClass.switchInfoWord(task11, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W11);
        SpecialMethodsClass.switchInfoWord(task12, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W12);
        SpecialMethodsClass.switchInfoWord(task13, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W13);
        SpecialMethodsClass.switchInfoWord(task14, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W14);

        SpecialMethodsClass.switchSettings(settingsButton, FXMLPath.SETTINGS_WINDOW_WORD);

        SpecialMethodsClass.switchWindow(lastWindow, FXMLPath.WINDOW_WORD_CONTROL_WORK_ONE);
        SpecialMethodsClass.switchWindow(nextWindow, FXMLPath.WINDOW_WORD_CONTROL_WORK_TWO);

        SpecialMethodsClass.returnMenuWindow(backMenuStudent);

        SpecialMethodsClass.closeWindow(closeButton);

        SpecialMethodsClass.viewCountCoins(countCoins);
    }
}

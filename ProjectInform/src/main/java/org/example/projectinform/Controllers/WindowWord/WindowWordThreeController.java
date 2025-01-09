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

        SpecialMethodsClass.switchInfoWord(task15, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W15);
        SpecialMethodsClass.switchInfoWord(task16, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W16);
        SpecialMethodsClass.switchInfoWord(task17, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W17);

        SpecialMethodsClass.switchSettings(settingsButton, FXMLPath.SETTINGS_WINDOW_WORD);

        SpecialMethodsClass.switchWindow(lastWindow, FXMLPath.WINDOW_WORD_CONTROL_WORK_TWO);
        SpecialMethodsClass.switchWindow(nextWindow, FXMLPath.WINDOW_WORD_CONTROL_WORK_THREE);

        SpecialMethodsClass.returnMenuWindow(backMenuStudent);

        SpecialMethodsClass.closeWindow(closeButton);

        SpecialMethodsClass.viewCountCoins(countCoins);
    }
}

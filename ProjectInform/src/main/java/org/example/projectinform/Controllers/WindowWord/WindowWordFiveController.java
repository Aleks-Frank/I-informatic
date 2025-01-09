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

public class WindowWordFiveController implements Initializable {

    @FXML
    private Button task20;

    @FXML
    private Button task21;

    @FXML
    private Button settingsButton;

    @FXML
    private Button lastWindow;

    @FXML
    private Button backMenuStudent;

    @FXML
    private Button closeButton;

    @FXML
    private Label countCoins;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpecialMethodsClass.switchInfoWord(task20, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W20);
        SpecialMethodsClass.switchInfoWord(task21, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.W21);

        SpecialMethodsClass.switchSettings(settingsButton, FXMLPath.SETTINGS_WINDOW_WORD);

        SpecialMethodsClass.switchWindow(lastWindow, FXMLPath.WINDOW_WORD_CONTROL_WORK_FOUR);

        SpecialMethodsClass.returnMenuWindow(backMenuStudent);

        SpecialMethodsClass.closeWindow(closeButton);

        SpecialMethodsClass.viewCountCoins(countCoins);
    }
}

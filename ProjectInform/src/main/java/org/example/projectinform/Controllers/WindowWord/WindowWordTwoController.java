package org.example.projectinform.Controllers.WindowWord;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.projectinform.Dictionaries.DictionaryPath;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowWordTwoController implements Initializable {

    @FXML
    private Button backMenuStudent;

    @FXML
    private Button closeButton;

    @FXML
    private Label count;

    @FXML
    private Button lastWindow;

    @FXML
    private Button nextWindow;

    @FXML
    private Button taskFourWord;

    @FXML
    private Button taskOneWord;

    @FXML
    private Button taskThreeWord;

    @FXML
    private Button taskTwoWord;

    @FXML
    private Button settingsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpecialMethodsClass.returnMenuWindow(backMenuStudent);

        SpecialMethodsClass.switchWindow(nextWindow, DictionaryPath.WINDOW_WORD_CONTROL_WORK_TWO);

        SpecialMethodsClass.switchWindow(lastWindow, DictionaryPath.WINDOW_WORD_CONTROL_WORK_ONE);

        SpecialMethodsClass.switchSettings(settingsButton, DictionaryPath.SETTINGS_WINDOW_WORD);

        SpecialMethodsClass.closeWindow(closeButton);
    }
}

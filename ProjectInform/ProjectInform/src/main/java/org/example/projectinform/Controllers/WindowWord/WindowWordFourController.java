package org.example.projectinform.Controllers.WindowWord;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.projectinform.Dictionaries.DictionaryPath;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowWordFourController implements Initializable {

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
    private Button taskOneWord;

    @FXML
    private Button taskTwoWord;

    @FXML
    private Button settingsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpecialMethodsClass.returnMenuWindow(backMenuStudent);

        SpecialMethodsClass.switchSettings(settingsButton, DictionaryPath.SETTINGS_WINDOW_WORD);

        SpecialMethodsClass.switchWindow(nextWindow, DictionaryPath.WINDOW_WORD_CONTROL_WORK_FOUR);

        SpecialMethodsClass.switchWindow(lastWindow, DictionaryPath.WINDOW_WORD_CONTROL_WORK_THREE);

        SpecialMethodsClass.closeWindow(closeButton);
    }
}

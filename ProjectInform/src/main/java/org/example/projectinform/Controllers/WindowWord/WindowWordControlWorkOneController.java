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

public class WindowWordControlWorkOneController implements Initializable {

    @FXML
    private Button settingsButton;

    @FXML
    private Button lastWindow;

    @FXML
    private Button nextWindow;

    @FXML
    private Button enterWorkControl;

    @FXML
    private Button backMenuStudent;

    @FXML
    private Button closeButton;

    @FXML
    private Label countCoins;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpecialMethodsClass.switchSettings(settingsButton, FXMLPath.SETTINGS_WINDOW_WORD);

        SpecialMethodsClass.switchWindow(lastWindow, FXMLPath.WINDOW_WORD_ONE);
        SpecialMethodsClass.switchWindow(nextWindow, FXMLPath.WINDOW_WORD_TWO);

        SpecialMethodsClass.switchInfoWord(enterWorkControl, FXMLPath.WINDOW_WORD_INFO_TASK, WordTaskPaths.CW1);

        SpecialMethodsClass.returnMenuWindow(backMenuStudent);

        SpecialMethodsClass.closeWindow(closeButton);

        SpecialMethodsClass.viewCountCoins(countCoins);
    }
}

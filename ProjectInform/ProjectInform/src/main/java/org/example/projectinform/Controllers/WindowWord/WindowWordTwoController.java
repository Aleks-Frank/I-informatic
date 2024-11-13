package org.example.projectinform.Controllers.WindowWord;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        SpecialMethodsClass.switchWindow(nextWindow, "/Fxml/WindowWord/WindowWordControlWorkTwo.fxml");

        SpecialMethodsClass.switchWindow(lastWindow, "/Fxml/WindowWord/WindowWordControlWorkOne.fxml");

        SpecialMethodsClass.switchSettings(settingsButton, "/Fxml/WindowWord/SettingsWindowWord.fxml");

        SpecialMethodsClass.closeWindow(closeButton);
    }
}

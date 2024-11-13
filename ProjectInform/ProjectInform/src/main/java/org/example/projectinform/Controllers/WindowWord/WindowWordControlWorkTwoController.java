package org.example.projectinform.Controllers.WindowWord;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowWordControlWorkTwoController implements Initializable {

    @FXML
    private Button backMenuStudent;

    @FXML
    private Button closeButton;

    @FXML
    private Label count;

    @FXML
    private Button enterWorkControl;

    @FXML
    private Button lastWindow;

    @FXML
    private Button nextWindow;

    @FXML
    private Button settingsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpecialMethodsClass.returnMenuWindow(backMenuStudent);

        SpecialMethodsClass.switchWindow(nextWindow, "/Fxml/WindowWord/WindowWordThree.fxml");

        SpecialMethodsClass.switchSettings(settingsButton, "/Fxml/WindowWord/SettingsWindowWord.fxml");

        SpecialMethodsClass.switchWindow(lastWindow, "/Fxml/WindowWord/WindowWordTwo.fxml");

        SpecialMethodsClass.closeWindow(closeButton);
    }
}

package org.example.projectinform.Controllers.WindowWord;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowWordOneController implements Initializable {

    @FXML
    private Button backMenuStudent;

    @FXML
    private Button nextWindow;

    @FXML
    private Button closeButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button taskEightWord;

    @FXML
    private Button taskFiveWord;

    @FXML
    private Button taskFourWord;

    @FXML
    private Button taskNineWord;

    @FXML
    private Button taskOneWord;

    @FXML
    private Button taskSevenWord;

    @FXML
    private Button taskSixWord;

    @FXML
    private Button taskTenWord;

    @FXML
    private Button taskThreeWord;

    @FXML
    private Button taskTwoWord;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpecialMethodsClass.returnMenuWindow(backMenuStudent);

        SpecialMethodsClass.switchSettings(settingsButton, "/Fxml/WindowWord/SettingsWindowWord.fxml");

        SpecialMethodsClass.switchWindow(nextWindow, "/Fxml/WindowWord/WindowWordControlWorkOne.fxml");

        SpecialMethodsClass.closeWindow(closeButton);
    }
}

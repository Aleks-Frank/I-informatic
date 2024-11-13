package org.example.projectinform.Controllers.Student;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;


import java.net.URL;
import java.util.ResourceBundle;

public class StudentMenuController implements Initializable {

    @FXML
    private Button backMenuStr;

    @FXML
    private Button wordNextStr;

    @FXML
    private Button closeButton;

    @FXML
    private Button settingsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpecialMethodsClass.switchWindow(backMenuStr, "/Fxml/WindowEnterAndInput/Login.fxml");

        SpecialMethodsClass.switchWindow(wordNextStr, "/Fxml/WindowWord/WindowWordOne.fxml");

        SpecialMethodsClass.switchSettings(settingsButton, "/Fxml/Student/SettingsMenu.fxml");

        SpecialMethodsClass.closeWindow(closeButton);

    }
}

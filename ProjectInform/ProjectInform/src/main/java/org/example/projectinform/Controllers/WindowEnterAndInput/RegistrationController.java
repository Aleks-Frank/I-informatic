package org.example.projectinform.Controllers.WindowEnterAndInput;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

    @FXML
    private Button backLogin;

    @FXML
    private TextField classStud;

    @FXML
    private Button closeButton;

    @FXML
    private TextField firstNameStud;

    @FXML
    private TextField lastNameStud;

    @FXML
    private TextField loginStud;

    @FXML
    private TextField passwordStud;

    @FXML
    private Button registrationEnter;

    @FXML
    private ChoiceBox<?> roleStud;

    @FXML
    private Button settingsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpecialMethodsClass.switchWindow(registrationEnter, "/Fxml/WindowEnterAndInput/Login.fxml");

        SpecialMethodsClass.switchWindow(backLogin, "/Fxml/WindowEnterAndInput/Login.fxml");

        SpecialMethodsClass.switchSettings(settingsButton, "/Fxml/WindowEnterAndInput/LoginSettings.fxml");

        SpecialMethodsClass.closeWindow(closeButton);
    }
}

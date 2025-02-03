package org.example.projectinform.Controllers.WindowEnterAndInput;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.projectinform.Controllers.Entity.ChoiceBoxController;
import org.example.projectinform.Dictionaries.FXMLPath;
import org.example.projectinform.SpecialMethods.RegistrationAndLoginSMC;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button enter;

    @FXML
    private TextField classStud;

    @FXML
    private Button closeButton;

    @FXML
    private Label errorMessage;

    @FXML
    private TextField loginStud;

    @FXML
    private TextField passwordStud;

    @FXML
    private Button registrationInput;

    @FXML
    private ChoiceBox<String> roleStud;

    @FXML
    private Button settingsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ChoiceBoxController.setOptions(roleStud);

        errorMessage.setVisible(false);

        RegistrationAndLoginSMC.loginStudent(enter, FXMLPath.STUDENT_MENU, roleStud, classStud, loginStud, passwordStud, errorMessage);

        SwitchWindowSMC.switchWindow(registrationInput, FXMLPath.REGISTRATION);

        SwitchWindowSMC.switchSettings(settingsButton, FXMLPath.LOGIN_SETTINGS);

        SwitchWindowSMC.closeWindow(closeButton);

    }
}

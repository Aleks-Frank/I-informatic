package org.example.projectinform.Controllers.WindowEnterAndInput;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.example.projectinform.Controllers.Entity.ChoiceBoxController;
import org.example.projectinform.Dictionaries.FXMLPath;
import org.example.projectinform.SpecialMethods.RegistrationAndLoginSMC;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;

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
    private ChoiceBox<String> roleStud;

    @FXML
    private Button settingsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ChoiceBoxController.setOptions(roleStud);

        RegistrationAndLoginSMC.registrationStudent(registrationEnter, FXMLPath.LOGIN, firstNameStud, lastNameStud, roleStud, classStud, loginStud, passwordStud);

        SwitchWindowSMC.switchSettings(settingsButton, FXMLPath.LOGIN_SETTINGS);

        SwitchWindowSMC.switchWindow(backLogin, FXMLPath.LOGIN);

        SwitchWindowSMC.closeWindow(closeButton);
    }
}

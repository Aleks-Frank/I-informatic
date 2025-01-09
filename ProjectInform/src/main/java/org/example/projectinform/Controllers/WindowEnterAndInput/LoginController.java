package org.example.projectinform.Controllers.WindowEnterAndInput;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.projectinform.Controllers.Entity.ChoiceBoxController;
import org.example.projectinform.Dictionaries.FXMLPath;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

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

        SpecialMethodsClass.loginStudent(enter, FXMLPath.STUDENT_MENU, roleStud, classStud, loginStud, passwordStud, errorMessage);

//        SpecialMethodsClass.switchWindow(enter, DictionaryPath.STUDENT_MENU);

        SpecialMethodsClass.switchWindow(registrationInput, FXMLPath.REGISTRATION);

        SpecialMethodsClass.switchSettings(settingsButton, FXMLPath.LOGIN_SETTINGS);

        SpecialMethodsClass.closeWindow(closeButton);

    }
}

package org.example.projectinform.Controllers.WindowEnterAndInput;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.projectinform.Dictionaries.DictionaryPath;
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
    private AnchorPane inputPane;

    @FXML
    private TextField loginStud;

    @FXML
    private TextField passwordStud;

    @FXML
    private Button registrationInput;

    @FXML
    private ChoiceBox<?> roleStud;

    @FXML
    private Button settingsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpecialMethodsClass.switchWindow(enter, DictionaryPath.STUDENT_MENU);

        SpecialMethodsClass.switchWindow(registrationInput, DictionaryPath.REGISTRATION);

        SpecialMethodsClass.switchSettings(settingsButton, DictionaryPath.LOGIN_SETTINGS);

        SpecialMethodsClass.closeWindow(closeButton);

    }
}

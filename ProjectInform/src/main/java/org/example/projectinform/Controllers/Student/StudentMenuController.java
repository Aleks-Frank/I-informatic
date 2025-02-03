package org.example.projectinform.Controllers.Student;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.projectinform.Dictionaries.FXMLPath;
import org.example.projectinform.SpecialMethods.RegistrationAndLoginSMC;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;


import java.net.URL;
import java.util.ResourceBundle;

public class StudentMenuController implements Initializable {

    @FXML
    private Button settingsButton;

    @FXML
    private Button wordNextStr;

    @FXML
    private Button nextGameWindow;

    @FXML
    private Button closeButton;

    @FXML
    private Button logOutProfile;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SwitchWindowSMC.switchSettings(settingsButton, FXMLPath.SETTINGS_MENU);

        SwitchWindowSMC.switchWindow(wordNextStr, FXMLPath.WINDOW_WORD_ONE);
        SwitchWindowSMC.switchWindow(nextGameWindow, FXMLPath.WINDOW_GAME_MODE_PLAY_ONE);

        SwitchWindowSMC.closeWindow(closeButton);

        RegistrationAndLoginSMC.logOutUser(logOutProfile, FXMLPath.LOGIN);

    }
}

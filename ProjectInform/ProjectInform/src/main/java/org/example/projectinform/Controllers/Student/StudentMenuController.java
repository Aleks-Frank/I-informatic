package org.example.projectinform.Controllers.Student;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.projectinform.Dictionaries.DictionaryPath;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;


import java.net.URL;
import java.util.ResourceBundle;

public class StudentMenuController implements Initializable {


    @FXML
    private Button closeButton;

    @FXML
    private Button logOutProfile;

    @FXML
    private Button nextGameWindow;

    @FXML
    private Button settingsButton;

    @FXML
    private Button wordNextStr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpecialMethodsClass.switchWindowBackLogin(logOutProfile, DictionaryPath.LOGIN);

        SpecialMethodsClass.switchWindow(wordNextStr, DictionaryPath.WINDOW_WORD_ONE);

        SpecialMethodsClass.switchSettings(settingsButton, DictionaryPath.SETTINGS_MENU);

        SpecialMethodsClass.switchWindow(nextGameWindow, DictionaryPath.WINDOW_GAME_MODE_PLAY_ONE);

        SpecialMethodsClass.closeWindow(closeButton);

    }
}

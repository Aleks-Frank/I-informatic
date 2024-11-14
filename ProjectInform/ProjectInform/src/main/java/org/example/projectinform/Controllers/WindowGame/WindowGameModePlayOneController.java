package org.example.projectinform.Controllers.WindowGame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WindowGameModePlayOneController implements Initializable {


    @FXML
    private Button backMenuStudent;

    @FXML
    private Button closeButton;

    @FXML
    private Label count;

    @FXML
    private Button nextWindow;

    @FXML
    private Button playInGameOne;

    @FXML
    private Button settingsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpecialMethodsClass.switchSettings(settingsButton, "/Fxml/WindowGame/SettingsGameWindow.fxml");

    }
}

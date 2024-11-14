package org.example.projectinform.Controllers.WindowWord;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsWindowController implements Initializable {
    @FXML
    private Button exitMenuPause;

    @FXML
    private Button enterMenuGames;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpecialMethodsClass.switchWindow(enterMenuGames, "/Fxml/WindowGame/WindowGameModePlayOne.fxml");

        SpecialMethodsClass.closeWindow(exitMenuPause);
    }
}

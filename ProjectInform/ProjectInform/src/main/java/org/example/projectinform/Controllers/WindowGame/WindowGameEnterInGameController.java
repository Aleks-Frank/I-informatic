package org.example.projectinform.Controllers.WindowGame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.projectinform.Dictionaries.DictionaryPath;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WindowGameEnterInGameController implements Initializable {

    @FXML
    private Button closeSettingsGame;

    @FXML
    private Button acceptGame;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SpecialMethodsClass.closeWindow(closeSettingsGame);

      //  SpecialMethodsClass.switchWindow(acceptGame);
    }
}

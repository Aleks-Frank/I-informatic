package org.example.projectinform.Controllers.WindowEnterAndInput;

import javafx.fxml.Initializable;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class PauseEnterAndInputController implements Initializable {

    @FXML
    private Button exitLoginPause;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpecialMethodsClass.closeWindow(exitLoginPause);
    }
}

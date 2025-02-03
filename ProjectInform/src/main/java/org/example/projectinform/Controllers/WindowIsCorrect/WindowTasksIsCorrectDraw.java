package org.example.projectinform.Controllers.WindowIsCorrect;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowTasksIsCorrectDraw implements Initializable {

    @FXML
    private Button nextTask;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SwitchWindowSMC.closeFailWindow(nextTask);
    }
}

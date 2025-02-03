package org.example.projectinform.Controllers.WindowIsCorrect;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;
import org.example.projectinform.SpecialMethods.TaskWorkerSMC;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowTaskIsCorrect implements Initializable {

    @FXML
    private Button logOutButton;

    @FXML
    private Button nextButton;

    @FXML
    private Label taskInfo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TaskWorkerSMC.setTasksInfo(taskInfo);

        SwitchWindowSMC.closeInfo(nextButton);

        SwitchWindowSMC.quitTask(logOutButton);

    }
}

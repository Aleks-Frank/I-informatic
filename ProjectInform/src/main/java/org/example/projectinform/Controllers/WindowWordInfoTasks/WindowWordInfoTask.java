package org.example.projectinform.Controllers.WindowWordInfoTasks;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;
import org.example.projectinform.SpecialMethods.TaskWorkerSMC;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowWordInfoTask implements Initializable {

    @FXML
    private Label numberTask;

    @FXML
    private Label nameTask;

    @FXML
    private Label priceTask;

    @FXML
    private Button backButton;

    @FXML
    private Button startButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TaskWorkerSMC.setTasksInfo(numberTask, nameTask, priceTask);

        SwitchWindowSMC.closeInfo(backButton);

        SwitchWindowSMC.openWordFileOnButton(startButton);


    }
}

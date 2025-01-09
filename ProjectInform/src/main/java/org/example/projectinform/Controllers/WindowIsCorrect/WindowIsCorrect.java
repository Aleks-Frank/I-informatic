package org.example.projectinform.Controllers.WindowIsCorrect;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.projectinform.Dictionaries.FXMLPath;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowIsCorrect implements Initializable {

    @FXML
    private Button getTaskInfo;

    @FXML
    private Button isCorrect;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpecialMethodsClass.switchTasksInfo(getTaskInfo, FXMLPath.WINDOW_TASK_IS_CORRECT);

        SpecialMethodsClass.checkTasks(isCorrect);
    }
}

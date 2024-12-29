package org.example.projectinform.Controllers.WindowIsCorrect;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.TextFlow;
import org.example.projectinform.WorkerasksResult.WorkerTasksResult;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowTasksResultController implements Initializable {

    @FXML
    private TextFlow textFlowResult;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WorkerTasksResult.viewTasksResult(textFlowResult);
    }
}

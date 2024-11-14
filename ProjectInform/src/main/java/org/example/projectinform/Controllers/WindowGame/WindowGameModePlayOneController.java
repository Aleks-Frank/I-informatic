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
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WindowGameModePlayOneController implements Initializable {

    @FXML
    private Button playInGameOne;

    @FXML
    private Button closeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playInGameOne.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/WindowGame/WindowGameEnterInGame.fxml"));
                Parent root = fxmlLoader.load();
                Stage secondStage = new Stage();
                secondStage.initModality(Modality.APPLICATION_MODAL);
                secondStage.initOwner(((Node) event.getSource()).getScene().getWindow());
                secondStage.setScene(new Scene(root));
                secondStage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        SpecialMethodsClass.closeWindow(closeButton);
    }
}

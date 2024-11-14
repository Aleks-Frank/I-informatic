package org.example.projectinform.SpecialMethods;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Setter;

import java.io.IOException;

public class SpecialMethodsClass {

    @Setter
    private static Stage primaryStage;

    public static void switchWindow(Button button, String path){
        button.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(SpecialMethodsClass.class.getResource(path));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) button.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void switchSettings(Button button, String path) {
        button.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(SpecialMethodsClass.class.getResource(path));
                Parent newRoot = loader.load();
                Stage settingsStage = new Stage();
                settingsStage.initOwner(primaryStage);
                settingsStage.initStyle(StageStyle.UNDECORATED);
                settingsStage.initModality(Modality.WINDOW_MODAL);
                settingsStage.setScene(new Scene(newRoot));

                settingsStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void closeWindow(Button button){
        button.setOnAction(event -> {
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        });
    }

    public static void returnMenuWindow(Button button){
        button.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(SpecialMethodsClass.class.getResource("/Fxml/Student/StudentMenu.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) button.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}

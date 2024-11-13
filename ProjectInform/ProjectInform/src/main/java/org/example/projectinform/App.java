package org.example.projectinform;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.projectinform.SpecialMethods.SpecialMethodsClass;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/WindowEnterAndInput/Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        SpecialMethodsClass.setPrimaryStage(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}

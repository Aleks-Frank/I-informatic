package org.example.projectinform.SpecialMethods;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Setter;
import org.example.projectinform.DBRepository.DBRepositoryController;
import org.example.projectinform.DBRepository.Entity.Student;
import org.example.projectinform.GlobalStudent.GlobalStudentUser;

import java.io.IOException;
import java.sql.SQLException;

public class SpecialMethodsClass {

    @Setter
    private static Stage primaryStage;

    @Setter
    private static Stage settingStage;

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
                settingStage = settingsStage;
                settingsStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void switchFromSettingsToTheWindow(Button button, String nextWindowPath) {
        button.setOnAction(event -> {
            settingStage.close();

            try {
                FXMLLoader loader = new FXMLLoader(SpecialMethodsClass.class.getResource(nextWindowPath));
                Parent newRoot = loader.load();
                Scene scene = new Scene(newRoot);
                primaryStage.setScene(scene);
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

    public static void registrationStudent(Button button, String path, TextField name, TextField lastName,
                                           ChoiceBox<String> role, TextField classStudent,
                                           TextField login, TextField password){


        button.setOnAction(event -> {
            String nameStudentText = name.getText().trim();
            String lastNameStudentText = lastName.getText().trim();
            String roleStudentBox = role.getValue();
            String classStudentText = classStudent.getText().trim();
            String loginStudentText = login.getText().trim();
            String passwordStudentText = password.getText().trim();

            try {
                registrationUser(nameStudentText, lastNameStudentText, roleStudentBox, classStudentText, loginStudentText, passwordStudentText);
                FXMLLoader loader = new FXMLLoader(SpecialMethodsClass.class.getResource(path));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) button.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void registrationUser(String name, String lastName, String role, String classStudent, String login, String password) throws Exception {
        DBRepositoryController dbRepositoryController = new DBRepositoryController();

        dbRepositoryController.connect();
        Student student = new Student(name, lastName, role, Integer.parseInt(classStudent), login, password);
        dbRepositoryController.saveStudent(student);
        dbRepositoryController.close();
    }

    public static void loginStudent(Button button, String path, ChoiceBox<String> role, TextField classStudent,
                                    TextField login, TextField password, Label message){
        button.setOnAction(event -> {
            String roleStudentBox = role.getValue();
            String classStudentText = classStudent.getText().trim();
            String loginStudentText = login.getText().trim();
            String passwordStudentText = password.getText().trim();

            try{
                loginUser(button, roleStudentBox, classStudentText, loginStudentText, passwordStudentText, path, message);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
    }

    private static void loginUser(Button button, String roleStudentBox, String classStudentText, String loginStudentText, String passwordStudentText,
                                  String path, Label message) throws Exception {
        DBRepositoryController dbRepositoryController = new DBRepositoryController();

        dbRepositoryController.connect();
        Student student = dbRepositoryController.getStudentByFourParameters(roleStudentBox, Integer.parseInt(classStudentText), loginStudentText, passwordStudentText);
        if(student != null) {
            GlobalStudentUser.globalStudent = student;
            try {
                FXMLLoader loader = new FXMLLoader(SpecialMethodsClass.class.getResource(path));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) button.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            message.setVisible(true);
        }

        dbRepositoryController.close();
    }
}

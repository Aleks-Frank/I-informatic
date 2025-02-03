package org.example.projectinform.SpecialMethods;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.projectinform.DBRepository.Entity.Student;
import org.example.projectinform.DBRepository.StudentDBRepositoryController;
import org.example.projectinform.GlobalEntity.GlobalStudentUser;

import java.io.IOException;

public class RegistrationAndLoginSMC {

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
                FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(path));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) button.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception e) {
                System.out.println("Значение введино не верно");
            }
        });
    }

    private static void registrationUser(String name, String lastName, String role, String classStudent, String login, String password) throws Exception {
        StudentDBRepositoryController dbRepositoryController = new StudentDBRepositoryController();

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
                GameWorkerSMC.getGameInfoForDB(1);
            } catch (Exception e) {
                System.out.print("Пользователя нет в базе данных");
            }

        });
    }

    private static void loginUser(Button button, String roleStudentBox, String classStudentText, String loginStudentText, String passwordStudentText,
                                  String path, Label message) throws Exception {
        StudentDBRepositoryController dbRepositoryController = new StudentDBRepositoryController();

        dbRepositoryController.connect();
        Student student = dbRepositoryController.getStudentByFourParameters(roleStudentBox, Integer.parseInt(classStudentText), loginStudentText, passwordStudentText);
        if(student != null) {
            GlobalStudentUser.globalStudent = student;
            System.out.println(GlobalStudentUser.globalStudent.getFirstName());
            try {
                FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(path));
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

    public static void logOutUser(Button button, String path){
        button.setOnAction(event -> {
            try {
                GlobalStudentUser.globalStudent = null;
                FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(path));
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

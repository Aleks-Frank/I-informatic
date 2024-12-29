package org.example.projectinform.SpecialMethods;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Setter;
import org.example.projectinform.DBRepository.Entity.Tasks;
import org.example.projectinform.DBRepository.StudentDBRepositoryController;
import org.example.projectinform.DBRepository.Entity.Student;
import org.example.projectinform.DBRepository.TasksDBRepositoryController;
import org.example.projectinform.Dictionaries.DictionaryPath;
import org.example.projectinform.FileWorker.CreateAndOpenFileWord;
import org.example.projectinform.GlobalEntity.GlobalStudentUser;
import org.example.projectinform.GlobalEntity.GlobalTasks;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;

public class SpecialMethodsClass {

    @Setter
    private static Stage primaryStage;

    @Setter
    private static Stage settingStage;

    @Setter
    private static Stage infoTasksSave;

    @Setter
    private static Stage currectSaveStage;

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

    public static void switchWindowBackLogin(Button button, String path){
        button.setOnAction(event -> {
            try {
                GlobalStudentUser.globalStudent = null;
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
                Scene scene = new Scene(newRoot);
                scene.setFill(Color.TRANSPARENT);
                settingsStage.setScene(scene);
                settingsStage.initStyle(StageStyle.TRANSPARENT);

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

    public static void startGameDragonPicker(Button button){
        button.setOnAction(event -> {
            String relativePath = "games/DragonPicker/BuildTwo/DragonPicker.exe";
            File gameFile = new File(relativePath);
            if (gameFile.exists()) {
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder(relativePath);
                    processBuilder.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Не удается найти указанный файл: " + relativePath);
            }
        });
    }

    public static void openWordFileOnButton(Button button){
        button.setOnAction(event -> {
            CreateAndOpenFileWord.workerFileWord();
            if (settingStage != null && settingStage.isShowing()){
                settingStage.close();
            }
            openWindowCorrect();
        });
    }

    public static void closeInfo(Button button){
        button.setOnAction(event -> {
            infoTasksSave.close();
        });
    }

    public static void viewCountCoins(Label label){
        label.setText(String.valueOf(GlobalStudentUser.globalStudent.getCountCoins()));
    }

    public static void switchInfoWord(Button button, String path, String id) {
        button.setOnAction(event -> {
            try {
                getTasksInfo(id);
                FXMLLoader loader = new FXMLLoader(SpecialMethodsClass.class.getResource(path));
                Parent newRoot = loader.load();
                Stage settingsStage = new Stage();
                settingsStage.initOwner(primaryStage);
                settingsStage.initStyle(StageStyle.UNDECORATED);
                settingsStage.initModality(Modality.WINDOW_MODAL);
                Scene scene = new Scene(newRoot);
                settingsStage.setScene(scene);

                scene.setFill(Color.TRANSPARENT);
                settingsStage.setScene(scene);
                settingsStage.initStyle(StageStyle.TRANSPARENT);

                settingStage = settingsStage;
                settingsStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void getTasksInfo(String id) throws Exception {

        TasksDBRepositoryController dbRepositoryController = new TasksDBRepositoryController();
        dbRepositoryController.connect();
        GlobalTasks.globalTasks = dbRepositoryController.getTasksById(id);
        dbRepositoryController.close();

    }

    public static void setTasksInfo(Label numberTasks, Label nameTasks, Label countCoins){
        numberTasks.setText(MessageFormat.format("Задание №{0}", GlobalTasks.globalTasks.idForNumberString()));
        nameTasks.setText(GlobalTasks.globalTasks.getNameTasks());
        countCoins.setText(MessageFormat.format("Стоимость: {0} инфокойнов", GlobalTasks.globalTasks.getCountCoins()));
    }

    private static void openWindowCorrect(){
        try {
            FXMLLoader loader = new FXMLLoader(SpecialMethodsClass.class.getResource(DictionaryPath.WINDOW_IS_CORRECT));
            Parent newRoot = loader.load();
            Stage currectStage = new Stage();
            currectStage.setAlwaysOnTop(true);

            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            double screenWidth = primaryScreenBounds.getWidth();
            double screenHeight = primaryScreenBounds.getHeight();

            double x = screenWidth - 320; // Координата x для правого края
            double y = screenHeight - 230; // Координата y для нижнего края

            currectStage.setX(x);
            currectStage.setY(y);
            currectStage.setResizable(false);
            currectStage.initOwner(primaryStage);
            currectStage.initStyle(StageStyle.UNDECORATED);
            currectStage.initModality(Modality.WINDOW_MODAL);
            Scene newScene = new Scene(newRoot);
            newScene.setFill(Color.TRANSPARENT);
            currectStage.setScene(newScene);
            currectStage.initStyle(StageStyle.TRANSPARENT);
            currectSaveStage = currectStage;
            primaryStage.hide();
            currectStage.show();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void setTasksInfo(Label label){
        label.setText(GlobalTasks.globalTasks.getTasks());
    }

    public static void switchTasksInfo(Button button, String path) {
        button.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(SpecialMethodsClass.class.getResource(path));
                Parent newRoot = loader.load();
                Stage infoTaskStage = new Stage();
                infoTaskStage.setAlwaysOnTop(true);
                infoTaskStage.initOwner(primaryStage);
                infoTaskStage.initStyle(StageStyle.UNDECORATED);
                infoTaskStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(newRoot);
                scene.setFill(Color.TRANSPARENT);
                infoTaskStage.setScene(scene);
                infoTaskStage.initStyle(StageStyle.TRANSPARENT);

                infoTasksSave = infoTaskStage;
                infoTaskStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void quitTask(Button button){
        button.setOnAction(event -> {
            try{
                currectSaveStage.setAlwaysOnTop(false);
                infoTasksSave.hide();
                currectSaveStage.hide();
                primaryStage.show();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        });

    }

}

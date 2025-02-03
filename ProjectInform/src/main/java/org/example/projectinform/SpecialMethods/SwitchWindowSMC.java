package org.example.projectinform.SpecialMethods;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.projectinform.Dictionaries.FXMLPath;
import org.example.projectinform.FileWorker.CreateAndOpenFileWord;
import org.example.projectinform.GlobalEntity.*;
import org.example.projectinform.WorkerCheckTask.WorkerCheckTask;

import java.io.IOException;

public class SwitchWindowSMC {

    public static void closeWindow(Button button){
        button.setOnAction(event -> {
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        });
    }

    public static void switchWindow(Button button, String path){
        button.setOnAction(event -> {
            try {
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

    public static void switchSettings(Button button, String path) {
        button.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(path));
                Parent newRoot = loader.load();
                Stage settingsStage = new Stage();
                settingsStage.initOwner(StageWorkerSMC.getPrimaryStage());
                settingsStage.initStyle(StageStyle.UNDECORATED);
                settingsStage.initModality(Modality.WINDOW_MODAL);
                Scene scene = new Scene(newRoot);
                scene.setFill(Color.TRANSPARENT);
                settingsStage.setScene(scene);
                settingsStage.initStyle(StageStyle.TRANSPARENT);

                StageWorkerSMC.setSettingStage(settingsStage);
                settingsStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void switchFromSettingsToTheWindow(Button button, String nextWindowPath) {
        button.setOnAction(event -> {
            StageWorkerSMC.getSettingStage().close();

            try {
                FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(nextWindowPath));
                Parent newRoot = loader.load();
                Scene scene = new Scene(newRoot);
                StageWorkerSMC.getPrimaryStage().setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void switchFromSettingsGameToTheWindow(Button button, String nextWindowPath) {
        button.setOnAction(event -> {
            StageWorkerSMC.getFailGameEnterSaveStage().close();

            try {
                FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(nextWindowPath));
                Parent newRoot = loader.load();
                Scene scene = new Scene(newRoot);
                StageWorkerSMC.getPrimaryStage().setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void returnMenuWindow(Button button){
        button.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource("/Fxml/Student/StudentMenu.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) button.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

//    public static void startGame(Button button){
//        button.setOnAction(event -> {
//            String relativePath = GlobalGame.globalGame.getUrlGame();
//            File gameFile = new File(relativePath);
//            if (gameFile.exists()) {
//                try {
//                    ProcessBuilder processBuilder = new ProcessBuilder(relativePath);
//                    processBuilder.start();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                System.out.println("Не удается найти указанный файл: " + relativePath);
//            }
//        });
//    }

    public static void openWordFileOnButton(Button button){
        button.setOnAction(event -> {
            CreateAndOpenFileWord.workerFileWord();
            if (StageWorkerSMC.getSettingStage() != null && StageWorkerSMC.getSettingStage() .isShowing()){
                StageWorkerSMC.getSettingStage().close();
            }
            showTasksInfo();
            openWindowCorrect();
            openWindowResultTask();
        });
    }

    public static void closeInfo(Button button){
        button.setOnAction(event -> {
            StageWorkerSMC.getInfoTasksSave().close();
        });
    }

    private static void openWindowCorrect(){
        try {
            FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(FXMLPath.WINDOW_IS_CORRECT));
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
            currectStage.initOwner(StageWorkerSMC.getPrimaryStage());
            currectStage.initStyle(StageStyle.UNDECORATED);
            currectStage.initModality(Modality.WINDOW_MODAL);
            Scene newScene = new Scene(newRoot);
            newScene.setFill(Color.TRANSPARENT);
            currectStage.setScene(newScene);
            currectStage.initStyle(StageStyle.TRANSPARENT);
            StageWorkerSMC.setCurrectSaveStage(currectStage);
            StageWorkerSMC.getPrimaryStage().hide();
            currectStage.show();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void switchTasksInfo(Button button, String path) {
        button.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(path));
                Parent newRoot = loader.load();
                Stage infoTaskStage = new Stage();
                infoTaskStage.setAlwaysOnTop(true);
                infoTaskStage.initOwner(StageWorkerSMC.getPrimaryStage());
                infoTaskStage.initStyle(StageStyle.UNDECORATED);
                infoTaskStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(newRoot);
                scene.setFill(Color.TRANSPARENT);
                infoTaskStage.setScene(scene);
                infoTaskStage.initStyle(StageStyle.TRANSPARENT);

                StageWorkerSMC.setInfoTasksSave(infoTaskStage);
                infoTaskStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void showTasksInfo(){
        try {
            FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(FXMLPath.WINDOW_TASK_IS_CORRECT));
            Parent newRoot = loader.load();
            Stage infoTaskStage = new Stage();
            infoTaskStage.setAlwaysOnTop(true);
            infoTaskStage.initOwner(StageWorkerSMC.getPrimaryStage());
            infoTaskStage.initStyle(StageStyle.UNDECORATED);
            infoTaskStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(newRoot);
            scene.setFill(Color.TRANSPARENT);
            infoTaskStage.setScene(scene);
            infoTaskStage.initStyle(StageStyle.TRANSPARENT);

            StageWorkerSMC.setInfoTasksSave(infoTaskStage);
            infoTaskStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void quitTask(Button button){
        button.setOnAction(event -> {
            try{
                StageWorkerSMC.getCurrectSaveStage().setAlwaysOnTop(false);
                StageWorkerSMC.getInfoTasksSave().hide();
                StageWorkerSMC.getCurrectSaveStage().hide();
                StageWorkerSMC.getResultSaveStage().hide();
                StageWorkerSMC.getPrimaryStage().show();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        });
    }

    public static void quitTaskWin(Button button){
        button.setOnAction(event -> {
            try{
                StageWorkerSMC.getCurrectSaveStage().setAlwaysOnTop(false);
                StageWorkerSMC.getWinSaveStage().hide();
                StageWorkerSMC.getCurrectSaveStage().hide();
                StageWorkerSMC.getResultSaveStage().hide();
                StageWorkerSMC.getPrimaryStage().show();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        });

    }

    private static void openWindowResultTask(){
        try {
            FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(FXMLPath.WINDOW_TASKS_RESULT));
            Parent newRoot = loader.load();
            Stage resultStage = new Stage();
            resultStage.setAlwaysOnTop(true);

            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            double screenWidth = primaryScreenBounds.getWidth();
            double screenHeight = primaryScreenBounds.getHeight();

            double x = screenWidth - 1500; // Координата x для правого края
            double y = screenHeight - 620; // Координата y для нижнего края

            resultStage.setX(x);
            resultStage.setY(y);
            resultStage.setResizable(false);
            resultStage.initOwner(StageWorkerSMC.getPrimaryStage());
            resultStage.initStyle(StageStyle.UNDECORATED);
            resultStage.initModality(Modality.WINDOW_MODAL);
            Scene newScene = new Scene(newRoot);
            newScene.setFill(Color.TRANSPARENT);
            resultStage.setScene(newScene);
            resultStage.initStyle(StageStyle.TRANSPARENT);
            StageWorkerSMC.setResultSaveStage(resultStage);
            resultStage.show();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void checkTasks(Button button){
        button.setOnAction(event -> {
            saveFailStage();
            saveWinStage();
            WorkerCheckTask.checkTaskDocument(StageWorkerSMC.getWinSaveStage(), StageWorkerSMC.getFailSaveStage());
        });
    }

    private static void saveWinStage(){
        try {
            FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(FXMLPath.WINDOW_IS_CORRECT_WIN));
            Parent newRoot = loader.load();
            Stage winStage = new Stage();
            winStage.setAlwaysOnTop(true);
            winStage.initOwner(StageWorkerSMC.getPrimaryStage());
            winStage.initStyle(StageStyle.UNDECORATED);
            winStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(newRoot);
            scene.setFill(Color.TRANSPARENT);
            winStage.setScene(scene);
            winStage.initStyle(StageStyle.TRANSPARENT);

            StageWorkerSMC.setWinSaveStage(winStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveFailStage(){
        try {
            FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(FXMLPath.WINDOW_IS_CORRECT_DRAW));
            Parent newRoot = loader.load();
            Stage failStage = new Stage();
            failStage.setAlwaysOnTop(true);
            failStage.initOwner(StageWorkerSMC.getPrimaryStage());
            failStage.initStyle(StageStyle.UNDECORATED);
            failStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(newRoot);
            scene.setFill(Color.TRANSPARENT);
            failStage.setScene(scene);
            failStage.initStyle(StageStyle.TRANSPARENT);

            StageWorkerSMC.setFailSaveStage(failStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeFailWindow(Button button){
        button.setOnAction(event -> {
            StageWorkerSMC.getFailSaveStage().hide();
        });
    }

    public static void nextTask(Button button){
        button.setOnAction(event -> {
            String nextTaskUrl = "Word_" + (Integer.parseInt(GlobalTasks.globalTasks.idForNumberString()) + 1);
            System.out.println(nextTaskUrl);
            try {
                TaskWorkerSMC.getTasksInfoForDB(nextTaskUrl);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            StageWorkerSMC.getWinSaveStage().hide();
            TaskWorkerSMC.updateTaskInfo();
        });
    }

    public static void switchSettingsGame(Button button, String path, int idGame) {
        button.setOnAction(event -> {
            try {
                GameWorkerSMC.getGameInfoForDB(idGame);
                FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(path));
                Parent newRoot = loader.load();
                Stage settingsGame = new Stage();
                settingsGame.initOwner(StageWorkerSMC.getPrimaryStage());
                settingsGame.initStyle(StageStyle.UNDECORATED);
                settingsGame.initModality(Modality.WINDOW_MODAL);
                Scene scene = new Scene(newRoot);
                scene.setFill(Color.TRANSPARENT);
                settingsGame.setScene(scene);
                settingsGame.initStyle(StageStyle.TRANSPARENT);

                StageWorkerSMC.setSettingStageGame(settingsGame);
                settingsGame.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

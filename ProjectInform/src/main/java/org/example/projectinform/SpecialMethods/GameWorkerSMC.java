package org.example.projectinform.SpecialMethods;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.projectinform.DBRepository.GameDBRepositoryController;
import org.example.projectinform.DBRepository.StudentDBRepositoryController;
import org.example.projectinform.Dictionaries.FXMLPath;
import org.example.projectinform.GlobalEntity.GlobalGame;
import org.example.projectinform.GlobalEntity.GlobalStudentUser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class GameWorkerSMC {

    public static void startGame(){
        String relativePath = GlobalGame.globalGame.getUrlGame();
        File gameFile = new File(relativePath);
        if (gameFile.exists()) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(relativePath);
                processBuilder.start();
                updateResultGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Не удается найти указанный файл: " + relativePath);
        }
    }

    public static void enterInGame(Button button){
        button.setOnAction(event -> {
            if (GlobalGame.globalGame.getCountCoins() < GlobalStudentUser.globalStudent.getCountCoins() && !GlobalGame.globalGame.getUrlGame().isEmpty()){
                GlobalStudentUser.globalStudent.setCountCoins(GlobalStudentUser.globalStudent.getCountCoins() - GlobalGame.globalGame.getCountCoins());
                try {
                    ViewCountCoinsSMC.updateStudentCoins();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                startGame();
                StageWorkerSMC.getSettingStageGame().hide();
            } else {
                StageWorkerSMC.getSettingStageGame().hide();
                if (StageWorkerSMC.getFailGameEnterSaveStage() == null){
                    saveFailGameStage();
                }
                StageWorkerSMC.getFailGameEnterSaveStage().show();
            }
        });
    }

    private static void saveFailGameStage(){
        try {
            FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(FXMLPath.WINDOW_GAME_NOT_ENOUGH_COINS));
            Parent newRoot = loader.load();
            Stage failGameStage = new Stage();
            failGameStage.setAlwaysOnTop(true);
            failGameStage.initOwner(StageWorkerSMC.getPrimaryStage());
            failGameStage.initStyle(StageStyle.UNDECORATED);
            failGameStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(newRoot);
            scene.setFill(Color.TRANSPARENT);
            failGameStage.setScene(scene);
            failGameStage.initStyle(StageStyle.TRANSPARENT);

            StageWorkerSMC.setFailGameEnterSaveStage(failGameStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getResultFromFile(){
        String filePath = GlobalGame.globalGame.getUrlResult();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                try {
                    int number = Integer.parseInt(line);
                    System.out.println("Number read from file: " + number);
                    return number;
                } catch (NumberFormatException e) {
                    System.err.println("Error: Unable to parse number from file");
                }
            } else {
                System.err.println("Error: File is empty");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return 0;
    }

    private static void updateResultGame(){
        StudentDBRepositoryController dbRepositoryController = new StudentDBRepositoryController();

        try {
            dbRepositoryController.connect();
            System.out.println("connect");
            dbRepositoryController.updateStudentResultDragonPicker(GlobalStudentUser.globalStudent.getId(), getResultFromFile());
            dbRepositoryController.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void getGameInfoForDB(int id) throws Exception {
        getGameInfoForDBConnect(id);
    }

    private static void getGameInfoForDBConnect(int id) throws Exception {

        GameDBRepositoryController dbRepositoryController = new GameDBRepositoryController();
        dbRepositoryController.connect();
        GlobalGame.globalGame = dbRepositoryController.getGameById(id);
        dbRepositoryController.close();

    }

}

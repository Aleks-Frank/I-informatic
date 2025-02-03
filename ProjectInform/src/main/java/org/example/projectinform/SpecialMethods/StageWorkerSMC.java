package org.example.projectinform.SpecialMethods;

import javafx.stage.Stage;
import lombok.Data;

@Data
public class StageWorkerSMC {

    private static Stage primaryStage;

    private static Stage settingStage;

    private static Stage infoTasksSave;

    private static Stage currectSaveStage;

    private static Stage resultSaveStage;

    private static Stage winSaveStage;

    private static Stage failSaveStage;

    private static Stage settingStageGame;

    private static Stage failGameEnterSaveStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        StageWorkerSMC.primaryStage = primaryStage;
    }

    public static Stage getSettingStage() {
        return settingStage;
    }

    public static void setSettingStage(Stage settingStage) {
        StageWorkerSMC.settingStage = settingStage;
    }

    public static Stage getInfoTasksSave() {
        return infoTasksSave;
    }

    public static void setInfoTasksSave(Stage infoTasksSave) {
        StageWorkerSMC.infoTasksSave = infoTasksSave;
    }

    public static Stage getCurrectSaveStage() {
        return currectSaveStage;
    }

    public static void setCurrectSaveStage(Stage currectSaveStage) {
        StageWorkerSMC.currectSaveStage = currectSaveStage;
    }

    public static Stage getResultSaveStage() {
        return resultSaveStage;
    }

    public static void setResultSaveStage(Stage resultSaveStage) {
        StageWorkerSMC.resultSaveStage = resultSaveStage;
    }

    public static Stage getWinSaveStage() {
        return winSaveStage;
    }

    public static void setWinSaveStage(Stage winSaveStage) {
        StageWorkerSMC.winSaveStage = winSaveStage;
    }

    public static Stage getFailSaveStage() {
        return failSaveStage;
    }

    public static void setFailSaveStage(Stage failSaveStage) {
        StageWorkerSMC.failSaveStage = failSaveStage;
    }

    public static Stage getSettingStageGame() {
        return settingStageGame;
    }

    public static void setSettingStageGame(Stage settingStageGame) {
        StageWorkerSMC.settingStageGame = settingStageGame;
    }

    public static Stage getFailGameEnterSaveStage() {
        return failGameEnterSaveStage;
    }

    public static void setFailGameEnterSaveStage(Stage failGameEnterSaveStage) {
        StageWorkerSMC.failGameEnterSaveStage = failGameEnterSaveStage;
    }
}

package org.example.projectinform.SpecialMethods;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.projectinform.DBRepository.TasksDBRepositoryController;
import org.example.projectinform.GlobalEntity.GlobalTasks;
import org.example.projectinform.WorkerTasksResult.WorkerTasksResult;

import java.io.IOException;
import java.text.MessageFormat;

public class TaskWorkerSMC {

    public static void switchInfoWord(Button button, String path, String id) {
        button.setOnAction(event -> {
            try {
                getTasksInfoForDB(id);
                FXMLLoader loader = new FXMLLoader(SwitchWindowSMC.class.getResource(path));
                Parent newRoot = loader.load();
                Stage infoTaskStage = new Stage();
                infoTaskStage.initOwner(StageWorkerSMC.getPrimaryStage());
                infoTaskStage.initStyle(StageStyle.UNDECORATED);
                infoTaskStage.initModality(Modality.WINDOW_MODAL);
                Scene scene = new Scene(newRoot);
                infoTaskStage.setScene(scene);

                scene.setFill(Color.TRANSPARENT);
                infoTaskStage.setScene(scene);
                infoTaskStage.initStyle(StageStyle.TRANSPARENT);

                StageWorkerSMC.setInfoTasksSave(infoTaskStage);
                infoTaskStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void getTasksInfoForDB(String id) throws Exception {
        getTasksInfoForDBConnect(id);
    }

    private static void getTasksInfoForDBConnect(String id) throws Exception {

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

    public static void setTasksInfo(Label label){
        label.setText(GlobalTasks.globalTasks.getTasks());
    }

    public static void updateTaskInfo() {
        TextFlow textFlow = findTextFlow(StageWorkerSMC.getResultSaveStage().getScene().getRoot());
        if (textFlow != null) {
            textFlow.getChildren().clear();
            WorkerTasksResult.viewTasksResult(textFlow);
        } else {
            System.out.println("TextFlow not found in scene graph");
        }
    }

    private static TextFlow findTextFlow(Parent parent) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node instanceof TextFlow) {
                return (TextFlow) node;
            } else if (node instanceof Parent) {
                TextFlow textFlow = findTextFlow((Parent) node);
                if (textFlow != null) {
                    return textFlow;
                }
            }
        }
        return null;
    }

}

package org.example.projectinform.SpecialMethods;

import javafx.scene.control.Label;
import org.example.projectinform.DBRepository.StudentDBRepositoryController;
import org.example.projectinform.GlobalEntity.GlobalStudentUser;
import org.example.projectinform.GlobalEntity.GlobalTasks;

import java.sql.SQLException;
import java.text.MessageFormat;

public class ViewCountCoinsSMC {

    public static void viewCountCoins(Label label){
        label.setText(String.valueOf(GlobalStudentUser.globalStudent.getCountCoins()));
    }

    public static void setCountInfoCoinsToWin(Label coinsToWin){
        coinsToWin.setText(MessageFormat.format("Ты получил {0} инфокойнов", GlobalTasks.globalTasks.getCountCoins()));
    }

    public static void updateStudentCoins() throws SQLException {
        updateStudentCoinsForDB();
    }

    public static void updateStudentCoinsForDB() throws SQLException {
        StudentDBRepositoryController dbRepositoryController = new StudentDBRepositoryController();

        dbRepositoryController.connect();
        dbRepositoryController.updateStudentCountCoins(GlobalStudentUser.globalStudent.getId(), GlobalStudentUser.globalStudent.getCountCoins());
        try {
            dbRepositoryController.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

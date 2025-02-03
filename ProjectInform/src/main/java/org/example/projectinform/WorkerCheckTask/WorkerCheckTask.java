package org.example.projectinform.WorkerCheckTask;

import javafx.stage.Stage;
import org.example.projectinform.GlobalEntity.*;
import org.example.projectinform.SpecialMethods.SwitchWindowSMC;
import org.example.projectinform.SpecialMethods.ViewCountCoinsSMC;
import org.example.projectinform.TasksChecking.*;

import java.io.IOException;
import java.sql.SQLException;

import static org.example.projectinform.TasksChecking.AllTasksChecking.*;


public class WorkerCheckTask {

    static String nameUser = GlobalStudentUser.getFirstName();
    static String lastNameUser = GlobalStudentUser.getLastName();

    public static void checkTaskDocument(Stage stageWin, Stage stageFail){
        boolean result;
        try {
            result = checkFileWord(getUrlUserFile(), getUrlCorrectFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (result) {
            stageWin.show();
            GlobalStudentUser.setCountCoins(GlobalStudentUser.getCountCoins() + GlobalTasks.globalTasks.getCountCoins());
            try {
                ViewCountCoinsSMC.updateStudentCoins();
            } catch (SQLException e) {
                System.out.println("Инфокойны не сохранились");
            }
        } else {
            stageFail.show();
        }
    }

    public static boolean checkFileWord(String filePath1, String filePath2) throws IOException {
        return checker(filePath1, filePath2);
    }

    public static String getUrlUserFile(){
        return "resources/File/File_" + nameUser + "_" + lastNameUser + ".docx";
    }

    public static String getUrlCorrectFile(){
        return GetUrlCorrectFile.getUrlCorrectFile();
    }

}

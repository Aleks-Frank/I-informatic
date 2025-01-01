package org.example.projectinform.WorkerCheckTask;

import com.spire.doc.Document;
import javafx.stage.Stage;
import org.example.projectinform.GlobalEntity.GlobalStudentUser;
import org.example.projectinform.GlobalEntity.GlobalTasks;


public class WorkerCheckTask {

    static String nameUser = GlobalStudentUser.globalStudent.getFirstName();
    static String lastNameUser = GlobalStudentUser.globalStudent.getLastName();
    static String nameTasks = GlobalTasks.globalTasks.getResult();

    public static void checkTaskDocument(Stage stageWin, Stage stageFail){

        boolean result = checkFileWord();

        System.out.println(result);

        if(!result){
            stageWin.show();
        } else {
            stageFail.show();
        }
    }

    private static Boolean checkFileWord(){
        Document userDoc = new Document(getUrlUserFile());
        Document correctDoc = new Document(getUrlCorrectFile());

        return !userDoc.getText().equals(correctDoc.getText());
    }

    private static String getUrlUserFile(){
        return "src/main/resources/File/File_" + nameUser + "_" + lastNameUser + ".docx";
    }

    private static String getUrlCorrectFile(){
        return "src/main/resources/FileCor/" + nameTasks + ".docx";
    }

}

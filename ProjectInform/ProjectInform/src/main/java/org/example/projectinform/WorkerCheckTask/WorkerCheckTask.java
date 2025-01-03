package org.example.projectinform.WorkerCheckTask;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.documents.comparison.CompareOptions;
import com.spire.doc.fields.Comment;
import javafx.stage.Stage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.example.projectinform.GlobalEntity.GlobalStudentUser;
import org.example.projectinform.GlobalEntity.GlobalTasks;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.projectinform.TasksChecking.AllTasksChecking.*;


public class WorkerCheckTask {

    static String nameUser = GlobalStudentUser.globalStudent.getFirstName();
    static String lastNameUser = GlobalStudentUser.globalStudent.getLastName();
    static String nameTasks = GlobalTasks.globalTasks.getResult();

    public static void checkTaskDocument(Stage stageWin, Stage stageFail){
        boolean result;
        try {
            result = checkFileWord(getUrlUserFile(), getUrlCorrectFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(result){
            stageWin.show();
        } else {
            stageFail.show();
        }
    }

    public static boolean checkFileWord(String filePath1, String filePath2) throws IOException {
        return checker(filePath1, filePath2);
    }

    private static String getUrlUserFile(){
        return "src/main/resources/File/File_" + nameUser + "_" + lastNameUser + ".docx";
    }

    private static String getUrlCorrectFile(){
        return "src/main/resources/FileCor/" + nameTasks + ".docx";
    }

}

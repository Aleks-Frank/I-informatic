package org.example.projectinform.FileWorker;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.example.projectinform.GlobalEntity.GlobalStudentUser;

import java.io.File;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateAndOpenFileWord {

    private static String nameUser;

    private static String urlFile;

    private static String lastNameUser;

    public static void workerFileWord(){

        nameUser = GlobalStudentUser.globalStudent.getFirstName();
        lastNameUser = GlobalStudentUser.globalStudent.getLastName();
        urlFile = "src/main/resources/File/File_" + nameUser + "_" + lastNameUser + ".docx";
        File file = new File(urlFile);

        if (file.exists()){
            openWordFile();
        } else {
            createNewWordFile();
        }

    }

    private static void createNewWordFile(){

        XWPFDocument document = new XWPFDocument();

        try (FileOutputStream fileOutputStream = new FileOutputStream(urlFile)){
            document.write(fileOutputStream);
            openWordFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void openWordFile(){

        File file = new File(urlFile);

        try{
            Desktop.getDesktop().open(file);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }

}

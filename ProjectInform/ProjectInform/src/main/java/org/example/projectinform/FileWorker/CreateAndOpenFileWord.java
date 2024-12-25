package org.example.projectinform.FileWorker;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateAndOpenFileWord {

    private static final String urlFile = "src/main/resources/File/file.docx";

    public static void createNewWordFile(){

        XWPFDocument document = new XWPFDocument();

        try (FileOutputStream fileOutputStream = new FileOutputStream(urlFile)){
            document.write(fileOutputStream);
            openWordFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void openWordFile(){

        File file = new File(urlFile);

        try{
            Desktop.getDesktop().open(file);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }

}

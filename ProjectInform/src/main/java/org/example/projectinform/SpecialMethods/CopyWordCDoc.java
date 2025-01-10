package org.example.projectinform.SpecialMethods;

import org.apache.poi.xwpf.usermodel.*;
import org.example.projectinform.WorkerCheckTask.WorkerCheckTask;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyWordCDoc {

    public static void copyFileWord(){
        try {
            // Открываем первый документ, из которого будем копировать содержимое
            FileInputStream fisSource = new FileInputStream(WorkerCheckTask.getUrlCorrectFile() + "_2");
            XWPFDocument docSource = new XWPFDocument(fisSource);

            // Открываем второй документ, в который будем вставлять содержимое
            FileInputStream fisDestination = new FileInputStream(WorkerCheckTask.getUrlUserFile());
            XWPFDocument docDestination = new XWPFDocument(fisDestination);

            // Копируем параграфы из первого документа
            for (XWPFParagraph paragraph : docSource.getParagraphs()) {
                XWPFParagraph newParagraph = docDestination.createParagraph();
                for (XWPFRun run : paragraph.getRuns()) {
                    XWPFRun newRun = newParagraph.createRun();
                    newRun.setText(run.getText(0));
                }
            }

            // Копируем таблицы из первого документа
            for (XWPFTable table : docSource.getTables()) {
                XWPFTable newTable = docDestination.createTable();
                for (XWPFTableRow row : table.getRows()) {
                    XWPFTableRow newRow = newTable.createRow();
                    for (XWPFTableCell cell : row.getTableCells()) {
                        XWPFTableCell newCell = newRow.createCell();
                        newCell.setText(cell.getText());
                    }
                }
            }

            // Сохраняем изменения во втором документе
            FileOutputStream fos = new FileOutputStream(WorkerCheckTask.getUrlUserFile());
            try {
                docDestination.write(fos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Закрываем потоки
            fisSource.close();
            fisDestination.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

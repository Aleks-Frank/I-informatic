package org.example.projectinform.WorkerasksResult;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkerTasksResult {

    public static void viewTasksResult(TextFlow textFlow) {
        try {
            InputStream fis = WorkerTasksResult.class.getResourceAsStream("/FileCor/TaskOne.docx");
            XWPFDocument document = new XWPFDocument(fis);

            System.out.println("Non");

            List<XWPFParagraph> paragraphs = getXwpfParagraphs(document, textFlow);

            System.out.println(paragraphs);

//            List<String> textLines = new ArrayList<>(); // Создание списка строк
//            for (XWPFParagraph paragraph : document.getParagraphs()) {
//                for (XWPFRun run : paragraph.getRuns()) {
//                    String textContent = run.text();
//                    String[] lines = textContent.split("\\r?\\n"); // Разделение текста на строки по символу новой строки
//                    textLines.addAll(Arrays.asList(lines)); // Добавление строк в список
//                }
//            }
//
//            for (String line : textLines) {
//                Text text = new Text(line);
//
//                // Получение стиля текста из первого XWPFRun в параграфе
//                XWPFParagraph firstParagraph = document.getParagraphs().get(0);
//                XWPFRun firstRun = firstParagraph.getRuns().get(0);
//                String fontFamily = firstRun.getFontFamily();
//                int fontSize = firstRun.getFontSize();
//                boolean isBold = firstRun.isBold();
//                boolean isItalic = firstRun.isItalic();
//                boolean isUnderline = firstRun.getUnderline() != UnderlinePatterns.NONE;
//
//                text.setFont(Font.font(fontFamily, fontSize));
//                text.setStyle("-fx-font-weight: " + (isBold ? "bold" : "normal") + ";");
//                text.setStyle("-fx-font-style: " + (isItalic ? "italic" : "normal") + ";");
//                text.setStyle("-fx-underline: " + (isUnderline ? "underline" : "none") + ";");
//
//                textFlow.getChildren().add(text);
//                textFlow.getChildren().add(new Text("\n")); // Добавление новой строки
//            }

            fis.close();
            System.out.println("Non_2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<XWPFParagraph> getXwpfParagraphs(XWPFDocument document, TextFlow textFlow) {
        List<XWPFParagraph> paragraphs = new ArrayList<>(document.getParagraphs());
        for (XWPFParagraph paragraph : paragraphs){
            Text text = new Text();

            XWPFRun firstRun = paragraph.getRuns().get(0);
            String fontFamily = firstRun.getFontFamily();
            int fontSize = firstRun.getFontSize();
            boolean isBold = firstRun.isBold();
            boolean isItalic = firstRun.isItalic();
            boolean isUnderline = firstRun.getUnderline() != UnderlinePatterns.NONE;

            text.setFont(Font.font(fontFamily, fontSize));
            text.setStyle("-fx-font-weight: " + (isBold ? "bold" : "normal") + ";");
            text.setStyle("-fx-font-style: " + (isItalic ? "italic" : "normal") + ";");
            text.setStyle("-fx-underline: " + (isUnderline ? "underline" : "none") + ";");

            textFlow.getChildren().add(text);
            textFlow.getChildren().add(new Text("\n"));
        }
        return paragraphs;
    }

}

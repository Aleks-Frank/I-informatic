package org.example.projectinform.WorkerTasksResult;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.IOException;
import java.io.InputStream;

public class WorkerTasksResult {

    public static void viewTasksResult(TextFlow textFlow) {
        XWPFDocument document = null;
        try {
            InputStream inputStream = WorkerTasksResult.class.getResourceAsStream("/FileCor/TaskOne.docx");
            document = new XWPFDocument(inputStream);

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                StringBuilder sb = new StringBuilder();
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.text();
                    sb.append(text);
                }
                String fullText = sb.toString();

                String fontFamily = paragraph.getRuns().get(0).getFontFamily();
                int fontSize = paragraph.getRuns().get(0).getFontSize();

                setTextFlow(textFlow, fullText, fontFamily, fontSize);
            }

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setTextFlow(TextFlow textFlow, String text, String fontFamily, int fontSize) {
        String[] lines = text.split("\\r?\\n");
        for (String line : lines) {
            Text textNode = new Text(line);
            textNode.setFont(Font.font(fontFamily, fontSize));
            textFlow.getChildren().add(textNode);
            textFlow.getChildren().add(new Text("\n"));
        }
    }

}

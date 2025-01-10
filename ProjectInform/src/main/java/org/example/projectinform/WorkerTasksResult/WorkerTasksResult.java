package org.example.projectinform.WorkerTasksResult;

import javafx.scene.paint.Color;
import javafx.scene.text.*;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.example.projectinform.TasksChecking.GetUrlCorrectFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.example.projectinform.TasksChecking.AllTasksChecking.*;

public class WorkerTasksResult {

    public static void viewTasksResult(TextFlow textFlow) {
        try {
            List<String> fontParagraphs = checkFontParagraphsInDocx(GetUrlCorrectFile.getUrlCorrectFile());
            System.out.println(fontParagraphs);
            List<Double> sizeFontParagraphs = checkSizeFontParagraphsInDocx(GetUrlCorrectFile.getUrlCorrectFile());
            System.out.println(sizeFontParagraphs);
            List<Boolean> boldParagraphs = checkBoldParagraphsInDocx(GetUrlCorrectFile.getUrlCorrectFile());
            System.out.println(boldParagraphs);
            List<String> colorParagraphs = checkColorParagraphsInDocx(GetUrlCorrectFile.getUrlCorrectFile());
            List<UnderlinePatterns> underlineParagraphs = checkUnderLineParagraphsInDocx(GetUrlCorrectFile.getUrlCorrectFile());

            try (FileInputStream fis = new FileInputStream(GetUrlCorrectFile.getUrlCorrectFile());
                 XWPFDocument doc = new XWPFDocument(fis)) {

                List<XWPFParagraph> paragraphs = doc.getParagraphs();

                for (int i = 0; i < paragraphs.size(); i++) {
                    String fontFamily = fontParagraphs.get(i);
                    int fontSize = sizeFontParagraphs.get(i).intValue();
                    boolean isBold = boldParagraphs.get(i);
                    String paragraphText = paragraphs.get(i).getText();
                    String colorText = colorParagraphs.get(i);
                    UnderlinePatterns underlineText = underlineParagraphs.get(i);

                    setTextFlow(textFlow, paragraphText, fontFamily, fontSize, isBold, colorText);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setTextFlow(TextFlow textFlow, String text, String fontFamily, int fontSize, boolean isBold,
                                    String colorText) {
        Text textNode = new Text(text);
        textNode.setFont(Font.font(fontFamily, isBold ? FontWeight.BOLD : FontWeight.NORMAL, FontPosture.REGULAR, fontSize));
        textNode.setFill(Color.web(colorText));
        textFlow.getChildren().add(textNode);
        textFlow.getChildren().add(new Text("\n"));
    }

}

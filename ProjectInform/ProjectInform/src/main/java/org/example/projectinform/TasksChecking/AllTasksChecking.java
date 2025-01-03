package org.example.projectinform.TasksChecking;

import com.j256.ormlite.stmt.query.In;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllTasksChecking {

    public static boolean checker(String urlFileUser, String urlFileCorrect){
        try {
            return extractTextFromDocx(urlFileUser).equals(extractTextFromDocx(urlFileCorrect)) &&
                    Arrays.equals(new List[]{checkBoldParagraphsInDocx(urlFileUser)}, new List[]{checkBoldParagraphsInDocx(urlFileCorrect)}) &&
                    Arrays.equals(new List[]{checkSizeFontParagraphsInDocx(urlFileUser)}, new List[]{checkSizeFontParagraphsInDocx(urlFileCorrect)}) &&
                    Arrays.equals(new List[]{checkFontParagraphsInDocx(urlFileUser)}, new List[]{checkFontParagraphsInDocx(urlFileCorrect)});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String extractTextFromDocx(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis)) {

            StringBuilder textBuilder = new StringBuilder();
            document.getParagraphs().forEach(paragraph -> textBuilder.append(paragraph.getText()).append("\n"));

            return textBuilder.toString().trim();
        }
    }

    public static List<String> checkFontParagraphsInDocx(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis)) {

            List<String> fontParagraphs = new ArrayList<>();

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                String fontName = "";

                for (XWPFRun run : paragraph.getRuns()) {
                    fontName = run.getFontName();
                }
                fontParagraphs.add(fontName);
            }
            return fontParagraphs;
        }
    }

    public static List<Double> checkSizeFontParagraphsInDocx(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis)) {

            List<Double> sizeFontParagraphs = new ArrayList<>();

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                double sizeFont = 0;

                for (XWPFRun run : paragraph.getRuns()) {
                    sizeFont = run.getFontSizeAsDouble();
                }
                sizeFontParagraphs.add(sizeFont);
            }
            return sizeFontParagraphs;
        }
    }

    public static List<Boolean> checkBoldParagraphsInDocx(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis)) {

            List<Boolean> boldParagraphs = new ArrayList<>();

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                boolean isBold = false;

                for (XWPFRun run : paragraph.getRuns()) {
                    if (run.isBold()) {
                        isBold = true;
                        break;
                    }
                }
                boldParagraphs.add(isBold);
            }
            return boldParagraphs;
        }
    }

}

package org.example.projectinform.TasksChecking;

import com.j256.ormlite.stmt.query.In;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

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
                    Arrays.equals(new List[]{checkFontParagraphsInDocx(urlFileUser)}, new List[]{checkFontParagraphsInDocx(urlFileCorrect)}) &&
                    Arrays.equals(new List[]{checkColorParagraphsInDocx(urlFileUser)}, new List[]{checkColorParagraphsInDocx(urlFileCorrect)}) &&
                    Arrays.equals(new List[]{checkUnderLineParagraphsInDocx(urlFileUser)}, new List[]{checkUnderLineParagraphsInDocx(urlFileCorrect)});
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
                    System.out.println(run);
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

    public static List<String> checkColorParagraphsInDocx(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis)) {

            List<String> colorParagraphs = new ArrayList<>();

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                String colorName = "";

                for (XWPFRun run : paragraph.getRuns()) {
                    colorName = run.getColor();
                }
                colorParagraphs.add(colorName);
            }
            return colorParagraphs;
        }
    }

    public static List<UnderlinePatterns> checkUnderLineParagraphsInDocx(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis)) {

            List<UnderlinePatterns> underLineParagraphs = new ArrayList<>();

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                UnderlinePatterns underLineName = null;

                for (XWPFRun run : paragraph.getRuns()) {
                    underLineName = run.getUnderline();
                    System.out.println(run);
                }
                underLineParagraphs.add(underLineName);
            }
            System.out.println(underLineParagraphs);
            return underLineParagraphs;
        }
    }

//    public static List<String> checkHighlightColorParagraphsInDocx(String filePath) throws IOException {
//        try (FileInputStream fis = new FileInputStream(filePath);
//             XWPFDocument document = new XWPFDocument(fis)) {
//
//            List<String> highlightColors = new ArrayList<>();
//
//            for (XWPFParagraph paragraph : document.getParagraphs()) {
//                String highlightColor = "";
//
//                for (XWPFRun run : paragraph.getRuns()) {
//                    if (run.isHighlighted()) {
//                        highlightColor = getHighlightColor(run);
//                        break;
//                    }
//                }
//                highlightColors.add(highlightColor);
//            }
//            return highlightColors;
//        }
//    }
//
//    private static String getHighlightColor(XWPFRun run) {
//        String hexColor = "";
//        CTHighlight highlight = (CTHighlight) run.getCTR().getPictList();
//        if (highlight != null) {
//            hexColor = highlight.getVal().toString();
//        }
//        System.out.println(hexColor);
//        return hexColor;
//    }
}

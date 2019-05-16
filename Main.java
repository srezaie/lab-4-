package com.company;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Main{
    public static void main(String[] args){
        try {
            PdfReader pdfReader = new PdfReader("C:\\Users\\MyPc\\IdeaProjects\\session4\\src\\com\\company\\Final-Project.pdf");
            int p = pdfReader.getNumberOfPages();
            System.out.println(p);
            for (int i=1; i<=p; i++) {
                String pageContent = PdfTextExtractor.getTextFromPage(pdfReader, i);
                System.out.println("Content on Page " + i + ": " + pageContent);
            }
            Document document = new Document();
            OutputStream outputStream =
                    new FileOutputStream(new File("C:\\Users\\MyPc\\IdeaProjects\\session4\\MyFile.pdf"));
            PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(new Paragraph("Hello world!, " +
                    "New pdf file created."));
            document.close();
            outputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

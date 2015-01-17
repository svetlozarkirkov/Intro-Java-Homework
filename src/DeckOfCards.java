import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
public class DeckOfCards {
 
    public static final String RESULT = "Deck-Of-Cards.pdf";
 
    public void createPdf(String filename) throws IOException, DocumentException {
    	String[] numbers = { "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        String[] letters = { "J", "Q", "K", "A" };
        String[] colors = { "\u00A7", "\u00A8", "\u00A9", "\u00AA" };
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();    
        Font symbols = new Font(Font.FontFamily.SYMBOL  , 12, Font.BOLD);
        Font normal = new Font(Font.FontFamily.HELVETICA,12,Font.BOLD);
        Font normalRed = new Font(Font.FontFamily.HELVETICA,12,Font.BOLD,BaseColor.RED);
        Font symbolsRed = new Font(Font.FontFamily.SYMBOL,12,Font.BOLD,BaseColor.RED);
        int widthPerc = 52;
        
        for (int i = 0; i < numbers.length;i++) {
        	PdfPTable table = new PdfPTable(8);
            table.setWidthPercentage(widthPerc);
        	for (int j = 0; j < colors.length; j++) {
                PdfPCell cell = new PdfPCell();
                Paragraph comb = new Paragraph();
                if (j == 1 || j == 2) {
                	Paragraph first = new Paragraph(numbers[i],normalRed);
            		Paragraph second = new Paragraph(colors[j],symbolsRed);
            		comb.add(first); 
            	    comb.add(second); 
                }
                else {
                	Paragraph first = new Paragraph(numbers[i],normal);
            		Paragraph second = new Paragraph(colors[j],symbols);
            		comb.add(first); 
            	    comb.add(second); 
                }      		
        		cell = new PdfPCell(comb);
        		cell.setFixedHeight(48f);
        		cell.setBorderWidth(1);
        		cell.setBorderColor(BaseColor.DARK_GRAY);
        		cell.setPaddingTop(16);
        		cell.setPaddingLeft(7);
        		Paragraph bord = new Paragraph(" ");
        		PdfPCell border = new PdfPCell(bord);
        		border.setBorderColor(BaseColor.WHITE);
        		border.setBorderWidth(0);
        		table.addCell(cell);
        		table.addCell(border);
        		table.setSpacingAfter(10);    
        	}
        	document.add(table);
        }
        for (int i = 0; i < letters.length;i++) {
        	PdfPTable table = new PdfPTable(8);
            table.setWidthPercentage(widthPerc);
        	for (int j = 0; j < colors.length; j++) {
                PdfPCell cell = new PdfPCell();
                Paragraph comb = new Paragraph();
                if (j == 1 || j == 2) {
                	Paragraph first = new Paragraph(letters[i],normalRed);
            		Paragraph second = new Paragraph(colors[j],symbolsRed);
            		comb.add(first); 
            	    comb.add(second); 
                }
                else {
                	Paragraph first = new Paragraph(letters[i],normal);
            		Paragraph second = new Paragraph(colors[j],symbols);
            		comb.add(first); 
            	    comb.add(second); 
                }	        		
        		cell = new PdfPCell(comb);
        		cell.setFixedHeight(48f);
        		cell.setBorderWidth(1);
        		cell.setPaddingTop(16);
        		cell.setPaddingLeft(7);     		
        		Paragraph bord = new Paragraph(" ");
        		PdfPCell border = new PdfPCell(bord);
        		border.setBorderColor(BaseColor.WHITE);
        		border.setBorderWidth(0);
        		table.addCell(cell);
        		table.addCell(border);
        		table.setSpacingAfter(10); 
        	}
        	document.add(table);
        }       
        document.close();
    }
    public static void main(String[] args)
        throws IOException, DocumentException {
        new DeckOfCards().createPdf(RESULT);
    }
}
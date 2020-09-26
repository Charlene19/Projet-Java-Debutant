package pdfTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.TextElementArray;
import com.lowagie.text.pdf.PdfWriter;

import swingLib.orderManager;

 public  class TestIText1 {

	/**
	 * @param args
	 */
	public TestIText1() {
		  Document document = new Document(PageSize.A4);
		    try {
		      PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Charlène\\Desktop\\Projet Java\\BddJava\\pdfTest/test.pdf"));
		      document.open();

		      Image image = Image.getInstance("image4.png");
		      image.scaleAbsolute(100, 70);
		      image.setAlignment(Element.ALIGN_TOP);
		      document.add(image);
		      Paragraph paragraph = new Paragraph("Bon de commande n° \t" ); //ajouter getId Order
		      paragraph.setAlignment(Element.ALIGN_CENTER);
		      document.add(paragraph);
		      Paragraph par = new Paragraph("\n\n\n\n\n ");
		     
		      Paragraph par1e = new  Paragraph("\n\n\nBookShop \n127.0.0.1 \nParis 12eme");
		 
				document.add(par);  
		        document.add(par1e);
				  
				  
				  
				  Paragraph parNcl = PdfConstructor.getClient("Moi", "Ici", "Paris",  "c tout");
						 
			      parNcl.setAlignment(Element.ALIGN_RIGHT);
			      document.add(parNcl); 
			      
			      ArrayList <String> listInit = new ArrayList();
			      listInit.add("1 + \n");
			      listInit.add("1");
			      listInit.add("1");
			      listInit.add("1");
			     
			      
			      Cell[] init = new Cell[4];
			      Table tableau =  PdfConstructor.getTableau(init);
			      for (String element : listInit ) {
			    	  Cell cell = new Cell(element);
			    	  for (int i = 0; i< init.length; i++) {
			    		  init[i] = cell;
			    		  tableau.addCell(cell);
			    	  }
			      }
			     

			      document.add(tableau);  
			      document.add(PdfConstructor.getSeparateur()); 
			      
					
					  ArrayList <String> listInitD = new ArrayList(); 
					  
					  listInitD.add("1 + \n");
					  listInitD.add("1"); listInitD.add("1"); listInitD.add("1");
					 
					  
					  Cell[] initD = new Cell[4]; 
					  Table tableau2 =
					  PdfConstructor.getTableau(initD);
					  for (String element : listInitD ) { Cell
					  cell = new Cell(element); for (int i = 0; i< initD.length; i++) { initD[i] =
					  cell; tableau2.addCell(cell); } }
					  
					  
					  document.add(tableau2);
					 
			      
				
				 
		      
		    } catch (DocumentException de) {
		      de.printStackTrace();
		    } catch (IOException ioe) {
		      ioe.printStackTrace();
		    }

		    document.close();
		  }
	public static void main(String []args) {
		
		TestIText1 t1 = new	TestIText1();
		
	}
	

	}
	
		


/*
 * Table tableau2 = new Table(5, 6); tableau2.setAutoFillEmptyCells(true);
 * tableau2.setPadding(2);
 * 
 * Cell cel = new Cell("Quantité"); cell.setHeader(true);
 * cell.setHorizontalAlignment(Element.ALIGN_CENTER); tableau2.addCell(cel);
 * 
 * cel = new Cell("ID Produit"); cell.setHeader(true);
 * cell.setHorizontalAlignment(Element.ALIGN_CENTER); tableau2.addCell(cel);
 * 
 * 
 * cel = new Cell("Description"); cell.setHeader(true);
 * cell.setHorizontalAlignment(Element.ALIGN_CENTER); tableau2.addCell(cel);
 * 
 * cel = new Cell("Prix Unitaire"); cell.setHeader(true);
 * cell.setHorizontalAlignment(Element.ALIGN_CENTER); tableau2.addCell(cel);
 * 
 * cel = new Cell("Total "); cell.setHeader(true);
 * cell.setHorizontalAlignment(Element.ALIGN_CENTER); tableau2.addCell(cel);
 * tableau2.endHeaders();
 * 
 * cel = new Cell("Produit"); cel.setHorizontalAlignment(Element.ALIGN_CENTER);
 * tableau2.addCell(cel);
 * 
 * tableau2.addCell(""); tableau2.addCell(""); tableau2.addCell("");
 * tableau2.addCell(""); tableau2.addCell("AutreProduit");
 * tableau2.addCell("	"); tableau2.addCell(""); tableau2.addCell("");
 * tableau2.addCell(""); tableau2.addCell("Autre"); tableau2.addCell("");
 * tableau2.addCell(""); tableau2.addCell("	"); tableau2.addCell("");
 * tableau2.addCell(""); tableau2.addCell(""); tableau2.addCell("");
 * tableau2.hasBorder(4); tableau2.addCell("Sous-total :");
 * tableau2.addCell("  "); tableau2.addCell(""); tableau2.addCell("");
 * tableau2.addCell(""); tableau2.addCell("TVA :"); tableau2.addCell("   ");
 * tableau2.addCell(""); tableau2.addCell(" "); tableau2.addCell("");
 * tableau2.addCell("Total : "); tableau2.addCell(""); document.add(tableau2);
 */


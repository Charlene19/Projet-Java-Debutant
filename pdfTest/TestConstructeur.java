package pdfTest;




	import java.io.FileOutputStream;
	import java.io.IOException;

	import com.lowagie.text.Cell;
	import com.lowagie.text.Document;
	import com.lowagie.text.DocumentException;
	import com.lowagie.text.Element;
	import com.lowagie.text.Image;
	import com.lowagie.text.PageSize;
	import com.lowagie.text.Paragraph;
	import com.lowagie.text.Table;
	import com.lowagie.text.pdf.PdfWriter;

	public class TestConstructeur extends Document {
		
		static Cell cell1 = new Cell("Date Commande"); 
		static Cell cell2 = new Cell("Nom Payeur"); 
		static Cell cell3 = new Cell("Organisme livreur");
		static Cell cell4 = new Cell("Mode de paiement");
		static Cell[] cellD;
		static Cell[] cellD2;
		String a = "a";
		String b = "b"; 
		String c = "c"; 
		String d = "d"; 
		String e = "e"; 
		String f = "f"; 
		String g = "g"; 
		static Cell cell12 = new Cell("Quantité"); 
		static Cell cell22 = new Cell("Id Produit"); 
		static Cell cell32 = new Cell("Description");
		static Cell cell42 = new Cell("Prix Unitaire");
		static Cell cell52 = new Cell("Total");
		final static Cell [] titre = new Cell [] { cell1 , cell2, cell3, cell4};
		final static Cell [] titre2 = new Cell [] { cell12 , cell22, cell32, cell42, cell52};
		
	static Paragraph getCommandeId(int commandeId) {
		return new Paragraph("\tBon de commande n° " + commandeId + "\n\n\n\n\n" ); 
	}
		
	static Paragraph getClient (String clientNom, String clientAdresse, String clientCP, String clientVille) {
		 
		 return new Paragraph (clientNom + "\n" + clientAdresse + "\n" + clientCP +"\t" + clientVille);
		
	}
	
	static public Cell[] data(String dateOrder, String nomPayeur, String nomLivreur, String modePaiement) {
		
		Cell docell = new Cell(dateOrder); 
		Cell pacell = new Cell(nomPayeur); 
		Cell nlcell = new Cell(nomLivreur); 
		Cell  mpcell = new Cell(modePaiement);
		return cellD = new Cell [] {docell, pacell, nlcell, mpcell};
		
	}
	
	static public Cell[] dataT2(String quantite, String idProduit, String description, String prixU, String total) {
		
		Cell docell = new Cell(quantite); 
		Cell pacell = new Cell(idProduit); 
		Cell nlcell = new Cell(description); 
		Cell  mpcell = new Cell(prixU);
		Cell  tocell = new Cell(total);
		return cellD2 = new Cell [] {docell, pacell, nlcell, mpcell, tocell};
		
	}
	
			/**
			 * @param args
			 */
			public static void main(String[] args) {

			    Document document = new Document(PageSize.A4);
			    try {
			      PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Charlène\\Desktop\\Projet Java\\BddJava\\pdfTest/test.pdf"));
			      document.open();

			      Image image = Image.getInstance("image4.png");
			      image.scaleAbsolute(100, 70);
			      image.setAlignment(Element.ALIGN_TOP);
			      document.add(image);
			      Paragraph paragraph = new Paragraph("Bon de commande n°"); //ajouter getId Order
			      paragraph.setAlignment(Element.ALIGN_CENTER);
			      document.add(paragraph);
			     
			      final Paragraph vendeur = new Paragraph("\n\n\nBookShop \n127.0.0.1 \nParis 12eme");
			     
				  document.add(vendeur);
					  
					  
						/*
						 * Paragraph parNcl = getClient("blable \n bla"); Paragraph parAdCl = new
						 * Paragraph(""); Paragraph parVilleCl = new Paragraph("");
						 * parNcl.setAlignment(Element.ALIGN_RIGHT);
						 * parAdCl.setAlignment(Element.ALIGN_RIGHT);
						 * parVilleCl.setAlignment(Element.ALIGN_RIGHT);
						 */
						/*
						 * document.add(parNcl); document.add(parAdCl); document.add(parVilleCl);
						 */
				      
				      Table tableau = new Table(4, 2);
				      tableau.setAutoFillEmptyCells(true);
				      tableau.setPadding(2);

				      TestConstructeur t = new TestConstructeur(); 
				      
				      
				      for (Cell cell : titre) {
				    	  cell.setHeader(true);
					      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					      tableau.addCell(cell);
				    	  
				      }
				     
				      tableau.endHeaders();
				      t.data("A", "B", "C", "d"); 
				      for (Cell cell : t.data("A", "B", "C", "d")) {
				    	  tableau.addCell(cell);
				      }
				      
				    
				      document.add(tableau);
				      
				      
				      Paragraph sep1 = new Paragraph(" \n\n\n");
				      document.add(sep1); 
				      
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
						 * 
						 */
					 
			      
			    } catch (DocumentException de) {
			      de.printStackTrace();
			    } catch (IOException ioe) {
			      ioe.printStackTrace();
			    }

			    document.close();
			  }
			}
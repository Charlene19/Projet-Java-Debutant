package pdfTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PdfConstructor extends Document {
//titre tableau 1
	
	final static Cell cell1 = new Cell("Date Commande"); 
	final static Cell cell2 = new Cell("Nom Payeur"); 
	final static Cell cell3 = new Cell("Organisme livreur");
	final static Cell cell4 = new Cell("Mode de paiement");
	
	final static Cell [] titre = new Cell [] { cell1 , cell2, cell3, cell4};
	
//titre tableau 2
	final static Cell cell12 = new Cell("Quantit�"); 
	final static Cell cell22 = new Cell("Id Produit"); 
	final static Cell cell32 = new Cell("Description");
	final static Cell cell42 = new Cell("Prix Unitaire");
	final static Cell cell52 = new Cell("Total");
	
	final  Cell [] titre2 = new Cell [] { cell12 , cell22, cell32, cell42, cell52};
	
	 static Cell[] cellD;
	 Cell[] cellD2;
	 
	final static Paragraph vendeur = new Paragraph("\n\n\nBookShop \n127.0.0.1 \nParis 12eme");
	
	//image
	static  Image image ; 
	
	//tableau
	static Table tableau;
	       Table tableauD;
	       
	static  Paragraph paragraph;
	static Paragraph paragraphClient;
	static Paragraph parSep; 
	
        static String dateOrder; 
        static String nomPayeur;
        static String nomLivreur; 
        static String modePaiement;
        static Document document;
        



	
	public PdfConstructor(Image image, Paragraph paragraph, Paragraph vendeur, Table tableau, Paragraph parSep, Table tableauD) throws BadElementException,
	  MalformedURLException, IOException {
		 new Document(PageSize.A4);
		 
		PdfConstructor.image = image; 
		this.tableau = tableau; 
		this.parSep = getSeparateur();
		this.tableauD = tableauD; 
		
	    try {
	      PdfWriter.getInstance(this, new FileOutputStream("D:\\DossierCharlene\\Librairie\\LibNetbeans/facture.pdf"));
	      this.open();
              this.add(new Paragraph(" bbbb"));
	      this.add(image);
	      this.add(paragraph);
		  this.add(vendeur);
		  this.add(paragraphClient);    
		  this.add(tableau);
		  this.add(getSeparateur());
		  this.add(tableauD);
	      
	      
	      
	    } catch (DocumentException de) {
	      de.printStackTrace();
	    } catch (IOException ioe) {
	      ioe.printStackTrace();
	    }

	  
	  
	}
	
	
	
	
	final public static Image getImage() throws BadElementException, MalformedURLException, IOException {
		image = Image.getInstance("image4.png");
		 image.scaleAbsolute(100, 70);
	      image.setAlignment(Element.ALIGN_TOP);
		return image ;
	}
	
	public static Paragraph getCommandeId(int commandeId) {
		 paragraph = new Paragraph("\tBon de commande n� " + commandeId + "\n\n\n\n\n" ); 
		 paragraph.setAlignment(Element.ALIGN_CENTER);
		return paragraph;
	}
	
	//public void setCommandeId();

	
	static public Paragraph getClient (String clientNom, String clientAdresse, String clientCP, String clientVille) {
		 paragraphClient = new Paragraph (clientNom + "\n" + clientAdresse + "\n" + clientCP +"\t" + clientVille);
		paragraphClient.setAlignment(Element.ALIGN_RIGHT);
		
		 return paragraphClient;
		
	}
	
	public static Cell[] initData(String dateOrder, String nomPayeur, String nomLivreur, String modePaiement) {
		Cell docell = new Cell(dateOrder); 
		Cell pacell = new Cell(nomPayeur); 
		Cell nlcell = new Cell(nomLivreur); 
		Cell  mpcell = new Cell(modePaiement);
         
		return new Cell []{docell,pacell,nlcell,mpcell};
			
		}
        
        public static String getDateOrder(){return dateOrder;}
	
public static String getNomPayeur(){
    return nomPayeur;
}

public static String getNomLivreur(){
    return nomLivreur;}

public static String getModePaiement(){
    return modePaiement;
}
	
    public static  Cell[] initDataT2(String quantite, String idProduit, String description, String prixU, String total) {
		
		Cell docell = new Cell(quantite); 
		Cell pacell = new Cell(idProduit); 
		Cell nlcell = new Cell(description); 
		Cell  mpcell = new Cell(prixU);
		Cell  tocell = new Cell(total);
		
		
		return new Cell [] {docell, pacell, nlcell, mpcell, tocell};
		
	}

public  static Table getTableau(Cell [] init) throws BadElementException {
    
    init = initData(dateOrder,  nomPayeur,  nomLivreur,  modePaiement);
    
	 tableau = new Table(4, 2);
     tableau.setAutoFillEmptyCells(true);
     tableau.setPadding(2);
     
     for (Cell cell : titre) {
   	  cell.setHeader(true);
	      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	      tableau.addCell(cell);
   	  
     }
    
     tableau.endHeaders();
     
     for (Cell cell : init) {
   	  tableau.addCell(cell);
     }
	return tableau;
	
}

final static public Paragraph getSeparateur() {
	
	return new Paragraph(" \n\n\n");
}

public static  Table getTableauD(Cell [] init2) throws BadElementException {
	 init2 =  initData(dateOrder,  nomPayeur,  nomLivreur,  modePaiement);
    
	 tableau = new Table(4, 2);
     tableau.setAutoFillEmptyCells(true);
     tableau.setPadding(2);
     
     for (Cell cell : titre) {
   	  cell.setHeader(true);
	      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	      tableau.addCell(cell);
   	  
     }
    
     tableau.endHeaders();
     
     for (Cell cell : cellD) {
   	  tableau.addCell(cell);
     }
	return tableau;
	
}




}

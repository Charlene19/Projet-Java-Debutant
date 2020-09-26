import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonneDAO {
	
	private String url; 
	private String username; 
	private String password;
	
	public PersonneDAO(String url, String username, String password) {
		this.url = url; 
		this.username = username;
		this.password = password;
		
	}

	public void savePersonne(Personne personne) {
		
		try {
		Connection connection = DriverManager.getConnection(url, username, password);
		
		if(personne.getNom()!= null) {
			PreparedStatement prepare = connection.prepareStatement
					( "update personne_code set Nom = ? where nom = ?;");
			
		
			prepare.setString(1, personne.getNom());
			prepare.setString(2, personne.getPrenom());
			prepare.setString(3, personne.getAdresse());
			prepare.setString(4, personne.getEmail());
			prepare.setInt(5, personne.getCode_postal());
			prepare.setLong(6, personne.getTelephone());
			prepare.setString(7, personne.getVille());
			prepare.setObject(8, personne.getType());
			

			
			prepare.execute();
		}else {
			PreparedStatement prepare = connection.prepareStatement("insert into dbo.produit(refproduit,  coulproduit, nomproduit, typeproduit, prixachatproduit, tvaappproduit, descrproduit, prixventeproduit, ReductionPrixProduit) VALUES (?);");

			prepare.setString(1, personne.getNom());
			prepare.setString(2, personne.getPrenom());
			prepare.setString(3, personne.getAdresse());
			prepare.setString(4, personne.getEmail());
			prepare.setInt(5, personne.getCode_postal());
			prepare.setLong(6, personne.getTelephone());
			prepare.setString(7, personne.getVille());
			prepare.setObject(8, personne.getType());
			
			prepare.execute();
			
		}
		System.out.println(produit.getNom() + " mis dans dbb");
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}
	
	public Personne getPersonne(String nom) {
		try {
			Connection connection = DriverManager.getConnection(url,username, password);
			
			PreparedStatement statement = connection.prepareStatement("select * from personne_code where nom = ?"); 
			statement.setString(1, nom);
			
			ResultSet resultSet = statement.executeQuery();
			
			Personne personne = new Personne(); 
			
			while (resultSet.next()) {
				produit.setReference(resultSet.getString("reference"));
				produit.setNom(resultSet.getString("NomProduit"));
				
			}return produit; 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null; 
		}
		
	}

}

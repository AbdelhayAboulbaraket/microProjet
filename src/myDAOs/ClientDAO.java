package myDAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myBusinessLayer.Achat;
import myBusinessLayer.Client;

public class ClientDAO extends DAO<Client> {

	public List<Client> selectAll() {
		{
			List<Client> liste =  new ArrayList<Client>() ;
			try
			{
				ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT * FROM client");
				while(result.next())
				{
					Client client=new Client(result.getInt("id"),result.getString("email"),result.getString("nom"),result.getString("prenom"),result.getString("adresse"),result.getString("code_postal"),result.getString("ville"),result.getString("tel"),result.getString("mot_de_passe"));
				liste.add(client);
				}
				
			}
			catch(SQLException e )
			{
				e.printStackTrace();
			}
			return liste;
		
		}
	}
	public List<Achat> selectAllbyClient(int id) {
		List<Achat> liste =  new ArrayList<Achat>() ;

		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery(""
					+ "SELECT a.code_article,a.designation,a.prix,l.qte_cde,c.date_commande FROM lignes_Commande l,article a,commande c WHERE a.code_article=l.code_article AND l.num_commande=c.num_commande AND c.id_client="+id+";");
			
			while(result.next())
			{
				Achat achat=new Achat(
						result.getInt(1),
						result.getString(2),
						result.getDouble(3),
						result.getInt(4),
						result.getInt(4)*result.getDouble(3),
						result.getDate(5)
						);
			liste.add(achat);
			}
			
		}
		catch(SQLException e )
		{
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public boolean create(Client obj) {
		
		 String prenom1=obj.getPrenom();
		 String nom1=obj.getNom();
		 String email1=obj.getEmail();
		 String adresse1=obj.getAdresse();
		 String tel1=obj.getTel();
		 String codepostal1=obj.getCodePostal();
		 String ville1=obj.getVille();
		 String motdepasse1=obj.getMotDePasse();
			try {
				 this.connect.getConn().createStatement().executeUpdate("INSERT INTO client(email,nom,prenom,adresse,code_postal,ville,tel,mot_de_passe) VALUES('"+email1+"','"+nom1+"','"+prenom1+"','"+adresse1+"','"+codepostal1+"','"+ville1+"','"+tel1+"','"+motdepasse1+"');");
		         
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}
		return true;
		
	}

	@Override
	public boolean delete(Client obj) {
		int id2=obj.getId();
		String sql= "DELETE FROM client WHERE id_client="+id2+" ";
		try {
			PreparedStatement p = this.connect.getConn().prepareStatement(sql);
            p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client find(int id) {
		   Client client=null;         
		    try {
		    	 ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT * FROM client WHERE id ="+ id +";");
		      if(result.first()){
		      client = new Client (id, result.getString("email"), result.getString("nom"),result.getString("prenom"),result.getString("adresse"),result.getString("code_postal"), result.getString("ville"),result.getString("tel"),result.getString("mot_de_passe"));
		       
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return client;   
		   
	}
	
	public Client find(String email) {
		   Client client=null;         
		    try {
		    	 ResultSet result=this.connect.getConn().createStatement().executeQuery("SELECT * FROM client WHERE email='"+ email +"';");
		      if(result.first()){
		      client = new Client (result.getInt(1), result.getString("email"), result.getString("nom"),result.getString("prenom"),result.getString("adresse"),result.getString("code_postal"), result.getString("ville"),result.getString("tel"),result.getString("mot_de_passe"));
		       
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return client;   
		   
	}
}

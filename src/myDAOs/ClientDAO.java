package myDAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myBusinessLayer.Client;

public class ClientDAO extends DAO<Client> {

	public List<Client> selectAll() {
		{
			List<Client> liste =  new ArrayList<Client>() ;
			try
			{
				ResultSet result=this.connect.getConn().createStatement().executeQuery("select * from Client");
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
				 this.connect.getConn().createStatement().executeUpdate("insert into Client(email,nom,prenom,adresse,code_postal,ville,tel,mot_de_passe) values('"+email1+"','"+nom1+"','"+prenom1+"','"+adresse1+"','"+codepostal1+"','"+ville1+"','"+tel1+"','"+motdepasse1+"');");
		         
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}
		return true;
		
	}

	@Override
	public boolean delete(Client obj) {
		int id2=obj.getId();
		String sql= "DELETE FROM Client WHERE id_client="+id2+" ";
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
		    	 ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * FROM Client WHERE id ="+ id +";");
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
		    	 ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * FROM Client WHERE email='"+ email +"';");
		      if(result.first()){
		      client = new Client (result.getInt(1), result.getString("email"), result.getString("nom"),result.getString("prenom"),result.getString("adresse"),result.getString("code_postal"), result.getString("ville"),result.getString("tel"),result.getString("mot_de_passe"));
		       
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return client;   
		   
	}
}

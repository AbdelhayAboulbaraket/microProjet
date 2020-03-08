package myDAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import myBusinessLayer.Client;
import myBusinessLayer.Commande;

public class CommandeDAO extends DAO<Commande> {

	@Override
	public List<Commande> selectAll() {
		List<Commande> maListe=new ArrayList<Commande>();
		ClientDAO clientDao=new ClientDAO();
		
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * from Commande;");
			while(result.next())
			{
				Commande commande=new Commande(
						result.getInt(1),
						clientDao.find(result.getInt(2)),
						result.getDate(3)
						);
				maListe.add(commande);
			}
			
		} catch(SQLException e)
		{
			e.printStackTrace();
		}		return null;
	}

	@Override
	public boolean create(Commande obj) {
		try
		{	String sql="INSERT INTO COMMANDE VALUES("+ obj.getNumCommande()+",'"+obj.getClient().getId()+
			"',"+ obj.getDateCommande()+");";
			this.connect.getConn().createStatement().executeUpdate(sql);
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
	}
	}

	@Override
	public boolean delete(Commande obj) {
		// TODO Auto-generated method stub
		try 
	    {
		  //done
	      this.connect.getConn().createStatement().executeUpdate("DELETE FROM commande WHERE num_commande="+ obj.getClient().getId() +";");
	      return true;
	    } catch (SQLException e) 
		{
	      e.printStackTrace();
	      return false;
	    } 
	}

	@Override
	public boolean update(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Commande find(int id) {
		Commande commande=new Commande();
		ClientDAO clientDao=new ClientDAO();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * from commande where num_commande="+ id+";" );
			while(result.next())
			{
						commande =new Commande(
								result.getInt(1),
								clientDao.find(result.getInt(2)),
								result.getDate(3)
						);
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return commande;


}
	}

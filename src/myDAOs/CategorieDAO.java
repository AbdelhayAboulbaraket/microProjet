package myDAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myBusinessLayer.Categorie;
import myBusinessLayer.Client;
import myBusinessLayer.Commande;

public class CategorieDAO extends DAO<Categorie> {

	@Override
	public List<Categorie> selectAll() {
		// TODO Auto-generated method stub
		List<Categorie> maListe=new ArrayList<Categorie>();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * from Categorie;");
			while(result.next())
			{
				Categorie categorie=new Categorie(
						result.getInt(1),
						result.getString(2)
						);
				maListe.add(categorie);
			}
			
		} catch(SQLException e)
		{
			e.printStackTrace();
		}		return null;	}

	@Override
	public boolean create(Categorie obj) {
		// TODO Auto-generated method stub
		try
		{	String sql="INSERT INTO CATEGORIE VALUES("+ obj.getRefCat()+",'"+ obj.getCategorie()+"');";
			this.connect.getConn().createStatement().executeUpdate(sql);
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;	}
	}

	@Override
	public boolean delete(Categorie obj) {
		// TODO Auto-generated method stub
		try 
	    {
		  //done
	      this.connect.getConn().createStatement().executeUpdate("DELETE FROM categorie WHERE ref_cat="+ obj.getRefCat() +";");
	      return true;
	    } catch (SQLException e) 
		{
	      e.printStackTrace();
	      return false;
	    } 	}

	@Override
	public boolean update(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Categorie find(int id) {
		// TODO Auto-generated method stub
		Categorie categorie=new Categorie();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * from categorie where ref_cat="+ id+";" );
			while(result.next())
			{
						categorie=new Categorie(
						result.getInt(1),
						result.getString(3)
						);
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return categorie;


}
}

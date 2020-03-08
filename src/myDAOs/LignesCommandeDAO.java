package myDAOs;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myBusinessLayer.Article;
import myBusinessLayer.Commande;
import myBusinessLayer.LignesCommande;

public class LignesCommandeDAO extends DAO<LignesCommande> {

	@Override
	public List<LignesCommande> selectAll() {
		List<LignesCommande> liste =  new ArrayList<LignesCommande>() ;
		CommandeDAO commandeDao=new CommandeDAO();
		ArticleDAO articleDao=new ArticleDAO();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("select * from LignesCommande");
			while(result.next())
			{
				LignesCommande lignesCommande= new LignesCommande(commandeDao.find(result.getInt(1)),articleDao.find(result.getInt(2)),result.getInt("qte_cde"));
			liste.add(lignesCommande);
			}
			
		}
		catch(SQLException e )
		{
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public boolean create(LignesCommande obj) {
		
		int commande1=obj.getCommande().getNumCommande();
		int article1=obj.getArticle().getCodeArticle();
		int qtecde1=obj.getQteCde();
		try {
			 this.connect.getConn().createStatement().executeUpdate("insert into LignesCommande (commande,article,qteCde) values("+commande1+","+article1+","+qtecde1+");");
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	return true;
		
	}

	@Override
	public boolean delete(LignesCommande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(LignesCommande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LignesCommande find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

package myServlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myBusinessLayer.Client;
import myBusinessLayer.Commande;
import myBusinessLayer.LignesCommande;
import myBusinessLayer.Panier;
import myDAOs.ClientDAO;
import myDAOs.CommandeDAO;
import myDAOs.LignesCommandeDAO;

/**
 * Servlet implementation class AfficherCommandes
 */
@WebServlet("/AfficherCommandes")
public class AfficherCommandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherCommandes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		Client utilisateur=(Client)session.getAttribute("utilisateur");
		List<Panier> monPanier=utilisateur.getPanier();
		
		for(int i=0;i<monPanier.size();i++)
		{
           Commande commande=new Commande(utilisateur,new Date());
           CommandeDAO commandeDao=new CommandeDAO();
           commandeDao.create(commande);
           commande=commandeDao.findLastRow();
           LignesCommande ligneCommande=new LignesCommande(commande,monPanier.get(i).getArticle(),monPanier.get(i).getQuantite());
           LignesCommandeDAO lignesCommandeDao=new LignesCommandeDAO();
           lignesCommandeDao.create(ligneCommande);
		}
		utilisateur.getPanier().clear();
		ClientDAO clientDao=new ClientDAO();
		utilisateur.setAchats(clientDao.selectAllbyClient(utilisateur.getId()));
		session.setAttribute("utilisateur",utilisateur);
		
		RequestDispatcher view=request.getRequestDispatcher("/restreint/voirCommandes.jsp");
		view.forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

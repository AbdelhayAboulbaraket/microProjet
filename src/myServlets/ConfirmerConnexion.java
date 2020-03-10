package myServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myBusinessLayer.Categorie;
import myBusinessLayer.Client;
import myDAOs.CategorieDAO;
import myDAOs.ClientDAO;

/**
 * Servlet implementation class ConfirmerConnexion
 */
@WebServlet("/ConfirmerConnexion")
public class ConfirmerConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmerConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String email=request.getParameter("email");
		String motdepasse=(String)request.getParameter("motdepasse");
		ClientDAO clientDao= new ClientDAO();	
		Client client=clientDao.find(email);
		HttpSession session=request.getSession();
		CategorieDAO catDao=new CategorieDAO();

		
		
		//System.out.println(motdepasse+" "+client.getMotDePasse());
		
		if(client != null && motdepasse.matches(client.getMotDePasse())) 
		{	
			List<String> taListe=catDao.selectAllCats();
			session.setAttribute("taListe", taListe);
			session.setAttribute("utilisateur",client);
			
			RequestDispatcher view=request.getRequestDispatcher("connexionReussite.jsp");
			view.forward(request, response);
		}
		else
		{	
			RequestDispatcher view=request.getRequestDispatcher("identification.jsp");
			view.forward(request, response);
		}
	}

}

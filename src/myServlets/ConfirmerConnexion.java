package myServlets;

import java.io.IOException;
import myBusinessLayer.Client;
import myDAOs.ClientDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String email=request.getParameter("email");
		String motdepasse=request.getParameter("motdepasse");
		ClientDAO clientDao= new ClientDAO();	
		Client client=clientDao.find(email);
		
		//System.out.println(motdepasse+" "+client.getMotDePasse());
		
		if(client != null ) 
		{	
			request.setAttribute("utilisateur",client);
			RequestDispatcher view=request.getRequestDispatcher("connexionReussite.jsp");
			view.forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

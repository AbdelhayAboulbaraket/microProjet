package myServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myBusinessLayer.Client;
import myDAOs.ClientDAO;

/**
 * Servlet implementation class ConfirmerInscription
 */
@WebServlet("/ConfirmerInscription")
public class ConfirmerInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmerInscription() {
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
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String adresse=request.getParameter("adresse");
		String codePostal=request.getParameter("codepostal");
		String ville=request.getParameter("ville");
		String tel=request.getParameter("tel");
		String motDePasse=request.getParameter("motdepasse");
		System.out.println(email+nom+prenom+adresse+codePostal+ville+tel+motDePasse);
		Client utilisateur=new Client(
				email,nom,prenom,adresse,codePostal,ville,tel,motDePasse
				);
		System.out.println(utilisateur.getNom()+utilisateur.getPrenom());
		ClientDAO clientDao=new ClientDAO();
		clientDao.create(utilisateur);
		System.out.println("ça marche");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

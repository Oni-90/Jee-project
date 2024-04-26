package com.UniDev.regis;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Auteur;
import Dao.AuteurDAO;
import Dao.AuteurDAOImpl;
import Dao.ConnectDbDao;

/**
 * Servlet implementation class AddAuteurServlet
 */
@WebServlet("/AddAuteurServlet")
public class AddAuteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuteurDAO auteurDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAuteurServlet() {
        super();
        // initialisation de l'interface AuteurDaoImpl
        auteurDao = new AuteurDAOImpl(ConnectDbDao.getCon());
    }
    
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recuperation des infos du formulaire 
		String nom = request.getParameter("nom");
		
		//Creation d'un nouvel auteur(objet)
		Auteur auteur = new Auteur();
		auteur.setNom(nom);
		
		//appel du DAO 
		 auteurDao.ajouterAuteur(auteur);
		
		if(auteur.getId() > 0) {
			request.setAttribute("status", "success");
			
			//Redirection vers la liste des auteurs 
			response.sendRedirect("listAuteur.jsp");
		}
		else {
			request.setAttribute("status", "failed");
			
			response.sendRedirect("addAuteur.jsp");
		}
		
	}

}

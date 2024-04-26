package com.UniDev.regis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AuteurDAOImpl;
import Dao.LivreDAOImpl;
import Dao.ConnectDbDao;
import models.Auteur;
import models.Livre;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/listeLivres")
public class LivreServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
     
        int auteurId = Integer.parseInt(request.getParameter("auteurId"));

        
        LivreDAOImpl livreDAO = new LivreDAOImpl(ConnectDbDao.getCon());
        List<Livre> livres = livreDAO.obtenirLivresParAuteur(auteurId);

        
        AuteurDAOImpl auteurDAO = new AuteurDAOImpl(ConnectDbDao.getCon()); 
        Auteur auteur = auteurDAO.obtenirAuteurParId(auteurId);


        request.setAttribute("livres", livres);
        request.setAttribute("auteur", auteur);

   
        request.getRequestDispatcher("/listeLivres.jsp").forward(request, response);
    }

    
}


package com.UniDev.regis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AuteurDAOImpl;
import Dao.ConnectDbDao;
import models.Auteur;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/listAuteurs")
public class AuteurServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       
        AuteurDAOImpl auteurDAO = new AuteurDAOImpl(ConnectDbDao.getCon()); 
        List<Auteur> auteurs = auteurDAO.obtenirTousAuteurs();

       
        request.setAttribute("auteurs", auteurs);

    
        request.getRequestDispatcher("/listAuteur.jsp").forward(request, response);
    }

    
}

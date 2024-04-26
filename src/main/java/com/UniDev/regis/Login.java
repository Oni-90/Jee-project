package com.UniDev.regis;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import Dao.ConnectDbDao;


@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("uemail")) {
                    request.setAttribute("uemail", cookie.getValue());
                }
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	
        String uemail = request.getParameter("username");
        String upwd = request.getParameter("password");
//        RequestDispatcher rd = null;
        HttpSession session = request.getSession();
        boolean remenber=request.getParameter("remenber-me")!=null;
        
        if(remenber){
        	Cookie cookie = new Cookie("uemail", uemail);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
        	
        }
               

        try {
           
        	Connection con = ConnectDbDao.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT upwd, uname FROM users WHERE uemail=?");
            ps.setString(1, uemail);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String hashedPasswordFromDB = rs.getString("upwd");

                if (BCrypt.checkpw(upwd, hashedPasswordFromDB)) {
                    session.setAttribute("name", rs.getString("uname"));
//                    rd = request.getRequestDispatcher("index.jsp");
                    response.sendRedirect("addAuteur.jsp");
                    return;
                } 
                else {

                	request.setAttribute("status", "failed");
//                	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                }
            } 
            else {
            	request.setAttribute("status", "failed");
//            	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

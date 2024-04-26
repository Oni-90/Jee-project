package com.UniDev.regis;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import Dao.ConnectDbDao;

/**
 * Servlet implementation class RegiServlet
 */
@WebServlet("/RegiServlet")
public class RegiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uname=request.getParameter("name");
		String uemail=request.getParameter("email");
		String upwd=request.getParameter("pass");
		String salt = BCrypt.gensalt(12);
		String hashedPassword = BCrypt.hashpw(upwd, salt);
		String umobile=request.getParameter("contact");
		RequestDispatcher rd=null;
		Connection con = null;
		
		try {
			con = ConnectDbDao.getCon();
			
			PreparedStatement ps=con.prepareStatement("insert into users(uname,upwd,uemail,umobile) values(?,?,?,?)");
			ps.setString(1,uname);
			ps.setString(2, hashedPassword);
			ps.setString(3, uemail);
			ps.setString(4, umobile);
			int  rc=ps.executeUpdate();
			
			rd=request.getRequestDispatcher("login.jsp");
		
			if(rc > 0) {
				 request.setAttribute("status","success");
				
			}
			
			else {
				request.setAttribute("status","failed");
			}
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			try {
				if (con != null) {
                    con.close();
                }
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
				
	}



}

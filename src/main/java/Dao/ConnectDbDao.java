package Dao;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.usersException;
import models.users;

public class ConnectDbDao {
	static Connection con=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jee_Project?useSSL=false", "root", "maxwell2004");
		}
		catch(Exception e){
		e.printStackTrace();
		
		}
	}
	public static Connection getCon() {return con;}


}

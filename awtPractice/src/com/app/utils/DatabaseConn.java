package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {
	
	public Connection getConnection() throws SQLException {
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userreg?useSSL=false", "root", "toor");
		return con;
	}
	
}

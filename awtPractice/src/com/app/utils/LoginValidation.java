package com.app.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.pojos.User;



public class LoginValidation {
	private String query ="Select * from user where useremail=? and userpassword=?";
	private String getAllUsersQuery = "Select * from user";
	public boolean validateUser(String email, String pass) throws SQLException{
		
		Connection conn = new DatabaseConn().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			return true;
		return false;
		
	}
	
	public List<User> getAllUsers() throws SQLException{
		List<User> users = new ArrayList<User>();
		Connection conn = new DatabaseConn().getConnection();
		PreparedStatement ps = conn.prepareStatement(getAllUsersQuery);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			users.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		}
		return users;
	}
}

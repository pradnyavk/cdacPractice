package com.app.pojos;

public class User {
	int id;
	String username;
	String useremail;
	String userpassword;
	
	public User() {
		super();
	}
	public User(String username, String useremail, String userpassword) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.userpassword = userpassword;
	}
	
	public User(int id, String username, String useremail, String userpassword) {
		super();
		this.id = id;
		this.username = username;
		this.useremail = useremail;
		this.userpassword = userpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", useremail=" + useremail + ", userpassword="
				+ userpassword + "]";
	}
	
}

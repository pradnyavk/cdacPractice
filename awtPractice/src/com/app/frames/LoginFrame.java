package com.app.frames;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.app.utils.LoginValidation;
import com.sun.media.sound.AlawCodec;

public class LoginFrame extends Frame {
	
	private TextField userEmail;
	private TextField userPassword;
	private Button submitButton;
	private Label alert;
	private String enteredEmail;
	private String enteredPassword;
	
	
	
	

	public LoginFrame() {
		
		Label email = new Label("Enter the Email");
		email.setBounds(20, 50, 100, 20);
		add(email);
		
		userEmail = new TextField();
		userEmail.setBounds(20, 100, 100, 20);
		add(userEmail);
		
		Label password = new Label("Enter the Password");
		password.setBounds(20, 160, 120, 20);
		add(password);
		
		userPassword = new TextField();
		userPassword.setBounds(20, 210, 100, 20);
		userPassword.setEchoChar('*');
		add(userPassword);
	
		submitButton = new Button("Login");
		submitButton.setBounds(20, 250, 50, 20);
		add(submitButton);
		

		alert = new Label();
		alert.setBounds(20, 300, 120, 20);
		add(alert);
		
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enteredEmail = userEmail.getText();
				enteredPassword = userPassword.getText();
				
				try {
					
					if(new LoginValidation().validateUser(enteredEmail, enteredPassword)) {
						new DetailsFrame().setVisible(true);
						dispose();
					}
					else {
						alert.setText("User not found");
						alert.setBackground(Color.RED);
						alert.setForeground(Color.WHITE);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				dispose();
			}
		});
		
		setSize(400, 400);
		setLayout(null);
		
	}
}

package com.app.frames;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.app.pojos.User;
import com.app.utils.LoginValidation;

public class DetailsFrame extends JFrame {
	public DetailsFrame() throws SQLException {
		
		List<User> users = new LoginValidation().getAllUsers();
		Vector<Vector<String>> usersVector = new Vector<Vector<String>>();
		for(User u: users) {
			Vector<String> userVector = new Vector<String>();
			userVector.add(u.getUsername());
			userVector.add(u.getUseremail());
			usersVector.add(userVector);
		}
		Vector<String> columnVector = new Vector<String>();
		columnVector.add("UserName");
		columnVector.add("UserEmail");
		JTable jt = new JTable(usersVector, columnVector);
		jt.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(30, 40, 200, 300);
		add(sp);
		
		Button logout = new Button("Logout");
		logout.setBounds(250,40,50,20);
		add(logout);
		
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFrame().setVisible(true);
				dispose();
				
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				dispose();
			}
		});
		
		setSize(600, 600);
		setLayout(null);
	}
}

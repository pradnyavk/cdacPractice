package com.app.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.app.dao.IUserDao;
import com.app.app.dao.UserDao;
import com.app.app.pojos.User;
import com.app.app.report.ReportGeneration;

@Controller
@RequestMapping("/user")
public class RegisterController {
	
	@Autowired
	IUserDao dao;
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String getUserDetails() {
		return "/user/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestParam String username,@RequestParam String useremail,@RequestParam String userpassword,RedirectAttributes modelMap) 
	{
		try {
			User user = new User(username,useremail,userpassword);
			dao.save(user);
			modelMap.addAttribute("status", "User Registered!Please Login");
			return "redirect:/user/login";
		} catch (Exception e) {
			e.printStackTrace();
			return "/user/register";
		}
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		return "/user/login";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String loginUser(@RequestParam String useremail,@RequestParam String userpassword,Model map) {
		List<User> users = dao.getAll();
		for(User u : users) {
			if(u.getUseremail().equals(useremail)) {
				if(u.getUserpassword().equals(userpassword)) {
					map.addAttribute("users", users);
					ReportGeneration rg = new ReportGeneration();
					try {
					rg.generateReport(users);
					}catch (Exception e) {
						e.printStackTrace();
					}
					return "/user/details";
				}
			}
		}
		map.addAttribute("loginStatus","Email or Password Incorrect!");
		return "/user/login";
	}

	
}

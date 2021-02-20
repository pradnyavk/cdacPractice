package com.app.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.app.dao.UserDao;
import com.app.app.pojos.User;

@Controller
@RequestMapping("/user")
public class RegisterController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String getUserDetails() {
		return "/user/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestParam String username,@RequestParam String useremail,@RequestParam String userpassword,Model modelMap) 
	{
		try {
			User user = new User(username,useremail,userpassword);
			userDao.save(user);
			modelMap.addAttribute("status", "User Registered!Please Login");
			return "/user/login";
		} catch (Exception e) {
			e.printStackTrace();
			return "/user/register";
		}
	}

	
}

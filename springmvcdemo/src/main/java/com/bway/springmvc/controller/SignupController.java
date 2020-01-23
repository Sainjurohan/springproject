package com.bway.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springmvc.dao.UserDao;
import com.bway.springmvc.model.User;

@Controller

public class SignupController {
	
	@Autowired
	private UserDao udao; // UserDao udao = new UserDaoImpl();

	@RequestMapping(value = "/usersignup", method=RequestMethod.GET)
	
	public String getSignup(Model model) {
		
		model.addAttribute("smodel", new User());
		
		return "signup";
	}
	
	@RequestMapping(value ="/usersignup" , method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		
		udao.signup(user);
		
		return "login";
	}
}

package com.bway.springmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.bway.springmvc.dao.EmployeeDao;
import com.bway.springmvc.dao.UserDao;
import com.bway.springmvc.model.User;
import com.bway.springmvc.utilities.VerifyRecaptcha;

@Controller

//@RequestMapping(value = "/user")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserDao udao;

	@Autowired
	private EmployeeDao edao;

	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public String login() {
		logger.info("loginform");
		return "login";
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)

	public String userlogin(@ModelAttribute User u, Model model, HttpSession session, HttpServletRequest request)
			throws IOException {

		String input = request.getParameter("g-recaptcha-response");
		boolean result =VerifyRecaptcha.verify(input);

		if (result == true) {

			u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes())); // to send password in encrypted form

			User user = udao.login(u.getUsername(), u.getPassword()); // u is user input

			if (user != null) {

				logger.info("login Sucess");

				session.setAttribute("active", user);
				session.setMaxInactiveInterval(180);

				model.addAttribute("un", u.getUsername());
				model.addAttribute("elist", edao.getAllEmployee());

				return "home";

			}
		} else {

			logger.info("login Failed");
			model.addAttribute("error", "You are not Human!!");

			return "login";

		}
		logger.info("login Failed");
		model.addAttribute("error", "user doesnot exixt!!");

		return "login";

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {

		logger.info("logout Sucess");
		session.invalidate();
		return "login";
	}
	
	
	// for facebook login
	
	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public String facebookLogin() {
		
		return "redirect:https://www.facebook.com/dialog/oauth?client_id=2953405344672336&redirect_uri=http://localhost:8080/springmvc/authorize/facebook&response_type=code&scope=email";
		
		
	}
	
	

	@RequestMapping(value = "/authorize/facebook", method = RequestMethod.GET)
	public String saveFbUser(String code, Model model, HttpServletRequest request){
		
		model.addAttribute("elist", edao.getAllEmployee());
		
	      return "home";
	      
	      
	      
	      }
	      

}

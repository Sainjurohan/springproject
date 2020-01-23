package com.bway.springmvc.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GallaryController {
	
	
	@RequestMapping(value = "/gallary")
	public String gallery(Model model, HttpSession session) {
		
		if (StringUtils.isEmpty(session.getAttribute("active"))) {

			return "login";
		}
		
		File dir = new File("B:\\springFramework\\springmvcdemo\\src\\main\\webapp\\resources\\imgs");
		
		String[] imglist = dir.list();
		
		model.addAttribute("imglist", imglist);
		
		return"gallary";
	}

}

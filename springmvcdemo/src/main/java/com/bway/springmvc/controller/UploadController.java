package com.bway.springmvc.controller;


import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@RequestMapping(value = "/upload")
	public String uploadForm() {
		
		return "uploadForm";
		
	}
	
	@RequestMapping(value = "/upload" , method = RequestMethod.POST)
	public String saveFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		
		if(!file.isEmpty()) {
			FileOutputStream fout = new FileOutputStream("B:\\springFramework\\springmvcdemo\\src\\main\\webapp\\resources\\imgs\\"+file.getOriginalFilename());
			fout.write(file.getBytes());
			
			fout.close();
			
			model.addAttribute("msg", "Upload sucess");
			return"uploadForm";
		}
		
		model.addAttribute("msg", "file not uploaded");
		
		return"uploadForm";
		
	}

}

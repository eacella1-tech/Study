package com.kedu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.FilesDAO;


@Controller
public class HomeController {
	
	@Autowired
	private FilesDAO fdao;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("files",fdao.selectAll());
		
		return "home";
	}
	
}

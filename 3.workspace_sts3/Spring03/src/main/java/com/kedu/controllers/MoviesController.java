package com.kedu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.MoviesDAO;
import com.kedu.dto.MoviesDTO;

@Controller
@RequestMapping("/movies")
public class MoviesController {
	
	@Autowired
	private MoviesDAO dao;

	@RequestMapping("/addform")
	public String addform() {
		return "addform";
	}

	@RequestMapping("/add")
	public String add(MoviesDTO dto) {
		dao.insert();
		return "home";
	}
}

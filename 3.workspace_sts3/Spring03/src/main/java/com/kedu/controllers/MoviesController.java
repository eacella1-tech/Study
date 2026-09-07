package com.kedu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	public String add(MoviesDTO dto) throws Exception {
		dao.insert(dto);

		return "redirect:/";
	}

	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		List<MoviesDTO> list = dao.selectAll();
		model.addAttribute("list", list);


		return "list";
	}
	@RequestMapping("/delete")
	public String delete(int id) throws Exception {
		dao.deleteMovies(id);

		return "redirect:/movies/list";
	}

	@RequestMapping("/update")
	public String update(MoviesDTO dto) throws Exception {
		dao.updateMovies(dto);

		return "redirect:/movies/list";
	}

	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e) {
		e.printStackTrace();
		return "error";
	}

}

package com.kedu.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.StudentsDAO;
import com.kedu.dto.StudentsDTO;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired 
	private StudentsDAO dao;
	
	@RequestMapping("/addform")
	public String addform () {

		return "addform";
	}
	@RequestMapping("/add")
	public String add(StudentsDTO dto) throws Exception {
		dao.insert(dto);
		
		return "redirect:/";
	}
	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		ArrayList<StudentsDTO> list = dao.selectAll();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/update")
	public String update(StudentsDTO dto) throws Exception {
		dao.updateStudents(dto);

		return "redirect:/students/list";
	}
	@RequestMapping("/delete")
	public String deleteStudents(int id) throws Exception {
	    dao.deleteStudents(id);

	    return "redirect:/students/list";
	}
	
	@RequestMapping("/search")
	public String searchStudents(String param, Model model) throws Exception {

	    ArrayList<StudentsDTO> list = dao.searchStudents(param);

	    model.addAttribute("list", list);

	    return "list";
	}
	
	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e) {
		e.printStackTrace();
		return "error";
	}


}

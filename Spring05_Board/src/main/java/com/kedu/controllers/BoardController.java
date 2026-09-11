package com.kedu.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.BoardsDAO;
import com.kedu.dto.BoardsDTO;

@Controller
@RequestMapping("/boards")
public class BoardController {
	
	@Autowired
	private BoardsDAO dao;
	
	@RequestMapping("/board")
	public String boardlist(Model model) throws Exception {
		ArrayList<BoardsDTO> list = dao.boardlist();
		model.addAttribute("list", list);
		return "boards/board";
	}
	
	@RequestMapping("/write")
	public String write(HttpSession session,Model model) throws Exception {
		String id = (String) session.getAttribute("loginId");
		model.addAttribute("loginId", id);
		return "boards/write";
	}
	
	@RequestMapping("/complete")
	public String insert(BoardsDTO dto) throws Exception {
		dao.insert(dto);
		
		return "redirect:/boards/board";
		
	}
	
	@RequestMapping("/delete")
	public String delete(int seq,HttpSession session) throws Exception {
		String id = (String) session.getAttribute("loginId");
		BoardsDTO dto = dao.detail(seq);
		if(dto != null && id != null && id.equals(dto.getWriter())) {
			dao.delete(seq);	
		}
		return "redirect:/boards/board";
	}
	
	@RequestMapping("/edit")
	public String edit(int seq, Model model) throws Exception {
		BoardsDTO dto = dao.detail(seq);
		model.addAttribute("dto", dto);
	    
	    return "boards/edit";
	}
	@RequestMapping("/update")
	public String update(BoardsDTO dto,HttpSession session) throws Exception {
		String id = (String) session.getAttribute("loginId");
		BoardsDTO org = dao.detail(dto.getSeq());
		if(org != null && id != null && id.equals(dto.getWriter())) {
			dao.update(dto);	
		}
		return "redirect:/boards/board";
		
	}
	
	
	@RequestMapping("/detail")
	public String detail(int seq, HttpSession session, Model model) throws Exception {

	    dao.viewCount(seq);

	    BoardsDTO dto = dao.detail(seq);

	    model.addAttribute("dto", dto);
	    model.addAttribute("loginId", session.getAttribute("loginId"));

	    return "boards/detail";
	}
	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}

}

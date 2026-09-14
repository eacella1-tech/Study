package com.kedu.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.ReplyDAO;
import com.kedu.dto.BoardsDTO;
import com.kedu.dto.ReplyDTO;

@Controller
@RequestMapping("/replys")
public class ReplyController {
	
	@Autowired
	private ReplyDAO dao;
	
	@RequestMapping("/comment")
	public String addcomment (int seq, String contents, HttpSession session) throws Exception {
		String id = (String) session.getAttribute("loginId");
		
		
		ReplyDTO dto = new ReplyDTO();
		dto.setParent_seq(seq);
		dto.setWriter(id);
		dto.setContents(contents);
		
		dao.addcomment(dto);
		
		return "redirect:/boards/detail?seq="+ seq;
		
	}
	
	@RequestMapping("/delete")
	public String deletecomment (int seq, int parent_seq,HttpSession session) throws Exception {
		String id = (String) session.getAttribute("loginId");
		ReplyDTO dto = dao.selectOne(seq);
		if(dto != null && id != null && id.equals(dto.getWriter())) {
			dao.deletecomment(seq);
		}
		
		return "redirect:/boards/detail?seq="+ parent_seq;
	}
	
	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}


}

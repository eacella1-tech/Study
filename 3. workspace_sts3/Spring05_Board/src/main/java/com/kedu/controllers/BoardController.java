package com.kedu.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.BoardsDAO;
import com.kedu.dao.ReplyDAO;
import com.kedu.dto.BoardsDTO;
import com.kedu.dto.ReplyDTO;

@Controller
@RequestMapping("/boards")
public class BoardController {

	@Autowired
	private BoardsDAO dao;
	@Autowired
	private ReplyDAO replydao;

	@RequestMapping("/board")
	public String boardlist(int cpage, Model model) throws Exception {
		List<BoardsDTO> list = dao.selectFromTo(cpage * 10 - 9 , cpage * 10);

		model.addAttribute("list", list);
		model.addAttribute("recordTotalCount", dao.selectCount());
		model.addAttribute("recordCountPerPage", 10);
		model.addAttribute("naviCountPerPage", 10);
		model.addAttribute("cpage", cpage);
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

		return "redirect:/boards/board?cpage=1";

	}

	@RequestMapping("/delete")
	public String delete(int seq,HttpSession session) throws Exception {
		String id = (String) session.getAttribute("loginId");
		BoardsDTO dto = dao.detail(seq);
		if(dto != null && id != null && id.equals(dto.getWriter())) {
			dao.delete(seq);	
		}
		return "redirect:/boards/board?cpage=1";
	}

	@RequestMapping("/edit")
	public String edit(int seq, Model model) throws Exception {
		BoardsDTO dto = dao.detail(seq);
		model.addAttribute("dto", dto);

		return "boards/edit";
	}
	@RequestMapping("/update")
	public String update(int seq, BoardsDTO dto,HttpSession session) throws Exception {
		String id = (String) session.getAttribute("loginId");
		BoardsDTO org = dao.detail(dto.getSeq());
		if(org != null && id != null && id.equals(dto.getWriter())) {
			dao.update(dto);	
		}
		return "redirect:/boards/detail?seq=" + seq;

	}


	@RequestMapping("/detail")
	public String detail(int seq, HttpSession session, Model model) throws Exception {

	    dao.viewCount(seq);

	    BoardsDTO dto = dao.detail(seq);

	    List<ReplyDTO> replyList = replydao.selectByParentSeq(seq);

	    model.addAttribute("dto", dto);
	    model.addAttribute("loginId", session.getAttribute("loginId"));
	    model.addAttribute("replyList", replyList);

	    return "boards/detail";
	}
	
	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}

}

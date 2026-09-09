package com.kedu.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.commons.EncryptionUtils;
import com.kedu.dao.MembersDAO;
import com.kedu.dto.MembersDTO;

@Controller
@RequestMapping("/members")
public class MemberController {

	@Autowired
	private MembersDAO dao;

	@RequestMapping("/signup")
	public String signup() {

		return "members/signup";
	}
	
	@RequestMapping("/login")
	public String login(String id, String pw, HttpSession session) throws Exception {

		pw = EncryptionUtils.encryptSHA512(pw);
		boolean result = dao.login(id, pw);
		if (result) {
			session.setAttribute("loginId", id);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		
		return "redirect:/";
		
	}

	@RequestMapping("/register")
	public String register(MembersDTO dto) throws Exception {
		dto.setPw(EncryptionUtils.encryptSHA512(dto.getPw()));
		dao.insert(dto);

		return "redirect:/";

	}
	
	@RequestMapping("/withdraw")
	public String withdraw(HttpSession session) throws Exception {
		String id = (String) session.getAttribute("loginId");
		dao.withdraw(id);
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping("/idcheck")
	public String idcheck(String id, Model model) throws Exception {
		boolean result = dao.idCheck(id);
		model.addAttribute("id", id);
		model.addAttribute("result", result);

		return "members/idcheck_view";
	}

	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}

}

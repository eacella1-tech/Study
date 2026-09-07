package com.kedu.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Hello Spring");
		return "home";
	}

	@RequestMapping("/message")
	public String message() {
		System.out.println("메세지 요청 받음");
		return "home";
	}
	
	@RequestMapping("/toInput")
	public String toInput() {
		return "input";
	}
	
	@RequestMapping("/input")
	public String input(String name, String contact) {
		
		System.out.println("이름 : " + name);
		System.out.println("연락처 : " + contact);
		return "home";
	}
			
}

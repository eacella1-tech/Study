package com.kedu.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kedu.dto.ContactsDTO;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	@Autowired
	private Gson gson;

	@RequestMapping("/exam01")
	public String exam01() {

		System.out.println("요청 도착 확인");
		return "home";

	}

	@RequestMapping("/exam02")
	public String exam02(String writer, String message) {
		System.out.println("writer : " + writer);
		System.out.println("message : " + message);

		return "home";
	}

	@ResponseBody
	@RequestMapping("/exam03")
	public String exam03() {

		return "Hello AJAX";

	}

	@ResponseBody
	@RequestMapping("/exam04")
	public String exam04() {
		
		List<ContactsDTO> list = new ArrayList<>();
		list.add(new ContactsDTO(1001, "Jack", "01012341234"));
		list.add(new ContactsDTO(1002, "Susan", "01056785678"));
		
		String result = gson.toJson(list);
		System.out.println(result);
		
		return result;

	}
}

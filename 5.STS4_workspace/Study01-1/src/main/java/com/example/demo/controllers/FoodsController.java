package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FoodsDTO;

@RestController
@RequestMapping("/foods")
public class FoodsController {
	
	
   @PostMapping
   public String insert(FoodsDTO dto) {
      System.out.println(dto.getId() + " : " + dto.getName() + " : " + dto.getLoc());
      return "OK";
   }
}
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.TaiKhoanRepository;

@Controller
public class TaiKhoanController {	
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	@RequestMapping("/login")
	public String enterLoginPage() {
		
		return "login";
	}
	@PostMapping
	public String login() {
		return "home";
	}
}

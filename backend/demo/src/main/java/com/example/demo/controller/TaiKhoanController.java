package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.TaiKhoan;
import com.example.demo.repository.TaiKhoanRepository;

@Controller
public class TaiKhoanController {	
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	@RequestMapping("/dangnhap")
	public String enterLoginPage() {
		
		return "dangnhap";
	}
//	@PostMapping
//	public String login(@ModelAttribute(name = "taikhoan") TaiKhoan taikhoan) {
//		
//		return "home";
//	}
}

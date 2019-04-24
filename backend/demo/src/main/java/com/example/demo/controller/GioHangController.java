package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.GioHangService;

@Controller
public class GioHangController {
	
	@Autowired
	private GioHangService gioHangService;
	
	@GetMapping("/giohang")
	public String xewGioHang(Model model) {
		model.addAttribute("giohang",gioHangService.getDanhSachSanPham());
		return "giohang";
	}
}

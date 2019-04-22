package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "/dangxuat", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/taikhoan", method = RequestMethod.GET)
	public String currentUserName(Model model, Authentication authentication) {
		if(authentication!=null) {
			String name = authentication.getName();
			TaiKhoan taiKhoan = taiKhoanRepository.findByTenTaiKhoan(name);
			model.addAttribute("taikhoan", taiKhoan);
			return "taikhoan";
		}
		return "redirect:/";

	}

}

package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.repository.SanPhamRepository;

@Controller
public class SanPhamController {
	@Autowired
	private SanPhamRepository sanPhamRepository;

	@RequestMapping("/")
	public String listSanPham(Model model,
			@RequestParam(name="page",required = false, defaultValue = "0") Integer page,
			@RequestParam(name="size",required = false, defaultValue = "5") Integer size,
			@RequestParam(name="sort",required = false, defaultValue = "ASC") String sort
			) {
		Sort sortable = null;
		if(sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if(sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		Pageable pageable = PageRequest.of(page, size, sortable);
		model.addAttribute("listSanPham", sanPhamRepository.findSanPhams(pageable));
		return "sanpham-list";
	}
}

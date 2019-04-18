package com.example.demo.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.SanPham;
import com.example.demo.repository.SanPhamRepository;

@Controller
public class SanPhamController {
	@Autowired
	private SanPhamRepository sanPhamRepository;

	@RequestMapping(value = "/sanpham")
	public String listSanPham(Model model,
			@RequestParam(name="page",required = false, defaultValue = "1") Optional<Integer> page ,
			@RequestParam(name="size",required = false, defaultValue = "6") Integer size,
			@RequestParam(name="sort",required = false, defaultValue = "ASC") String sort
			) {
		Sort sortable = null;
		if(sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if(sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		int currentPage = page.orElse(1);
		// Page nó đếm từ 0  - > end - Nên phải trừ giá trị hiện tại xuống 1 để khớp với cái Pageable
		Pageable pageable = PageRequest.of(currentPage - 1, size, sortable);
		Page<SanPham> pageSanPham = sanPhamRepository.findSanPhams(pageable);
		int totalPage = pageSanPham.getTotalPages();
		if(totalPage>0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		model.addAttribute("listSanPham", sanPhamRepository.findSanPhams(pageable));
		return "sanpham";
	}
	
	@RequestMapping(value = "/sanpham/{id}")
	public String getChitietSanPham(Model model, @PathVariable String maSanPham) {
		Optional<SanPham> sp = sanPhamRepository.findById(maSanPham);
		if(sp.isPresent()) {
			model.addAttribute("sanpham", sp.get());
			return "chitiet-sanpham";
		}
		return "home";
	}
}

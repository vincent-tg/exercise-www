package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.SanPham;
import com.example.demo.repository.SanPhamRepository;

@Controller
public class SanPhamController {
	@Autowired
	private SanPhamRepository sanPhamRepository;
	@GetMapping("/sanphams")
	public String viewSanPham() {

		return "danhsachSP";

	}
	@RequestMapping(value="/sanpham",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
	@ResponseBody
	public List<SanPham> getDanhSachSP(){
		List<SanPham> list = (List<SanPham>) sanPhamRepository.findAll();
		return list;
	}
	@RequestMapping("/sanpham/{id}")
	@ResponseBody
	public SanPham findSanPham(@PathVariable String id) {
		Optional<SanPham> sanpham = sanPhamRepository.findById(id);
		if(!sanpham.isPresent()) {
			return null;
		}
		return sanpham.get();
		
	}
	@PostMapping("/sanpham")
	public ResponseEntity<Object> createSanPham(@RequestBody SanPham sanpham){
		SanPham sanpham_new = sanPhamRepository.save(sanpham);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sanpham_new.getMaSanPham()).toUri();
		return ResponseEntity.created(location).build();		
	}
}

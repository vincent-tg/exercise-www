package com.example.demo.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TaiKhoan;
import com.example.demo.repository.TaiKhoanRepository;

@RestController
public class demoRESTController {
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "REST example ! ";
	}
	@RequestMapping(value="/taikhoans",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
	@ResponseBody
	public List<TaiKhoan> getTaikhoans() {
		List<TaiKhoan> list = (List<TaiKhoan>) taiKhoanRepository.findAll();
		return list;
	}
}

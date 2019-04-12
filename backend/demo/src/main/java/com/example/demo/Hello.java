package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Hello {
	@GetMapping(path = "/hello")
	public String hello(@RequestParam(value = "name",defaultValue = "No name")String name, Model model) {
		model.addAttribute("name",name);
		return "hello";
	}
	@GetMapping(path = "/goodbye")
	public String goodbye(@RequestParam(value = "name",defaultValue = "No name")String name, Model model) {
		model.addAttribute("name",name);
		return "goodbye";
	}
}

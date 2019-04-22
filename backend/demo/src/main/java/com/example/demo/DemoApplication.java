package com.example.demo;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.KhachHang;
import com.example.demo.model.Role;
import com.example.demo.model.TaiKhoan;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.TaiKhoanRepository;
import com.example.demo.service.TaiKhoanService;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	@Autowired
    private TaiKhoanService taiKhoanService;

	@Autowired
	private RoleRepository roleRepository;
	@Autowired 
	private KhachHangRepository khachHangRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			TaiKhoan taiKhoan = new TaiKhoan("admin", "123456");
			KhachHang kh = new KhachHang();
			kh.setTaiKhoan(taiKhoan);
			taiKhoan.setKhachHang(kh);
			Role role = new Role();
			role.setId((long) 1);
			role.setTen("admin");
			taiKhoan.setRoles(new HashSet<>(Arrays.asList(role)));		
			roleRepository.save(role);
			taiKhoanService.save(taiKhoan);
			khachHangRepository.save(kh);
		};
	}
}

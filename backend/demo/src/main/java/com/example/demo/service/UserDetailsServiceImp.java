package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.TaiKhoan;
import com.example.demo.repository.TaiKhoanRepository;

public class UserDetailsServiceImp  implements UserDetailsService {

	@Autowired
	private TaiKhoanRepository taiKhoanRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TaiKhoan taikhoan = taiKhoanRepository.findByTenTaiKhoan(username);
		UserBuilder builder = null;
		if(taikhoan!=null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(new BCryptPasswordEncoder().encode(taikhoan.getMatKhau()));
			builder.roles(taikhoan.getRoles().stream().toArray(String[]::new));
		}
		else {
			throw new  UsernameNotFoundException("Tai khoan khong tim thay");
		}
		return builder.build();
	}

}

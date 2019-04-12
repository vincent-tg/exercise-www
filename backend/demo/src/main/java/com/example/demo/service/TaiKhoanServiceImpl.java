package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.TaiKhoan;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.TaiKhoanRepository;

@Service
public class TaiKhoanServiceImpl implements TaikhoanService {
	@Autowired
	private TaiKhoanRepository taikhoanRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public void save(TaiKhoan tk) {
		tk.setPassword(bCryptPasswordEncoder.encode(tk.getPassword()));
		tk.setRoles((Set<Role>) roleRepository.findAll());
		taikhoanRepository.save(tk);
	}

	@Override
	public TaiKhoan findByTen(String ten) {
		return taikhoanRepository.findByTentk(ten);
	}

}

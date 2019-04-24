package com.example.demo.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.TaiKhoan;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.TaiKhoanRepository;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public boolean save(TaiKhoan taikhoan) {
		if(taiKhoanRepository.findByTenTaiKhoan(taikhoan.getTenTaiKhoan()) == null) {
			taikhoan.setMatKhau(bCryptPasswordEncoder.encode(taikhoan.getMatKhau()));
			taiKhoanRepository.save(taikhoan);
			return true;
		}
		return false;
	}

	@Override
	public TaiKhoan findByTen(String ten) {
		return taiKhoanRepository.findByTenTaiKhoan(ten);
	}
}

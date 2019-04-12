package com.example.demo.service;
import com.example.demo.model.TaiKhoan;

public interface TaikhoanService {
	void save(TaiKhoan tk);
	TaiKhoan findByTen(String ten);
}

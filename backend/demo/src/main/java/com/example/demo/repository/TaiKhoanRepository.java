package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TaiKhoan;
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String>{
	TaiKhoan findByTentk(String ten);
}

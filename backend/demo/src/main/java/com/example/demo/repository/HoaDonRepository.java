package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.HoaDon;
import com.example.demo.model.TaiKhoan;

public interface HoaDonRepository extends JpaRepository<HoaDon, String> {
	
}


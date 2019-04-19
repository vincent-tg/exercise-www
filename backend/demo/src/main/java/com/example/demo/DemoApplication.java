package com.example.demo;


import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.HoaDon;
import com.example.demo.repository.HoaDonRepository;
@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		HoaDon hd = new HoaDon("HD01", LocalDate.now());
	}

}

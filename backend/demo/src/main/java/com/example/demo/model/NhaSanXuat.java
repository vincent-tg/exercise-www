package com.example.demo.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Repository;
@Repository
@Entity
public class NhaSanXuat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String maNhaSanXuat;
	private String tenNhaSanXuat;
	private String diaChi;
	@OneToMany(mappedBy = "nhaSanXuat")
	private List<SanPham> sanPhams;
	
	public NhaSanXuat() {
		super();
	}
	public NhaSanXuat(String maNhaSanXuat, String tenNhaSanXuat, String diaChi) {
		super();
		this.maNhaSanXuat = maNhaSanXuat;
		this.tenNhaSanXuat = tenNhaSanXuat;
		this.diaChi = diaChi;
	}
	public String getMaNhaSanXuat() {
		return maNhaSanXuat;
	}
	public void setMaNhaSanXuat(String maNhaSanXuat) {
		this.maNhaSanXuat = maNhaSanXuat;
	}
	public String getTenNhaSanXuat() {
		return tenNhaSanXuat;
	}
	public void setTenNhaSanXuat(String tenNhaSanXuat) {
		this.tenNhaSanXuat = tenNhaSanXuat;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
}

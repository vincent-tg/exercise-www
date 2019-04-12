package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {
	@Id
	private long id;
	private String name;
	@ManyToMany(mappedBy = "roles")
	private Set<TaiKhoan> listTaikhoan;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<TaiKhoan> getListTaikhoan() {
		return listTaikhoan;
	}
	public void setListTaikhoan(Set<TaiKhoan> listTaikhoan) {
		this.listTaikhoan = listTaikhoan;
	}
	
}

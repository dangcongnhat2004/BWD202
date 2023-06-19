package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.model.Admin;


public interface AdminReponsitory extends JpaRepository<Admin, Integer> {

	public Admin findByUsername(String username);
	
}

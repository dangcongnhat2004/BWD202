package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.model.University;
import java.util.List;



public interface UniversityRepository extends JpaRepository<University, Long> {

	public University findByUsername(String username);
	public University findByUniversityId(int universityId);
}

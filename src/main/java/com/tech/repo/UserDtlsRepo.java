package com.tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.entity.UserDtlsEntity;

import jakarta.persistence.Entity;
import java.util.List;


@Repository
public interface UserDtlsRepo extends JpaRepository<UserDtlsEntity, Integer>{
	
	public UserDtlsEntity findByEmail(String email);

	

}

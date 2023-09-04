package com.idrbt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idrbt.entity.Login;



public interface LoginRepository extends JpaRepository<Login, Long> {
	
	 Optional<Login> findByAccountNum(Long accountNum);

}
package com.example.oncall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oncall.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	String findPasswordById(String username);
}

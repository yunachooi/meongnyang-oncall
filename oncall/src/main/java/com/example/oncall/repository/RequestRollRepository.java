package com.example.oncall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oncall.entity.RequestRoll;

public interface RequestRollRepository extends JpaRepository<RequestRoll, Integer>{
	
}

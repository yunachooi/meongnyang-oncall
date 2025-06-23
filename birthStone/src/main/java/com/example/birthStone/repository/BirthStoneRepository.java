package com.example.birthStone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.birthStone.entity.BirthStone;

public interface BirthStoneRepository extends JpaRepository<BirthStone, Integer>{
	
}

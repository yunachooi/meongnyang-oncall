package com.example.zodiacSign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.zodiacSign.entity.Sign;

public interface SignRepository extends JpaRepository<Sign, Integer> {

}

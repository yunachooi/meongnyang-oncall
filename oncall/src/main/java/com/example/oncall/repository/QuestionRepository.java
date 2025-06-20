package com.example.oncall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oncall.entity.Question;


public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
}

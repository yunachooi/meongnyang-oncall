package com.example.oncall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oncall.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	List<Question> findByVetUsername(String vetUsername);
}

package com.example.oncall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oncall.entity.Question;
import com.example.oncall.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	public Optional<Question> getQuestionById(int q_no) {
		return questionRepository.findById(q_no);
	}

	public Question save(Question question) {
		return questionRepository.save(question);
	}
	
	public List<Question> findByVetUsername(String vet_username) {
        return questionRepository.findByVetUsername(vet_username);
    }

}

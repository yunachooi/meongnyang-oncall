package com.example.oncall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oncall.entity.Veterinarian;
import com.example.oncall.repository.VeterinarianRepository;

@Service
public class VeterinarianService {
	@Autowired
	VeterinarianRepository veterinarianRepository;
	
	public List<Veterinarian> getAllVet() {
	    return veterinarianRepository.findAll();
	}
	
	public Optional<Veterinarian> getVetByUsername(String username) {
		return veterinarianRepository.findById(username);
	}
}

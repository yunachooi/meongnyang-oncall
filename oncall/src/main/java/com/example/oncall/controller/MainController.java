package com.example.oncall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.oncall.entity.Veterinarian;
import com.example.oncall.service.VeterinarianService;

@Controller
public class MainController {
	@Autowired
    private VeterinarianService veterinarianService;
	
	@GetMapping("/")
	public String root(Model model) {
		List<Veterinarian> vets = veterinarianService.getAllVet();
	    model.addAttribute("veterinarians", vets);
		return "index";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
}

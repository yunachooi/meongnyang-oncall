package com.example.oncall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.oncall.entity.Veterinarian;
import com.example.oncall.service.VeterinarianService;

@Controller
public class VeterinarianController {

    
	@Autowired
	VeterinarianService veterinarianService;

	@GetMapping("/counsel")
	public String getCounsel() {
		return "counsel";
	}
	
	@PostMapping("/counsel")
	public String counsel(@RequestParam("username") String username,Model model) {
		System.out.println(username);
		
		model.addAttribute("veterinarians", veterinarianService.getVetByUsername(username));
		
		return "redirect:/counsel";
	}
}

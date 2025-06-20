package com.example.oncall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VeterinarianController {
	@GetMapping("/counsel")
	public String getCounsel() {
		return "counsel";
	}
	
	@PostMapping("/counsel")
	public String counsel(@RequestParam("username") String username) {
		System.out.println(username);
		return "redirect:/counsel";
	}
}

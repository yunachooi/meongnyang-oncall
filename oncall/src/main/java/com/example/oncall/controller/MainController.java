package com.example.oncall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.oncall.entity.Veterinarian;
import com.example.oncall.service.VeterinarianService;

import jakarta.servlet.http.HttpSession;

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
  
	@GetMapping("/mypage")
    public String myPage(HttpSession session, Model model) {
        Object loginInfo = session.getAttribute("loginInfo");
        if (loginInfo == null) {
            return "redirect:/login";
        }
        model.addAttribute("loginInfo", loginInfo);
        return "mypage";
    }

    @GetMapping("/registForm")
    public String registForm() {
        return "regist";
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

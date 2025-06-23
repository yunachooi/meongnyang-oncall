package com.example.oncall.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.oncall.dto.UserDto;
import com.example.oncall.entity.User;
import com.example.oncall.entity.Veterinarian;
import com.example.oncall.service.UserService;
import com.example.oncall.service.VeterinarianService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@Autowired
    private VeterinarianService veterinarianService;
	@Autowired
	private UserService userService;
	
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
	    UserDto loginInfo = (UserDto) session.getAttribute("loginInfo");
	    if (loginInfo == null) {
	        return "redirect:/login";
	    }

	    Optional<User> userOpt = userService.getUserInfo(loginInfo.getUsername());
	    if (userOpt.isPresent()) {
	        model.addAttribute("user", userOpt.get());
	    } else {
	        model.addAttribute("error", "사용자 정보를 찾을 수 없습니다.");
	    }

	    return "mypage";
	}


    @GetMapping("/registForm")
    public String registForm() {
        return "regist";
    }
}

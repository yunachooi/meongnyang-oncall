package com.example.oncall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.oncall.dto.UserDto;
import com.example.oncall.entity.Question;
import com.example.oncall.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String login(UserDto userDto, Model model, HttpSession session) {
	    if (userService.loginCheck(userDto)) {
	        session.setAttribute("loginInfo", userDto);

	        model.addAttribute("msg", "로그인 성공!");
	        return "redirect:/";
	    }
	    model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
	    return "login";
	}

	@PostMapping("/regist")
	public String regist(UserDto userDto, Model model) {
		boolean success = userService.registUser(userDto);
		if (success) {
			
			return "login";
		}
		return "회원가입 실패!";
	}
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
	
	@GetMapping("/write")
	public String showWritePage(Model model) {
	    model.addAttribute("counsel", new Question());
	    return "write";
	}
}

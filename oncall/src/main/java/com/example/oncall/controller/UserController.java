package com.example.oncall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.oncall.dto.UserDto;
import com.example.oncall.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String login(UserDto userDto, Model model) {
		if (userService.loginCheck(userDto)) {
			model.addAttribute("msg", "로그인 성공!");
			return "redirect:/";
		}
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
}

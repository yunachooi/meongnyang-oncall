package com.example.oncall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oncall.entity.User;
import com.example.oncall.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public void login(User user) {
		//엔티티를 DTO로 변환시키는 매서드 필요
		
	}
}

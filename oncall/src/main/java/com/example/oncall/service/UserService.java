package com.example.oncall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oncall.dto.UserDto;
import com.example.oncall.entity.User;
import com.example.oncall.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public Boolean loginCheck(UserDto userDto) {
		System.out.println("로그인 체크: " + userDto.getUsername() + ", " + userDto.getPassword());
		User user = new User();
		user = userRepository.findByUsername(userDto.getUsername());
		System.out.println("유저정보: " + user);
		if (user != null && user.getPassword().equals(userDto.getPassword())) {
			System.out.println("로그인 성공!");
			return true;
		}
		return false;
	}
}

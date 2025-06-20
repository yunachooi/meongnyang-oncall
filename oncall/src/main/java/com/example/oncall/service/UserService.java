package com.example.oncall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oncall.dto.UserDto;
import com.example.oncall.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public boolean loginCheck(UserDto userDto) {
		if (userRepository.findById(userDto.getUsername()) != null) {
			if(userDto.getPassword().equals(userRepository.findPasswordById(userDto.getPassword()))) {
				System.out.println("로그인 성공!");
				return true;
			}

		}

		return false;

	}
}

package com.example.oncall.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oncall.dto.RequestRollDto;
import com.example.oncall.dto.UserDto;
import com.example.oncall.entity.RequestRoll;
import com.example.oncall.entity.User;
import com.example.oncall.repository.RequestRollRepository;
import com.example.oncall.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RequestRollRepository requestRollRepository;
	
	private User convert(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setP_name(userDto.getP_name());
		user.setP_phone(userDto.getP_phone());
		user.setP_email(userDto.getP_email());
		user.setP_role(userDto.getP_role());

		return user;
	}
	


	public boolean loginCheck(UserDto userDto) {
		User user = userRepository.findByUsername(userDto.getUsername());
		return user != null && user.getPassword().equals(userDto.getPassword());
	}
	

	public boolean registUser(UserDto userDto) {
		try {
			User user = convert(userDto);
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			// 로깅 등 처리 가능
			return false;
		}
	}
	public Optional<User> getUserInfo(String username) {
		
		return userRepository.findById(username);
	}
	
	public RequestRoll requestRoll(RequestRollDto rollDto) {
		RequestRoll roll = new RequestRoll();
		
		roll.setUsername(rollDto.getUsername());
		roll.setLisencenum(rollDto.getLisenceNum());
		return requestRollRepository.save(roll);
	}
}

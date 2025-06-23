package com.example.oncall.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.oncall.dto.QuestionDto;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.oncall.dto.RequestRollDto;
import com.example.oncall.dto.UserDto;
import com.example.oncall.entity.Question;
import com.example.oncall.entity.User;
import com.example.oncall.service.QuestionService;
import com.example.oncall.service.UserService;

import jakarta.servlet.http.HttpSession;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private QuestionService questionService;

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
	public String showWritePage(@RequestParam(value = "vetUsername", required = false) String vetUsername, Model model) {
	    model.addAttribute("counsel", new Question());
	    model.addAttribute("vetUsername", vetUsername);
	    return "write";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute QuestionDto questionDto) {
	    Question question = questionDto.toEntity();
	    questionService.save(question);
	    return "redirect:/";
	}
  
	@GetMapping("/getUserData")
	@ResponseBody
	public ResponseEntity<?> getUserData(HttpSession session) {
	    UserDto loginInfo = (UserDto) session.getAttribute("loginInfo");

	    if (loginInfo == null) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
	    }

	    Optional<User> userOpt = userService.getUserInfo(loginInfo.getUsername());
	    if (userOpt.isPresent()) {
	        return ResponseEntity.ok(userOpt.get());
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자 정보를 찾을 수 없습니다.");
	    }
	}
  
	@PostMapping("/requestRoll")
	public String requestRoll(RequestRollDto requestRollDto, HttpSession session){
		UserDto user = new UserDto();
		user = (UserDto) session.getAttribute("loginInfo");
		System.out.println(user);
		requestRollDto.setUsername(user.getUsername());
		
		if(userService.requestRoll(requestRollDto) != null) {
			return "index";
		}
		
		return "mypage";
		
	}
}

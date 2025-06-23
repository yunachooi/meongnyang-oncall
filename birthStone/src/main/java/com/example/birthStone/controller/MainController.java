package com.example.birthStone.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.birthStone.entity.BirthStone;
import com.example.birthStone.repository.BirthStoneRepository;

@Controller
public class MainController {
	
	@Autowired
	private BirthStoneRepository bsRepository;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("month") int month, Model model) {
		Optional<BirthStone> info = bsRepository.findById(month);
		System.out.println(info);
		model.addAttribute("info", info);
	    return "detail";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username")String username, @RequestParam("password")String password) {
		if("admin".equals(username) && "1234".equals(password)) {
			return  "management";
		}
		return "login";
	}
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody BirthStone birthStone) {
	    bsRepository.save(birthStone);
	    return ResponseEntity.ok("등록 성공");
	}
	
	@GetMapping("/getInfo")
	public ResponseEntity<BirthStone> getInfo(@RequestParam("b_no") int b_no) {
	    Optional<BirthStone> birthStoneOpt = bsRepository.findById(b_no);
	    if (birthStoneOpt.isPresent()) {
	        return ResponseEntity.ok(birthStoneOpt.get());
	    } else {
	        return ResponseEntity.notFound().build(); // 404 반환
	    }
	}
	

}

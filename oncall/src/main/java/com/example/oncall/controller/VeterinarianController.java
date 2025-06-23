package com.example.oncall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.oncall.entity.Question;
import com.example.oncall.entity.Veterinarian;
import com.example.oncall.repository.QuestionRepository;
import com.example.oncall.service.VeterinarianService;

@Controller
public class VeterinarianController {

    @Autowired
    private VeterinarianService veterinarianService;
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/counsel")
    public String getCounsel(Model model) {
        model.addAttribute("vet", null);
        return "counsel";
    }

    @PostMapping("/counsel")
    public String counsel(@RequestParam("username") String username, Model model) {
        System.out.println("요청 받은 수의사 username: " + username);

        Veterinarian vet = veterinarianService.getVetByUsername(username)
            .orElseThrow(() -> new RuntimeException("해당 수의사가 존재하지 않습니다."));

        model.addAttribute("vet", vet);
        List<Question> list = questionRepository.findByVetUsername(username);        
        model.addAttribute("qna", list);
        
        return "counsel";
    }
}

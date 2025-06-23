package com.example.zodiacSign.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.zodiacSign.dto.SignDto;
import com.example.zodiacSign.entity.Sign;
import com.example.zodiacSign.repository.SignRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private SignRepository signRepository;
    
    @PostMapping("regist")
    public String postRegist(SignDto signDto) {
        Sign sign = toEntity(signDto);
        
        signRepository.save(sign);
        return "management";
    }
    
    @GetMapping("list")
    public @ResponseBody List<SignDto> getList() {
        List<Sign> signs = signRepository.findAll();
        return signs.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    
    @DeleteMapping("delete/{id}")
    public @ResponseBody String deleteSign(@PathVariable("id") Integer id) {
        signRepository.deleteById(id);
        return "삭제 성공";
    }
    
    @GetMapping("get/{id}")
    public @ResponseBody SignDto getSign(@PathVariable("id") Integer id) {
        Sign sign = signRepository.findById(id).orElseThrow();
        return toDto(sign);
    }

    @PostMapping("update")
    public String update(SignDto signDto, RedirectAttributes redirectAttributes) {
        Sign sign = toEntity(signDto);
        signRepository.save(sign);
        redirectAttributes.addFlashAttribute("success", true);
        return "management";
    }
    
    private Sign toEntity(SignDto dto) {
        return Sign.builder()
                .s_no(dto.getS_no())
                .s_name(dto.getS_name())
                .s_info(dto.getS_info())
                .start_month(dto.getStart_month())
                .start_day(dto.getStart_day())
                .end_month(dto.getEnd_month())
                .end_day(dto.getEnd_day())
                .build();
    }
    
    private SignDto toDto(Sign sign) {
        SignDto dto = new SignDto();
        dto.setS_no(sign.getS_no());
        dto.setS_name(sign.getS_name());
        dto.setS_info(sign.getS_info());
        dto.setStart_month(sign.getStart_month());
        dto.setStart_day(sign.getStart_day());
        dto.setEnd_month(sign.getEnd_month());
        dto.setEnd_day(sign.getEnd_day());
        return dto;
    }
    
}

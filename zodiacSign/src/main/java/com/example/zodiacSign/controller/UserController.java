package com.example.zodiacSign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.zodiacSign.dto.SignDto;
import com.example.zodiacSign.entiry.Sign;
import com.example.zodiacSign.repository.SignRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SignRepository signRepository;

    @PostMapping("/find")
    public SignDto findZodiac(@RequestParam("month") int month, @RequestParam("day") int day) {
        List<Sign> signs = signRepository.findAll();

        for (Sign sign : signs) {
            if (isDateInRange(month, day, sign)) {
                return toDto(sign);
            }
        }
        return null;
    }

    private boolean isDateInRange(int month, int day, Sign sign) {
        int startMonth = sign.getStart_month();
        int startDay = sign.getStart_day();
        int endMonth = sign.getEnd_month();
        int endDay = sign.getEnd_day();

        if (startMonth > endMonth) {
            if ((month == startMonth && day >= startDay) ||
                (month == endMonth && day <= endDay) ||
                (month > startMonth || month < endMonth)) {
                return true;
            }
        }

        else if (startMonth < endMonth) {
            if ((month == startMonth && day >= startDay) ||
                (month == endMonth && day <= endDay) ||
                (month > startMonth && month < endMonth)) {
                return true;
            }
        }

        else {
            if (month == startMonth && day >= startDay && day <= endDay) {
                return true;
            }
        }
        return false;
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

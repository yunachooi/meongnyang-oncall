package com.example.oncall.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class QuestionDto {
	private int q_no;
    private String username;
    private String qTitle;
    private String qContent;
    private Date q_time;
    private String q_status;
    private int ani_no;
}

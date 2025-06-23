package com.example.oncall.dto;


import java.util.Date;

import com.example.oncall.entity.Question;

import lombok.Data;

@Data
public class QuestionDto {
	private int q_no;
    private String username;
    private String q_title;
    private String q_content;
    private Date q_time;
    private String q_status;
    private int ani_no;
    private String vet_username;
    
    public Question toEntity() {
        Question question = new Question();
        question.setUsername(this.username);
        question.setQ_title(this.q_title);
        question.setQ_content(this.q_content);
        question.setQ_status(this.q_status);
        question.setAni_no(this.ani_no);
        question.setVetUsername(this.vet_username);
        return question;
    }
}

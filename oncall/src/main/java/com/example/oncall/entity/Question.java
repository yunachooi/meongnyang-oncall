package com.example.oncall.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_question")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {
    @Id
    private int q_no;

    @Column(length = 100)
    private String username;

    private int ani_no;

    @Column(name = "q_title", length = 2000)
    private String q_title;

    @Column(name = "q_content", length = 2000)
    private String q_content;

    private Date q_time;

    @Column(length = 1)
    private String q_status;
}

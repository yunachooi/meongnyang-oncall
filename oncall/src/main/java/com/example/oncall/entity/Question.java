package com.example.oncall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tbl_question")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {

    @Id
    @Column(name = "q_no")
    private int q_no;

    @Column(length = 100)
    private String username;

    @Column(name = "ani_no")
    private int ani_no;

    @Column(name = "q_title", length = 2000)
    private String q_title;

    @Column(name = "q_content", length = 2000)
    private String q_content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "q_time")
    private Date q_time;

    @Column(length = 1, name = "q_status")
    private String q_status;

    @OneToOne(mappedBy = "question", fetch = FetchType.LAZY)
    private Answer answer;
}

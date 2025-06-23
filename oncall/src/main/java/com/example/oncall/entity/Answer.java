package com.example.oncall.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_answer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {

    @Id
    @Column(name = "a_no")
    private Integer a_no;

    @Column(name = "a_content", length = 2000)
    private String a_content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "a_time")
    private String a_time;

    @OneToOne
    @JoinColumn(name = "q_no")
    private Question question;
}

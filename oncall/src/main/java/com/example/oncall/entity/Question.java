package com.example.oncall.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	@Column(name = "q_no")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq_gen")
	@SequenceGenerator(name = "question_seq_gen", sequenceName = "tbl_question_seq", allocationSize = 1)
	private int q_no;


    @Column(length = 100)
    private String username;

    @Column(name = "ani_no")
    private int ani_no;
    
    @Column(name = "vet_username")
    private String vetUsername;


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

    @PrePersist
    protected void onCreate() {
        if (this.q_time == null) {
            this.q_time = new Date();
        }
        if (this.q_status == null) {
            this.q_status = "N";
        }
    }
}

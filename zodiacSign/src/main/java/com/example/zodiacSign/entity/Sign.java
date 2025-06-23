package com.example.zodiacSign.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name="tbl_sign")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Sign {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s_no;
	
	private String s_name;
	private String s_info;
	
	private int start_month;
	private int start_day;
	private int end_month;
	private int end_day;
	
}

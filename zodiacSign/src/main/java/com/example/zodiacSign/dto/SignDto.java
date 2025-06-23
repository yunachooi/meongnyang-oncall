package com.example.zodiacSign.dto;

import lombok.Data;

@Data
public class SignDto {
	private int s_no;
	private String s_name;
	private String s_info;
	private int start_month;
	private int start_day;
	private int end_month;
	private int end_day;
}

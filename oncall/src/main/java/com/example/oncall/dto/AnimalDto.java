package com.example.oncall.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AnimalDto {
	private int ani_no;
	private String username;
	private String ani_name;
	private String ani_breed;
	private Date ani_birth;
}

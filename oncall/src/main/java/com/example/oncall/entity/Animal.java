package com.example.oncall.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_animal")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Animal {
	@Id
	private int ani_no;
	
	private String username;
	private String ani_name;
	private String ani_breed;
	@Temporal(TemporalType.DATE)
	private Date ani_birth;
}

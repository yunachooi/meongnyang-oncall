package com.example.oncall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_requestroll")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestRoll {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int r_no;
	private String username;
	private String lisencenum;
	
	
}



package com.example.birthStone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_birthstone")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BirthStone {
	@Id
	private Integer b_no;
	private String b_name;
	private String b_info;
}

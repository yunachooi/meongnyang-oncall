package com.example.oncall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_oncall_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	private String username;
	private String password;
	private String p_name;
	private String p_phone;
	private String p_email;
	private String p_role;
}

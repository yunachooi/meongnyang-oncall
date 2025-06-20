package com.example.oncall.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_veterinarian")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veterinarian {
	@Id
    @Column(length = 100)
    private String username;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private User user; 

    @Column(length = 100)
    private String v_hospital;

    @Column(length = 50)
    private String v_area;

    @Column(length = 50)
    private String v_major;

    @Column(length = 1)
    private String v_status;
}

package com.example.oncall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oncall.entity.Veterinarian;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Integer> {

}

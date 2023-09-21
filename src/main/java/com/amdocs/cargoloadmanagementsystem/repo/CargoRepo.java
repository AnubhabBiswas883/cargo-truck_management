package com.amdocs.cargoloadmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.cargoloadmanagementsystem.model.Cargo;



@Repository
public interface CargoRepo extends JpaRepository<Cargo, Integer> {

	//findByxxx
	//Customized queries
}
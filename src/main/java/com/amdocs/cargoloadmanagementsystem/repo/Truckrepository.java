package com.amdocs.cargoloadmanagementsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.amdocs.cargoloadmanagementsystem.model.Cargo;
import com.amdocs.cargoloadmanagementsystem.model.Truck;

    
	@Repository
	public interface Truckrepository extends JpaRepository<Truck, Long> {
      List<Truck> findByCargo(Cargo cargo);
	  Truck findByCargoAndId(Cargo cargo,Long id); 
	}



package com.amdocs.cargoloadmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.cargoloadmanagementsystem.exception.CargoDoesntExistException;
import com.amdocs.cargoloadmanagementsystem.model.Cargo;
import com.amdocs.cargoloadmanagementsystem.model.Truck;
import com.amdocs.cargoloadmanagementsystem.repo.CargoRepo;
//import com.amdocs.cargoloadmanagementsystem.repo.Truckrepo;
import com.amdocs.cargoloadmanagementsystem.repo.Truckrepository;


@Service
public class TruckService {

private Truckrepository truckrepo;

private CargoRepo cargorepo;
	
    @Autowired
	public TruckService(Truckrepository truckrepo, CargoRepo cargorepo) {
		//super();
	     this.cargorepo = cargorepo;
         this.truckrepo = truckrepo;
	}


	//crud operations
	//savebook data
	//insert query is generated at runtime by server using hibernate and jpa
	public Truck saveTruck(Integer cargoid, Truck truck) throws CargoDoesntExistException
	{   
		Cargo cargo=cargorepo.findById(cargoid).orElse(null);
		if(cargo!=null) {
			truck.setCargo(cargo);
			return truckrepo.save(truck); 
		}
		else {
	       throw new CargoDoesntExistException("Cargo Doesn't Exist");
	}
	}
	

	public List<Truck> getAlltrucks()
	{
		return truckrepo.findAll();
	}
	
	public 	Truck getTruckById(Long id)
	{
		return truckrepo.findById(id).orElse(null);
	}

	public Truck updateTruck(Integer cargoid,Long id, Truck truck)
	{   
		Cargo cargo=cargorepo.findById(cargoid).orElse(null);
		
		Truck existingtruck=truckrepo.findByCargoAndId(cargo,id);
		
		if(existingtruck!=null)
		{
			existingtruck.setTruck_name(truck.getTruck_name());
			existingtruck.setStartDate(truck.getStartDate());
			existingtruck.setTruck_number(truck.getTruck_number());

		return truckrepo.save(existingtruck);
		}
		return null;
	}
	public List<Truck> getTrucksByCargoId(Integer cargoid) {
		Cargo cargo=cargorepo.findById(cargoid).orElse(null);
		return truckrepo.findByCargo(cargo);
	}
	
	public void deleteTruck(Long id)
	{
		 truckrepo.deleteById(id);
	}
	
}

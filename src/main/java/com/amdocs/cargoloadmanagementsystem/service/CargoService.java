package com.amdocs.cargoloadmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.cargoloadmanagementsystem.model.Cargo;
import com.amdocs.cargoloadmanagementsystem.repo.CargoRepo;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepo cargoRepo;


	public boolean saveCargo(Cargo cargo) {
		// TODO Auto-generated method stub

		// interact db s/w to store data into the database

		Cargo cargoSave = cargoRepo.save(cargo);
		boolean flag = false;

		if (cargoSave != null)
			flag = true;

		return flag;
	}

	
	public List<Cargo> getAllCargo() {
		// TODO Auto-generated method stub
		//select *from employee;
		List<Cargo> cargoRecords = cargoRepo.findAll();
		return cargoRecords;
	}

	public Cargo getCargoId(int id) {
		// TODO Auto-generated method stub
		//select *From employee where eno=?;
		Optional<Cargo> cargoId = cargoRepo.findById(id);
		Cargo cargo = cargoId.get();
		return cargo;
	}
	

	public boolean updateCargo(Cargo car) {
		// TODO Auto-generated method stub
		
		//Record is exist or not have to check once record is exist then update the data
		
			
		
		return saveCargo(car);
	}

	public boolean deleteCargo(int id) {
		// TODO Auto-generated method stub
		//Record is exist or not have to check first then delete
		Cargo cargo = getCargoId(id);
		boolean flag=false;
		if(cargo!=null)
		{
			cargoRepo.delete(cargo);
		flag=true;	
		}
		
			
		
		return flag;
		
		
	}

}

package com.amdocs.cargoloadmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.cargoloadmanagementsystem.exception.CargoDoesntExistException;
import com.amdocs.cargoloadmanagementsystem.model.Truck;
import com.amdocs.cargoloadmanagementsystem.service.CargoService;
//import com.amdocs.cargoloadmanagementsystem.service.CargoService;
import com.amdocs.cargoloadmanagementsystem.service.TruckService;

@RestController
@RequestMapping("/trucks")
public class TruckController {
	
	private TruckService truckserv;

	private CargoService cargoserv;
    
	@Autowired
	public TruckController(TruckService truckserv,CargoService cargoserv) {
		//super();
		this.truckserv = truckserv;
		this.cargoserv=cargoserv;
	}
	//Basic URI for API Testing
	
	//http://localhost:8085/books
	
	//insert into book_entity(book_name, pub_date)values(?,?);
	//http://localhost:8085/books/insert
	@PostMapping("/insert/{cargoid}")
	public Truck saveTruck(@PathVariable Integer cargoid,@RequestBody Truck truck) throws CargoDoesntExistException
	{
		return truckserv.saveTruck(cargoid,truck);
	}
	
	//select *from book_entity
	//http://localhost:8085/books/allbooks

	@GetMapping("/alltrucks")
	public List<Truck> getAlltrucks()
	{
		return truckserv.getAlltrucks();
		
	}
	
	//select *from book_entity where isbnno=?
	//http://localhost:8085/books/1
	@GetMapping("/{id}")
	public Truck getTruckById(@PathVariable Long id)
	{
		return truckserv.getTruckById(id);
	}
	
	//http://localhost:8085/books/update/1
	@PutMapping("/update/{cargoid}/{id}")
	public Truck updateTruck(@PathVariable Integer cargoid,@PathVariable Long id,@RequestBody Truck truck)
	{
		return truckserv.updateTruck(cargoid,id,truck);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteTruck(@PathVariable Long id)
	{
		truckserv.deleteTruck(id);
	}
	
	@GetMapping("/cargo/{cargoid}")
	public List<Truck> getTrucksByCargoId(@PathVariable Integer cargoid){
		return truckserv.getTrucksByCargoId(cargoid);
	}
}

package com.amdocs.cargoloadmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.cargoloadmanagementsystem.model.Cargo;
import com.amdocs.cargoloadmanagementsystem.service.CargoService;

@Controller
public class CargoController {
    
	@Autowired
	private CargoService cargoService;
	
	

	
	@RequestMapping("/")
	public String loadForm(Model model)
	{
		Cargo cargo=new Cargo();
		model.addAttribute("cargo", cargo);
		
		return "cargo";
	}
	


	@RequestMapping("/insert")
	public String handleCargoForm(@ModelAttribute("cargo")Cargo cargo,Model model)
	{
		
		//intract to service layer
		boolean saveCargo = cargoService.saveCargo(cargo);
		
		String msg="";
		
		if(saveCargo)
			msg="Data Inserted SuccessFully";
		else
			msg="Data Not Inserted SuccessFully";
		
		model.addAttribute("msg", msg);
		return "cargo";
	}
	
	
	@RequestMapping("/viewAll")
	public String viewAllCargos(Model model)
	{
		//fetch the data from the databse ,can interact service layer
		List<Cargo> allCargos = cargoService.getAllCargo();
		
		model.addAttribute("cargos", allCargos);
		return "view";
	}
	
	@RequestMapping("/deleteCargo")
	public String deleteCargo(@RequestParam("cid")     int id)
	{
		boolean flag = cargoService.deleteCargo(id);
		
		if(flag)
		return "redirect:/viewAll";
		else
		return "redirect:/viewAll";
	}
	
	
	@RequestMapping("/editCargo")
	public String editCargo(@RequestParam("cid")   int id,Model model)
	{
		Cargo cargo = cargoService.getCargoId(id);
		
		model.addAttribute("cargo", cargo);
		return "editCargo";
	}
	
	@RequestMapping("/update")
	public String updateCargo1(Cargo cargo)
	{
		boolean updateCargo = cargoService.updateCargo(cargo);
		
		return "redirect:/viewAll";

	}
	
	
}

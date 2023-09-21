package com.amdocs.cargoloadmanagementsystem.exception;

@SuppressWarnings("serial")
public class CargoDoesntExistException extends Exception{
	
  public CargoDoesntExistException(String Message) {
		
		System.out.println(Message);
	}


}

package com.amdocs.cargoloadmanagementsystem.model;

import java.util.*;

import javax.persistence.*;


@Entity
@Table(name= "Cargos")
public class Cargo {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cargoid;
	@Column(name="Name")
	private String cargoname;
	@Column(name="PhoneNo")
	private String phno;
	@Column(name="email")
	private String email;
	@Column(name="Place")
	private String place;
	@OneToMany(mappedBy="cargo",cascade=CascadeType.ALL)
	private Set<Truck> truck= new HashSet<>();
	
	
	
	public Cargo(Integer cargoid, String cargoname, String phno, String email, String place) {
		super();
		this.cargoid = cargoid;
		this.cargoname = cargoname;
		this.phno = phno;
		this.email = email;
		this.place = place;
	}
	
	
	
	public Cargo() {
		//super();
	}



	public Integer getCargoid() {
		return cargoid;
	}
	public void setCargoid(Integer cargoid) {
		this.cargoid = cargoid;
	}
	public String getCargoname() {
		return cargoname;
	}
	public void setCargoname(String cargoname) {
		this.cargoname = cargoname;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	
}

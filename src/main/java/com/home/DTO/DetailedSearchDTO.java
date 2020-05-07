package com.home.DTO;

import com.home.Entity.Address;
import com.home.Entity.AppUser;
import com.home.Entity.Specialization;

public class DetailedSearchDTO {

	/*
	 * public String getArea_Name();
	 * 
	 * public String getSpecialization_Name();
	 * 
	 * public String getUser_Name();
	 * 
	 * public String getAccount_Type();
	 * 
	 * public String getUser_Mobile();
	 * 
	 * public String getGovernoratName();
	 * 
	 * public String getName();
	 */
	
	
	private Specialization specialization;
	
	private AppUser appUser;
	
	public Address address;

	
	
	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
	

	
}

package com.home.DTO;

import com.home.Entity.AppUser;
import com.home.Entity.Address;
import com.home.Entity.Specialization;

public class UserRegisterationDto {
	
	private AppUser appUser;
	private Address address ;
	private Specialization specialization;

	
	public AppUser getAppUser() {
		return appUser;
	}    
	public void setUser(AppUser appUser) {
		this.appUser = appUser;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address =address;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	
	
}

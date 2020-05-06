package com.home.DTO;

import com.home.Entity.Address;
import com.home.Entity.AppUser;

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
	
	public AppUser appUser;
	
	public Address address;

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

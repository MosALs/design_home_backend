package com.home.DTO;

import java.util.List;

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
	
	private String specializationName;
	private String areaName;
	private String governorateName;
	private String accountType;
	private List<AppUser> appUsers;
	
	private AppUser appUser;
	private Address address;
	
	
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccounrType(String accounrType) {
		this.accountType = accounrType;
	}
	public String getSpecializationName() {
		return specializationName;
	}
	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getGovernorateName() {
		return governorateName;
	}
	public void setGovernorateName(String governorateName) {
		this.governorateName = governorateName;
	}
	public List<AppUser> getAppUsers() {
		return appUsers;
	}
	public void setAppUsers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
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

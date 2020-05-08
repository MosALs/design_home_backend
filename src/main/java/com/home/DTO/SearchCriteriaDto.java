package com.home.DTO;

import com.home.Entity.AppUser;
import com.home.Entity.Specialization;

public class SearchCriteriaDto {
	
	private String user_name;

	private String account_Type;

	private String user_Mobile;
	private AppUser appUser;

	
	private String specializationName;
	
	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public Specialization specialization;


	
	
	public String getSpecializationName() {
		return specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}


	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAccount_Type() {
		return account_Type;
	}

	public void setAccount_Type(String account_Type) {
		this.account_Type = account_Type;
	}

	public String getUser_Mobile() {
		return user_Mobile;
	}

	public void setUser_Mobile(String user_Mobile) {
		this.user_Mobile = user_Mobile;
	}

	
	
}

package com.home.DTO;

import java.util.List;

import com.home.Entity.Address;
import com.home.Entity.AppUser;
import com.home.entities.AppUserEntity;
import com.home.entities.LocationEntity;
import com.home.entities.ShopEntity;

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
	
	private List<AppUserEntity> appUserEntitiesList;
	private List<AppUser> appUsers;
	private AppUserEntity appUserEntity;
	private AppUser appUser;
	private Address address;
	private LocationEntity locationEntity;
	
	private ShopEntity shopEntity;
	private List <ShopEntity> shopEntityList;



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

	public AppUserEntity getAppUserEntity() {
		return appUserEntity;
	}

	public void setAppUserEntity(AppUserEntity appUserEntity) {
		this.appUserEntity = appUserEntity;
	}

	public LocationEntity getLocationEntity() {
		return locationEntity;
	}

	public void setLocationEntity(LocationEntity locationEntity) {
		this.locationEntity = locationEntity;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public List<AppUserEntity> getAppUserEntitiesList() {
		return appUserEntitiesList;
	}
	public void setAppUserEntitiesList(List<AppUserEntity> appUserEntitiesList) {
		this.appUserEntitiesList = appUserEntitiesList;
	}
	public ShopEntity getShopEntity() {
		return shopEntity;
	}
	public void setShopEntity(ShopEntity shopEntity) {
		this.shopEntity = shopEntity;
	}
	public List<ShopEntity> getShopEntityList() {
		return shopEntityList;
	}
	public void setShopEntityList(List<ShopEntity> shopEntityList) {
		this.shopEntityList = shopEntityList;
	}
	
	

	
	
	
	
}

package com.home.DTO;

import com.home.entities.AccountTypeEntity;
import com.home.entities.AppUserEntity;
import com.home.entities.LocationEntity;
import com.home.entities.ShopEntity;
import com.home.entities.SpecializationEntity;
import com.home.entities.UserRoleEntity;


public class UserRegisterationDto {

	private AppUserEntity appUserEntity;
	private SpecializationEntity specializationEntity;
	private LocationEntity locationEntity;
	private UserRoleEntity userRoleEntity;
	private ShopEntity shopEntity;
	public AccountTypeEntity getAccountTypeEntity() {
		return accountTypeEntity;
	}

	public void setAccountTypeEntity(AccountTypeEntity accountTypeEntity) {
		this.accountTypeEntity = accountTypeEntity;
	}

	private AccountTypeEntity accountTypeEntity;
	
	public AppUserEntity getAppUserEntity() {
		return appUserEntity;
	}

	public void setAppUserEntity(AppUserEntity appUserEntity) {
		this.appUserEntity = appUserEntity;
	}

	public SpecializationEntity getSpecializationEntity() {
		return specializationEntity;
	}

	public void setSpecializationEntity(SpecializationEntity specializationEntity) {
		this.specializationEntity = specializationEntity;
	}

	public LocationEntity getLocationEntity() {
		return locationEntity;
	}

	public void setLocationEntity(LocationEntity locationEntity) {
		this.locationEntity = locationEntity;
	}

	public UserRoleEntity getUserRoleEntity() {
		return userRoleEntity;
	}

	public void setUserRoleEntity(UserRoleEntity userRoleEntity) {
		this.userRoleEntity = userRoleEntity;
	}

	public ShopEntity getShopEntity() {
		return shopEntity;
	}

	public void setShopEntity(ShopEntity shopEntity) {
		this.shopEntity = shopEntity;
	}
	

	/*
	 * private Address address ; private Specialization specialization; private
	 * AppUser appUser; public AppUser getAppUser() { return appUser; } public void
	 * setUser(AppUser appUser) { this.appUser = appUser; } public Address
	 * getAddress() { return address; } public void setAddress(Address address) {
	 * this.address =address; }
	 * 
	 * public Specialization getSpecialization() { return specialization; }
	 * 
	 * public void setSpecialization(Specialization specialization) {
	 * this.specialization = specialization; }
	 */

}

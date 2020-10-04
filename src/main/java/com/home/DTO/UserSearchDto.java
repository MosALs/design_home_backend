package com.home.DTO;

import com.home.entities.LocationEntity;
import com.home.entities.ShopEntity;

public class UserSearchDto {

	private String areaName;
	private String specializationName;
	private String accountTypeName;
	private String governoratName;
	public ShopEntity getShopEntity() {
		return shopEntity;
	}
	public void setShopEntity(ShopEntity shopEntity) {
		this.shopEntity = shopEntity;
	}
	public LocationEntity getLocationEntity() {
		return locationEntity;
	}
	public void setLocationEntity(LocationEntity locationEntity) {
		this.locationEntity = locationEntity;
	}
	private ShopEntity shopEntity;
	private LocationEntity locationEntity;
	
	
	public UserSearchDto() {
		
	}
	public UserSearchDto(String areaName, String specializationName, String accountTypeName, String governoratName) {
		super();
		this.areaName = areaName;
		this.specializationName = specializationName;
		this.accountTypeName = accountTypeName;
		this.governoratName = governoratName;
	}
	
	
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getSpecializationName() {
		return specializationName;
	}
	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}
	public String getAccountTypeName() {
		return accountTypeName;
	}
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
	public String getGovernoratName() {
		return governoratName;
	}
	public void setGovernoratName(String governoratName) {
		this.governoratName = governoratName;
	}

}

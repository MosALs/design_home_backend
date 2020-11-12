package com.home.DTO;

import com.home.entities.LocationEntity;
import com.home.entities.ShopEntity;

public class UserSearchDto {

	private String areaName;
	private String specializationName;
	private String accountTypeName;
	private String governoratName;
	private String arabicShort;
	
	
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

	
	
	public UserSearchDto(String areaName, String specializationName, String accountTypeName, String governoratName,
			String arabicShort, ShopEntity shopEntity, LocationEntity locationEntity) {
		super();
		this.areaName = areaName;
		this.specializationName = specializationName;
		this.accountTypeName = accountTypeName;
		this.governoratName = governoratName;
		this.arabicShort = arabicShort;
		this.shopEntity = shopEntity;
		this.locationEntity = locationEntity;
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
	public String getArabicShort() {
		return arabicShort;
	}
	public void setArabicShort(String arabicShort) {
		this.arabicShort = arabicShort;
	}

	
	
}

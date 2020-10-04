package com.home.DTO;

import java.util.List;

import com.home.entities.LocationEntity;
import com.home.entities.ShopEntity;

public class DetailedSearchDTONew {
	
	private String accountTypeName;
	private String specializationName;
	private String areaName;
	private String governorateName;
	
	private LocationEntity locationEntity;
	private ShopEntity shopEntity;
	private List <ShopEntity> shopEntityList;
	public String getAccountTypeName() {
		return accountTypeName;
	}
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
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
	public LocationEntity getLocationEntity() {
		return locationEntity;
	}
	public void setLocationEntity(LocationEntity locationEntity) {
		this.locationEntity = locationEntity;
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

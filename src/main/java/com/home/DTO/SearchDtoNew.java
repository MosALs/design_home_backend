package com.home.DTO;

import com.home.entities.ShopEntity;

public class SearchDtoNew {

	private String areaName;
    private String locationName;
    private String userName;
    private String shopName;

    
    
    
	public SearchDtoNew() {
		
	}
	//userName, sh.shopName,l.locationName,a.areaName
	public SearchDtoNew( String userName, String shopName, String locationName, String areaName) {
		super();
		this.areaName = areaName;
		this.locationName = locationName;
		this.userName = userName;
		this.shopName = shopName;
	}

	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
    
    
	
	
	
}

package com.home.DTO;

public class ShopSearch {

	
	private String areaName;
    private String locationName;
    private String userName;
    private String shopName;
	private String specializationName;
	 private String accountTypeName;

    
    
    
    
	public ShopSearch() {

	}
	//auser.userName, sh.shopName,l.locationName,a.areaName,ac.accountTypeName, s.specializationName)
	public ShopSearch(String userName, String shopName, String locationName,String  areaName,String accountTypeName,
			String specializationName){
		super();
		this.areaName = areaName;
		this.locationName = locationName;
		this.userName = userName;
		this.shopName = shopName;
		this.specializationName = specializationName;
		this.accountTypeName = accountTypeName;
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

    
}

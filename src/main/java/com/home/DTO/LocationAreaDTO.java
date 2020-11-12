package com.home.DTO;

public class LocationAreaDTO {

	private String locationName;
	 
	private String areaName;
	 
	
	 
	public LocationAreaDTO() {
		super();
	}
	public LocationAreaDTO(String locationName, String areaName) {
		super();
		this.locationName = locationName;
		this.areaName = areaName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	 
	 
	 
}

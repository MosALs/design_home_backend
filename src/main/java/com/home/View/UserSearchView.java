package com.home.View;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Column;

@Entity
@Table(name = "user_search_view", schema = "dbo")
public class UserSearchView {

	@Id
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "mobile_one")
	private String mobileOne;
	@Column(name = "mobile_two")
	private String mobileTwo;
	@Column(name = "mobile_three")
	private String mobileThree;
	@Column(name = "mobile_four")
	private String mobileFour;
	@Column(name = "land_line_one")
	private String landLineOne;
	@Column(name = "land_line_two")
	private String landLineTwo;
	@Column(name = "land_line_three")
	private String landLineThree;
	@Column(name = "governorat_name")
	private String governoratName;
	@Column(name = "area_name")
	private String areaName;
	@Column(name = "location_name")
	private String locationName;
	@Column(name = "account_type_name")
	private String accountTypeName;
	@Column(name = "specialization_name")
	private String specializationName;
	@Column(name = "shop_name")
	private String shopName;
	@Column(name = "arabic_short")
	private String arabicShort;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileOne() {
		return mobileOne;
	}

	public void setMobileOne(String mobileOne) {
		this.mobileOne = mobileOne;
	}

	public String getMobileTwo() {
		return mobileTwo;
	}

	public void setMobileTwo(String mobileTwo) {
		this.mobileTwo = mobileTwo;
	}

	public String getMobileThree() {
		return mobileThree;
	}

	public void setMobileThree(String mobileThree) {
		this.mobileThree = mobileThree;
	}

	public String getMobileFour() {
		return mobileFour;
	}

	public void setMobileFour(String mobileFour) {
		this.mobileFour = mobileFour;
	}

	public String getLandLineOne() {
		return landLineOne;
	}

	public void setLandLineOne(String landLineOne) {
		this.landLineOne = landLineOne;
	}

	public String getLandLineTwo() {
		return landLineTwo;
	}

	public void setLandLineTwo(String landLineTwo) {
		this.landLineTwo = landLineTwo;
	}

	public String getLandLineThree() {
		return landLineThree;
	}

	public void setLandLineThree(String landLineThree) {
		this.landLineThree = landLineThree;
	}

	public String getGovernoratName() {
		return governoratName;
	}

	public void setGovernoratName(String governoratName) {
		this.governoratName = governoratName;
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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getArabicShort() {
		return arabicShort;
	}

	public void setArabicShort(String arabicShort) {
		this.arabicShort = arabicShort;
	}

}

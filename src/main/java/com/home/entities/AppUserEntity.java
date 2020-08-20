package com.home.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.home.jsonfilter.View;
@Entity
@Table(name = "app_user", schema = "dbo", catalog = "kmgnew")
public class AppUserEntity {


    private int id;

    private String name;
    @JsonView({View.AuthenticateInfo.class,View.SearchCriteriaInfo.class})
    private String userName;
    @JsonView(View.SearchCriteriaInfo.class)
    private String userMobile;
    @JsonView(View.SearchCriteriaInfo.class)
    private byte[] userImage;
    @JsonView(View.SearchCriteriaInfo.class)
    private String userHours;
    @JsonView(View.SearchCriteriaInfo.class)
    private String userGender;
    private String tradeName;
    private String tradeMobileNumber;
    private String wholeRetailSale;
    private String deliveryNoDelivery;
    private String websiteLink;
    @JsonView(View.AuthenticateInfo.class)
    private String password;
//    @JsonView(View.AuthenticateInfo.class)
    private boolean active;
//    private int userRoleId;
    private String facbookLink;
    @JsonView(View.AuthenticateInfo.class)
    private UserRoleEntity userRoleByUserRoleId;
    private Collection<ShopEntity> shopsById;
    private Collection<WorkOrderEntity> workOrdersById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_mobile")
    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    @Basic
    @Column(name = "user_image")
    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    @Basic
    @Column(name = "user_hours")
    public String getUserHours() {
        return userHours;
    }

    public void setUserHours(String userHours) {
        this.userHours = userHours;
    }


    @Basic
    @Column(name = "user_gender")
    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }


    @Basic
    @Column(name = "trade_name")
    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    @Basic
    @Column(name = "trade_mobile_number")
    public String getTradeMobileNumber() {
        return tradeMobileNumber;
    }

    public void setTradeMobileNumber(String tradeMobileNumber) {
        this.tradeMobileNumber = tradeMobileNumber;
    }

    @Basic
    @Column(name = "whole_retail_sale")
    public String getWholeRetailSale() {
        return wholeRetailSale;
    }

    public void setWholeRetailSale(String wholeRetailSale) {
        this.wholeRetailSale = wholeRetailSale;
    }

    @Basic
    @Column(name = "delivery_no_delivery")
    public String getDeliveryNoDelivery() {
        return deliveryNoDelivery;
    }

    public void setDeliveryNoDelivery(String deliveryNoDelivery) {
        this.deliveryNoDelivery = deliveryNoDelivery;
    }

    @Basic
    @Column(name = "website_link")
    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

//    @Basic
//    @Column(name = "user_role_id")
//    public int getUserRoleId() {
//        return userRoleId;
//    }
//
//    public void setUserRoleId(int userRoleId) {
//        this.userRoleId = userRoleId;
//    }

    @Basic
    @Column(name = "facbook_link")
    public String getFacbookLink() {
        return facbookLink;
    }

    public void setFacbookLink(String facbookLink) {
        this.facbookLink = facbookLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserEntity that = (AppUserEntity) o;
        return id == that.id &&
                active == that.active &&
//                userRoleId == that.userRoleId &&
                Objects.equals(name, that.name) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userMobile, that.userMobile) &&
                Arrays.equals(userImage, that.userImage) &&
                Objects.equals(userHours, that.userHours) &&
                Objects.equals(userGender, that.userGender) &&
                Objects.equals(tradeName, that.tradeName) &&
                Objects.equals(tradeMobileNumber, that.tradeMobileNumber) &&
                Objects.equals(wholeRetailSale, that.wholeRetailSale) &&
                Objects.equals(deliveryNoDelivery, that.deliveryNoDelivery) &&
                Objects.equals(websiteLink, that.websiteLink) &&
                Objects.equals(password, that.password) &&
                Objects.equals(facbookLink, that.facbookLink);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, userName, userMobile, userHours, userGender, tradeName, tradeMobileNumber, wholeRetailSale, deliveryNoDelivery, websiteLink, password, active, facbookLink);
        result = 31 * result + Arrays.hashCode(userImage);
        return result;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_role_id", referencedColumnName = "id", nullable = false, updatable= false)
    public UserRoleEntity getUserRoleByUserRoleId() {
        return userRoleByUserRoleId;
    }

    public void setUserRoleByUserRoleId(UserRoleEntity userRoleByUserRoleId) {
        this.userRoleByUserRoleId = userRoleByUserRoleId;
    }

    @OneToMany(mappedBy = "appUserByUserId")
    public Collection<ShopEntity> getShopsById() {
        return shopsById;
    }

    public void setShopsById(Collection<ShopEntity> shopsById) {
        this.shopsById = shopsById;
    }

    @OneToMany(mappedBy = "appUserByRequsetUserId")
    public Collection<WorkOrderEntity> getWorkOrdersById() {
        return workOrdersById;
    }

    public void setWorkOrdersById(Collection<WorkOrderEntity> workOrdersById) {
        this.workOrdersById = workOrdersById;
    }

	@Override
	public String toString() {
		return "AppUserEntity [id=" + id + ", name=" + name + ", userName=" + userName + ", userMobile=" + userMobile
				+ ", userImage=" + Arrays.toString(userImage) + ", userHours=" + userHours + ", userGender="
				+ userGender + ", tradeName=" + tradeName + ", tradeMobileNumber=" + tradeMobileNumber
				+ ", wholeRetailSale=" + wholeRetailSale + ", deliveryNoDelivery=" + deliveryNoDelivery
				+ ", websiteLink=" + websiteLink + ", password=" + password + ", active=" + active + ", facbookLink="
				+ facbookLink + ", userRoleByUserRoleId=" + userRoleByUserRoleId + ", shopsById=" + shopsById
				+ ", workOrdersById=" + workOrdersById + "]";
	}
    

	
    
    
}

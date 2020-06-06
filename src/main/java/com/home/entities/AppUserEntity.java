package com.home.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "app_user", schema = "dbo", catalog = "kmgnew")
public class AppUserEntity {
    private int id;
    private String name;
    private String userName;
    private String userMobile;
    private byte[] userImage;
    private String userHours;
    private Integer specializationId;
    private String userGender;
    private String accountType;
    private String tradeName;
    private String tradeMobileNumber;
    private String wholeRetailSale;
    private String deliveryNoDelivery;
    private String websiteLink;
    private String password;
    private boolean active;
    private int userRoleId;
    private String facbookLink;
    private UserRoleEntity userRoleByUserRoleId;
    private Collection<ShopEntity> shopsById;
    private Collection<WorkOrderEntity> workOrdersById;

    @Id
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
    @Column(name = "specialization_id")
    public Integer getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
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
    @Column(name = "account_type")
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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

    @Basic
    @Column(name = "user_role_id")
    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

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
                userRoleId == that.userRoleId &&
                Objects.equals(name, that.name) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userMobile, that.userMobile) &&
                Arrays.equals(userImage, that.userImage) &&
                Objects.equals(userHours, that.userHours) &&
                Objects.equals(specializationId, that.specializationId) &&
                Objects.equals(userGender, that.userGender) &&
                Objects.equals(accountType, that.accountType) &&
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
        int result = Objects.hash(id, name, userName, userMobile, userHours, specializationId, userGender, accountType, tradeName, tradeMobileNumber, wholeRetailSale, deliveryNoDelivery, websiteLink, password, active, userRoleId, facbookLink);
        result = 31 * result + Arrays.hashCode(userImage);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_role_id", referencedColumnName = "id", nullable = false,insertable= false , updatable= false)
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
}

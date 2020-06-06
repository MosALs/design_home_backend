package com.home.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "shop", schema = "dbo", catalog = "kmgnew")
public class ShopEntity {
    private int id;
    private Integer userId;
    private String shopName;
    private Integer specializationId;
    private Integer locationId;
    private String street;
    private Boolean active;
    private Date startDate;
    private Integer accountTypeId;
    private AppUserEntity appUserByUserId;
    private SpecializationEntity specializationBySpecializationId;
    private LocationEntity locationByLocationId;
    private AccountTypeEntity accountTypeByAccountTypeId;
    private Collection<ShopProductEntity> shopProductsById;
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
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "shop_name")
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
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
    @Column(name = "location_id")
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "active")
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "account_type_id")
    public Integer getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Integer accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopEntity that = (ShopEntity) o;
        return id == that.id &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(shopName, that.shopName) &&
                Objects.equals(specializationId, that.specializationId) &&
                Objects.equals(locationId, that.locationId) &&
                Objects.equals(street, that.street) &&
                Objects.equals(active, that.active) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(accountTypeId, that.accountTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, shopName, specializationId, locationId, street, active, startDate, accountTypeId);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",insertable=false ,updatable=false)
    public AppUserEntity getAppUserByUserId() {
        return appUserByUserId;
    }

    public void setAppUserByUserId(AppUserEntity appUserByUserId) {
        this.appUserByUserId = appUserByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "specialization_id", referencedColumnName = "id",insertable=false ,updatable=false)
    public SpecializationEntity getSpecializationBySpecializationId() {
        return specializationBySpecializationId;
    }

    public void setSpecializationBySpecializationId(SpecializationEntity specializationBySpecializationId) {
        this.specializationBySpecializationId = specializationBySpecializationId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id",insertable=false ,updatable=false)
    public LocationEntity getLocationByLocationId() {
        return locationByLocationId;
    }

    public void setLocationByLocationId(LocationEntity locationByLocationId) {
        this.locationByLocationId = locationByLocationId;
    }

    @ManyToOne
    @JoinColumn(name = "account_type_id", referencedColumnName = "id",insertable=false ,updatable=false)
    public AccountTypeEntity getAccountTypeByAccountTypeId() {
        return accountTypeByAccountTypeId;
    }

    public void setAccountTypeByAccountTypeId(AccountTypeEntity accountTypeByAccountTypeId) {
        this.accountTypeByAccountTypeId = accountTypeByAccountTypeId;
    }

    @OneToMany(mappedBy = "shopByShopId")
    public Collection<ShopProductEntity> getShopProductsById() {
        return shopProductsById;
    }

    public void setShopProductsById(Collection<ShopProductEntity> shopProductsById) {
        this.shopProductsById = shopProductsById;
    }

    @OneToMany(mappedBy = "shopByWorkUserId")
    public Collection<WorkOrderEntity> getWorkOrdersById() {
        return workOrdersById;
    }

    public void setWorkOrdersById(Collection<WorkOrderEntity> workOrdersById) {
        this.workOrdersById = workOrdersById;
    }
}

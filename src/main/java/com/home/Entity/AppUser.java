/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author goher
 */
@Entity
@Table(name = "app_user", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUser.findAll", query = "SELECT a FROM AppUser a")
    , @NamedQuery(name = "AppUser.findById", query = "SELECT a FROM AppUser a WHERE a.id = :id")
    , @NamedQuery(name = "AppUser.findByName", query = "SELECT a FROM AppUser a WHERE a.name = :name")
    , @NamedQuery(name = "AppUser.findByUserName", query = "SELECT a FROM AppUser a WHERE a.userName = :userName")
    , @NamedQuery(name = "AppUser.findByUserMobile", query = "SELECT a FROM AppUser a WHERE a.userMobile = :userMobile")
    , @NamedQuery(name = "AppUser.findByUserHours", query = "SELECT a FROM AppUser a WHERE a.userHours = :userHours")
    , @NamedQuery(name = "AppUser.findByUserGender", query = "SELECT a FROM AppUser a WHERE a.userGender = :userGender")
    , @NamedQuery(name = "AppUser.findByTradeName", query = "SELECT a FROM AppUser a WHERE a.tradeName = :tradeName")
    , @NamedQuery(name = "AppUser.findByTradeMobileNumber", query = "SELECT a FROM AppUser a WHERE a.tradeMobileNumber = :tradeMobileNumber")
    , @NamedQuery(name = "AppUser.findByWholesaleretailsale", query = "SELECT a FROM AppUser a WHERE a.wholesaleretailsale = :wholesaleretailsale")
    , @NamedQuery(name = "AppUser.findByDeliveryNoDelivery", query = "SELECT a FROM AppUser a WHERE a.deliveryNoDelivery = :deliveryNoDelivery")
    , @NamedQuery(name = "AppUser.findByHyperLink", query = "SELECT a FROM AppUser a WHERE a.hyperLink = :hyperLink")
    , @NamedQuery(name = "AppUser.findByPassword", query = "SELECT a FROM AppUser a WHERE a.password = :password")})
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 50)
    @Column(name="name" ,length = 50)
    private String name;
    @Size(max = 50)
    @Column(name = "user_name", length = 50)
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_mobile", nullable = false, length = 20)
    private String userMobile;
    @Lob
    @Column(name = "user_image")
    private byte[] userImage;
    @Size(max = 20)
    @Column(name = "user_hours", length = 20)
    private String userHours;
    @Size(max = 8)
    @Column(name = "user_gender", length = 8)
    private String userGender;
    @Size(max = 2147483647)
    @Column(name = "trade_name", length = 2147483647)
    private String tradeName;
    @Size(max = 20)
    @Column(name = "trade_mobile_number", length = 20)
    private String tradeMobileNumber;
    @Size(max = 15)
    @Column(name = "Wholesale_retail_sale", length = 15)
    private String wholesaleretailsale;
    @Size(max = 15)
    @Column(name = "delivery_no_delivery", length = 15)
    private String deliveryNoDelivery;
    @Size(max = 2147483647)
    @Column(name = "hyper_link", length = 2147483647)
    private String hyperLink;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String password;

    private boolean active ;
    private String roles ;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appuserId", fetch = FetchType.LAZY)
//    @OneToMany
//    @JoinColumn(name ="appuser_id")
    private List<Address> addressList;
    @JsonIgnore
    @JoinColumn(name = "specialization_id", referencedColumnName = "id")
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Specialization specializationId;

    public AppUser() {
    }

    public AppUser(Integer id) {
        this.id = id;
    }

    public AppUser(Integer id, String userMobile, String password) {
        this.id = id;
        this.userMobile = userMobile;
       
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    public String getUserHours() {
        return userHours;
    }

    public void setUserHours(String userHours) {
        this.userHours = userHours;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }


    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTradeMobileNumber() {
        return tradeMobileNumber;
    }

    public void setTradeMobileNumber(String tradeMobileNumber) {
        this.tradeMobileNumber = tradeMobileNumber;
    }

    public String getWholesaleretailsale() {
        return wholesaleretailsale;
    }

    public void setWholesaleretailsale(String wholesaleretailsale) {
        this.wholesaleretailsale = wholesaleretailsale;
    }

    public String getDeliveryNoDelivery() {
        return deliveryNoDelivery;
    }

    public void setDeliveryNoDelivery(String deliveryNoDelivery) {
        this.deliveryNoDelivery = deliveryNoDelivery;
    }

    public String getHyperLink() {
        return hyperLink;
    }

    public void setHyperLink(String hyperLink) {
        this.hyperLink = hyperLink;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Specialization getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Specialization specializationId) {
        this.specializationId = specializationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.home.Entity.AppUser[ id=" + id + " ]";
    }
    
}

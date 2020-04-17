/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.Entity;

import java.io.Serializable;
import java.util.Arrays;
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
@Table(catalog = "kmg", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
    , @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName")
    , @NamedQuery(name = "Users.findByUserMobile", query = "SELECT u FROM Users u WHERE u.userMobile = :userMobile")
    , @NamedQuery(name = "Users.findByUserHours", query = "SELECT u FROM Users u WHERE u.userHours = :userHours")
    , @NamedQuery(name = "Users.findByUserGender", query = "SELECT u FROM Users u WHERE u.userGender = :userGender")
    , @NamedQuery(name = "Users.findByAccountType", query = "SELECT u FROM Users u WHERE u.accountType = :accountType")
    , @NamedQuery(name = "Users.findByTradeName", query = "SELECT u FROM Users u WHERE u.tradeName = :tradeName")
    , @NamedQuery(name = "Users.findByTradeMobileNumber", query = "SELECT u FROM Users u WHERE u.tradeMobileNumber = :tradeMobileNumber")
    , @NamedQuery(name = "Users.findByWholesaleretailsale", query = "SELECT u FROM Users u WHERE u.wholesaleretailsale = :wholesaleretailsale")
    , @NamedQuery(name = "Users.findByDeliveryNoDelivery", query = "SELECT u FROM Users u WHERE u.deliveryNoDelivery = :deliveryNoDelivery")
    , @NamedQuery(name = "Users.findByHyperLink", query = "SELECT u FROM Users u WHERE u.hyperLink = :hyperLink")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "account_type", nullable = false, length = 30)
    private String accountType;
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
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Branches> branchesList;
    @JsonIgnore
    @JoinColumn(name = "specialization_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Specialization specializationId;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String userName, String userMobile, String accountType, String password) {
        this.id = id;
        this.userName = userName;
        this.userMobile = userMobile;
        this.accountType = accountType;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getName() {
 		return name;
 	}

 	public void setName(String name) {
 		this.name = name;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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

    @XmlTransient
    public List<Branches> getBranchesList() {
        return branchesList;
    }

    public void setBranchesList(List<Branches> branchesList) {
        this.branchesList = branchesList;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", name=" + name + ", userMobile=" + userMobile
				+ ", userImage=" + Arrays.toString(userImage) + ", userHours=" + userHours + ", userGender="
				+ userGender + ", accountType=" + accountType + ", tradeName=" + tradeName + ", tradeMobileNumber="
				+ tradeMobileNumber + ", wholesaleretailsale=" + wholesaleretailsale + ", deliveryNoDelivery="
				+ deliveryNoDelivery + ", hyperLink=" + hyperLink + ", password=" + password + ", branchesList="
				+ branchesList + ", specializationId=" + specializationId + "]";
	}
    
    
    
}

package com.home.entities;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account_type", schema = "dbo", catalog = "kmgnew")
public class AccountTypeEntity {
    private int id;
    private String accountTypeName;
    private Collection<ShopEntity> shopsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account_type_name")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeEntity that = (AccountTypeEntity) o;
        return id == that.id &&
                Objects.equals(accountTypeName, that.accountTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountTypeName);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "accountTypeByAccountTypeId")
    public Collection<ShopEntity> getShopsById() {
        return shopsById;
    }

    public void setShopsById(Collection<ShopEntity> shopsById) {
        this.shopsById = shopsById;
    }

	@Override
	public String toString() {
		return "AccountTypeEntity [id=" + id + ", accountTypeName=" + accountTypeName + ", shopsById=" + shopsById
				+ "]";
	}
    
    
}

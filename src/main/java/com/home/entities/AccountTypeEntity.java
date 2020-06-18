package com.home.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "accountTypeByAccountTypeId")
    public Collection<ShopEntity> getShopsById() {
        return shopsById;
    }

    public void setShopsById(Collection<ShopEntity> shopsById) {
        this.shopsById = shopsById;
    }
}

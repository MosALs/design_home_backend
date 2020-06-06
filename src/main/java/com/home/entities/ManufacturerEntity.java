package com.home.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "manufacturer", schema = "dbo", catalog = "kmgnew")
public class ManufacturerEntity {
    private int id;
    private String manufacturerName;
    private Collection<ShopProductEntity> shopProductsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "manufacturer_name")
    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufacturerEntity that = (ManufacturerEntity) o;
        return id == that.id &&
                Objects.equals(manufacturerName, that.manufacturerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manufacturerName);
    }

    @OneToMany(mappedBy = "manufacturerByManufacturerId")
    public Collection<ShopProductEntity> getShopProductsById() {
        return shopProductsById;
    }

    public void setShopProductsById(Collection<ShopProductEntity> shopProductsById) {
        this.shopProductsById = shopProductsById;
    }
}

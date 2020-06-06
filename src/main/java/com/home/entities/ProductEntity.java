package com.home.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "dbo", catalog = "kmgnew")
public class ProductEntity {
    private int id;
    private String productname;
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
    @Column(name = "productname")
    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id == that.id &&
                Objects.equals(productname, that.productname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productname);
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<ShopProductEntity> getShopProductsById() {
        return shopProductsById;
    }

    public void setShopProductsById(Collection<ShopProductEntity> shopProductsById) {
        this.shopProductsById = shopProductsById;
    }
}

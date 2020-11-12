package com.home.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "shop_product", schema = "dbo", catalog = "kmgnew")
public class ShopProductEntity {
    private int id;
    private Integer productId;
    private Integer shopId;
    private Double size;
    private String color;
    private Integer unitPrice;
    private Integer manufacturerId;
    private Collection<ProductTransactionEntity> productTransactionsById;
    private ProductEntity productByProductId;
    private ShopEntity shopByShopId;
    private ManufacturerEntity manufacturerByManufacturerId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_id")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "shop_id")
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "size")
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "unit_price")
    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "manufacturer_id")
    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopProductEntity that = (ShopProductEntity) o;
        return id == that.id &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(shopId, that.shopId) &&
                Objects.equals(size, that.size) &&
                Objects.equals(color, that.color) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(manufacturerId, that.manufacturerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, shopId, size, color, unitPrice, manufacturerId);
    }

    @OneToMany(mappedBy = "shopProductByProductShopId")
    public Collection<ProductTransactionEntity> getProductTransactionsById() {
        return productTransactionsById;
    }

    public void setProductTransactionsById(Collection<ProductTransactionEntity> productTransactionsById) {
        this.productTransactionsById = productTransactionsById;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id",insertable=false ,updatable=false)
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id",insertable=false ,updatable=false)
    public ShopEntity getShopByShopId() {
        return shopByShopId;
    }

    public void setShopByShopId(ShopEntity shopByShopId) {
        this.shopByShopId = shopByShopId;
    }

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id",insertable=false ,updatable=false)
    public ManufacturerEntity getManufacturerByManufacturerId() {
        return manufacturerByManufacturerId;
    }

    public void setManufacturerByManufacturerId(ManufacturerEntity manufacturerByManufacturerId) {
        this.manufacturerByManufacturerId = manufacturerByManufacturerId;
    }
}

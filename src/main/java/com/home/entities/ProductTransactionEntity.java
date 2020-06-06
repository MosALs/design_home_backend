package com.home.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_transaction", schema = "dbo", catalog = "kmgnew")
public class ProductTransactionEntity {
    private int id;
    private Integer workorderId;
    private Integer productShopId;
    private Integer qty;
    private WorkOrderEntity workOrderByWorkorderId;
    private ShopProductEntity shopProductByProductShopId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "workorder_id")
    public Integer getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(Integer workorderId) {
        this.workorderId = workorderId;
    }

    @Basic
    @Column(name = "product_shop_id")
    public Integer getProductShopId() {
        return productShopId;
    }

    public void setProductShopId(Integer productShopId) {
        this.productShopId = productShopId;
    }

    @Basic
    @Column(name = "qty")
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTransactionEntity that = (ProductTransactionEntity) o;
        return id == that.id &&
                Objects.equals(workorderId, that.workorderId) &&
                Objects.equals(productShopId, that.productShopId) &&
                Objects.equals(qty, that.qty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workorderId, productShopId, qty);
    }

    @ManyToOne
    @JoinColumn(name = "workorder_id", referencedColumnName = "id",insertable=false ,updatable=false)
    public WorkOrderEntity getWorkOrderByWorkorderId() {
        return workOrderByWorkorderId;
    }

    public void setWorkOrderByWorkorderId(WorkOrderEntity workOrderByWorkorderId) {
        this.workOrderByWorkorderId = workOrderByWorkorderId;
    }

    @ManyToOne
    @JoinColumn(name = "product_shop_id", referencedColumnName = "id",insertable=false ,updatable=false)
    public ShopProductEntity getShopProductByProductShopId() {
        return shopProductByProductShopId;
    }

    public void setShopProductByProductShopId(ShopProductEntity shopProductByProductShopId) {
        this.shopProductByProductShopId = shopProductByProductShopId;
    }
}

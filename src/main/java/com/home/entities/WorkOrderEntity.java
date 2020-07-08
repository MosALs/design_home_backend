package com.home.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "work_order", schema = "dbo", catalog = "kmgnew")
public class WorkOrderEntity {
    private int id;
    private Integer requsetUserId;
    private Integer workUserId;
    private Timestamp requsetDate;
    private Timestamp closedDate;
    private Date openDate;
    private Integer rating;
    private String remarks;
    private String workNeeded;
    private Boolean paid;
    private Collection<ProductTransactionEntity> productTransactionsById;
    private AppUserEntity appUserByRequsetUserId;
    private ShopEntity shopByWorkUserId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "requset_user_id")
    public Integer getRequsetUserId() {
        return requsetUserId;
    }

    public void setRequsetUserId(Integer requsetUserId) {
        this.requsetUserId = requsetUserId;
    }

    @Basic
    @Column(name = "work_user_id")
    public Integer getWorkUserId() {
        return workUserId;
    }

    public void setWorkUserId(Integer workUserId) {
        this.workUserId = workUserId;
    }

    @Basic
    @Column(name = "requset_date")
    public Timestamp getRequsetDate() {
        return requsetDate;
    }

    public void setRequsetDate(Timestamp requsetDate) {
        this.requsetDate = requsetDate;
    }

    @Basic
    @Column(name = "closed_date")
    public Timestamp getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Timestamp closedDate) {
        this.closedDate = closedDate;
    }

    @Basic
    @Column(name = "open_date")
    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    @Basic
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "work_needed")
    public String getWorkNeeded() {
        return workNeeded;
    }

    public void setWorkNeeded(String workNeeded) {
        this.workNeeded = workNeeded;
    }

    @Basic
    @Column(name = "paid")
    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkOrderEntity that = (WorkOrderEntity) o;
        return id == that.id &&
                Objects.equals(requsetUserId, that.requsetUserId) &&
                Objects.equals(workUserId, that.workUserId) &&
                Objects.equals(requsetDate, that.requsetDate) &&
                Objects.equals(closedDate, that.closedDate) &&
                Objects.equals(openDate, that.openDate) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(workNeeded, that.workNeeded) &&
                Objects.equals(paid, that.paid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requsetUserId, workUserId, requsetDate, closedDate, openDate, rating, remarks, workNeeded, paid);
    }

    @OneToMany(mappedBy = "workOrderByWorkorderId")
    public Collection<ProductTransactionEntity> getProductTransactionsById() {
        return productTransactionsById;
    }

    public void setProductTransactionsById(Collection<ProductTransactionEntity> productTransactionsById) {
        this.productTransactionsById = productTransactionsById;
    }

    @ManyToOne
    @JoinColumn(name = "requset_user_id", referencedColumnName = "id",insertable=false ,updatable=false)
    public AppUserEntity getAppUserByRequsetUserId() {
        return appUserByRequsetUserId;
    }

    public void setAppUserByRequsetUserId(AppUserEntity appUserByRequsetUserId) {
        this.appUserByRequsetUserId = appUserByRequsetUserId;
    }

    @ManyToOne
    @JoinColumn(name = "work_user_id", referencedColumnName = "id",insertable=false ,updatable=false)
    public ShopEntity getShopByWorkUserId() {
        return shopByWorkUserId;
    }

    public void setShopByWorkUserId(ShopEntity shopByWorkUserId) {
        this.shopByWorkUserId = shopByWorkUserId;
    }
}

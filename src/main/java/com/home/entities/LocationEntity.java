package com.home.entities;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "location", schema = "dbo", catalog = "kmgnew")
public class LocationEntity {
    private int id;
    private String locationName;
//    private Integer areaId;
    private AreasEntity areasByAreaId;
    private Collection<ShopEntity> shopsById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "location_name")
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

//    @Column(name = "area_id")
//    public Integer getAreaId() {
//        return areaId;
//    }

//    public void setAreaId(Integer areaId) {
//        this.areaId = areaId;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        LocationEntity that = (LocationEntity) o;
//        return id == that.id &&
//                Objects.equals(locationName, that.locationName) &&
//              // Objects.equals(areaId, that.areaId);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, locationName, areaId);
//    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id" , updatable= true,insertable = true)
    public AreasEntity getAreasByAreaId() {
        return areasByAreaId;
    }

    public void setAreasByAreaId(AreasEntity areasByAreaId) {
        this.areasByAreaId = areasByAreaId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "locationByLocationId" , fetch = FetchType.LAZY)
    public Collection<ShopEntity> getShopsById() {
        return shopsById;
    }

    public void setShopsById(Collection<ShopEntity> shopsById) {
        this.shopsById = shopsById;
    }
}

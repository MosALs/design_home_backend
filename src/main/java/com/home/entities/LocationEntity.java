package com.home.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "location", schema = "dbo", catalog = "kmgnew")
public class LocationEntity {
    private int id;
    private String locationName;
    private Integer areaId;
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

    @Column(name = "area_id")
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationEntity that = (LocationEntity) o;
        return id == that.id &&
                Objects.equals(locationName, that.locationName) &&
                Objects.equals(areaId, that.areaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locationName, areaId);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id",insertable= false , updatable= false)
    @JsonBackReference
    public AreasEntity getAreasByAreaId() {
        return areasByAreaId;
    }

    public void setAreasByAreaId(AreasEntity areasByAreaId) {
        this.areasByAreaId = areasByAreaId;
    }

    @OneToMany(mappedBy = "locationByLocationId" , fetch = FetchType.LAZY)
    public Collection<ShopEntity> getShopsById() {
        return shopsById;
    }

    public void setShopsById(Collection<ShopEntity> shopsById) {
        this.shopsById = shopsById;
    }
}

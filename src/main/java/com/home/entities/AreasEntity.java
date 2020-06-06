package com.home.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "areas", schema = "dbo", catalog = "kmgnew")
public class AreasEntity {
    private int id;
    private String areaName;
    private Integer governoratId;
    private GovernoratEntity governoratByGovernoratId;
    private List<LocationEntity> locationsById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "area_name")
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Column(name = "governorat_id")
    public Integer getGovernoratId() {
        return governoratId;
    }

    public void setGovernoratId(Integer governoratId) {
        this.governoratId = governoratId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreasEntity that = (AreasEntity) o;
        return id == that.id &&
                Objects.equals(areaName, that.areaName) &&
                Objects.equals(governoratId, that.governoratId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, areaName, governoratId);
    }

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "governorat_id", referencedColumnName = "id" ,insertable= false , updatable= false)
    @JsonBackReference
    public GovernoratEntity getGovernoratByGovernoratId() {
        return governoratByGovernoratId;
    }

    public void setGovernoratByGovernoratId(GovernoratEntity governoratByGovernoratId) {
        this.governoratByGovernoratId = governoratByGovernoratId;
    }

    @OneToMany(mappedBy = "areasByAreaId",fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    public List<LocationEntity> getLocationsById() {
        return locationsById;
    }

    public void setLocationsById(List<LocationEntity> locationsById) {
        this.locationsById = locationsById;
    }
}

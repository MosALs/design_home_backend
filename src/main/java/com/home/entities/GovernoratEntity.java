package com.home.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "governorat", schema = "dbo", catalog = "kmgnew")
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class GovernoratEntity {
    private int id;
    private String governoratName;
    private Integer countryId;
    private Collection<AreasEntity> areasById;
    private CountriesEntity countriesByCountryId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "governorat_name")
    public String getGovernoratName() {
        return governoratName;
    }

    public void setGovernoratName(String governoratName) {
        this.governoratName = governoratName;
    }

    @Basic
    @Column(name = "country_id")
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GovernoratEntity that = (GovernoratEntity) o;
        return id == that.id &&
                Objects.equals(governoratName, that.governoratName) &&
                Objects.equals(countryId, that.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, governoratName, countryId);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "governoratByGovernoratId")
    public Collection<AreasEntity> getAreasById() {
        return areasById;
    }

    public void setAreasById(Collection<AreasEntity> areasById) {
        this.areasById = areasById;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id",insertable= false , updatable= false)
    public CountriesEntity getCountriesByCountryId() {
        return countriesByCountryId;
    }

    public void setCountriesByCountryId(CountriesEntity countriesByCountryId) {
        this.countriesByCountryId = countriesByCountryId;
    }
}

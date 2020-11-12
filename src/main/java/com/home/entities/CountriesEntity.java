package com.home.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "countries", schema = "dbo", catalog = "kmgnew")
public class CountriesEntity {
    private int id;
    private String englishShort;
    private String arabicShort;
    private String englishFormal;
    private String arabicFormal;
    private Collection<GovernoratEntity> governoratsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "english_short")
    public String getEnglishShort() {
        return englishShort;
    }

    public void setEnglishShort(String englishShort) {
        this.englishShort = englishShort;
    }

    @Basic
    @Column(name = "arabic_short")
    public String getArabicShort() {
        return arabicShort;
    }

    public void setArabicShort(String arabicShort) {
        this.arabicShort = arabicShort;
    }

    @Basic
    @Column(name = "english_formal")
    public String getEnglishFormal() {
        return englishFormal;
    }

    public void setEnglishFormal(String englishFormal) {
        this.englishFormal = englishFormal;
    }

    @Basic
    @Column(name = "arabic_formal")
    public String getArabicFormal() {
        return arabicFormal;
    }

    public void setArabicFormal(String arabicFormal) {
        this.arabicFormal = arabicFormal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountriesEntity that = (CountriesEntity) o;
        return id == that.id &&
                Objects.equals(englishShort, that.englishShort) &&
                Objects.equals(arabicShort, that.arabicShort) &&
                Objects.equals(englishFormal, that.englishFormal) &&
                Objects.equals(arabicFormal, that.arabicFormal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, englishShort, arabicShort, englishFormal, arabicFormal);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "countriesByCountryId")
    public Collection<GovernoratEntity> getGovernoratsById() {
        return governoratsById;
    }

    public void setGovernoratsById(Collection<GovernoratEntity> governoratsById) {
        this.governoratsById = governoratsById;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author goher
 */
@Entity
@Table(schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Governorates.findAll", query = "SELECT g FROM Governorates g")
    , @NamedQuery(name = "Governorates.findById", query = "SELECT g FROM Governorates g WHERE g.id = :id")
    , @NamedQuery(name = "Governorates.findByGovernoratName", query = "SELECT g FROM Governorates g WHERE g.governoratName = :governoratName")})
public class Governorates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "governorat_name", nullable = false, length = 50)
    private String governoratName;
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Countries countryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "governorateId", fetch = FetchType.LAZY)
    private List<Areas> areasList;

    public Governorates() {
    }

    public Governorates(Integer id) {
        this.id = id;
    }

    public Governorates(Integer id, String governoratName) {
        this.id = id;
        this.governoratName = governoratName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGovernoratName() {
        return governoratName;
    }

    public void setGovernoratName(String governoratName) {
        this.governoratName = governoratName;
    }

    public Countries getCountryId() {
        return countryId;
    }

    public void setCountryId(Countries countryId) {
        this.countryId = countryId;
    }

    @XmlTransient
    public List<Areas> getAreasList() {
        return areasList;
    }

    public void setAreasList(List<Areas> areasList) {
        this.areasList = areasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Governorates)) {
            return false;
        }
        Governorates other = (Governorates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.home.Entity.Governorates[ id=" + id + " ]";
    }
    
}

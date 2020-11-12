package com.home.entities;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "specialization", schema = "dbo", catalog = "kmgnew")
public class SpecializationEntity {
	private int id;
	private String specializationName;
	private Collection<ShopEntity> shopsById;

	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "specialization_name")
	public String getSpecializationName() {
		return specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		SpecializationEntity that = (SpecializationEntity) o;
		return id == that.id && Objects.equals(specializationName, that.specializationName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, specializationName);
	}
	@JsonIgnore
	@OneToMany(mappedBy = "specializationBySpecializationId")
	public Collection<ShopEntity> getShopsById() {
		return shopsById;
	}

	public void setShopsById(Collection<ShopEntity> shopsById) {
		this.shopsById = shopsById;
	}
}

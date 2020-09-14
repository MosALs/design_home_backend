package com.home.entities;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone", schema = "dbo", catalog = "kmgnew")
public class PhoneEntity {

	private int id;
	private String mobileOne;
	private String mobileTwo;
	private String mobileThree;
	private String mobileFour;
	private String landLineOne;
	private String landLineTwo;
	private String landLineThree;

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the mobileOne
	 */
	@Basic
	@Column(name = "mobile_one")
	public String getMobileOne() {
		return mobileOne;
	}

	/**
	 * @param mobileOne the mobileOne to set
	 */
	public void setMobileOne(String mobileOne) {
		this.mobileOne = mobileOne;
	}

	/**
	 * @return the mobileTwo
	 */
	@Basic
	@Column(name = "mobile_two")
	public String getMobileTwo() {
		return mobileTwo;
	}

	/**
	 * @param mobileTwo the mobileTwo to set
	 */
	public void setMobileTwo(String mobileTwo) {
		this.mobileTwo = mobileTwo;
	}

	/**
	 * @return the mobileThree
	 */
	@Basic
	@Column(name = "mobile_three")
	public String getMobileThree() {
		return mobileThree;
	}

	/**
	 * @param mobileThree the mobileThree to set
	 */
	public void setMobileThree(String mobileThree) {
		this.mobileThree = mobileThree;
	}

	/**
	 * @return the mobileFour
	 */
	@Basic
	@Column(name = "mobile_four")
	public String getMobileFour() {
		return mobileFour;
	}

	/**
	 * @param mobileFour the mobileFour to set
	 */
	public void setMobileFour(String mobileFour) {
		this.mobileFour = mobileFour;
	}

	/**
	 * @return the landLineOne
	 */
	@Basic
	@Column(name = "land_line_one")
	public String getLandLineOne() {
		return landLineOne;
	}

	/**
	 * @param landLineOne the landLineOne to set
	 */
	public void setLandLineOne(String landLineOne) {
		this.landLineOne = landLineOne;
	}

	/**
	 * @return the landLineTwo
	 */
	@Basic
	@Column(name = "land_line_two")
	public String getLandLineTwo() {
		return landLineTwo;
	}

	/**
	 * @param landLineTwo the landLineTwo to set
	 */
	public void setLandLineTwo(String landLineTwo) {
		this.landLineTwo = landLineTwo;
	}

	/**
	 * @return the landLineThree
	 */
	@Basic
	@Column(name = "land_line_three")
	public String getLandLineThree() {
		return landLineThree;
	}

	/**
	 * @param landLineThree the landLineThree to set
	 */
	public void setLandLineThree(String landLineThree) {
		this.landLineThree = landLineThree;
	}

	/**
	 * @return the shopId
	 */

	@Override
	public int hashCode() {
		return Objects.hash(id, landLineOne, landLineThree, landLineTwo, mobileFour, mobileOne, mobileThree, mobileTwo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneEntity other = (PhoneEntity) obj;
		return id == other.id && Objects.equals(landLineOne, other.landLineOne)
				&& Objects.equals(landLineThree, other.landLineThree) && Objects.equals(landLineTwo, other.landLineTwo)
				&& Objects.equals(mobileFour, other.mobileFour) && Objects.equals(mobileOne, other.mobileOne)
				&& Objects.equals(mobileThree, other.mobileThree) && Objects.equals(mobileTwo, other.mobileTwo);
	}

}

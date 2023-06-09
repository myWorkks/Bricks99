package com.marolix.Bricks99.entity;

import javax.persistence.*;

@Entity
@Table(name = "property_address")
public class PropertyAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressId;

	@Column(unique = true, nullable = false)
	private String surveyNo;

	@Column(name = "locality", nullable = false)
	private String locality;

	@Column(name = "area_in_sqft", nullable = false)
	private Double areaInSqft;

	@Column(name = "pincode", nullable = false)
	private Integer pincode;

	@Column(name = "state", nullable = false)
	private String state;

	public PropertyAddress() {
		super();
	}

	public PropertyAddress(Integer addressId, String surveyNo, String locality, Double areaInSqft, Integer pincode,
			String state) {
		super();
		this.addressId = addressId;
		this.surveyNo = surveyNo;
		this.locality = locality;
		this.areaInSqft = areaInSqft;
		this.pincode = pincode;
		this.state = state;
	}

	public PropertyAddress(String surveyNo, String locality, Double areaInSqft, Integer pincode, String state) {
		super();

		this.surveyNo = surveyNo;
		this.locality = locality;
		this.areaInSqft = areaInSqft;
		this.pincode = pincode;
		this.state = state;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public double getAreaInSqft() {
		return areaInSqft;
	}

	public void setAreaInSqft(double areaInSqft) {
		this.areaInSqft = areaInSqft;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}

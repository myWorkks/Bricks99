package com.marolix.Bricks99.dto;

public class PropertyAddressDTO {

	private Integer addressId;

	private String surveyNo;

	private String locality;

	private Double areaInSqft;

	private Integer pincode;

	private String state;

	public PropertyAddressDTO() {
		super();
	}

	public PropertyAddressDTO(Integer addressId, String surveyNo, String locality, Double areaInSqft, Integer pincode,
			String state) {
		super();
		this.addressId = addressId;
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

	public void setAreaInSqft(Double areaInSqft) {
		this.areaInSqft = areaInSqft;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}

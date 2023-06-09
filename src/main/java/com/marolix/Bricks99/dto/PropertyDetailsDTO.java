package com.marolix.Bricks99.dto;

public class PropertyDetailsDTO {
	private Integer propertyId;
	private String propertyName;
	private String propertyType;
	private Double propertyPrice;
	private String numberOfRooms;
	
	private PropertyAddressDTO propertyAddressDto;

	public PropertyDetailsDTO() {
	}

	public PropertyDetailsDTO(Integer propertyId, String propertyName, String propertyType, double propertyPrice,
			String numberOfRooms, PropertyAddressDTO propertyAddressDto) {
		super();
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.propertyType = propertyType;
		this.propertyPrice = propertyPrice;
		this.numberOfRooms = numberOfRooms;
		this.propertyAddressDto = propertyAddressDto;
	}

	public Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public double getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(double propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public String getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(String numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public PropertyAddressDTO getPropertyAddressDto() {
		return propertyAddressDto;
	}

	public void setPropertyAddressDto(PropertyAddressDTO propertyAddressDto) {
		this.propertyAddressDto = propertyAddressDto;
	}

}

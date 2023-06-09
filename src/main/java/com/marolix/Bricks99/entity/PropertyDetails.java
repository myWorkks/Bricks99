package com.marolix.Bricks99.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PropertyDetails")
public class PropertyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PropertyID")
	private Integer propertyId;

	@Column(name = "PropertyName")
	private String propertyName;

	@Column(name = "PropertyType")
	private String propertyType;

	@Column(name = "PropertyPrice")
	private double propertyPrice;

	@Column(name = "NumberOfRooms")
	private String numberOfRooms;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private PropertyAddress addressEntity;

	public PropertyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyDetails(String propertyName, String propertyType, double propertyPrice, String numberOfRooms,
			PropertyAddress addressEntity) {
		this.propertyName = propertyName;
		this.propertyType = propertyType;
		this.propertyPrice = propertyPrice;
		this.numberOfRooms = numberOfRooms;
		this.addressEntity = addressEntity;
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

	public PropertyAddress getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(PropertyAddress addressEntity) {
		this.addressEntity = addressEntity;
	}
}

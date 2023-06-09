package com.marolix.Bricks99.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.marolix.Bricks99.entity.PropertyDetails;

public interface PropertyRepository extends PagingAndSortingRepository<PropertyDetails, Integer>{
	PropertyDetails findByPropertyName(String name);
	List<PropertyDetails> findByAddressEntitySurveyNo(String surveynumber);
	public List<PropertyDetails>findByAddressEntityLocality(String LocalityName);
	List<PropertyDetails> findByPropertyPriceLessThanEqual(double price);

}

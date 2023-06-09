package com.marolix.Bricks99.service;

import java.util.List;
import com.marolix.Bricks99.dto.PropertyDetailsDTO;
import com.marolix.Bricks99.exception.Bricks99Exception;

public interface PropertyService {
	 public PropertyDetailsDTO addProperty(PropertyDetailsDTO propertyDto) throws Bricks99Exception;
	 public List<PropertyDetailsDTO> findAllPropertiesUsingPagination(int pageNumber, int pageSize)throws Bricks99Exception;
	public List<PropertyDetailsDTO>findByLocalityName(String LocalityName)throws Bricks99Exception;
	public List<PropertyDetailsDTO>findByPropertyPrice(double price)throws Bricks99Exception;
}

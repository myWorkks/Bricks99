package com.marolix.Bricks99.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marolix.Bricks99.dto.PropertyDetailsDTO;
import com.marolix.Bricks99.exception.Bricks99Exception;
import com.marolix.Bricks99.service.PropertyService;

@RestController
@Validated
@RequestMapping(value = "property-api")
public class PropertyApi {

	@Autowired
	private PropertyService propertyservice;

	@PostMapping(value = "/add-details")
	public ResponseEntity<PropertyDetailsDTO> addDetails(@RequestBody PropertyDetailsDTO addressDTO)
			throws Bricks99Exception {
		PropertyDetailsDTO addedPropertyDTO = propertyservice.addProperty(addressDTO);
		return new ResponseEntity<>(addedPropertyDTO, HttpStatus.CREATED);
	}

	@GetMapping(value = "/find-properties")
	public ResponseEntity<List<PropertyDetailsDTO>> findProperties(@RequestParam Integer pageNumber,
			@RequestParam Integer pageSize) throws Bricks99Exception {
		List<PropertyDetailsDTO> PropertyDTOList = propertyservice.findAllPropertiesUsingPagination(pageNumber,
				pageSize);
		return new ResponseEntity<>(PropertyDTOList, HttpStatus.OK);
	}
	@GetMapping(value = "/find-locality")
	public ResponseEntity<List<PropertyDetailsDTO>> findLocality(
			@RequestParam String locality) throws Bricks99Exception {
		List<PropertyDetailsDTO> PropertyLocality = propertyservice.findByLocalityName(locality);
			
		return new ResponseEntity<>(PropertyLocality, HttpStatus.OK);
	}

@GetMapping(value = "/find-price")
public ResponseEntity<List<PropertyDetailsDTO>> findPrice(
		@RequestParam double price) throws Bricks99Exception {
	List<PropertyDetailsDTO> Propertyprice = propertyservice.findByPropertyPrice(price);
		
	return new ResponseEntity<>(Propertyprice, HttpStatus.OK);
}
}

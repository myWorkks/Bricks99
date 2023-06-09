package com.marolix.Bricks99.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marolix.Bricks99.dto.SellerAddressDTO;
import com.marolix.Bricks99.dto.PropertyAddressDTO;
import com.marolix.Bricks99.dto.PropertyDetailsDTO;
import com.marolix.Bricks99.entity.PropertyAddress;
import com.marolix.Bricks99.entity.PropertyDetails;
import com.marolix.Bricks99.exception.Bricks99Exception;
import com.marolix.Bricks99.repository.AddressRepository;
import com.marolix.Bricks99.repository.PropertyRepository;

@Service(value="propertyService")
@Transactional
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyRepository propertyRepo;
	@Autowired
	private AddressRepository addressRepo;

	@Override
	public PropertyDetailsDTO addProperty(PropertyDetailsDTO propertyDto) throws Bricks99Exception {
		List<PropertyDetails> propertyEntity = propertyRepo
				.findByAddressEntitySurveyNo(propertyDto.getPropertyAddressDto().getSurveyNo());

		if (!propertyEntity.isEmpty()) {
			throw new Bricks99Exception("AddressSurveyNumberalreadyExists");
		}

		PropertyAddressDTO addressDto = propertyDto.getPropertyAddressDto();
		PropertyAddress newAddress = new PropertyAddress(addressDto.getSurveyNo(), addressDto.getLocality(),

				// String surveyNo, String locality, Double areaInSqft, Integer pincode, String
				// state
				addressDto.getAreaInSqft(), addressDto.getPincode(), addressDto.getState());
		PropertyAddress addedAddress = addressRepo.save(newAddress);

		PropertyDetails newProperty = new PropertyDetails(propertyDto.getPropertyName(), propertyDto.getPropertyType(),
				propertyDto.getPropertyPrice(), propertyDto.getNumberOfRooms(), addedAddress);

		PropertyDetails addedProperty = propertyRepo.save(newProperty);

		PropertyAddressDTO addedAddressDto = new PropertyAddressDTO(addedAddress.getAddressId(),
				addedAddress.getSurveyNo(), addedAddress.getLocality(), addedAddress.getAreaInSqft(),
				addedAddress.getPincode(), addedAddress.getState());

		return new PropertyDetailsDTO(addedProperty.getPropertyId(), addedProperty.getPropertyName(),
				addedProperty.getPropertyType(), addedProperty.getPropertyPrice(), addedProperty.getNumberOfRooms(),
				addedAddressDto);
	}

	@Override
	public List<PropertyDetailsDTO> findAllPropertiesUsingPagination(int pageNumber, int pageSize)
			throws Bricks99Exception {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);

		Page<PropertyDetails> propertyPage = propertyRepo.findAll(pageable);
		if (propertyPage.hasContent()) {
			List<PropertyDetails> propertyList = propertyPage.getContent();
			return propertyList.stream().map(property -> {
				PropertyAddress address = property.getAddressEntity();
				PropertyAddressDTO addressDTO = new PropertyAddressDTO(address.getAddressId(), address.getSurveyNo(),
						address.getLocality(), address.getAreaInSqft(), address.getPincode(), address.getState());
				return new PropertyDetailsDTO(property.getPropertyId(), property.getPropertyName(),
						property.getPropertyType(), property.getPropertyPrice(), property.getNumberOfRooms(),
						addressDTO);
			}).collect(Collectors.toList());
		}
		throw new Bricks99Exception("No Properties found");
	}

	@Override
	public List<PropertyDetailsDTO> findByLocalityName(String localityName) throws Bricks99Exception {
		List<PropertyDetails> propertyList = propertyRepo.findByAddressEntityLocality(localityName);

		if (propertyList.isEmpty()) {
			throw new Bricks99Exception("Property with the given locality not found");
		}

		List<PropertyDetailsDTO> propertyDTOList = propertyList.stream()
				.map(property -> new PropertyDetailsDTO(property.getPropertyId(), property.getPropertyName(),
						property.getPropertyType(), property.getPropertyPrice(), property.getNumberOfRooms(),
						new PropertyAddressDTO(property.getAddressEntity().getAddressId(),
								property.getAddressEntity().getSurveyNo(), property.getAddressEntity().getLocality(),
								property.getAddressEntity().getAreaInSqft(), property.getAddressEntity().getPincode(),
								property.getAddressEntity().getState())))
				.collect(Collectors.toList());

		return propertyDTOList;
	}

	@Override
	public List<PropertyDetailsDTO> findByPropertyPrice(double price) throws Bricks99Exception {
		List<PropertyDetails> propertyList = propertyRepo.findByPropertyPriceLessThanEqual(price);
		if (propertyList.isEmpty()) {
			throw new Bricks99Exception("Property with the given Price not found");
		}
		List<PropertyDetailsDTO> propertyDTOList = propertyList.stream()
				.map(property -> new PropertyDetailsDTO(property.getPropertyId(), property.getPropertyName(),
						property.getPropertyType(), property.getPropertyPrice(), property.getNumberOfRooms(),
						new PropertyAddressDTO(property.getAddressEntity().getAddressId(),
								property.getAddressEntity().getSurveyNo(), property.getAddressEntity().getLocality(),
								property.getAddressEntity().getAreaInSqft(), property.getAddressEntity().getPincode(),
								property.getAddressEntity().getState())))
				.collect(Collectors.toList());

		return propertyDTOList;
	}

}

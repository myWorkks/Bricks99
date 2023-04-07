package com.marolix.Bricks99.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.marolix.Bricks99.dto.AddressDTO;
import com.marolix.Bricks99.dto.SellerRegistrationDTO;
import com.marolix.Bricks99.dto.UserLoginDTO;
import com.marolix.Bricks99.entity.Address;
import com.marolix.Bricks99.entity.SellerRegistration;
import com.marolix.Bricks99.entity.SellerStatus;
import com.marolix.Bricks99.entity.UserLogin;
import com.marolix.Bricks99.exception.Bricks99Exception;
import com.marolix.Bricks99.repository.SellerRegistrationRepository;
import com.marolix.Bricks99.repository.UserLoginRepository;

@Component
public class SellerServiceImpl implements SellerService {

	@Autowired
	public UserLoginRepository userLoginRepository;
	@Autowired
	private SellerRegistrationRepository sellerRegistrationRepository;

	@Override
	public String validLogin(UserLoginDTO dto) throws Bricks99Exception {
		UserLogin ulogin = userLoginRepository.findByUserName(dto.getUser_name());
		if (ulogin == null)
			throw new Bricks99Exception("user not registered");
		System.out.println(dto.getUser_name());
		System.out.println(ulogin.getUserName());
		if (dto.getUser_name().equals(ulogin.getUserName()) && dto.getPassword().equals(ulogin.getPassword())) {
			return "login successful";
		} else
			throw new Bricks99Exception("Invalid login");

	}

	@Override
	public String sellerRegistration(SellerRegistrationDTO sellerDTO) throws Bricks99Exception {

		SellerRegistration sr = sellerRegistrationRepository.findByContact(sellerDTO.getContact());
		if (sr != null)
			throw new Bricks99Exception("Phone number already registered");
		SellerRegistration sr2 = sellerRegistrationRepository.findByEmail(sellerDTO.getEmail());
		if (sr2 != null)
			throw new Bricks99Exception("Email  already registered");
		SellerRegistration newSR = new SellerRegistration();
		newSR.setContact(sellerDTO.getContact());
		newSR.setEmail(sellerDTO.getEmail());
		newSR.setFirstName(sellerDTO.getFirstName());
		newSR.setLastName(sellerDTO.getLastName());
		newSR.setStatus(SellerStatus.PENDING);
		newSR.setPassword(sellerDTO.getPassword());
		Address address = new Address();
		AddressDTO adto = sellerDTO.getAddress();
		address.setAddressLine1(adto.getAddressLine1());
		address.setAddressLine2(adto.getAddressLine2());
		address.setCity(adto.getCity());
		address.setState(adto.getState());
		address.setPincode(adto.getPincode());
		newSR.setAddress(address);
		Integer i = sellerRegistrationRepository.save(newSR).getSeller_id();
		return "your registration is successfull with register id: " + i;
	}

}

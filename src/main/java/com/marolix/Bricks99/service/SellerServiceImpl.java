package com.marolix.Bricks99.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marolix.Bricks99.dto.SellerAddressDTO;
import com.marolix.Bricks99.dto.SellerRegistrationDTO;
import com.marolix.Bricks99.dto.UserLoginDTO;
import com.marolix.Bricks99.entity.SellerAddress;
import com.marolix.Bricks99.entity.SellerRegistration;
import com.marolix.Bricks99.entity.SellerStatus;
import com.marolix.Bricks99.entity.UserLogin;
import com.marolix.Bricks99.exception.Bricks99Exception;
import com.marolix.Bricks99.repository.SellerRegistrationRepository;
import com.marolix.Bricks99.repository.UserLoginRepository;

@Service(value = "selelrService")
@Transactional
public class SellerServiceImpl implements SellerService {

	@Autowired
	public UserLoginRepository userLoginRepository;
	@Autowired
	private SellerRegistrationRepository sellerRegistrationRepository;
	@Autowired
	private Environment environment;

	private String validation(String variable, String password, UserLogin ulogin) throws Bricks99Exception {
		if (ulogin == null)
			throw new Bricks99Exception(environment.getProperty("UserService.USER_NOT_FOUND"));

		if (variable.equals(ulogin.getEmail()) && password.equals(ulogin.getPassword())) {
			return "login successful";
		} else
			throw new Bricks99Exception("Invalid login");
	}

	@Override
	public String validLogin(UserLoginDTO dto) throws Bricks99Exception {
		UserLogin ulogin = null;
		if (dto.getUser_name() != null) {
			ulogin = userLoginRepository.findByUserName(dto.getUser_name());
			return validation(dto.getUser_name(), dto.getPassword(), ulogin);
		} else if (dto.getContact() != null) {
			ulogin = userLoginRepository.findByContact(dto.getContact());
			return validation(dto.getContact(), dto.getPassword(), ulogin);

		} else if (dto.getEmail() != null)
			ulogin = userLoginRepository.findByEmail(dto.getEmail());
		return validation(dto.getEmail(), dto.getPassword(), ulogin);

	}

	@Override
	public SellerRegistrationDTO sellerRegistration(SellerRegistrationDTO sellerDTO) throws Bricks99Exception {

		SellerRegistration sr = sellerRegistrationRepository.findByContact(sellerDTO.getContact());
		if (sr != null)
			throw new Bricks99Exception("Phone number already registered");
		SellerRegistration sr2 = sellerRegistrationRepository.findByEmail(sellerDTO.getEmail());
		if (sr2 != null)
			throw new Bricks99Exception("Email  already registered");
		SellerRegistration newSR = SellerRegistrationDTO.dtoToEntity(sellerDTO);

		Integer i = sellerRegistrationRepository.save(newSR).getSellerId();
		sellerDTO.setSellerId(i);
		UserLogin u = new UserLogin();
		u.setPassword(sellerDTO.getPassword());
		String s[] = sellerDTO.getEmail().split("@");
		String username = s[0] + sellerDTO.getContact().substring(2, 6);
		u.setUserName(username);
		u.setUserRole(sellerDTO.getRole());
		u.setContact(sellerDTO.getContact());
		u.setEmail(sellerDTO.getEmail());
		userLoginRepository.save(u);
		return sellerDTO;
	}

}

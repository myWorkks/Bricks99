package com.marolix.Bricks99.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marolix.Bricks99.dto.SellerRegistrationDTO;
import com.marolix.Bricks99.entity.SellerRegistration;
import com.marolix.Bricks99.entity.SellerStatus;
import com.marolix.Bricks99.exception.Bricks99Exception;
import com.marolix.Bricks99.repository.SellerRegistrationRepository;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private SellerRegistrationRepository sellerRegistrationRepository;

	@Override
	public List<SellerRegistrationDTO> viewAllRegisteredSellers(SellerStatus status) throws Bricks99Exception {
		List<SellerRegistration> list = sellerRegistrationRepository.findByStatus(status);
		return list.stream().map(p -> {
			SellerRegistrationDTO dto = new SellerRegistrationDTO();
			dto.setFirstName(p.getFirstName());
			return dto;
		}).collect(Collectors.toList());

	}

	@Override
	public SellerRegistrationDTO viewRegisteredSeller(Integer seller_id) throws Bricks99Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveAllSellers() throws Bricks99Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void approveSeller(Integer seller_id) throws Bricks99Exception {
		// TODO Auto-generated method stub

	}

}

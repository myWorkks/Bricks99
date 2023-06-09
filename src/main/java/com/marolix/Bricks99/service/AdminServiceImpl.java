package com.marolix.Bricks99.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
	@Autowired
	private Environment environment;

	@Override
	public List<SellerRegistrationDTO> viewAllRegisteredSellers(SellerStatus status) throws Bricks99Exception {
		List<SellerRegistration> list = sellerRegistrationRepository.findByStatus(status);
		return list.stream().map(p -> {
			SellerRegistrationDTO dto = SellerRegistrationDTO.entityToDTO(p);
			return dto;
		}).collect(Collectors.toList());

	}

	@Override
	public SellerRegistrationDTO viewRegisteredSeller(Integer seller_id) throws Bricks99Exception {
		Optional<SellerRegistration> op = sellerRegistrationRepository.findById(seller_id);
		SellerRegistration sr = op
				.orElseThrow(() -> new Bricks99Exception(environment.getProperty("AdminService.SellerNotRegistered")));
		return SellerRegistrationDTO.entityToDTO(sr);

	}

	@Override
	public void approveAllSellers() throws Bricks99Exception {
		List<SellerRegistration> list = sellerRegistrationRepository.findByStatus(SellerStatus.PENDING);
		if (list == null)
			throw new Bricks99Exception(environment.getProperty("AdminService.NO_NEW_SELLERS_FOUND"));
		else
			list.stream().forEach(t -> {
				t.setStatus(SellerStatus.APPROVED);
				sellerRegistrationRepository.save(t);
			});

	}

	@Override
	public void approveSeller(Integer seller_id) throws Bricks99Exception {
		Optional<SellerRegistration> op = sellerRegistrationRepository.findById(seller_id);
		SellerRegistration sr = op
				.orElseThrow(() -> new Bricks99Exception(environment.getProperty("AdminService.SellerNotRegistered")));
		sr.setStatus(SellerStatus.APPROVED);
		sellerRegistrationRepository.save(sr);
	}
	@Override
	public void rejectAllSellers() throws Bricks99Exception {
		List<SellerRegistration> list = sellerRegistrationRepository.findByStatus(SellerStatus.PENDING);
		if (list == null)
			throw new Bricks99Exception(environment.getProperty("AdminService.NO_NEW_SELLERS_FOUND"));
		else
			list.stream().forEach(t -> {
				t.setStatus(SellerStatus.REJECTED);
				sellerRegistrationRepository.save(t);
			});

	}

	@Override
	public void rejectSeller(Integer seller_id) throws Bricks99Exception {
		Optional<SellerRegistration> op = sellerRegistrationRepository.findById(seller_id);
		SellerRegistration sr = op
				.orElseThrow(() -> new Bricks99Exception(environment.getProperty("AdminService.SellerNotRegistered")));
		sr.setStatus(SellerStatus.REJECTED);
		sellerRegistrationRepository.save(sr);
	}
	

}

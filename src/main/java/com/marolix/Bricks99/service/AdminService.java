package com.marolix.Bricks99.service;

import java.util.List;

import com.marolix.Bricks99.dto.SellerRegistrationDTO;
import com.marolix.Bricks99.entity.SellerStatus;
import com.marolix.Bricks99.exception.Bricks99Exception;

public interface AdminService {
	public List<SellerRegistrationDTO> viewAllRegisteredSellers(SellerStatus status) throws Bricks99Exception;

	public SellerRegistrationDTO viewRegisteredSeller(Integer seller_id) throws Bricks99Exception;

	public void approveAllSellers() throws Bricks99Exception;

	public void approveSeller(Integer seller_id) throws Bricks99Exception;
}

package com.marolix.Bricks99.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marolix.Bricks99.dto.SellerRegistrationDTO;
import com.marolix.Bricks99.exception.Bricks99Exception;
import com.marolix.Bricks99.service.SellerService;
@CrossOrigin
@RestController
@RequestMapping(value = "seller-api")
public class SellerAPI {

	@Autowired
	private SellerService sellerService;

	@PostMapping(value = "register")
	public ResponseEntity<String> registerSeller(@RequestBody SellerRegistrationDTO sellerDTO)
			throws Bricks99Exception {

		return new ResponseEntity<String>(sellerService.sellerRegistration(sellerDTO), HttpStatus.CREATED);
	}
}

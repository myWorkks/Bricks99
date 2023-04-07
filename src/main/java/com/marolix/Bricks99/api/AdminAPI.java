package com.marolix.Bricks99.api;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marolix.Bricks99.dto.SellerRegistrationDTO;
import com.marolix.Bricks99.entity.SellerStatus;
import com.marolix.Bricks99.exception.Bricks99Exception;
import com.marolix.Bricks99.service.AdminService;

@Validated
@RestController
@RequestMapping(value = "admin-api")
public class AdminAPI {

	@Autowired
	private AdminService adminService;

	@GetMapping(value = "viewAll/{status}")
	public ResponseEntity<List<SellerRegistrationDTO>> viewRegisteredSellers(
			@PathVariable @NotNull( message = "invalid status entry") SellerStatus status)
			throws Bricks99Exception {
		return new ResponseEntity<List<SellerRegistrationDTO>>(adminService.viewAllRegisteredSellers(status),
				HttpStatus.OK);
	}

}

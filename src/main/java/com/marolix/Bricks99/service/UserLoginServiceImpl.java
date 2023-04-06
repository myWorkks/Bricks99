package com.marolix.Bricks99.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.marolix.Bricks99.dto.UserLoginDTO;
import com.marolix.Bricks99.entity.UserLogin;
import com.marolix.Bricks99.exception.Bricks99Exception;
import com.marolix.Bricks99.repository.UserLoginRepository;

@Component
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	public UserLoginRepository userLoginRepository;

	@Override
	public String  validLogin(UserLoginDTO dto) throws Bricks99Exception {
		UserLogin ulogin = userLoginRepository.findByUserName(dto.getUser_name());
		if(ulogin==null)throw new Bricks99Exception("user not registered");
		System.out.println(dto.getUser_name());
		System.out.println(ulogin.getUserName());
		if (dto.getUser_name().equals(ulogin.getUserName()) && dto.getPassword().equals(ulogin.getPassword())) {
			return "login successful";
		} else
			throw new Bricks99Exception("Invalid login");

	}

}

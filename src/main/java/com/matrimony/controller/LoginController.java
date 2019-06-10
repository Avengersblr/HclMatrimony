package com.matrimony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.dto.LoginDto;
import com.matrimony.entity.Login;
import com.matrimony.exception.MatrimonyDetailNotfoundException;
import com.matrimony.service.LoginService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<Login> validateLogin(@RequestBody LoginDto loginDto) {
		Login login = loginService.validateLogin(loginDto);
		if (login == null)
			throw new MatrimonyDetailNotfoundException();
		return new ResponseEntity<Login>(login, HttpStatus.OK);
	}

}

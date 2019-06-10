package com.matrimony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.dto.ProfileDto;
import com.matrimony.entity.Login;
import com.matrimony.service.ProfileService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfileController {
	
	@Autowired
	ProfileService profileService;

	@PostMapping("/createProfile")
	public ResponseEntity<Login> createProfile(@RequestBody ProfileDto profileDto) {
		Login profileData = profileService.createProfile(profileDto);

		return new ResponseEntity<Login>(profileData, HttpStatus.OK);
	}
}

package com.matrimony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.service.ProfileService;

@RestController
public class ProfileController {
	
	@Autowired
	ProfileService profileService;

}

package com.matrimony.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.entity.Profile;
import com.matrimony.service.DashboardService;

@RestController
public class DashboardController {
	
	@Autowired
	DashboardService dashboardService;
	@GetMapping("/getFilteredProfile/{profileId}")
	public ResponseEntity<List<Profile>> getFilteredProfile(@PathVariable Integer profileId) {

		List<Profile> profileData = new ArrayList<Profile>();
		profileData = dashboardService.getFilteredProfile(profileId);

		return new ResponseEntity<List<Profile>>(profileData, HttpStatus.OK);
	}
}

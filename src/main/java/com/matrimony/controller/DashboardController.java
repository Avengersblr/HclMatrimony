package com.matrimony.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.dto.DashboardDto;
import com.matrimony.entity.Dashboard;
import com.matrimony.entity.Profile;
import com.matrimony.service.DashboardService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DashboardController {

	@Autowired
	DashboardService dashboardService;

	@GetMapping("/getFilteredProfile/{profileId}")
	public ResponseEntity<List<Profile>> getFilteredProfile(@PathVariable Integer profileId) {

		List<Profile> profileData = new ArrayList<Profile>();
		profileData = dashboardService.getFilteredProfile(profileId);

		return new ResponseEntity<List<Profile>>(profileData, HttpStatus.OK);
	}

	@GetMapping("/getInterestedProfile/{profileId}")
	public List<Dashboard> getInterestedProfile(@PathVariable Long profileId) {
		return dashboardService.getInterestedProfiles(profileId);
	}

	@GetMapping("/getAcceptedProfile/{profileId}")
	public List<Dashboard> getAcceptedProfile(@PathVariable Long profileId) {
		return dashboardService.getAcceptedProfiles(profileId);
	}

	@GetMapping("/getRejectedProfile/{profileId}")
	public List<Dashboard> getRejectedProfile(@PathVariable Long profileId) {
		return dashboardService.getRejectedProfiles(profileId);
	}

	@PutMapping("/updateInterest")
	public ResponseEntity<Dashboard> updateInterest(@RequestBody DashboardDto dashboardDto) {
		Dashboard dashboard = dashboardService.updateInterest(dashboardDto);
		return new ResponseEntity<Dashboard>(dashboard, HttpStatus.OK);
	}

	@PutMapping("/updateAcceptReject")
	public ResponseEntity<Dashboard> updateAcceptReject(@RequestBody DashboardDto profileDto) {
		Dashboard dashboard = dashboardService.updateAcceptReject(profileDto);
		return new ResponseEntity<Dashboard>(dashboard, HttpStatus.OK);
	}
}

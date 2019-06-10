package com.matrimony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.service.DashboardService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DashboardController {
	
	@Autowired
	DashboardService dashboardService;

}

package com.matrimony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.repository.DashboardRepository;

@Service
public class DashboardService {
	
	@Autowired
	DashboardRepository dashboardRepository;

}

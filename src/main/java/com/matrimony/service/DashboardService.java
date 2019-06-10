package com.matrimony.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.entity.Dashboard;
import com.matrimony.entity.Profile;
import com.matrimony.repository.DashboardRepository;
import com.matrimony.repository.ProfileRepository;

@Service
public class DashboardService {

	@Autowired
	DashboardRepository dashboardRepository;

	@Autowired
	ProfileRepository profileRepo;

	public List<Profile> getFilteredProfile(Integer profileId) {
		Profile profile = new Profile();
		List<Profile> lp = new ArrayList<Profile>();
		profile = profileRepo.findByProfileId(profileId);
		String profileGender = profile.getGender();
		List<Profile> profileList = profileRepo.findByGenderNotLike(profileGender);
		for (Profile pro : profileList) {
			Long profId = pro.getProfileId();

			if (null != dashboardRepository.findByProfileDashId(profId)) {
				continue;
			} else {
				lp.add(pro);
			}

		}
		return lp;
	}

	
	public List<Dashboard> getInterestedProfiles(Long profileId) {
		return dashboardRepository.getAllInterestedProfiles(profileId);
	}

	
	public List<Dashboard> getAcceptedProfiles(Long profileId) {
		return dashboardRepository.getAllAccepetedProfiles(profileId);
	}

	
	public List<Dashboard> getRejectedProfiles(Long profileId) {
		return dashboardRepository.getAllRejectedProfiles(profileId);
	}
}

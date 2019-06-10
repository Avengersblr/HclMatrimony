package com.matrimony.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.dto.DashboardDto;
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
	
	public Dashboard updateInterest(DashboardDto profileDto) {
		Dashboard newOrUpdated = null;
		Long actionProfileID = profileDto.getActionProfileId();
		Long profileId = profileDto.getProfileId();
		Dashboard actionProfile = dashboardRepository.findByProfileIdAndInterestedProfileId(actionProfileID, profileId);
		Dashboard newProfile = new Dashboard();
		newProfile.setProfileId(profileDto.getActionProfileId());
		newProfile.setProfileName(profileDto.getActionProfileName());
		if (profileDto.getAction().equalsIgnoreCase("Interest")) {
			newProfile.setInterestedProfileId(profileDto.getProfileId());
			newProfile.setInterestedProfileName(profileDto.getProfileName());
		}
		newOrUpdated = dashboardRepository.save(newProfile);
		return newOrUpdated;
	}
	
	public Dashboard updateAcceptReject(DashboardDto profileDto) {
		Dashboard newOrUpdated = null;
		Long actionProfileID = profileDto.getActionProfileId();
		Long profileId = profileDto.getProfileId();
		Dashboard actionProfile = dashboardRepository.findByProfileIdAndInterestedProfileId(actionProfileID, profileId);
		
		if (actionProfile != null) {
			if (profileDto.getAction().equalsIgnoreCase("Accept")) {
				actionProfile.setAcceptedProfileID(profileDto.getProfileId());
				actionProfile.setAcceptedProfileName(profileDto.getProfileName());
				actionProfile.setInterestedProfileId(null);
				actionProfile.setInterestedProfileName(null);
				actionProfile.setRejectedProfileId(null);
				actionProfile.setRejectedProfileName(null);
			} else if (profileDto.getAction().equalsIgnoreCase("Reject")) {
				actionProfile.setRejectedProfileId(profileDto.getProfileId());
				actionProfile.setRejectedProfileName(profileDto.getProfileName());
				actionProfile.setInterestedProfileId(null);
				actionProfile.setInterestedProfileName(null);
				actionProfile.setAcceptedProfileID(null);
				actionProfile.setAcceptedProfileName(null);
			} 
			newOrUpdated = dashboardRepository.save(actionProfile);
		} 
		return newOrUpdated;
	}
}

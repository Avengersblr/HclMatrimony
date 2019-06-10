package com.matrimony.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.dto.ProfileDto;
import com.matrimony.entity.Login;
import com.matrimony.entity.Profile;
import com.matrimony.exception.MatrimonyApplicationException;
import com.matrimony.repository.LoginRepository;
import com.matrimony.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	LoginRepository loginRepository;

	private static Logger logger = Logger.getLogger(ProfileService.class.getName());

	public Login createProfile(ProfileDto profileDto) {

		Login loginDetail = loginRepository.findByLoginName(profileDto.getEmailIdDto());
		if (null != loginDetail) {
			throw new MatrimonyApplicationException("User already exists...!!");
		}

		logger.info("success");
		logger.log(Level.FINE, "suceess", profileDto.toString());

		Profile profile = new Profile();
		profile.setAge(profileDto.getAgeDto());
		profile.setCaste(profileDto.getCasteDto());
		profile.setEmailId(profileDto.getEmailIdDto());
		profile.setDob(profileDto.getDobDto());
		profile.setFirstName(profileDto.getFirstNameDto());
		profile.setLastName(profileDto.getLastNameDto());
		profile.setGender(profileDto.getGenderDto());
		profile.setMobile(profileDto.getMobileDto());
		profile.setOpenToMany(profileDto.getOpenToManyDto());
		profile.setReligionPreference(profileDto.getReligionPreferenceDto());
		profile.setSalary(profileDto.getSalaryDto());

		Login login = new Login();
		login.setPassword(profileDto.getFirstNameDto());
		login.setLoginName(profileDto.getEmailIdDto());
		login.setActionMessage("success");

		// login.setProfile(profileDto);
		login.setProfile(profile);

		profileRepository.save(profile);
		loginRepository.save(login);

		return login;
	}

}

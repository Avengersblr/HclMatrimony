package com.matrimony.servicetest;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.matrimony.dto.DashboardDto;
import com.matrimony.dto.LoginDto;
import com.matrimony.dto.ProfileDto;
import com.matrimony.entity.Dashboard;
import com.matrimony.entity.Login;
import com.matrimony.entity.Profile;
import com.matrimony.repository.DashboardRepository;
import com.matrimony.repository.LoginRepository;
import com.matrimony.repository.ProfileRepository;
import com.matrimony.service.LoginService;
import com.matrimony.service.ProfileService;

import junit.framework.Assert;

public class ProfileServiceImplTest {
	
	@InjectMocks
	ProfileService profileService;

	@Mock
	LoginRepository loginRepository;

	@Mock
	DashboardRepository dashboardRepository;

	@Mock
	ProfileRepository profileRepository;

	static Dashboard dashboard = new Dashboard();
	static List<Dashboard> expectval = new ArrayList<Dashboard>();

	static ProfileDto ProfileDto = new ProfileDto();
	static Profile profile = new Profile();
	static Login login = new Login();
	static LoginDto loginDto = new LoginDto();

	static DashboardDto dashboardDto = new DashboardDto();
	static List<Profile> lst = new ArrayList<Profile>();

	@BeforeClass
	public static void setUp() {

		ProfileDto.setAgeDto(12);
		ProfileDto.setCasteDto("asd");
		ProfileDto.setEmailIdDto("rohit@gmail");
		ProfileDto.setFirstNameDto("Rohit");
		ProfileDto.setGenderDto("M");
		ProfileDto.setLastNameDto("Kumar");
		ProfileDto.setMobileDto(122434L);
		ProfileDto.setReligionPreferenceDto("Hindu");
		ProfileDto.setSalaryDto(12340);

		profile.setAge(ProfileDto.getAgeDto());
		profile.setCaste(ProfileDto.getCasteDto());
		profile.setEmailId(ProfileDto.getEmailIdDto());
		profile.setFirstName(ProfileDto.getFirstNameDto());
		profile.setGender(ProfileDto.getGenderDto());
		profile.setLastName(ProfileDto.getLastNameDto());
		profile.setMobile(ProfileDto.getMobileDto());
		profile.setProfileId(111L);
		profile.setReligionPreference(ProfileDto.getReligionPreferenceDto());
		profile.setSalary(ProfileDto.getSalaryDto());
		lst.add(profile);

		login.setPassword(ProfileDto.getFirstNameDto());
		login.setLoginName(ProfileDto.getFirstNameDto().substring(0, 3) + ProfileDto.getLastNameDto().substring(0, 3));
		login.setActionMessage("success");

		loginDto.setLoginName("RohKum");
		loginDto.setPassword("Rohit");

	}

	@Test
	public void testCreateProfile() {
		Login actval = profileService.createProfile(ProfileDto);
		Assert.assertEquals("RohKum", actval.getLoginName());

	}
}

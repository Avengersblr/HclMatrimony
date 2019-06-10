package com.matrimony.servicetest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.matrimony.entity.Dashboard;
import com.matrimony.repository.DashboardRepository;
import com.matrimony.repository.LoginRepository;
import com.matrimony.repository.ProfileRepository;
import com.matrimony.service.DashboardService;

@RunWith(MockitoJUnitRunner.class)
public class DashboardServiceImplTest {

	@InjectMocks
	DashboardService dashboardService;

	@Mock
	DashboardRepository dashboardRepository;
	@Mock
	ProfileRepository profileRepository;
	@Mock
	LoginRepository loginRepository;

	static Dashboard dashboard = new Dashboard();
	static List<Dashboard> expectval = new ArrayList<Dashboard>();

	@BeforeClass
	public static void setUp() {

		dashboard.setDashboardId(11L);
		dashboard.setAcceptedProfileID(1);
		dashboard.setAcceptedProfileName("qwe");
		dashboard.setInterestedProfileId(2L);
		dashboard.setInterestedProfileName("asd");
		dashboard.setProfileId(3L);
		dashboard.setProfileName("zxc");
		dashboard.setRejectedProfileId(4);
		expectval.add(dashboard);
	}

	@Test
	public void testGetInterestedProfiles() {
		Mockito.when(dashboardRepository.getAllInterestedProfiles(dashboard.getInterestedProfileId()))
				.thenReturn(expectval);
		List<Dashboard> actval = dashboardService.getInterestedProfiles(dashboard.getInterestedProfileId());
		assertEquals(expectval.size(), actval.size());
	}

	@Test
	public void testGetAcceptedProfiles() {
		Mockito.when(dashboardRepository.getAllAccepetedProfiles(dashboard.getInterestedProfileId()))
				.thenReturn(expectval);
		List<Dashboard> actval = dashboardService.getAcceptedProfiles(dashboard.getInterestedProfileId());
		assertEquals(expectval.size(), actval.size());
	}

	@Test
	public void testGetRejectedProfiles() {
		Mockito.when(dashboardRepository.getAllRejectedProfiles(dashboard.getInterestedProfileId()))
				.thenReturn(expectval);
		List<Dashboard> actval = dashboardService.getRejectedProfiles(dashboard.getInterestedProfileId());
		assertEquals(expectval.size(), actval.size());
	}

}

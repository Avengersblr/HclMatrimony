package com.matrimony.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dashboard implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dashboardId;
	private Long profileId;
	private String profileName;
	private Long interestedProfileId;
	private String interestedProfileName;
	private Long acceptedProfileID;
	private String acceptedProfileName;
	private Long rejectedProfileId;
	private String rejectedProfileName;

	public Long getDashboardId() {
		return dashboardId;
	}

	public void setDashboardId(Long dashboardId) {
		this.dashboardId = dashboardId;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Long getInterestedProfileId() {
		return interestedProfileId;
	}

	public void setInterestedProfileId(Long interestedProfileId) {
		this.interestedProfileId = interestedProfileId;
	}

	public String getInterestedProfileName() {
		return interestedProfileName;
	}

	public void setInterestedProfileName(String interestedProfileName) {
		this.interestedProfileName = interestedProfileName;
	}

	public Long getAcceptedProfileID() {
		return acceptedProfileID;
	}

	public void setAcceptedProfileID(Long acceptedProfileID) {
		this.acceptedProfileID = acceptedProfileID;
	}

	public String getAcceptedProfileName() {
		return acceptedProfileName;
	}

	public void setAcceptedProfileName(String acceptedProfileName) {
		this.acceptedProfileName = acceptedProfileName;
	}

	public Long getRejectedProfileId() {
		return rejectedProfileId;
	}

	public void setRejectedProfileId(Long rejectedProfileId) {
		this.rejectedProfileId = rejectedProfileId;
	}

	public String getRejectedProfileName() {
		return rejectedProfileName;
	}

	public void setRejectedProfileName(String rejectedProfileName) {
		this.rejectedProfileName = rejectedProfileName;
	}

	@Override
	public String toString() {
		return "Dashboard [dashboardId=" + dashboardId + ", profileId=" + profileId + ", profileName=" + profileName
				+ ", interestedProfileId=" + interestedProfileId + ", interestedProfileName=" + interestedProfileName
				+ ", acceptedProfileID=" + acceptedProfileID + ", acceptedProfileName=" + acceptedProfileName
				+ ", rejectedProfileId=" + rejectedProfileId + ", rejectedProfileName=" + rejectedProfileName + "]";
	}

	public Dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}
}

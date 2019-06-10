package com.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matrimony.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}

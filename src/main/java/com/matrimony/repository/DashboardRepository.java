package com.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matrimony.entity.Dashboard;

public interface DashboardRepository extends JpaRepository<Dashboard, Long> {

	@Query(value = "select * from dashboard d where d.profile_id = :profId", nativeQuery = true)
	Dashboard findByProfileDashId(Long profId);
}

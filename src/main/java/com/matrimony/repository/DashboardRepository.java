package com.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matrimony.entity.Dashboard;

public interface DashboardRepository extends JpaRepository<Dashboard, Long> {

}

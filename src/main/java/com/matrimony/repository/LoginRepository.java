package com.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matrimony.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

}

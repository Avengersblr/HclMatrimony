package com.matrimony.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.dto.LoginDto;
import com.matrimony.entity.Login;
import com.matrimony.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;
	
	private static Logger logger = Logger.getLogger(ProfileService.class.getName());
	
	public Login validateLogin(LoginDto loginDto) {
		logger.log(Level.FINE, "suceess", loginDto.toString());
		Login login = new Login();
		login = loginRepository.findByLoginNameAndPassword(loginDto.getLoginName(), loginDto.getPassword());
		/*
		 * if (login != null) { logger.log(Level.FINE, "suceess", login.toString());
		 * login.setActionMessage("success"); return login; } else { Login login1 = new
		 * Login(); logger.log(Level.SEVERE, "Login details should not be null",
		 * loginDto.toString()); login1.setLoginName(loginDto.getLoginName());
		 * login1.setActionMessage(loginDto.getLoginName() + "is not a valid user");
		 * return login1; }
		 */
		return login;
	}

}

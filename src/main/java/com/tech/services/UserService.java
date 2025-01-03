package com.tech.services;

import org.springframework.stereotype.Service;

import com.tech.dto.LoginForm;
import com.tech.dto.SignUpForm;
import com.tech.dto.UnlockForm;

@Service
public interface UserService {
	
	public String login(LoginForm form);
	
	public boolean signup(SignUpForm form);
	
	public boolean unlock(UnlockForm form);
	
	public String forgotpswrd(String email);

	
}

package com.tech.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dto.LoginForm;
import com.tech.dto.SignUpForm;
import com.tech.dto.UnlockForm;
import com.tech.entity.UserDtlsEntity;
import com.tech.repo.UserDtlsRepo;
import com.tech.utils.EmailUtils;
import com.tech.utils.PwdUtils;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDtlsRepo userDtlsRepo;
	
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public String login(LoginForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean signup(SignUpForm form) {
		
		// copy data from binding object to entitty object
		UserDtlsEntity  entity = new UserDtlsEntity();
		BeanUtils.copyProperties(form, entity);
		
		//generate the random password and set to object
		String tempPwd= PwdUtils.generateRandompwd();
		entity.setPassword(tempPwd);
		
		// set the account status as locked
		entity.setAccstatus("LOCKED");
		
		// Insert the record into the table 
			userDtlsRepo.save(entity);
		
		// send email to the account
			String to = form.getMail();
			String subject = "Unlock your account";
		//	String body ="<h1>Use below Temp password to unlock your account</h1>";
			
			StringBuffer body = new StringBuffer();
			body.append("<h1>Use below Temp password to unlock your account</h1>");
			body.append("Temporary Password is :" +tempPwd);
			body.append("<br/>");
			body.append("<a href=\"unlock?email="+to+"\">click here to unlock your account");
			
			emailUtils.sendEmail(to, subject, body.toString());
		
		return false;
	}

	@Override
	public String unlock(UnlockForm form) {
		// TODO Auto-generated method stub
		return null ;
	}

	@Override
	public String forgotpswrd(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}

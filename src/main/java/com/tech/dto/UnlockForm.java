package com.tech.dto;

import lombok.Data;

@Data
public class UnlockForm {
	
	private String email;
	private String tempPassword;
	private String newPwd;
	private String confirmPwd;
	
	

}

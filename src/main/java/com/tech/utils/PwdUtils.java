package com.tech.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class PwdUtils {
	
	public static String generateRandompwd() {
		
		// this logic is brought from stack overflow with a dependency
		
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String pwd = RandomStringUtils.random( 6, characters );
		
		//System.out.println( pwd );

		return pwd;
	}

}

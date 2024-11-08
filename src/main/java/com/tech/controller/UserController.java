package com.tech.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/login")
	public String logiPage()
	{
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup()
	{
		return "signup";
	}
	@GetMapping("/unlock")
	public String unlock()
	{
		return"unlock";
	}
	
	@GetMapping("/forgot")
	public String forgotpswrd()
	{
		return "forgotPwd";
	}
}

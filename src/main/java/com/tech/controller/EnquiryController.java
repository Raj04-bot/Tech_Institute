package com.tech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {
	
	@GetMapping("/dashboard")
	public String dashBoard()
	{
		return "dashboard";
	}
	
	@GetMapping("/enquiry")
	 public String addEnquiry()
	 {
		 return"view_enquiries";
	 }
	
	@GetMapping("/enquiries")
	public String viewEnquiry()
	{
		return "add-enquiry";
	}
	
	

}

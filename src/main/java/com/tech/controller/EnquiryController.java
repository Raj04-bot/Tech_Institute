package com.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tech.dto.DashBoardResponse;
import com.tech.services.EnquiryService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {
	
	@Autowired
	private EnquiryService enqservice;
	
	@Autowired
	private HttpSession session;
	
	
	@GetMapping("/logout")
	public String logout()
	{
		session.invalidate();	
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String dashBoard(Model model)
	{
		Integer userId =(Integer) session.getAttribute("userID");
		
		 DashBoardResponse dashboardData = enqservice.getDashBoardData(null);
		 
		 model.addAttribute("dashboardData",dashboardData);
		
		return "dashboard";
	}
	
	@GetMapping("/enquiry")
	 public String addEnquiry()
	 {
		 return"view-enquiries";
	 }
	
	@GetMapping("/enquiries")
	public String viewEnquiry()
	{
		return "add-enquiry";
	}
	
	

}

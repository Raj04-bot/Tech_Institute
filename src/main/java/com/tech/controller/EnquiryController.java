package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tech.dto.DashBoardResponse;
import com.tech.dto.EnquiryForm;
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
	 public String addEnquiry(Model model)
	 {
		//get courses for dropdown
			List<String> courses = enqservice.getCourses();
		
		//get enq status for dropdown
			List<String> enqStatus  = enqservice.getEnqStatuses();
		
		//create binding class object
			EnquiryForm formobj = new EnquiryForm();
		
		//send data in model object
		model.addAttribute("courseNames",courses);
		model.addAttribute("enqStatusNames",enqStatus);
		model.addAttribute("formObj", formobj);
		
		 return"add-enquiry";
	 }
	
//	  @PostMapping("/enquiry")
//	    public String saveEnquiry(@ModelAttribute("formObj") EnquiryForm formObj, Model model) {
//	        boolean isSaved = enqservice.saveEnquiry(formObj);
//
//	        if (isSaved) {
//	            model.addAttribute("successMessage", "Enquiry saved successfully!");
//	        } else {
//	            model.addAttribute("errorMessage", "Failed to save enquiry.");
//	        }
//
//	        return "redirect:/enquiries";
//	    }

	
	@GetMapping("/enquiries")
	public String viewEnquiry()
	{
		return "view-enquires";
	}
	
	

}

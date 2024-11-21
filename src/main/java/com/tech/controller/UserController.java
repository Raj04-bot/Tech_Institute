package com.tech.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.dto.SignUpForm;
import com.tech.dto.UnlockForm;
import com.tech.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("user", new SignUpForm());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String handleSignup( @ModelAttribute ("user")SignUpForm form, Model model)
	{
		boolean status = userService.signup(form);
		
		if (status)
		{
			model.addAttribute("success msg", "Account cerated, Check your Email");
		}else {
			model.addAttribute("error","Chose another email");
		}
		
		return "signup";
	}
	
	
	
	@GetMapping("/login")
	public String logiPage()
	{
		return "login";
	}
	

	
	@GetMapping("/unlock")
	public String unlock(@RequestParam String email, Model model)// this method is taking data from form as a query parameter
	{
		// Setting data to the binding oject
		UnlockForm unlockFormObj = new UnlockForm();
		unlockFormObj.setEmail(email);
		
		// sending the data to the UI
		model.addAttribute("unlock",unlockFormObj);
		
		// page will be loaded
		return"unlock";
	}
	
	@PostMapping("/unlock")
	public String unlockAccount(@ModelAttribute UnlockForm form, Model model)
	{
		
		return "unlock";
	}
	
	
	
	@GetMapping("/forgot")
	public String forgotpswrd()
	{
		return "forgotPwd";
	}
}

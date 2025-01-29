package com.tech.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.dto.LoginForm;
import com.tech.dto.SignUpForm;
import com.tech.dto.UnlockForm;
import com.tech.services.UserService;

import ch.qos.logback.core.joran.conditional.IfAction;
import ch.qos.logback.core.status.Status;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	private boolean status;
	
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
			model.addAttribute("succMsg", "Account cerated, Check your Email");
		}else {
			model.addAttribute("errMsg","Chose another email");
		}
		
		return "signup";
	}
	
	
	
	@GetMapping("/login")
	public String loginpage(Model model)
	{
		model.addAttribute("loginform",new LoginForm());
		return "login";
	}
	
	@PostMapping("/loginform")
	public String login (@ModelAttribute("loginform") LoginForm loginform, Model model)
	{
		
		String	status = userService.login(loginform);
		if(status.contains("success"))
		{
			return "redirect:/dashboard";
		}
		model.addAttribute("errMsg",status);
		
		return "login";
		
	}
	

	
	@GetMapping("/unlock")
	// this method is taking data from form as a query parameter
	public String unlock(@RequestParam String email, Model model)
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
	public String unlockAccount(@ModelAttribute("unlock") UnlockForm unlock, Model model)
	{
		
		
		if(unlock.getNewPwd().equals(unlock.getConfirmPwd()))
		{
		  if (status) {
			  model.addAttribute("succMsg", "Your acchount has been unlocked");
		  }else {
			model.addAttribute("given temp password is  incorrect");
		}
			
		}else {
			model.addAttribute("errMsg","New Password and confirm password should be same");
		}

		
		return "unlock";
	}
	
	
	
	@GetMapping("/forgot")
	public String forgotpswrd()
	{
		return "forgotPwd";
	}
	
	@PostMapping("/forgotPwd")
	public String forgotpwd(@RequestParam("email")String email,Model model)
	{
		boolean status = userService.forgotpswrd(email);
		
		if (status)
		{
			model.addAttribute("succMsg","password sent to your registerd email id");
		}else {
			model.addAttribute("errMsg","invalid email");
			
		}
		return forgotpswrd();
	}
}

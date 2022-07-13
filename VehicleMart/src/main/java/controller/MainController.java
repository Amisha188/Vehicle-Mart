package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping(value = "/login")
	public String showLogin(Model model) {
		
		model.addAttribute("loginDetail", "login");
		return "Login";
	}
	
	@RequestMapping(value = "/register")
	public String showRegister() {
		return "Registration";
	}
	
	@RequestMapping(value = "/about_us")
	public String showAboutUs() {
		return "index";
	}
	
	@RequestMapping(value = "/contact_us")
	public String showContactUs() {
		return "index";
	}
	
	
}

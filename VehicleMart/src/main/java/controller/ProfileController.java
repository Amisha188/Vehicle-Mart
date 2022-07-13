package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDAO;
import model.UserDetail;

@Controller
public class ProfileController {

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(Model model,@RequestParam("username")String userName,@RequestParam("password")String password1,
			@RequestParam("confirm")String password2,@RequestParam("role")String role,@RequestParam("email")String email,
			@RequestParam("fullname")String fullName,@RequestParam("address")String Address) {
		
		String page = "";
		if(password1.equals(password2)) {
			
			model.addAttribute("message", "");
			
			UserDetail user = new UserDetail();
			user.setUserName(userName);
			user.setPassword(password1);
			user.setEmail(email);
			user.setUserRole(role);
			user.setFullName(fullName);
			user.setAddress(Address);
			
			model.addAttribute("user", user);
			userDAO.registerUser(user);
			page = "index";
		}
		else {
			model.addAttribute("message", "Password and Confirm password should be same.");
			page = "Registration";
		}
		
		return page;
	}
	
	
	@RequestMapping(value = "/displayProfile")
	public ModelAndView displayProfile(HttpSession session, ModelAndView model) {
		
		String userName = (String) session.getAttribute("username");
		UserDetail user = userDAO.getUser(userName);
		model.addObject("user", user);
		model.setViewName("DisplayProfile");
		
		return model;
	}
	
	@RequestMapping(value = "/editProfile")
	public ModelAndView editProfile(HttpSession session, ModelAndView model) {
		
		String userName = (String) session.getAttribute("username");
		UserDetail user = userDAO.getUser(userName);
		model.addObject("user", user);
		model.setViewName("UpdateProfile");
		
		return model;
	}
	
	@RequestMapping(value = "/updateProfile")
	public String updateProfile(Model model,@RequestParam("username")String userName,@RequestParam("role")String role,
			@RequestParam("email")String email,@RequestParam("fullname")String fullName,@RequestParam("address")String Address) {
		
			
		UserDetail user = new UserDetail();
		user.setUserName(userName);
		user.setEmail(email);
		user.setUserRole(role);
		user.setFullName(fullName);
		user.setAddress(Address);
		
		userDAO.updateUserDetail(user);
		model.addAttribute("user", user);
		return "DisplayProfile";
	}
	
	@RequestMapping(value = "/deleteProfile")
	public ModelAndView deleteProfile(HttpSession session, ModelAndView model) {
		
		String userName = (String) session.getAttribute("username");
		UserDetail user = userDAO.getUser(userName);
		userDAO.deleteUserDetail(user);
		
		session.invalidate();
		model.setViewName("index");
		
		return model;
	}
}

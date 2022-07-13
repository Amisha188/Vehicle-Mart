package controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.ProductDAO;
import dao.UserDAO;
import model.Product;
import model.UserDetail;

@SuppressWarnings("serial")
@Controller
public class UserController extends HttpServlet {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = "/userHome")
	public ModelAndView userHome(ModelAndView model, HttpSession session) {
		
		model.addObject("pageinfo", "Product Catalog");
		List<Product> listOfProduct = productDAO.listOfProducts();
		model.addObject("listOfProduct", listOfProduct);
		model.setViewName("UserHome");
		
		return model;
	}
	
	
	@RequestMapping(value = "/performLogin", method = RequestMethod.POST)
	public String performLogin(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String page = "";
		boolean loggedIn = false;
		boolean admin = false;
		HttpSession session = request.getSession();
		List<Product> listOfProduct = productDAO.listOfProducts();
		model.addAttribute("listOfProduct", listOfProduct);
		
		UserDetail user =  userDAO.validateUser(userName, password);
		if (null != user) {
			
			loggedIn = true;
			String role = user.getUserRole();
			session.setAttribute("role", role);
			session.setAttribute("loggedIn", loggedIn);
			session.setAttribute("username", userName);
			
			if(role.equals("ADMIN")) {
				admin = true;
				page = "AdminHome";
			}
			else {
				
				model.addAttribute("pageinfo", "User Home");
				page = "UserHome";
			}
			session.setAttribute("admin", admin);
		} 
		else {
		    loggedIn = false;
		    session.setAttribute("loggedIn", loggedIn);
		    model.addAttribute("message", "Username or Password is wrong!!");
		    page = "Login";
		}
		
		return page;
	}
	
	@RequestMapping(value = "/performLogout")
	public String performLogout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "Login";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        performLogin(request, response,model);
    }
	
	
}

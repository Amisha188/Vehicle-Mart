package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.CartDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.UserDAO;
import model.CartItem;
import model.OrderDetail;
import model.UserDetail;

@Controller
public class PaymentController {

	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping(value = "/checkOut")
	public ModelAndView checkOut(ModelAndView model, HttpSession session) {
		
		String userName = (String) session.getAttribute("username");
		List<CartItem> listOfCartItems = cartDAO.listOfCartItems(userName);
		
		model.addObject("listOfCartItems", listOfCartItems);
		model.addObject("grandTotal", this.getGrandTotal(listOfCartItems));
		
		UserDetail user = userDAO.getUser(userName);
		String address = user.getAddress();
		model.addObject("address", address);
		
		model.setViewName("OrderConfirm");
		
		return model;
	}
	
	@RequestMapping(value="/updateAddress", method = RequestMethod.POST)
	public ModelAndView updateAddress(@RequestParam("address")String address, ModelAndView model, HttpSession session) {
		
		String userName = (String) session.getAttribute("username");
		UserDetail user = userDAO.getUser(userName);
		user.setAddress(address);
		userDAO.updateUserDetail(user);
		
		model.setViewName("redirect:/checkOut");
		return model;
		
	}
	
	@RequestMapping(value = "/payment")
	public String makePayment(Model model, HttpSession session) {
		return "Payment";
	}
	
	@RequestMapping(value = "/receipt", method = RequestMethod.POST)
	public ModelAndView generateReceipt(@RequestParam("method")String method, ModelAndView model, HttpSession session) {
		
		String userName = (String) session.getAttribute("username");
		OrderDetail order = new OrderDetail();
		order.setOrderDate(new java.util.Date());
		order.setShippingAddress(userDAO.getUser(userName).getAddress());
		order.setTransaction(method);
		order.setUserName(userName);
		
		
		List<CartItem> listOfcartItems = cartDAO.listOfCartItems(userName);
		model.addObject("listOfCartItems", listOfcartItems);
		model.addObject("grandTotal", this.getGrandTotal(listOfcartItems));
		
		order.setTotalAmount(this.getGrandTotal(listOfcartItems));
		
		orderDAO.addOrder(order);
		orderDAO.updateCart(userName);
		
		model.addObject("orderDetail", order);
		model.setViewName("Receipt");
		return model;
	}
	
	public int getGrandTotal(List<CartItem> listOfCartItems) {
		
		int grandTotal = 0,count = 0;
		while(count < listOfCartItems.size()) {
			grandTotal = grandTotal + (listOfCartItems.get(count).getQuantity() * listOfCartItems.get(count).getPrice());
			count++;
	}
		
		return grandTotal;
	}
}

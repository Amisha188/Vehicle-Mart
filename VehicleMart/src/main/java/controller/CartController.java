package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.CartDAO;
import dao.ProductDAO;
import model.CartItem;
import model.Product;

@Controller
public class CartController {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value = "/cart")
	public String displayCart(Model model, HttpSession session) {
		
		String userName = (String)session.getAttribute("username");
		List<CartItem> listOfCartItems = cartDAO.listOfCartItems(userName);
		model.addAttribute("listOfCartItems", listOfCartItems);
		model.addAttribute("grandTotal",this.getGrandTotal(listOfCartItems));
		
		return "Cart";
	}
	
	@RequestMapping(value = "/addToCart/{productId}")
	public ModelAndView addToCart(@PathVariable("productId")int productId, @RequestParam("quantity")int quantity, HttpSession session) {
		
		Product product = productDAO.getProduct(productId);
		String userName = (String)session.getAttribute("username");
		
		CartItem cartItem = new CartItem();
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setQuantity(quantity);
		cartItem.setPrice(product.getPrice());
		cartItem.setPaymentStatus("NP");
		cartItem.setUserName(userName);
		
		cartDAO.addCartItem(cartItem);
		return new ModelAndView("redirect:/cart");
	}
	
	@RequestMapping(value = "/updateCartItem/{cartItemId}")
	public ModelAndView updateCartItem(@PathVariable("cartItemId")int cartItemId, @RequestParam("quantity")int quantity) {
		
		CartItem cartItem = cartDAO.getCartItem(cartItemId);
		cartItem.setQuantity(quantity);
		cartDAO.updateCartItem(cartItem);
		
		return new ModelAndView("redirect:/cart");
	}
	
	@RequestMapping(value = "/deleteCartItem/{cartItemId}")
	public ModelAndView deleteCartItem(@PathVariable("cartItemId")int cartItemId) {
		
		CartItem cartItem = cartDAO.getCartItem(cartItemId);
		cartDAO.deleteCartItem(cartItem);
				
		return new ModelAndView("redirect:/cart");
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

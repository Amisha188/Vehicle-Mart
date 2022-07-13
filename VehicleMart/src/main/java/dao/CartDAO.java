package dao;

import java.util.List;

import model.CartItem;

public interface CartDAO {
	
	public boolean addCartItem(CartItem cartItem);
	public boolean deleteCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	
	public List<CartItem> listOfCartItems(String userName);
	public CartItem getCartItem(int cartItemId);
}

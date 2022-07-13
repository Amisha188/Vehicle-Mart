package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.CartItem;

@Repository("CartDAO")
@Transactional
public class CartDAOImpl implements CartDAO{

	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public boolean addCartItem(CartItem cartItem) {
		
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteCartItem(CartItem cartItem) {
		
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<CartItem> listOfCartItems(String userName) {
		
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM CartItem WHERE username =: username and paymentStatus = 'NP'");
		query.setParameter("username", userName);
		List<CartItem> listOfCartItems = query.getResultList();
		session.close();
		
		return listOfCartItems;
	}

	@Override
	public CartItem getCartItem(int cartItemId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		CartItem cartItem = session.get(CartItem.class, cartItemId);
		
		session.close();
		
		return cartItem;
	}

}

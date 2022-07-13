package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.OrderDetail;

@Repository("OrderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addOrder(OrderDetail orderDetail) {
		
		try {
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCart(String userName) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("UPDATE CartItem SET paymentStatus='P' WHERE username =: username");
		query.setParameter("username", userName);
		int effectedRows = query.executeUpdate();
		
		if(effectedRows > 0)
			return true;
		else
			return false;
	}
	
}

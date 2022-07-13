package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.CartItem;
import model.Product;
import model.UserDetail;

@Repository("UserDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean registerUser(UserDetail user) {
		// TODO Auto-generated method stub
		try {
			
			sessionFactory.getCurrentSession().save(user);
			return true;
			
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean updateUserDetail(UserDetail user) {
		// TODO Auto-generated method stub
		try {
			
			sessionFactory.getCurrentSession().update(user);
			return true;
			
		}catch(Exception ex) {
			return false;
		}
	}
	
	@Override
	public boolean deleteUserDetail(UserDetail user) {
		try {
			
			sessionFactory.getCurrentSession().delete(user);
			return true;
			
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public UserDetail getUser(String userName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		UserDetail userDetail = (UserDetail)session.get(UserDetail.class, userName);
		session.close();
		return userDetail;
	}

	@Override
	public UserDetail validateUser(String userName, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM UserDetail WHERE username =: username and password =: password");
		query.setParameter("username", userName);
		query.setParameter("password", password);
	    UserDetail user = (UserDetail) query.getSingleResult();

	    return user;
	}

	
	
}

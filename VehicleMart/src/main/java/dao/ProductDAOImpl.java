package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addProduct(Product product) {
		
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public List<Product> listOfProducts() {
		
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> listOfProducts = query.list();
		session.close();
		return listOfProducts;
	}

	@Override
	public Product getProduct(int productId) {
		
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Product product = (Product)session.get(Product.class, productId);
		session.close();
		return product;
	}

}

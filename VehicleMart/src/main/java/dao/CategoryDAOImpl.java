package dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Category;

@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<Category> listOfCategories() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Category");
		List<Category> listOfCategories = query.list();
		session.close();
		return listOfCategories;
	}

	@Override
	public Category getCategory(int categoryId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Category category = (Category)session.get(Category.class, categoryId);
		session.close();
		return category;
	}


}

package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.Category;

public interface CategoryDAO {
	
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	
	public List<Category> listOfCategories();
	public Category getCategory(int categoryId);
}

package dao;

import java.util.List;

import model.Product;

public interface ProductDAO{
	
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	
	public List<Product> listOfProducts();
	public Product getProduct(int productId); 
}

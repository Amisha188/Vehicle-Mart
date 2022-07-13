package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

@Controller
public class productController {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/product")
	public ModelAndView displayProduct(ModelAndView model) {
		
		Product product = new Product();
		model.addObject("product", product);
		
		List<Product> listOfProduct = productDAO.listOfProducts();
		model.addObject("listOfProduct", listOfProduct);

		model.addObject("categoryList", this.getCategories());
		
		model.setViewName("Product");
		return model;
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product")Product product, @RequestParam("pimage") MultipartFile filedet, ModelAndView model) {
		
		productDAO.addProduct(product);
		String imagePath = "C:\\Users\\amisha\\OneDrive\\Documents\\Ecommerce website\\VehicleMart\\src\\main\\webapp\\images\\";
		imagePath = imagePath+ String.valueOf(product.getProductId()+".jpg");
		
		File image = new File(imagePath);
		if(!filedet.isEmpty()) {
			try {
				
				byte buff[] = filedet.getBytes();
				FileOutputStream fos = new FileOutputStream(image);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(buff);
				bs.close();
				
			}catch(Exception ex) {
				model.addObject("errorInfo", "Exception occured during inage uploading :"+ex.getMessage());
			}
		}
		else
			model.addObject("errorInfo", "Problem occured during image uploading");
		
		return new ModelAndView("redirect:/product");
	}
	
	
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute("product")Product product) {
		
		productDAO.updateProduct(product);
		return new ModelAndView("redirect:/product");
	}
	
	@RequestMapping(value = "/editProduct/{productId}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable("productId")int productId, ModelAndView model) {
		
		Product product = productDAO.getProduct(productId);
		model.addObject("product", product);
		
		model.addObject("categoryList", this.getCategories());
		
		model.setViewName("UpdateProduct");
		return model;
	}
	
	@RequestMapping(value = "/deleteProduct/{productId}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable("productId")int productId) {
		
		Product product = productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		return new ModelAndView("redirect:/product");
	}
	
	@RequestMapping(value="/productDisplay")
	public ModelAndView displayAllProduct(ModelAndView model) {
		
		model.addObject("pageinfo", "Product Catalog");
		List<Product> listOfProduct = productDAO.listOfProducts();
		model.addObject("listOfProduct", listOfProduct);
		
		model.setViewName("ProductDisplay");

		return model;
	}
	
	@RequestMapping(value="/detailedProductDisplay/{productId}")
	public ModelAndView detailedProductDisplay(ModelAndView model, @PathVariable("productId")int productId) {
			
			model.addObject("pageinfo", "Product Info");

			Product product = productDAO.getProduct(productId);
			model.addObject("product", product);
			
			model.setViewName("DetailedProductDisplay");
	
			return model;
	}
	
	
	public LinkedHashMap<Integer, String> getCategories(){
		
		List<Category> listOfCategories = categoryDAO.listOfCategories();
		LinkedHashMap<Integer, String> categoryList = new LinkedHashMap<Integer, String>();
		for(Category category:listOfCategories) {
			
			categoryList.put(category.getCategoryId(), category.getCategoryName());
		}
		
		return categoryList;
	}
}

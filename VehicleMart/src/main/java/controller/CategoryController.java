package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.CategoryDAO;
import model.Category;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = "/category")
	public ModelAndView displayCategory(ModelAndView model) {
		
		List<Category> listOfCategory = categoryDAO.listOfCategories();
		model.addObject("listOfCategories", listOfCategory);
		model.setViewName("Category");
 		return model;
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public ModelAndView addCategory(@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc) {
		
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDescri(categoryDesc);
		
		categoryDAO.addCategory(category);
		
		return new ModelAndView("redirect:/category");
	}
	
	@RequestMapping(value = "/editCategory/{categoryId}", method = RequestMethod.GET)
	public ModelAndView editCategory(ModelAndView model,@PathVariable("categoryId")int categoryId) {
		
		Category category = categoryDAO.getCategory(categoryId);
		model.addObject("category", category);
		model.setViewName("UpdateCategory");
		return model;
	}
	
	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public ModelAndView updateCategory(@RequestParam("categoryId")int categoryId,@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc) {
		
		Category category = categoryDAO.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDescri(categoryDesc);
		
		categoryDAO.updateCategory(category);
		
		return new ModelAndView("redirect:/category");
	}
	
	@RequestMapping(value = "/deleteCategory/{categoryId}", method = RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable("categoryId")int categoryId) {
		
		Category category = categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		
		return new ModelAndView("redirect:/category");
	}
}

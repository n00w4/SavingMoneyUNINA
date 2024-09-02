package oo.smu.Controller;

import java.sql.SQLException;
import java.util.List;

import oo.smu.Entity.Category;
import oo.smu.DAO.CategoryDAO;

public class CategoryController {
	private CategoryDAO categoryDAO;
	
	public CategoryController(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	public boolean saveCategory(Category category) throws SQLException {
		return categoryDAO.insert(category);
	}
	
	public boolean updateCategory(Category category) throws SQLException {
		return categoryDAO.update(category);
	}
	
	public boolean deleteCategory(Category category) throws SQLException {
		return categoryDAO.delete(category);
	}
	
	public List<String> findAllCategoryNames() throws SQLException {
		return categoryDAO.findAllCategoryNames();
	}
	
	public String findCategoryKeywordByName(String keyword) throws SQLException {
		return categoryDAO.findCategoryKeywordByName(keyword);
	}
}

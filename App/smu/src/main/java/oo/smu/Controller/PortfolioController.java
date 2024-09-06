package oo.smu.Controller;

import java.sql.SQLException;

import oo.smu.Entity.Portfolio;
import oo.smu.Entity.User;
import oo.smu.Entity.Family;
import oo.smu.Entity.Category;
import oo.smu.DAO.PortfolioDAO;

public class PortfolioController {
	private PortfolioDAO portfolioDAO;
	
	public PortfolioController(PortfolioDAO portfolioDAO) {
		this.portfolioDAO = portfolioDAO;
	}
	
	public boolean saveUserPortfolio(Portfolio portfolio, User user, Category category) throws SQLException {
		return portfolioDAO.insertUserPortfolio(portfolio, user, category);
	}
	
	public boolean saveFamilyPortfolio(Portfolio portfolio, Family family, Category category) throws SQLException {
		return portfolioDAO.insertFamilyPortfolio(portfolio, family, category);
	}
	
	public boolean deleteUserPortfolio(Portfolio portfolio, User user, Category category) throws SQLException {
		return portfolioDAO.deleteUserPortfolio(portfolio, user, category);
	}
	
	public boolean deleteFamilyPortfolio(Portfolio portfolio, Family family, Category category) throws SQLException {
		return portfolioDAO.deleteFamilyPortfolio(portfolio, family, category);
	}
	
	public Portfolio findUserPortfolioByName(String name, User user) throws SQLException {
		return portfolioDAO.findUserPortfolioByName(name, user);
	}
}

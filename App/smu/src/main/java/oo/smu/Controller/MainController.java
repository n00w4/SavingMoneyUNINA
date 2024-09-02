package oo.smu.Controller;


import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import oo.smu.DAO.*;
import oo.smu.DAO.PgSQLImp.*;
import oo.smu.Database.PgSQL;
import oo.smu.Entity.Card;
import oo.smu.Entity.Expense;
import oo.smu.Entity.Income;
import oo.smu.Entity.Portfolio;
import oo.smu.Entity.User;
import oo.smu.GUI.*;

public class MainController {
	private UserController userController;
	private CardController cardController;
	private PortfolioController portfolioController;
	private TransactionController transactionController;
	private CategoryController categoryController;

    public MainController() {
    	try {
    		// Inizio connessione
    		Connection dbConnection = PgSQL.getConnection();
    		// Inizializzazione DAO
    		UserDAO userDAO = new PgUserDAO(dbConnection);
    		TransactionDAO transactionDAO = new PgTransactionDAO(dbConnection);
    		CardDAO cardDAO = new PgCardDAO(dbConnection);
    		PortfolioDAO portfolioDAO = new PgPortfolioDAO(dbConnection);
    		CategoryDAO categoryDAO = new PgCategoryDAO(dbConnection);
    		// Inizializzazione Controller
    		this.userController = new UserController(userDAO);
    		this.transactionController = new TransactionController(transactionDAO);
    		this.cardController = new CardController(cardDAO);
    		this.portfolioController = new PortfolioController(portfolioDAO);
    		this.categoryController = new CategoryController(categoryDAO);
    	} catch (SQLException e) { e.printStackTrace(); }
    }

    public void showLoginFrame() {
    	// Inizializzazione LoginFrame
		LoginFrame loginFrame = new LoginFrame(this);
		loginFrame.setVisible(true);
    }
    
    public User tryLogin(String username, String password) throws SQLException {
    	return userController.login(username, password);
    }
    
    public void showDashboardFrame(User user) {
    	DashboardFrame dashboardFrame = new DashboardFrame(this, user);
    	dashboardFrame.setVisible(true);
    }
    
    public boolean saveIncome(Income income, Card card, Portfolio portfolio) throws SQLException {
    	return transactionController.saveIncome(income, card, portfolio);
    }
    
    public boolean saveExpense(Expense expense, Card card, Portfolio portfolio) throws SQLException {
    	return transactionController.saveExpense(expense, card, portfolio);
    }
    
    public Card findCardByCardNumber(String cardNumber) throws SQLException {
    	return cardController.findCardByCardNumber(cardNumber);
    }
    
    public Portfolio findUserPortfolioByName(String name, User user) throws SQLException {
    	return portfolioController.findUserPortfolioByName(name, user);
    }
    
    public List<String> findAllCardNumbersFromTaxCode(String taxCode) throws SQLException {
    	return cardController.findAllCardNumbersFromTaxCode(taxCode);
    }
    
    public List<String> findAllCategoryNames() throws SQLException {
    	return categoryController.findAllCategoryNames();
    }
    
    public List<Income> findIncomeByDateCardCategory(LocalDateTime dateA, LocalDateTime dateB, String cardNumber, String keyword, String taxCode) throws SQLException {
		return transactionController.findIncomeByDateCardCategory(dateA, dateB, cardNumber, keyword, taxCode);
	}
    
    public List<Expense> findExpenseByDateCardCategory(LocalDateTime dateA, LocalDateTime dateB, String cardNumber, String keyword, String taxCode) throws SQLException {
		return transactionController.findExpenseByDateCardCategory(dateA, dateB, cardNumber, keyword, taxCode);
	}
    
    public String findCategoryKeywordByName(String keyword) throws SQLException {
    	return categoryController.findCategoryKeywordByName(keyword);
    }
    
    public void start() {
    	showLoginFrame();
    }
}

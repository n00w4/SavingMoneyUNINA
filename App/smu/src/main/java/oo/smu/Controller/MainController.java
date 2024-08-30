package oo.smu.Controller;


import java.sql.Connection;
import java.sql.SQLException;

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

    public MainController() {
    	try {
    		// Inizio connessione
    		Connection dbConnection = PgSQL.getConnection();
    		// Inizializzazione DAO
    		UserDAO userDAO = new PgUserDAO(dbConnection);
    		TransactionDAO transactionDAO = new PgTransactionDAO(dbConnection);
    		CardDAO cardDAO = new PgCardDAO(dbConnection);
    		PortfolioDAO portfolioDAO = new PgPortfolioDAO(dbConnection);
    		// Inizializzazione Controller
    		this.userController = new UserController(userDAO);
    		this.transactionController = new TransactionController(transactionDAO);
    		this.cardController = new CardController(cardDAO);
    		this.portfolioController = new PortfolioController(portfolioDAO);
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
    
    public void start() {
    	showLoginFrame();
    }
}

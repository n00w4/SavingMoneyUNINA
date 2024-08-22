package oo.smu.Controller;


import java.sql.Connection;
import java.sql.SQLException;

import oo.smu.DAO.*;
import oo.smu.DAO.PgSQLImp.*;
import oo.smu.Database.PgSQL;
import oo.smu.GUI.*;

public class MainController {
	private UserController userController;

    public MainController() {
    	try {
    		// Inizio connessione
    		Connection dbConnection = PgSQL.getConnection();
    		// Inizializzazione DAO User
    		UserDAO userDAO = new PgUserDAO(dbConnection);
    		// Inizializzazione Controller User
    		this.userController = new UserController(userDAO);
    	} catch (SQLException e) { e.printStackTrace(); }
    }

    public void showLoginFrame() {
    	// Inizializzazione LoginFrame
		LoginFrame loginFrame = new LoginFrame(this);
		loginFrame.setVisible(true);
    }
    
    public boolean tryLogin(String username, String password) throws SQLException {
    	return userController.login(username, password);
    }
    
    public void showDashboardFrame() {
    	DashboardFrame dashboardFrame = new DashboardFrame(this);
    	dashboardFrame.setVisible(true);
    }
    
    public void start() {
    	showLoginFrame();
    }
}

package oo.smu.Controller;

import java.sql.SQLException;

import oo.smu.Entity.User;
import oo.smu.DAO.UserDAO;

public class UserController {
	private UserDAO userDAO;
	
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public boolean saveUser(User user) throws SQLException {
		return userDAO.insert(user);
	}
	
	public boolean updateUserPassword(User user) throws SQLException {
		return userDAO.updatePassword(user);
	}
	
	public boolean deleteUser(User user) throws SQLException {
		return userDAO.delete(user);
	}
	
	public boolean login(String username, String password) throws SQLException {
		User user = userDAO.findByUsername(username);
		return user != null && user.getPassword().equals(password);
	}
}

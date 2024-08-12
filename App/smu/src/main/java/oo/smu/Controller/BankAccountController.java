package oo.smu.Controller;

import java.sql.SQLException;

import oo.smu.Entity.BankAccount;
import oo.smu.Entity.User;
import oo.smu.DAO.BankAccountDAO;

public class BankAccountController {
	private BankAccountDAO bankAccountDAO;
	
	public BankAccountController(BankAccountDAO bankAccountDAO) {
		this.bankAccountDAO = bankAccountDAO;
	}
	
	public boolean saveBankAccount(BankAccount bankAccount, User user) throws SQLException {
		return bankAccountDAO.insert(bankAccount, user);
	}
	
	public boolean deleteBankAccount(BankAccount bankAccount, User user) throws SQLException {
		return bankAccountDAO.delete(bankAccount, user);
	}
}

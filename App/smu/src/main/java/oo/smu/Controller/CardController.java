package oo.smu.Controller;

import java.sql.SQLException;
import java.util.List;

import oo.smu.Entity.Card;
import oo.smu.Entity.DebitCard;
import oo.smu.Entity.CreditCard;
import oo.smu.Entity.BankAccount;
import oo.smu.DAO.CardDAO;

public class CardController {
	private CardDAO cardDAO;
	
	public CardController(CardDAO cardDAO) {
		this.cardDAO = cardDAO;
	}
	
	public boolean saveDebitCard(DebitCard debitCard, BankAccount bankAccount) throws SQLException {
		return cardDAO.insertDebitCard(debitCard, bankAccount);
	}
	
	public boolean saveCreditCard(CreditCard creditCard, BankAccount bankAccount) throws SQLException {
		return cardDAO.insertCreditCard(creditCard, bankAccount);
	}
	
	public boolean updateDebitCard(DebitCard debitCard) throws SQLException {
		return cardDAO.updateDebitCard(debitCard);
	}
	
	public boolean updateCreditCard(CreditCard creditCard) throws SQLException {
		return cardDAO.updateCreditCard(creditCard);
	}
	
	public boolean deleteCard(Card card, BankAccount bankAccount) throws SQLException {
		return cardDAO.deleteCard(card, bankAccount);
	}
	
	public Card findCardByCardNumber(String cardNumber) throws SQLException {
		return cardDAO.findByCardNumber(cardNumber);
	}
	
	public List<String> findAllCardNumbersFromTaxCode(String taxCode) throws SQLException {
		return cardDAO.findAllCardNumbersFromTaxCode(taxCode);
	}
}

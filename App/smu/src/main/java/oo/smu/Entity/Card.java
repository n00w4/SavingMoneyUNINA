package oo.smu.Entity;

import java.time.LocalDate;

public class Card {
	private String cardNumber;
	private String cvv;
	private LocalDate expirationDate;
	private String ibanCard;
	private float balanceCard;
	private String ibanBankAccount;
	
	// Costruttore
	public Card(String cardNumber, String cvv, LocalDate expirationDate, String ibanCard, float balance, String ibanBankAccount) {
		this.setCardNumber(cardNumber);
		this.setCvv(cvv);
		this.setExpirationDate(expirationDate);
		this.setIbanCard(ibanCard);
		this.setBalanceCard(balance);
		this.setIbanBankAccount(ibanBankAccount);
	}
	
	/* GETTER e SETTER */
	public String getCardNumber() { return cardNumber; }
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getCvv() { return cvv; }
	
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	public String getIbanCard() { return ibanCard; }
	
	public void setIbanCard(String ibanCard) {
		this.ibanCard = ibanCard;
	}
	
	public LocalDate getExpirationDate() { return expirationDate; }
	
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public float getBalanceCard() { return balanceCard; }
	
	public void setBalanceCard(float balance) {
		this.balanceCard = balance;
	}

	public String getIbanBankAccount() { return ibanBankAccount; }

	public void setIbanBankAccount(String ibanBankAccount) {
		this.ibanBankAccount = ibanBankAccount;
	}
}

package oo.smu.Entity;

import java.time.LocalDate;

public class Card {
	private String cardNumber;
	private String cvv;
	private LocalDate expirationDate;
	private String ibanCard;
	private float balance;
	
	// Costruttore
	public Card(String cardNumber, String cvv, LocalDate expirationDate, String ibanCard, float balance) {
		this.setCardNumber(cardNumber);
		this.setCvv(cvv);
		this.setExpirationDate(expirationDate);
		this.setIbanCard(ibanCard);
		this.setBalance(balance);
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
	
	public float getBalance() { return balance; }
	
	public void setBalance(float balance) {
		this.balance = balance;
	}
}

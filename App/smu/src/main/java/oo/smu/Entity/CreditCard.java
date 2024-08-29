package oo.smu.Entity;

import java.time.LocalDate;

public class CreditCard extends Card {
	private float plafond;
	
	// Costruttore
	public CreditCard(String cardNumber, String cvv, LocalDate expirationDate, String ibanCard, float balance, float plafond, String ibanBankAccount) {
		super(cardNumber, cvv, expirationDate, ibanCard, balance, ibanBankAccount);
		this.setPlafond(plafond);
	}
	
	/* GETTER e SETTER */
	public float getPlafond() { return plafond; }

	public void setPlafond(float plafond) {
		this.plafond = plafond;
	}

}

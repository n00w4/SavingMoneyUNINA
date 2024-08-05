package oo.smu.Entity;

import java.time.LocalDate;

public class DebitCard extends Card {
	
	// Costruttore
	public DebitCard(String cardNumber, String cvv, LocalDate expirationDate, String ibanCard, float balance) {
		super(cardNumber, cvv, expirationDate, ibanCard, balance);
	}
	
}

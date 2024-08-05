package oo.smu.Entity;

import java.time.LocalDateTime;

public class Transaction {
	private float amount;
	private LocalDateTime dateTime;
	private String description;
	
	// Costruttore
	public Transaction(float amount, LocalDateTime dateTime, String description) {
		this.setAmount(amount);
		this.setDateTime(dateTime);
		this.setDescription(description);
	}
	
	/* GETTER e SETTER */
	public float getAmount() { return amount; }

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public LocalDateTime getDateTime() { return dateTime; }

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getDescription() { return description; }

	public void setDescription(String description) {
		this.description = description;
	}
	
}

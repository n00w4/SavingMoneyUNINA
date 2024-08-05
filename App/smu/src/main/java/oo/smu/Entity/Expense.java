package oo.smu.Entity;

import java.time.LocalDateTime;

public class Expense extends Transaction {
	private String receiver;
	
	// Costruttore
	public Expense(float amount, LocalDateTime dateTime, String description, String receiver) {
		super(amount, dateTime, description);
		this.setReceiver(receiver);
	}
	
	/* GETTER e SETTER */
	public String getReceiver() { return receiver; }
	
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

}

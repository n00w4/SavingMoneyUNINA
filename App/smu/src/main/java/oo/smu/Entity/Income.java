package oo.smu.Entity;

import java.time.LocalDateTime;

public class Income extends Transaction {
	private String sender;

	// Costruttore
	public Income(float amount, LocalDateTime dateTime, String description, String sender) {
		super(amount, dateTime, description);
		this.setSender(sender);
	}

	/* GETTER e SETTER */
	public String getSender() { return sender; }

	public void setSender(String sender) {
		this.sender = sender;
	}

}

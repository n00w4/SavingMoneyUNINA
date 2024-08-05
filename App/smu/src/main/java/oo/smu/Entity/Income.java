package oo.smu.Entity;

import java.time.LocalDateTime;

public class Income extends Transaction {
	private String source;

	// Costruttore
	public Income(float amount, LocalDateTime dateTime, String description, String source) {
		super(amount, dateTime, description);
		this.setSource(source);
	}

	/* GETTER e SETTER */
	public String getSource() { return source; }

	public void setSource(String source) {
		this.source = source;
	}

}

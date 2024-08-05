package oo.smu.Entity;

import java.time.LocalDate;

public class User {
	private String firstName;
	private String secondName;
	private String username;
	private String password;
	private String taxCode;
	private LocalDate birthDate;
	
	
	// Costruttore
	public User(String firstName, String secondName, String username, String password, String taxCode, LocalDate birthDate) {
		this.setFirstName(firstName);
		this.setSecondName(secondName);
		this.setUsername(username);
		this.setPassword(password);
		this.setTaxCode(taxCode);
		this.setBirthDate(birthDate);
	}
	
	
	
	/* GETTER e SETTER */
	public String getFirstName() { return firstName; }
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSecondName() { return secondName; }
	
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getUsername() { return username; }

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() { return password; }

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTaxCode() { return taxCode; }

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public LocalDate getBirthDate() { return birthDate; }

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	
}

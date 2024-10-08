package oo.smu.Entity;

import java.time.LocalDate;

public class User {
	private String firstName;
	private String secondName;
	private String username;
	private String password;
	private String email;
	private String taxCode;
	private LocalDate birthDate;
	private int idFamily;
	
	// Costruttore
	public User(String firstName, String secondName, String username, String password, String email, String taxCode, LocalDate birthDate, int idFamily) {
		this.setFirstName(firstName);
		this.setSecondName(secondName);
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setTaxCode(taxCode);
		this.setBirthDate(birthDate);
		this.setIdFamily(idFamily);
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

	public String getEmail() { return email; }
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTaxCode() { return taxCode; }

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public LocalDate getBirthDate() { return birthDate; }

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public int getIdFamily() { return idFamily; }

	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
	}
	
	
}

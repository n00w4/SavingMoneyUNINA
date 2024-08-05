package oo.smu.Entity;

public class BankAccount {
	private String bankName;
	private String ibanBankAccount;
	private float balance;
	
	// Costruttore
	public BankAccount(String bankName, String ibanBankAccount, float balance) {
		this.setBankName(bankName);
		this.setIbanBankAccount(ibanBankAccount);
		this.setBalance(balance);
	}
	
	/* GETTER e SETTER */
	public String getBankName() { return bankName; }
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIbanBankAccount() { return ibanBankAccount; }

	public void setIbanBankAccount(String ibanBankAccount) {
		this.ibanBankAccount = ibanBankAccount;
	}

	
	public float getBalance() { return balance; }

	
	public void setBalance(float balance) {
		this.balance = balance;
	}
}

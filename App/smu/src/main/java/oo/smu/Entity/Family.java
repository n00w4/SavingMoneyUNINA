package oo.smu.Entity;

public class Family {
	private String familyName;

	// Costruttore
	public Family(String familyName) {
		this.setFamilyName(familyName);
	}
	
	/* GETTER e SETTER */
	public String getFamilyName() { return familyName; }

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
}

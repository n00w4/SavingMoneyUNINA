package oo.smu.Entity;

public class Family {
	private int id;
	private String familyName;

	// Costruttore
	public Family(String familyName) {
		this.setFamilyName(familyName);
	}
	
	/* GETTER e SETTER */
	public int getId() { return id; }

	public void setId(int id) {
		this.id = id;
	}

	public String getFamilyName() { return familyName; }

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
}

package oo.smu.Entity;

public class Portfolio {
	private String name;
	private String description;
	
	// Costruttore
	public Portfolio(String name, String description) {
		this.setName(name);
		this.setDescription(description);
	}
	
	/* GETTER e SETTER */
	public String getName() { return name; }
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() { return description; }

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

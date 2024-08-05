package oo.smu.Entity;

public class Category {
	private String name;
	private String keyword;
	
	// Costruttore
	public Category(String name, String keyword) {
		this.setName(name);
		this.setKeyword(keyword);
	}
	
	/* GETTER e SETTER */
	public String getName() { return name; }
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getKeyword() { return keyword; }
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}

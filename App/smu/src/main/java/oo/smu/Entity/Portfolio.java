package oo.smu.Entity;

public class Portfolio {
	private int id;
	private String name;
	private String description;
	private String taxCode;
	private Integer idFamily;
	private String keyword;
	
	// Costruttore
	public Portfolio(int id, String name, String description, String taxCode, Integer idFamily, String keyword) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		this.setTaxCode(taxCode);
		this.setIdFamily(idFamily);
		this.setKeyword(keyword);
	}
	
	/* GETTER e SETTER */
	public int getId() { return id; }

	public void setId(int id) {
		this.id = id;
	}

	public String getName() { return name; }
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() { return description; }

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTaxCode() { return taxCode; }

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public int getIdFamily() { return idFamily; }

	public void setIdFamily(Integer idFamily) {
		this.idFamily = idFamily;
	}

	public String getKeyword() { return keyword; }

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}

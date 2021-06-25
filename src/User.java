
 class User {
	private String ITEM;
	private Double SINGLE;
	private Double PACK;
	private int STOCK;
	
	public User(String ITEM, Double SINGLE, Double PACK, int STOCK) {
		
		this.ITEM = ITEM;
		this.SINGLE = SINGLE;
		this.PACK = PACK;
		this.STOCK = STOCK;
	}
	
	public String getITEM() {
		return ITEM;
	}
	
	public Double getSINGLE() {
		return SINGLE;
	}
	
	
	public Double getPACK() {
		return PACK;
	}
	
	public int getSTOCK() {
		return STOCK;
	}
	
}

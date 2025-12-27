package Tech_Store_Pack;


public abstract class Item {
	private String id;
	private String typeName;
	private String Company_made;
	private double price;
	static int staticcounter=100;
	
	
	public Item() {
		super();
	}
	public Item(int counter) {
		super();
		staticcounter=counter;
	}

	public Item( String company_made, String typeName,double price) {
		this.price=price;
		this.typeName=typeName;
		this.id ="Item_"+staticcounter;
		Company_made = company_made;
		
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public String getId() {
		return id;
	}

	public void setId() {
		staticcounter++;
		this.id ="Item_"+staticcounter;
		
	}

	public String getCompany_made() {
		return Company_made;
	}

	public void setCompany_made(String company_made) {
		Company_made = company_made;
	}

		@Override
	public String toString() {
		return "[id]=" + id + ", [typeName]=" + typeName + ", [Company_made]=" + Company_made + ", [price]=" + price;
	}
		
		public boolean equal(Object o) {
			Item item=(Item)o;
			System.out.println("boolean equal : "+this.getId().equals(item.getId()));
			return this.getId().equals(item.getId());
		}

}

package Tech_Store_Pack;

public class Laptop extends Item {
	private String DisplayScreen;
	private int RAM;
	private int Storage;
	
	
	
	public Laptop() {
		super();
	}

	public Laptop(String id, String company_made,String typeName,double price,
			String displayScreen,int rAM,int Storage) {
		super(company_made,typeName,price);
		DisplayScreen = displayScreen;
		RAM = rAM;
		this.Storage=Storage;
	}

	public String getDisplayScreen() {
		return DisplayScreen;
	}

	public void setDisplayScreen(String displayScreen) {
		DisplayScreen = displayScreen;
	}

	public int getRAM() {
		return RAM;
	}

	public void setRAM(int rAM) {
		RAM = rAM;
	}

	public int getStorage() {
		return Storage;
	}

	public void setStorage(int storage) {
		Storage = storage;
	}

	@Override
	public String toString() {
		return super.toString()+" , "+"[Display Screen]=" + DisplayScreen + ",[RAM] =" + RAM + ", [Storage] =" + Storage ;
	}
	
	
	

	
	

}

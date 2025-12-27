package Tech_Store_Pack;


public class Phone extends Item {
	private String OperatingSystem;
	private String CameraResoultion;
	
	public Phone() {
		super();
	}
	public Phone(int counter) {
		super(counter);
	}
	
	
	public Phone( String company_made, String typeName,double price,
			String operatingSystem,String cameraResoultion) {
		super( company_made,typeName,price);
		OperatingSystem = operatingSystem;
		CameraResoultion = cameraResoultion;
	}
	
	public String getOperatingSystem() {
		return OperatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		OperatingSystem = operatingSystem;
	}
	
	public String getCameraResoultion() {
		return CameraResoultion;
	}
	public void setCameraResoultion(String cameraResoultion) {
		CameraResoultion = cameraResoultion;
	}

	@Override
	public String toString() {
		return super.toString()+" , "+"[Operating System]=" + OperatingSystem +
				 ", [Camera Resoultion]= " + CameraResoultion ;
	}


	
	
	

}

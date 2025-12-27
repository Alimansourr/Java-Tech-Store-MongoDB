package Tech_Store_Pack;
import java.util.ArrayList;

public class Television extends Item{
	ArrayList<String> IOports=new ArrayList<String>();
	
	public Television() {
		super();
	}
	public Television( String company_made, String typeName,double price,
			ArrayList<String> iOports) {
		super( company_made, typeName,price);
		IOports = iOports;
	}


	public ArrayList<String> getIOports() {
		return IOports;
	}
	public void setIOports(ArrayList<String> iOports) {
		IOports = iOports;
	}
	@Override
	public String toString() {
		return super.toString()+" , "  + ", [Input and Output ports] =" + IOports.toString() ;
	}

	
	

}

package Tech_Store_Pack;

import java.util.ArrayList;
import java.util.Scanner;

public class Insert_Info {
	Scanner sc=new Scanner(System.in);
	Scanner st=new Scanner(System.in);
	String string;
	public Phone Phone_Info() {
			try {
				Phone phone=new Phone();
				phone.setId();
				System.out.println("TYPE_NAME[STRING]");
				string=st.nextLine();
				phone.setTypeName(string);
				System.out.println("COMPANY_MADE[STRING]");
				phone.setCompany_made(st.nextLine());
				System.out.println("PRICE [DOUBLE]:");
				phone.setPrice(sc.nextDouble());
				System.out.println("OPERATING_SYSTEM [STRING]");
				phone.setOperatingSystem(st.nextLine());
				System.out.println("CAMERA_RESOLUTION [STRING]");
				phone.setCameraResoultion(st.nextLine());
				return phone;
			}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Television TV_Info() {
		try {
			Television TV=new Television();
			TV.setId();
			System.out.println("TYPE_NAME[STRING]");
			string=st.nextLine();
			TV.setTypeName(string);
			System.out.println("COMPANY_MADE[STRING]");
			TV.setCompany_made(st.nextLine());
			System.out.println("PRICE [DOUBLE]:");
			TV.setPrice(sc.nextDouble());
			System.out.println("Enter the main Input and Output ports and when you finish type exit ");
			ArrayList<String>ports=new ArrayList<String>();
			while(true) {
				string=st.nextLine();
				if(string.equalsIgnoreCase("exit")) {
					break;
				}
				ports.add(string);

			}
			TV.setIOports(ports);
			return TV;
		}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return null;
	}
	
	
	public Laptop Laptop_Info() {
		try {
			Laptop laptop=new Laptop();
			laptop.setId();
			System.out.println("TYPE_NAME[STRING]");
			string=st.nextLine();
			laptop.setTypeName(string);//Laptop.setTypeName("Laptop : "+string);
			System.out.println("COMPANY_MADE[STRING]");
			laptop.setCompany_made(st.nextLine());
			System.out.println("PRICE [DOUBLE]:");
			laptop.setPrice(sc.nextDouble());
			System.out.println("SCREEN_RESOLUTION [STRING]");
			laptop.setDisplayScreen(st.nextLine());
			System.out.println("RAM_IN_GIGABYTE[INTEGER]");
			laptop.setRAM(sc.nextInt());
			System.out.println("STORAGE [INTEGER]");
			laptop.setStorage(sc.nextInt());
			return laptop;
		}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return null;
}
	public boolean YesOrNo() {
		String str;
		while(true) {
			str=st.nextLine();
		if(str.equalsIgnoreCase("no")) {
			return false;
		}
		else if(str.equalsIgnoreCase("yes")) {
			return true;
		}
		else {
			System.out.println("Please enter 'Yes' or 'No'");
		}
		}
		
	}
	

	public Phone Phone_Modify(Phone PHONE) {
		Phone phone=PHONE;
		try {
			
			System.out.println("Do You want to change the type name  ?");
			if(YesOrNo()) {
				System.out.println("Enter TYPE_NAME[STRING] : ");
				string=st.nextLine();
				phone.setTypeName(string);//phone.setTypeName("Phone : "+string);
			}
				
			System.out.println("Do You want to change the company name  ?");
			if(YesOrNo()) {
				System.out.println("Enter COMPANY_MADE[STRING]: ");
				phone.setCompany_made(st.nextLine());
			}
			
			System.out.println("Do You want to change the price  ? ");
			if(YesOrNo()) {
				System.out.println("Enter PRICE [DOUBLE]: : ");
				phone.setPrice(sc.nextDouble());
			}
				
			System.out.println("Do You want to change the Operating System ? ");
			if(YesOrNo()) {
				System.out.println("Enter OPERATING_SYSTEM [STRING]: ");
				phone.setOperatingSystem(st.nextLine());
			}
				
			System.out.println("Do You want to change the Camera Resolution ?");
			if(YesOrNo()) {
				System.out.println("Enter CAMERA_RESOLUTION [STRING] : ");
				phone.setCameraResoultion(st.nextLine());
			}
			return phone;
			
		}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return null;
}

	public Television TV_Modify(Television TV) {
		Television telev=TV;
		try {
			
			System.out.println("Do You want to change the type name  ?");
			if(YesOrNo()) {
				System.out.println("Enter TYPE_NAME[STRING] : ");
				string=st.nextLine();
				telev.setTypeName(string);
			
			}
					
			System.out.println("Do You want to change the company name  ?");
			if(YesOrNo()) {
				System.out.println("Enter COMPANY_MADE[STRING]: ");
				telev.setCompany_made(st.nextLine());
			}				
			
			System.out.println("Do You want to change the price  ? ");
			if(YesOrNo()) {
				System.out.println("Enter PRICE [DOUBLE]:  ");
				telev.setPrice(sc.nextDouble());
			}
			
			System.out.println("Do You want to enter new ports For the TV  ? ");
			if(YesOrNo()) {
				System.out.println("Enter the new ports : ");
				while(true) {
					string=st.nextLine();
					if(string.equalsIgnoreCase("exit")) {
						break;
					}
					telev.IOports.add(string);
				}
			}
				
			return telev;
			
		}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return null;
}
	
	
	public Laptop Laptop_Modify(Laptop LAPTOP) {
		Laptop laptop=LAPTOP;
		try {
			
			System.out.println("Do You want to change the type name  ?");
			if(YesOrNo()) {
				System.out.println("Enter TYPE_NAME[STRING] : ");
				string=st.nextLine();
				laptop.setTypeName(string);
			}
					
			System.out.println("Do You want to change the company name  ?");
			if(YesOrNo()) {
				System.out.println("Enter COMPANY_MADE[STRING]: ");
				laptop.setCompany_made(st.nextLine());
			}				
			
			System.out.println("Do You want to change the price  ? ");
			if(YesOrNo()) {
				System.out.println("Enter PRICE [DOUBLE]:");
				laptop.setPrice(sc.nextDouble());
			}
			
			System.out.println("Do You want to change the Screen Display  ? ");
			if(YesOrNo()) {
				System.out.println("Enter SCREEN_DISPLAY [STRING] : ");
				laptop.setDisplayScreen(st.nextLine());
			}
			
			System.out.println("Do You want to change the RAM Capacity ?");
			if(YesOrNo()) {
				System.out.println("Enter RAM_IN_GIGABYTE[INTEGER] : ");
				laptop.setRAM(sc.nextInt());
			}
			
			System.out.println("Do You want to change the Storage ?");
			if(YesOrNo()) {
				System.out.println("Enter STORAGE [INTEGER] : ");
				laptop.setStorage(sc.nextInt());
			}
				
			return laptop;
		}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return null;
}
	
	
	public  String SearchedWord() {
		
		System.out.println("Type here the type name or the company made to search for the item ");
		string=st.nextLine();
		return string;
	}
	

}

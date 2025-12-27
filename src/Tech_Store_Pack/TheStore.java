package Tech_Store_Pack;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.text.similarity.JaroWinklerDistance;

import com.google.gson.Gson;

public class TheStore {
	Scanner sc=new Scanner(System.in);
	int choice;
	
	public Item ADD() {
		while(true) {
		System.out.println("Choose one of the following items to be added by entering its number : ");
		System.out.println("1. LAPTOP ");
		System.out.println("2. TELEVISION ");
		System.out.println("3. PHONE ");
		choice=sc.nextInt();
		
		if(choice==1) {
			Laptop laptop=new Insert_Info().Laptop_Info();
			return laptop;
		}
		else if(choice==2) {
			Television tv=new Insert_Info().TV_Info();
			return tv;
		}
		else if(choice==3) {
			Phone phone=new Insert_Info().Phone_Info();
			return phone;
		}
		else {
			System.out.println(" Please choose between 1 and 3 only ");
			}
		}

	}
	
	public static  ArrayList<Item> SearchList(ArrayList<Item> List,String UserInput){
		ArrayList<Item> SortedList=(ArrayList<Item>) List.stream()
				.filter(item->new JaroWinklerDistance().apply(item.getTypeName().toLowerCase(), UserInput.toLowerCase())<0.5
						||item.getTypeName().toLowerCase().contains(UserInput.toLowerCase())
						||UserInput.toLowerCase().contains(item.getTypeName().toLowerCase())
						||new JaroWinklerDistance().apply(item.getCompany_made().toLowerCase(), UserInput.toLowerCase())<0.35
						||item.getCompany_made().toLowerCase().contains(UserInput.toLowerCase())
						||UserInput.toLowerCase().contains(item.getCompany_made().toLowerCase())
						)
				.sorted(Comparator.comparingInt
						(item->matchScore(((Item) item).getTypeName().toLowerCase(), UserInput.toLowerCase())).reversed())
				.collect(Collectors.toList());
		return SortedList;
		
		
	}
	public static int matchScore(String word, String searchWord) {
        if (word.toLowerCase().equals(searchWord.toLowerCase())) {
            return 3; // perfect match
        } else if (word.toLowerCase().contains(searchWord.toLowerCase())) {
            return 2; // close match
        } else if (searchWord.toLowerCase().contains(word.toLowerCase())) {
            return 1; // weak match
        }
        else {
        	return 0;
        }
    }
	
	public static void PrintItems(ArrayList<Item>ListOfItems) {
		for (Item obj : ListOfItems) {
			   if (obj instanceof Television) {
				   Television subObj1 = (Television) obj;
			      System.out.println(subObj1.toString());
			   } else if (obj instanceof Phone) {
			      Phone p = (Phone) obj;
			      System.out.println(p.toString());
			   }else {
				   Laptop subObj3 = (Laptop) obj;
				   System.out.println(subObj3.toString());
				   
			   }
		}
	}
	public static ArrayList<Item> Modify_Item(ArrayList<Item>ListOfItems,String ID){
		
		System.out.println("You will be asked about modifying every Field except the ID ");
		System.out.println("To modify write 'Yes' and to skip write 'No' ");
		System.out.println("###############################################");
		
		for(Item obj:ListOfItems) {
			if(obj.getId().equals(ID)) {
				if (obj instanceof Television) {
					   Television tv = (Television) obj;
					   System.out.println("Modifying the info of TELEVISION of ID :"+ID);
					      obj=new Insert_Info().TV_Modify(tv);
					      return ListOfItems;
					   
					   
				   } else if (obj instanceof Phone) {
				      Phone phone = (Phone) obj;
				      System.out.println("Modifying the info of PHONE of ID :"+ID);
				      obj=new Insert_Info().Phone_Modify(phone);
				      return ListOfItems;
				      
				   }else {
					   Laptop laptop = (Laptop) obj;
					   System.out.println("Modifying the info of LAPTOP of ID :"+ID);
					      obj=new Insert_Info().Laptop_Modify(laptop);
					      return ListOfItems;
					   
				   }
				
				
			}
		}
		
		
		return null;
	}
	
	public static boolean Check_id(ArrayList<Item>ListOfItems,String Item_id) {
		
		for(Item o:ListOfItems) {
			if(o.getId().equals(Item_id)) {
				System.out.println("The item id exists in this List");
				return true;
			}
		}return false;
	}
	
	public static ArrayList<Item> DELETE_Item(ArrayList<Item>ListOfItems,String Item_id){
		for(Item obj:ListOfItems) {
			if(obj.getId().equals(Item_id)) {
				ListOfItems.remove(obj);
				return ListOfItems;
			}
		}
		return null;
	}
	
	public static void Save_in_json(ArrayList<Item>ListOfItems) {
		File file=new File("Items.json");
		FileWriter fw;
	try {
		fw = new FileWriter(file);
		Gson gson=new Gson();
		gson.toJson(ListOfItems,fw);
		fw.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	


}

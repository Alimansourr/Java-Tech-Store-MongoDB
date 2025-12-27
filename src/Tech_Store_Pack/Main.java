package Tech_Store_Pack;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Item> ListOfItems=new ArrayList<Item>();
		Scanner s=new Scanner(System.in);
		String choice;
		int counter;
		

		System.out.println("-----------------------------Welcome to Technology Store--------------------------------");
		System.out.println("Choose the Source of the initial data : \n"+"1-JSON"+"\n"+"2-MongoDB");
		choice=s.next();
		if(choice.equals("1")) {		
			ListOfItems= ItemDeserializer.Deserializtion();
		}
		
		else if(choice.equals("2")) {
			ListOfItems=Mongodb.Read_mongo();
		}		
		
		 if(ListOfItems==null) {
			 ListOfItems=new ArrayList<Item>();
			 System.out.println("No Results");
		 }
		 else{
			 String[] arrStr= ListOfItems.get(ListOfItems.size()-1).getId().split("_");
		     counter=Integer.parseInt(arrStr[1]);
		     Item item=new Phone(counter);
			 TheStore.PrintItems(ListOfItems);
		 }
		 

		
		System.out.println("Successful loading of data");
		while(true) {
			System.out.println("Now you should choose what to do with data by entering its number and this are your choices : ");
			System.out.println("1. ADD ITEM ");
			System.out.println("2. UPDATE AN ITEM ");
			System.out.println("3. SEARCH FOR AN ITEM ");
			System.out.println("4. DELETE AN ITEM ");
			System.out.println("5.EXIT"+"\n"+"\n");
			System.out.println("-----Select your choice ");
			
			choice=s.next();
			if(choice.equals("1")) {
				Item item=new TheStore().ADD();
					ListOfItems.add(item);
			}
			
			else if(choice.equals("2")) {
				System.out.println("Search for the item that you want to update : ");
				System.out.println("Enter a keyword to show the results : ");
				choice=new Insert_Info().SearchedWord();
				ArrayList<Item> SearchedItems=TheStore.SearchList(ListOfItems, choice);
				System.out.println("-----------------------------------------------------");
				 if(SearchedItems==null) {
					 System.out.println("No Results");
				 }
				 else{
					 TheStore.PrintItems(SearchedItems);
				 }
				 System.out.println("Enter the ID of the item you want to modify : ");
				 choice=s.next();
				 if(TheStore.Check_id(SearchedItems, choice)) {
					 System.out.println("Ready For updating");
					 ListOfItems=TheStore.Modify_Item(ListOfItems, choice);
					 TheStore.PrintItems(ListOfItems);
					}
				 else {
						System.out.println("This item doesn't exist ,repeat the experiment");
					}				 
				 
			}
			
			else if(choice.equals("3")) {
				choice=new Insert_Info().SearchedWord();
				ArrayList<Item> SearchedItems=TheStore.SearchList(ListOfItems, choice);
				 System.out.println("-----------------------------------------------------");
				 if(SearchedItems==null) {
					 System.out.println("No Results");
				 }
				 else{
					 TheStore.PrintItems(SearchedItems);
				 }
			}
			
			else if(choice.equals("4")) {
				choice=new Insert_Info().SearchedWord();
				ArrayList<Item> SearchedItems=TheStore.SearchList(ListOfItems, choice);
				if(SearchedItems==null) {
					 System.out.println("No Results");
				 }
				 else{
					 TheStore.PrintItems(SearchedItems);
				 }
				 System.out.println("-----------------------------------------------------");
				
				
				 System.out.println("Enter the ID of the item you want to Remove From the List : ");
				 choice=s.next();
				 if(TheStore.Check_id(SearchedItems, choice)) {
					 ListOfItems=TheStore.DELETE_Item(ListOfItems, choice);
					 TheStore.PrintItems(ListOfItems);
					}
				 else {
						System.out.println("This item doesn't exist ,repeat the experiment");
					}			
			}
			
			else if(choice.equals("5")) {
				System.out.println("Finish");break;
			}
			
			else {
				System.out.println("!!!Enter from 1 to 5 only");
			}
		}
		
		System.out.println("Do you want to save changes if yes enter word 'Yes' and if not enter word 'No' ");
		if(new Insert_Info().YesOrNo()) {
			TheStore.Save_in_json(ListOfItems);
			Mongodb.Save_to_mongo();
		}
		
		
		


	
	}
}

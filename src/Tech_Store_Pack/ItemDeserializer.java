package Tech_Store_Pack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;


public class ItemDeserializer implements JsonDeserializer<Item> {

	@Override
	public Item deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
		 JsonObject jsonObject = json.getAsJsonObject();
	        if (jsonObject.has("DisplayScreen")) {
	           return context.deserialize(json, Laptop.class);
	        } else if (jsonObject.has("IOports")) {
	           return context.deserialize(json, Television.class);
	        } else {
	           return context.deserialize(json, Phone.class);
	        }
		
	}
	public static ArrayList<Item> Deserializtion(){
		File file=new File("Items.json");
		ArrayList<Item> ListOfItems=new ArrayList<Item>();
		Gson gson = new GsonBuilder()
		        .registerTypeAdapter(Item.class, new ItemDeserializer())
		        .create();
			try {
				Type type = new TypeToken<ArrayList<Item>>(){}.getType();
				ListOfItems=gson.fromJson(new FileReader(file), type);
			}catch(JsonIOException | JsonSyntaxException | FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			return ListOfItems;

	}

}

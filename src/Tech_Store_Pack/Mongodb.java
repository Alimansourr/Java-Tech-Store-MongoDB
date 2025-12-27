package Tech_Store_Pack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Mongodb {
	public static void Save_to_mongo() {
		
		// Connect to MongoDB server
       MongoClient mongoClient = new MongoClient("localhost", 27017);
       
       // Connect to database
       MongoDatabase database = mongoClient.getDatabase("my_database");
       
       // Connect to collection
      MongoCollection<Document> collection = database.getCollection("mycollection1");
      collection.deleteMany(new Document()); // Delete all documents in the collection
      
      try(BufferedReader reader = new BufferedReader(new FileReader("Items.json"))){
    	  String line;
    	  Gson gson = new Gson();
    	
    	
    	  // Read the JSON file line by line
    	  while ((line = reader.readLine()) != null) {
    		  // Convert each line to JSON element
              JsonElement jsonElement = gson.fromJson(line, JsonElement.class);
              if (jsonElement.isJsonArray()) {
                  // Convert array to BSON documents
                  JsonArray jsonArray = jsonElement.getAsJsonArray();
                  for (JsonElement element : jsonArray) {
                      Document bsonDocument = Document.parse(element.toString());
                      //System.out.println(bsonDocument);
                      collection.insertOne(bsonDocument);
                  }
                  
              } else {
                  // Convert single object to BSON document
                  Document bsonDocument = Document.parse(jsonElement.toString());
                  System.out.println(bsonDocument.toJson());
                  
                  // Replace the entire collection with the new document
                  collection.insertOne(bsonDocument);
              }
    	  }
      }catch(IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
      }
      
   // Close MongoDB client
      mongoClient.close();

       
	}
	
	public static ArrayList<Item> Read_mongo() {
		
		// Connect to MongoDB server
		MongoClient mongoClient = new MongoClient("localhost", 27017);
	       
	    // Connect to database
	    MongoDatabase database = mongoClient.getDatabase("my_database");
	       
	    // Connect to collection
	    MongoCollection<Document> collection = database.getCollection("mycollection1");
	    
	    MongoCursor<Document> cursor = collection.find().iterator();
	    
	    while (cursor.hasNext()) {
            Document document = cursor.next();int i=0;
            for (String fieldName : document.keySet()) {
            	i++;
            }
            if(i==7) {
            	
            }else if(i==6) {
            	
            }else {
            	
            }
            
	    }
	      return null;
	}
	
	

}

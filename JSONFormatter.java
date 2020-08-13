package com.json.formatter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONFormatter {

	public static void main(String[] args) throws IOException {
		
	    String data = "";
	    Path path = Paths.get("/Users/arghya/ipshita/workspace/JSONFormatter/Input/Sample.txt");
	    data = new String(Files.readAllBytes(path)); 
	    System.out.println(data);
		
        //String jsonString = "{\"quiz\":{\"sport\":{\"q1\":{\"question\":\"Which one is correct team name in NBA?\",\"options\":[\"New York Bulls\",\"Los Angeles Kings\",\"Golden State Warriros\",\"Huston Rocket\"],\"answer\":\"Huston Rocket\"}},\"maths\":{\"q1\":{\"question\":\"5 + 7 = ?\",\"options\":[\"10\",\"11\",\"12\",\"13\"],\"answer\":\"12\"},\"q2\":{\"question\":\"12 - 8 = ?\",\"options\":[\"1\",\"2\",\"3\",\"4\"],\"answer\":\"4\"}}}}";

        JsonObject jsonObjectAlt = JsonParser.parseString(data).getAsJsonObject();
        //System.out.println(jsonObjectAlt);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //System.out.println(gson.toJson(jsonObjectAlt));
        
        Path outPath = Paths.get("/Users/arghya/ipshita/workspace/JSONFormatter/Input/Output.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(outPath)) 
        {
            writer.write(gson.toJson(jsonObjectAlt));
        }
	}


}

// Project for CS 2336 PircBot and API usage
// lfh180001 2020

import org.jibble.pircbot.*;
import java.util.*;
import java.net.*;
import java.io.*;
import com.google.gson.*;

public class MyBot extends PircBot {
    
	public MyBot() {
    	
        this.setName("LHBOT");
    }
    
    public void onMessage(String channel, String sender, String login, String hostname, String message) {
       
    	//if else block to check the message and see if a command needs to be performed
    	if(message.equalsIgnoreCase("help"))								//help functionality for list of commands
    	{
    		sendMessage(channel, "Type \"weather [city]\" for temperature info | Type \"movie [movie title]\" for movie info | Type \"time\" for the current time | Type \"bye\" to quit");
    	}
    	else if(message.equalsIgnoreCase("time")) 							//for the bot to display time
        {
            String time = new Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }
    	else if(message.equalsIgnoreCase("bye"))							//for the bot to leave the chatroom
    	{
    		disconnect();
    	}
    	else if(message.substring(0, 5).equalsIgnoreCase("movie"))			//prints the movie info when asked
    	{
    		printMovieInfo(message.substring(6), channel);
    	}
    	else if((message.substring(0, 7)).equalsIgnoreCase("weather"))		//print the temperature info for whatever city
    	{
    		printTemp(message.substring(8), channel);
    	}

    }
    
    //function to print temperature of a given city
    public void printTemp(String city, String channel) {
    	
    	//replaces any spaces in the city with %20 as it helps the api get more accurate info
    	String temp_city = city.replace(" ", "%20");
    	
    	//declare api url using api from OpenWeatherMaps
    	String api_url = "http://api.openweathermap.org/data/2.5/weather?q=" + temp_city + "&units=imperial&appid=1b2b50d41d78dc1220c58e87bd34bf6b";
		//http://api.openweathermap.org/data/2.5/weather?q=Houston&APPID=2ae2de60b38324d820a5cd331fef5d72
    	
    	//call the getJSON function to turn the JSON format api url into a string buffer
    	StringBuffer temperature_JSON = getJSON(api_url);
    	
    	//put string buffer into json and get it ready to be parsed
    	JsonElement w_elem = new JsonParser().parse(temperature_JSON.toString());
    	JsonObject w_main = w_elem.getAsJsonObject();
    	w_main = w_main.getAsJsonObject("main");
    	
    	//print temps
    	sendMessage(channel, "The temperature in " + city + " is going to be " + w_main.get("temp") + "\u00B0F with a high of " + w_main.get("temp_max")+ "°F and a low of " + w_main.get("temp_min") + "°F.");
    }
     
    public void printMovieInfo(String movie_name, String channel) {
    	
    	//replace the spaces with + in the string to accomadate for API addressing
    	String temp_movie_name = movie_name.replace(" ", "+");
    	
    	//set the apiurl
    	String api_url = "http://www.omdbapi.com/?t=" + temp_movie_name + "&apikey=37b6338b";
    	
    	//call getJSON function and turn it into a usable json object thats parsed
    	StringBuffer movie_JSON = getJSON(api_url);
    	JsonElement m_elem = new JsonParser().parse(movie_JSON.toString());
    	JsonObject m_main = m_elem.getAsJsonObject();
    	
    	//print relevant data
    	sendMessage(channel, "Movie: \"" + movie_name + "\"");
    	sendMessage(channel, "Genre(s): " + m_main.get("Genre"));
    	sendMessage(channel, "Plot: " + m_main.get("Plot"));
    	sendMessage(channel, "Release Date: " + m_main.get("Released"));
    	sendMessage(channel, "Runtime: " + m_main.get("Runtime"));
    }

    // boiler plate code; reads from apiurl into a string buffer
    public StringBuffer getJSON(String api_url) {
    	
    	StringBuffer content = new StringBuffer();
    	
    	try
    	{
    		URL url = new URL(api_url);
    		HttpURLConnection con = (HttpURLConnection) url.openConnection();
    		con.setRequestMethod("GET");
    	
    		Map<String, String> parameters = new HashMap<>();
    		parameters.put("param1", "val");
    	 
    		con.setDoOutput(true);
    		DataOutputStream out = new DataOutputStream(con.getOutputStream());
    		out.writeBytes(getParamsString(parameters));
    		out.flush();
    		out.close();
    	
    		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    		String inputLine;
    		while ((inputLine = in.readLine()) != null)
    		{
    			content.append(inputLine);
    		}
    		
    		in.close();
    		
    		con.disconnect();
    	}
    	catch(Exception error) {
    		
    		System.out.print("Error in recieving JSON file");
    	}
    	
    	System.out.println(content);
    	return content;
    }
    
    // boiler plate code
    public static String getParamsString(Map<String, String> params) throws UnsupportedEncodingException {
    	
    	StringBuilder result = new StringBuilder();
    	 
    	for (Map.Entry<String, String> entry : params.entrySet()) 
    	{
    		result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
    		result.append("=");
    		result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
    		result.append("&");
    	}
    	 
    	String resultString = result.toString();
    	return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
    }
}


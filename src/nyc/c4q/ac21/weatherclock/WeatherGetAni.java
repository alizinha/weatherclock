package nyc.c4q.ac21.weatherclock;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Access Code 2.1
 * Created by Jaellys Bales on 4/6/15.
 * Project: weatherclock
 *
 * WeatherGetAni.java
 * Retrieves API info, checks weather condition, and returns ASCII animation.
 */

public class WeatherGetAni
{
    public static String getAscii(int index) throws IOException, ParseException
    {
        // Need to revert to this before demo.
        //        URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?q=New%20York");
        //        String doc = HTTP.get(url);
        //        JSONObject obj = (JSONObject) JSONValue.parse(doc);

        // Creating JSON parsing object.
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject)parser.parse(new FileReader("/Users/c4q-tashasmith/Desktop/weatherclock/src/nyc/c4q/ac21/weatherclock/weather.json"));

        // Retrieving API data.
        JSONArray weatherJSONArray = (JSONArray) obj.get("weather");
        JSONObject weatherJSONObj = (JSONObject) weatherJSONArray.get(0);
        String weatherMain = (String) weatherJSONObj.get("main");

        HashMap<String, ArrayList<String>> weatherConditions = new HashMap<String, ArrayList<String>>(WeatherMakeAni.map());

        // Checking API data vs weatherConditions keys, retrieving corresponding animation.
        String aniFrame = "";

        if(weatherMain.toLowerCase().contains("additional"))
        {
            aniFrame = weatherConditions.get("Additional").get(index);
        }
        else if(weatherMain.toLowerCase().contains("atmosphere"))
        {
            aniFrame = weatherConditions.get("Atmosphere").get(index);
        }
        else if(weatherMain.toLowerCase().contains("clear"))
        {
            aniFrame = weatherConditions.get("Clear").get(index);
        }
        else if(weatherMain.toLowerCase().contains("clouds"))
        {
            aniFrame = weatherConditions.get("Clouds").get(index);
        }
        else if(weatherMain.toLowerCase().contains("drizzle"))
        {
            aniFrame = weatherConditions.get("Drizzle").get(index);
        }
        else if(weatherMain.toLowerCase().contains("extreme"))
        {
            aniFrame = weatherConditions.get("Extreme").get(index);
        }
        else if(weatherMain.toLowerCase().contains("rain"))
        {
            aniFrame = weatherConditions.get("Rain").get(index);
        }
        else if(weatherMain.toLowerCase().contains("snow"))
        {
            aniFrame = weatherConditions.get("Snow").get(index);
        }
        else if(weatherMain.toLowerCase().contains("thunderstorm"))
        {
            aniFrame = weatherConditions.get("Thunderstorm").get(index);
        }

        return aniFrame;
    }
}
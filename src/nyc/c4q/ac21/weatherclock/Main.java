package nyc.c4q.ac21.weatherclock;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    /**
     * Returns sunrise time for the current day (Jaellys).
     */
    public static Calendar getSunrise() {
        URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?q=New%20York");
        String doc = HTTP.get(url);
        JSONObject obj = (JSONObject) JSONValue.parse(doc);

        JSONObject sys = (JSONObject) obj.get("sys");
        if (sys == null)
            return null;
        Long sunriseTimestamp = (Long) sys.get("sunrise");
        if (sunriseTimestamp == null)
            return null;
        return DateTime.fromTimestamp(sunriseTimestamp);
    }

    /**
     * SAMPLE CODE: Returns sunset time for the current day.
     */
    public static Calendar getSunset() {
        URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?q=New%20York");
        String doc = HTTP.get(url);
        JSONObject obj = (JSONObject) JSONValue.parse(doc);

        JSONObject sys = (JSONObject) obj.get("sys");
        if (sys == null)
            return null;
        Long sunsetTimestamp = (Long) sys.get("sunset");
        if (sunsetTimestamp == null)
            return null;
        return DateTime.fromTimestamp(sunsetTimestamp);
    }

    /**
     * SAMPLE CODE: Displays a very primitive clock.
     */
    public static void main(String[] args) throws IOException, ParseException
    {
        //prompt user to choose a 12 or 24-hour format to display a clock--Allison added
        Scanner scan = new Scanner(System.in);
        System.out.println("Type in \"12\" or \"24\" to choose preferred clock format: ");
        while(!scan.hasNextInt()) {
            System.out.println("Please enter \"12\" or \"24\" only! Thank you.");
            scan.next();
        }
        int preferredClock = scan.nextInt();

        boolean militaryTime = true;

        if (preferredClock == 24) {
            militaryTime = true;
        }
        else if(preferredClock == 12)
        {
            militaryTime = false;
        }
        else
        {
            System.out.println("Please enter \"12\" or \"24\" only! Thank you.");
        }

        // Prompt user for city -- Madelyn
        System.out.println("Which city would you like to get information for?");
        String input=scan.next();
        if (input.substring(0).equals(" ")){
            input.replace(" ", "%20");
        }
        String goTo = ("http://api.openweathermap.org/data/2.5/weather?q=" + input);


        // Find out the size of the terminal currently.
        final int numCols = TerminalSize.getNumColumns();
        final int numRows = TerminalSize.getNumLines();

        // Create the terminal.
        final AnsiTerminal terminal = new AnsiTerminal();

        // When the program shuts down, reset the terminal to its original state.
        // This code makes sure the terminal is reset even if you kill your
        // program by pressing Control-C.
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run()
            {
                terminal.showCursor();
                terminal.reset();
                terminal.scroll(1);
                terminal.moveTo(numRows, 0);
            }
        });

        // Clear the screen to black.
        terminal.setBackgroundColor(AnsiTerminal.Color.BLACK);
        terminal.clear();
        // Don't show the cursor.
        terminal.hideCursor();

        // Get sunrise time for the current day (Jaellys).
        Calendar sunrise = getSunrise();

        // Get sunset time for the current day.
        Calendar sunset = getSunset();

        int xPosition = 1 + numCols / 2 - 5;
        int numFrames = 0; // Needed for displaying weather ASCII.
        while (true)
        {
            // Get the current date and time.
            Calendar cal = Calendar.getInstance();
            //          Calendar cal = DateTime.parseDate("2012-07-04");//used this date to test holiday functionality

            //            // Write the time, including seconds, in white.
            //            String time = DateTime.formatTime(cal, true);
            //            if(cal.get(Calendar.HOUR_OF_DAY) >= 12) time += " PM";
            //            else time += " AM";
            //            terminal.setTextColor(AnsiTerminal.Color.WHITE);
            //            terminal.moveTo(3, xPosition + 30);
            //            terminal.write(time);

            //            // Write the date in gray.
            //            String date = DateTime.formatDate(cal);
            //            terminal.setTextColor(AnsiTerminal.Color.WHITE, false);
            //            terminal.moveTo(4, xPosition + 30);
            //            terminal.write(date);

            // Write sunrise time in dark yellow. -- Allison
            String sunriseTime = DateTime.formatTime(sunrise, false);
            terminal.setTextColor(AnsiTerminal.Color.YELLOW, false);
            terminal.moveTo(5, xPosition + 30);
            terminal.write("Sunrise: " + sunriseTime + " AM");

            // Set the background color back to black.
            terminal.setBackgroundColor(AnsiTerminal.Color.BLACK);

            // Write sunset time in dark yellow.
            String sunsetTime = DateTime.formatTime(sunset, false);
            terminal.setTextColor(AnsiTerminal.Color.YELLOW, false);
            terminal.moveTo(6, xPosition + 30);
            terminal.write("Sunset: " + sunsetTime + " PM");

            //Write if DST or not on this date. -- Allison B. wrote this portion below and also in DST.java
            String dst = DST.getDSTStatus(cal);
            terminal.setTextColor(AnsiTerminal.Color.WHITE, false);
            //            terminal.setBackgroundColor(AnsiTerminal.Color.GREEN);
            terminal.moveTo(7, xPosition + 30);
            terminal.write(dst);

            //Write the holiday if today is a national holiday. --Allison did this.
            //TODO--JAE please note that this currently posts "No holiday" when there is not a holiday.
            //I wanted you to be able to see it in the terminal which is why I left it that way but feel
            //free to change it so that it prints nothing on days when there is no holiday.
            terminal.setTextColor(AnsiTerminal.Color.WHITE, false);
            //            terminal.setBackgroundColor(AnsiTerminal.Color.GREEN);
            terminal.moveTo(8, xPosition + 30);
            terminal.write(Holidays.getHolidayStatus(cal));

            //allison-- print mini calendar
            //TODO--JAE, please note that the alignment on this is wacky right now, so the name of the month
            //and the year aren't directly above the "Su Mo Tu We Th Fr Sa". I figured it'll get moved around
            //anyway so I left it as is.
            //            terminal.setTextColor(AnsiTerminal.Color.BLUE, false);
            //            terminal.setBackgroundColor(AnsiTerminal.Color.GREEN);
            //            terminal.moveTo(15, xPosition + 30);
            //            CalendarPrinter.printMonthCalendar(cal);

            //allison--print Day of week, Name of month, date, and year (e.g.: "Wednesday, April 8, 2015")
            String dayOfWeek = DateTime.getDayOfWeekNames().get(cal.get(Calendar.DAY_OF_WEEK));
            String nameOfMonth = DateTime.getMonthNames().get(cal.get(Calendar.MONTH));
            terminal.setTextColor(AnsiTerminal.Color.WHITE, false);
            //            terminal.setBackgroundColor(AnsiTerminal.Color.GREEN);
            terminal.moveTo(9, xPosition + 30);
            terminal.write(dayOfWeek + ", " + nameOfMonth + " " + DateTime.allisonsMethod(cal));

            WeatherData currentWeatherData = new WeatherData(goTo);
            terminal.setTextColor(AnsiTerminal.Color.WHITE);
            terminal.moveTo(12, xPosition + 30);
            terminal.write("Temp: " + String.valueOf(currentWeatherData.getTemp()));
            terminal.moveTo(13, xPosition + 30);
            terminal.write("Pressure: " + String.valueOf(currentWeatherData.getPressure()));
            terminal.moveTo(14, xPosition + 30);
            terminal.write("Humidity: " + String.valueOf(currentWeatherData.getHumidity()));

            //Writing time in big numbers
            //This code will use the hashmap generated from the bigLetters method to print out
            //the appropriate big number strings that correspond with the current time
            //boolean militaryTime=false;
            String formatTime="";
            int hours=cal.get(Calendar.HOUR);
            int AMorPM=cal.get(Calendar.AM_PM);
            String ampmString = "";

            //Determine if user asked for military time or not, then format time accordingly
            if(!militaryTime)
                formatTime=DateTime.formatTime(cal,false);
            else
                formatTime=new SimpleDateFormat("HH:mm").format(cal.getTime());

            //Next if user did not request military time, then update am_pm variable to the appropriate value

            if(militaryTime==false){
                if(hours<12)
                {
                    if(AMorPM==1)
                    {
                        ampmString="PM";
                    }
                }
                else
                {
                    ampmString="AM";
                }
            }

            //get hashmap
            HashMap<String, ArrayList<String>> numbers=TimeInBigLetters.bigNumbers();

            //get the hours and minutes from the current time String and save to variables
            int semiColon=formatTime.indexOf(":");
            String hour=formatTime.substring(0,semiColon);
            String minutes=formatTime.substring(semiColon+1);

            //run a loop to print out the time in big letters
            System.out.println();
            for(int i=0;i<8;i++)
            {
                Random random = new Random();
                int color = random.nextInt(6);
                if (color == 0)
                    terminal.setTextColor(AnsiTerminal.Color.GREEN, false);
                else if (color == 1)
                    terminal.setTextColor(AnsiTerminal.Color.RED, false);
                else if (color == 2)
                    terminal.setTextColor(AnsiTerminal.Color.YELLOW, false);
                else if (color == 3)
                    terminal.setTextColor(AnsiTerminal.Color.BLUE, false);
                else if (color == 4)
                    terminal.setTextColor(AnsiTerminal.Color.MAGENTA, false);
                else if (color == 5)
                    terminal.setTextColor(AnsiTerminal.Color.CYAN, false);
                else
                    terminal.setTextColor(AnsiTerminal.Color.WHITE, false);


                if(hour.length()<2&&militaryTime==false)
                {
                    System.out.print(numbers.get(hour.substring(0)).get(i)+"  ");
                    System.out.print(numbers.get("10").get(i)+"  ");
                    System.out.print(numbers.get((minutes.substring(0,1))).get(i)+"  ");
                    System.out.print(numbers.get((minutes.substring(1))).get(i)+"  ");
                    if (ampmString.equals("AM")) {
                        System.out.print(numbers.get("11").get(i));
                    }
                    else
                        System.out.print(numbers.get("12").get(i));
                    System.out.println();

                }
                else if(hour.length()>1&&militaryTime==false)
                {
                    System.out.print(numbers.get(hour.substring(0,1)).get(i)+"  ");
                    System.out.print(numbers.get(hour.substring(1)).get(i)+"  ");
                    System.out.print(numbers.get("10").get(i)+"  ");
                    System.out.print(numbers.get((minutes.substring(0,1))).get(i)+"  ");
                    System.out.print(numbers.get((minutes.substring(1))).get(i) + "  ");
                    if (ampmString.equals("AM")) {
                        System.out.print(numbers.get("11").get(i));
                    }
                    else
                        System.out.print(numbers.get("12").get(i));
                    System.out.println();
                }
                else
                {
                    System.out.print(numbers.get(hour.substring(0,1)).get(i)+"  ");
                    System.out.print(numbers.get(hour.substring(1)).get(i)+"  ");
                    System.out.print(numbers.get("10").get(i)+"  ");
                    System.out.print(numbers.get((minutes.substring(0,1))).get(i)+"  ");
                    System.out.print(numbers.get((minutes.substring(1))).get(i));
                    System.out.println();
                }
            }

            //            // Get weather condition ASCII art. (Jaellys)
            //            terminal.setTextColor(AnsiTerminal.Color.WHITE, false);
            //            terminal.moveTo(20, 0);
            //
            //            // Displaying each frame. (Jaellys)
            //            if (numFrames % 6 == 0) {
            //                String tmp = WeatherGetAni.getAscii(0);
            //                terminal.write(tmp);
            //            }
            //            else if (numFrames % 6 == 2) {
            //                String tmp = WeatherGetAni.getAscii(1);
            //                terminal.write(tmp);
            //            }
            //            else if (numFrames % 6 == 4) {
            //                String tmp = WeatherGetAni.getAscii(2);
            //                terminal.write(tmp);
            //            }
            //            numFrames++;

            // Pause for one second, and do it again.
            DateTime.pause(.5);
        }
    }
}
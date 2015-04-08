package nyc.c4q.ac21.weatherclock;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.net.URL;
import java.util.Calendar;

public class Main {

    /**
     * Jae made this - Returns sunset time for the current day.
     */
    public static Calendar getSunrise() {
        URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?q=New%20York,NY");
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
        URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?q=New%20York,NY");
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
    public static void main(String[] args) {
        // Find out the size of the terminal currently.
        final int numCols = TerminalSize.getNumColumns();
        final int numRows = TerminalSize.getNumLines();

        // Create the terminal.
        final AnsiTerminal terminal = new AnsiTerminal();

        // When the program shuts down, reset the terminal to its original state.
        // This code makes sure the terminal is reset even if you kill your
        // program by pressing Control-C.
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
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

        // Jae MADE THIS - Get sunrise time for the current day.
        Calendar sunrise = getSunrise();

        // Get sunset time for the current day.
        Calendar sunset = getSunset();

        int xPosition = 1 + numCols / 2 - 5;
        while (true)
        {
            // Get the current date and time.
            Calendar cal = Calendar.getInstance();
  //          Calendar cal = DateTime.parseDate("2012-07-04");//used this date to test holiday functionality

            // Write the time, including seconds, in white.
            String time = DateTime.formatTime(cal, true);
            if(cal.get(Calendar.HOUR_OF_DAY) >= 12) time += " PM";
            else time += " AM";
            terminal.setTextColor(AnsiTerminal.Color.WHITE);
            terminal.moveTo(3, xPosition);
            terminal.write(time);

            // Write the date in gray.
            String date = DateTime.formatDate(cal);
            terminal.setTextColor(AnsiTerminal.Color.WHITE, false);
            terminal.moveTo(5, xPosition);
            terminal.write(date);

            // Write the day of the week in green on a blue background.
            String dayOfWeek = DateTime.getDayOfWeekNames().get(cal.get(Calendar.DAY_OF_WEEK));
            terminal.setTextColor(AnsiTerminal.Color.GREEN);
            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE);
            terminal.moveTo(7, xPosition);
            terminal.write("  " + dayOfWeek + "  ");

            // Set the background color back to black.
            terminal.setBackgroundColor(AnsiTerminal.Color.BLACK);

            // Write sunset time in dark yellow.
            String sunsetTime = DateTime.formatTime(sunset, false);
            terminal.setTextColor(AnsiTerminal.Color.YELLOW, false);
            terminal.moveTo(9, xPosition - 2);
            terminal.write("sunset at " + sunsetTime);

            //Write if DST or not on this date. -- Allison B. wrote this portion below and also in DST.java
            String dst = DST.getDSTStatus(cal);
            terminal.setTextColor(AnsiTerminal.Color.BLUE, false);
            terminal.setBackgroundColor(AnsiTerminal.Color.GREEN);
            terminal.moveTo(11, xPosition);
            terminal.write(dst);

            //Write the holiday if today is a national holiday. --Allison working on this.
            //**need to add a String here that is empty to start**
            terminal.setTextColor(AnsiTerminal.Color.BLUE, false);
            terminal.setBackgroundColor(AnsiTerminal.Color.GREEN);
            terminal.moveTo(13, xPosition);
            terminal.write(Holidays.getHolidayStatus(cal));
            //    HashMap<Calendar, String> holidays = Holidays.getHolidays("National holiday");
            //    String holiday = holidays.get(date);
            //    System.out.println("National Holiday:    " + holiday)

            //Print a mini-calendar




            DateTime.pause(1.0);
        }
    }
}



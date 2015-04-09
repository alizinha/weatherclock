package nyc.c4q.ac21.weatherclock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Holidays {

    /**
     * Loads holidays from a file.
     *
     * @param holidayType
     *   The type of holiday.  Use "National holiday" for U.S. federal holidays.
     * @return
     *   A map from date to holiday name for holidays.
     */
    public static HashMap<Calendar, String> getHolidays(String holidayType) {
        ArrayList<String> lines = FileTools.readLinesFromFile("./weatherclock/holidays.csv");
        HashMap<Calendar, String> holidays = new HashMap<Calendar, String>();
        for (String line : lines) {
            // Each line is of the form "date,name,type", where "date" is a date
            // in YYYY-MM-DD format, "name" is the holiday name, and "type" is
            // the holiday type.  Include only those lines where "type" matches
            // the 'holidayType' parameter.
            int comma1 = line.indexOf(',');
            String date = line.substring(0, comma1);
            int comma2 = line.indexOf(',', comma1 + 1);
            String name = line.substring(comma1 + 1, comma2);
            String type = line.substring(comma2 + 1);
            if (type.equals(holidayType))
            {
                Calendar cal = DateTime.parseDate(date);
                holidays.put(cal, name);
            }
        }
        return holidays;
    }

    public static boolean isHoliday(Calendar date)
    {
        HashMap<Calendar, String> holidayMap = getHolidays("National holiday");
//        for (Map.Entry<Calendar, String> e : holidayMap.entrySet()) {
//            Calendar c = e.getKey();
//            System.out.print(DateTime.formatDate(c));
//            System.out.print(e.getValue());
//            System.out.println();
//        }

        return holidayMap.containsKey(date);


    }
    public static String getHolidayStatus(Calendar date) {
        String status = "";
        if (isHoliday(date))
            status = getHolidays("National holiday").get(date);
        else status = "No holiday.";
        return status;
    }



}

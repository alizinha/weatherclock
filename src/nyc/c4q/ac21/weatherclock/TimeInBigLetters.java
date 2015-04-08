package nyc.c4q.ac21.weatherclock;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by c4q-madelyntavarez on 4/6/15.
 */
public class TimeInBigLetters
    {
        public static void printSimpleClock(Calendar cal, boolean militaryTime)
        {
            int hours = cal.get(Calendar.HOUR);
            int AM_orPM = cal.get(Calendar.AM_PM);
            String PMorAM = "";
            String formatTime;

            if (militaryTime== false)
            {
                formatTime = DateTime.formatTime(cal, false);
            }
            else {
                formatTime = new SimpleDateFormat("HH:mm").format(cal.getTime());
            }

            HashMap<String, String> printSimpleTime = new HashMap<String, String>();

            printSimpleTime.put("0", " ,pP\"\"Yq.  \n" + "6W'    `Wb \n" + "8M      M8 \n" + "YA.    ,A9 \n" + " `Ybmmd9' \n");
            printSimpleTime.put("1", " __,  \n" + "`7MM  \n" + "  MM  \n" + "  MM  \n" + "  MM  \n" + ".JMML.\n");
            printSimpleTime.put("2", "pd*\"*b. \n" + "(O)   j8 \n" + "    ,;j9 \n" + " ,-='    \n" + "Ammmmmmm \n");
            printSimpleTime.put("3", " pd\"\"b.  \n" + "(O)  `8b \n" + "     ,89 \n" + "   \"\"Yb. \n" + "      88 \n" + "(O)  .M' \n" + " bmmmd'  \n");
            printSimpleTime.put("4", "     ,AM   \n" + "    AVMM   \n" + "  ,W' MM   \n" + ",W'   MM   \n" + "AmmmmmMMmm \n" + "      MM   \n" + "      MM \n");
            printSimpleTime.put("5", " M****** \n" + ".M       \n" + "|bMMAg.  \n" + "     `Mb \n" + "      jM \n" + "(O)  ,M9 \n" + " 6mmm9   \n");
            printSimpleTime.put("6", "   .6*\"   \n" + " ,M'      \n" + ",Mbmmm.   \n" + "6M'  `Mb. \n" + "MI     M8 \n" + "WM.   ,M9 \n" + " WMbmmd9  \n");
            printSimpleTime.put("7", "M******A' \n" + "Y     A'  \n" + "     A'   \n" + "    A'    \n" + "   A'     \n" + "  A'      \n" + " A'       \n");
            printSimpleTime.put("8", " ,6*\"*VA. \n" + "dN     V8 \n" + "`MN.  ,g9 \n" + " ,MMMMq.  \n" + "6P   `YMb \n" + "8b    `M9 \n" + "`MmmmmM9  \n");
            printSimpleTime.put("9", " .d*\"*bg. \n" + "6MP    Mb \n" + "YMb    MM \n" + " `MbmmdM9 \n" + "      .M' \n" + "    .d9   \n" + "  m\"'     \n");

            int semiColon = formatTime.indexOf(":");
            String hour = formatTime.substring(0, semiColon);
            String minutes = formatTime.substring(semiColon + 1);

            if(hour.length() > 1)
            {
                System.out.print(printSimpleTime.get(hour.substring(0,1)));
                System.out.print(printSimpleTime.get(hour.substring(1)));
            }
            else
            {
                System.out.print(printSimpleTime.get(hour.substring(0)));
            }

            System.out.print(" gp \n" + " \"\" \n" + "    \n" + " ,, \n" + " db \n");

            System.out.print(printSimpleTime.get(minutes.substring(0, 1)));
            System.out.print(printSimpleTime.get(minutes.substring(1)));

            if (militaryTime == false)
            {
                if(hours < 12)
                {

                    if(AM_orPM == 1)
                    {
                        PMorAM = "PM";
                    }
                }
                else
                {
                    PMorAM = "AM";
                }

                System.out.print(PMorAM);
            }

        }
        public static void main(String[] args)
        {
            Calendar myCal = Calendar.getInstance();
            printSimpleClock(myCal, true);


        }
    }

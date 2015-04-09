package nyc.c4q.ac21.weatherclock;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Access Code 2.1
 * Created by Jaellys Bales on 4/7/15.
 * Project: weatherclock
 *
 * WeatherMakeAni.java
 * ASCII art for all weather conditions.
 */
public class WeatherMakeAni
{
    public static HashMap<String, ArrayList<String>> map() {
        // Hashmap of arraylists, where conditions are keys and arraylists are values.
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        // Each element of an arraylist is a "frame" of the animation.
        // Simple Weather Icons by Daniel Vierich (http://www.danvierich.de/weather/) rendered/animated in Monodraw by me.
        // Given more time, I would have added color and built out additional weather conditions provided by API, commented out below.

        //        ArrayList<String> additional = new ArrayList<String>();
        //        ArrayList<String> atmosphere = new ArrayList<String>();
        //        ArrayList<String> drizzle = new ArrayList<String>();
        //        ArrayList<String> extreme = new ArrayList<String>();
        //        ArrayList<String> snow = new ArrayList<String>();
        //        ArrayList<String> thunderstorm = new ArrayList<String>();

        // With more time, I would have implemented a "clear" for day and night.
        ArrayList<String> clear = new ArrayList<String>();
        clear.add("          **  .        \n" +
                          "    .  *****       +   \n" +
                          "  +   ******    +      \n" +
                          "     *******   .  .    \n" +
                          " . . ********       +  \n" +
                          "     *********   .     \n" +
                          "     ************    . \n" +
                          " +    **************** \n" +
                          "     .  *************  \n" +
                          "          ********     ");
        clear.add("          **  .        \n" +
                          "    .  *****           \n" +
                          "      ******           \n" +
                          "     *******   .  .    \n" +
                          " . . ********          \n" +
                          "     *********   .     \n" +
                          "     ************    . \n" +
                          "      **************** \n" +
                          "     .  *************  \n" +
                          "          ********     ");
        clear.add("          **  .        \n" +
                          "    .  *****       +   \n" +
                          "  +   ******    +      \n" +
                          "     *******   .  .    \n" +
                          " . . ********       +  \n" +
                          "     *********   .     \n" +
                          "     ************    . \n" +
                          " +    **************** \n" +
                          "     .  *************  \n" +
                          "          ********     ");

        ArrayList<String> clouds = new ArrayList<String>();
        clouds.add("                        **               \n" +
                           "            ******   **    **            \n" +
                           "        ***        *** *      **         \n" +
                           "      **               **      **        \n" +
                           "     **                 **        **     \n" +
                           "     **                    **      **    \n" +
                           "   **                        **    **    \n" +
                           "  **                          ** **      \n" +
                           "   **                        **          \n" +
                           "     ***********************             \n");
        clouds.add("                         **               \n" +
                           "             ******   **    **            \n" +
                           "         ***        *** *      **         \n" +
                           "       **               **      **        \n" +
                           "      **                 **        **     \n" +
                           "      **                    **      **    \n" +
                           "    **                        **    **    \n" +
                           "   **                          ** **      \n" +
                           "    **                        **          \n" +
                           "      ***********************             \n");
        clouds.add("                          **               \n" +
                           "              ******   **    **            \n" +
                           "          ***        *** *      **         \n" +
                           "        **               **      **        \n" +
                           "       **                 **        **     \n" +
                           "       **                    **      **    \n" +
                           "     **                        **    **    \n" +
                           "    **                          ** **      \n" +
                           "     **                        **          \n" +
                           "       ***********************             \n");

        ArrayList<String> rain = new ArrayList<String>();
        rain.add("                        **               \n" +
                         "            ******   **    **            \n" +
                         "        ***        *** *      **         \n" +
                         "      **               **      **        \n" +
                         "     **                 **        **     \n" +
                         "     **                    **      **    \n" +
                         "   **                        **    **    \n" +
                         "  **                          ** **      \n" +
                         "   **       ◜◝   ◜◝  ◜◝      **          \n" +
                         "     ******/ /* / /*/ / ****             \n" +
                         "           ◟◞   ◟◞  ◟◞                   \n" +
                         "                                         \n" +
                         "                                         \n" +
                         "                                         \n" +
                         "                                         \n" +
                         "                                         \n" +
                         "                                         \n");
        rain.add("                        **               \n" +
                         "            ******   **    **            \n" +
                         "        ***        *** *      **         \n" +
                         "      **               **      **        \n" +
                         "     **                 **        **     \n" +
                         "     **                    **      **    \n" +
                         "   **                        **    **    \n" +
                         "  **                          ** **      \n" +
                         "   **       ◜◝   ◜◝  ◜◝      **          \n" +
                         "     ******/ /* / /*/ / ****             \n" +
                         "           ◟◞   ◟◞  ◟◞                   \n" +
                         "         ◜◝   ◜◝  ◜◝                     \n" +
                         "        / /  / / / /                     \n" +
                         "        ◟◞   ◟◞  ◟◞                      \n" +
                         "                                         \n" +
                         "                                         \n" +
                         "                                         \n");
        rain.add("                        **               \n" +
                         "            ******   **    **            \n" +
                         "        ***        *** *      **         \n" +
                         "      **               **      **        \n" +
                         "     **                 **        **     \n" +
                         "     **                    **      **    \n" +
                         "   **                        **    **    \n" +
                         "  **                          ** **      \n" +
                         "   **       ◜◝   ◜◝  ◜◝      **          \n" +
                         "     ******/ /* / /*/ / ****             \n" +
                         "           ◟◞   ◟◞  ◟◞                   \n" +
                         "         ◜◝   ◜◝  ◜◝                     \n" +
                         "        / /  / / / /                     \n" +
                         "        ◟◞   ◟◞  ◟◞                      \n" +
                         "            ◜◝                           \n" +
                         "           / /                           \n" +
                         "           ◟◞                            \n");


        // Store it all.
        //        map.put("Additional", additional);
        //        map.put("Atmosphere", atmosphere);
        //        map.put("Drizzle", drizzle);
        //        map.put("Extreme", extreme);
        //        map.put("Snow", snow);
        //        map.put("Thunderstorm", thunderstorm);
        map.put("Clear", clear);
        map.put("Clouds", clouds);
        map.put("Rain", rain);

        return map;

    }
}
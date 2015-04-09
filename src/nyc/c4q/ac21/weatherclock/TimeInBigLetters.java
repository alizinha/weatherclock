package nyc.c4q.ac21.weatherclock;

import java.util.ArrayList;
import java.util.HashMap;



/**
 * Created by c4q-madelyntavarez on 4/6/15.
 */
public class TimeInBigLetters
{
    public static HashMap<String, ArrayList<String>> bigNumbers()
    {

        HashMap<String, ArrayList<String>> printSimpleTime = new HashMap<String, ArrayList<String>>();

        ArrayList<String> zero = new ArrayList<String>();
        zero.add(" .d8888b. ");
        zero.add("d88P  Y88b");
        zero.add("888    888");
        zero.add("888    888");
        zero.add("888    888");
        zero.add("888    888");
        zero.add("Y88b  d88P");
        zero.add(" \"Y8888P\" ");

        ArrayList<String> one = new ArrayList<String>();
        one.add("  d888    ");
        one.add(" d8888    ");
        one.add("   888    ");
        one.add("   888    ");
        one.add("   888    ");
        one.add("   888    ");
        one.add("   888    ");
        one.add(" 8888888  ");

        ArrayList<String> two = new ArrayList<String>();
        two.add(" .d8888b. ");
        two.add("d88P  Y88b");
        two.add("       888");
        two.add("     .d88P");
        two.add(" .od888P\" ");
        two.add("d88P\"     ");
        two.add("888\"      ");
        two.add("888888888 ");

        ArrayList<String> three = new ArrayList<String>();
        three.add(" .d8888b. ");
        three.add("d88P  Y88b");
        three.add("     .d88P");
        three.add("    8888\" ");
        three.add("     \"Y8b.");
        three.add("888    888");
        three.add("Y88b  d88P");
        three.add(" \"Y8888P\" ");

        ArrayList<String> four = new ArrayList<String>();
        four.add("    d8888 ");
        four.add("   d8P888 ");
        four.add("  d8P 888 ");
        four.add(" d8P  888 ");
        four.add("d88   888 ");
        four.add("8888888888");
        four.add("      888 ");
        four.add("      888 ");

        ArrayList<String> five = new ArrayList<String>();
        five.add("888888888 ");
        five.add("888       ");
        five.add("888       ");
        five.add("8888888b. ");
        five.add("     \"Y88b");
        five.add("       888");
        five.add("Y88b  d88P");
        five.add(" \"Y8888P\" ");

        ArrayList<String> six = new ArrayList<String>();
        six.add(" .d8888b. ");
        six.add("d88P  Y88b");
        six.add("888       ");
        six.add("888d888b. ");
        six.add("888P \"Y88b");
        six.add("888    888");
        six.add("Y88b  d88P");
        six.add(" \"Y8888P\" ");

        ArrayList<String> seven = new ArrayList<String>();
        seven.add("8888888888");
        seven.add("      d88P");
        seven.add("     d88P ");
        seven.add("    d88P  ");
        seven.add(" 88888888 ");
        seven.add("  d88P    ");
        seven.add(" d88P     ");
        seven.add("d88P      ");

        ArrayList<String> eight = new ArrayList<String>();
        eight.add(" .d8888b. ");
        eight.add("d88P  Y88b");
        eight.add("Y88b. d88P");
        eight.add(" \"Y88888\" ");
        eight.add(".d8P\"\"Y8b.");
        eight.add("888    888");
        eight.add("Y88b  d88P");
        eight.add(" \"Y8888P\" ");

        ArrayList<String> nine = new ArrayList<String>();
        nine.add(" .d8888b. ");
        nine.add("d88P  Y88b");
        nine.add("888    888");
        nine.add("Y88b. d888");
        nine.add(" \"Y888P888");
        nine.add("       888");
        nine.add("Y88b  d88P");
        nine.add(" \"Y8888P\" ");

        ArrayList<String> colon = new ArrayList<String>();
        colon.add("       ");
        colon.add("       ");
        colon.add("       ");
        colon.add("  d8b  ");
        colon.add("  Y8P  ");
        colon.add("       ");
        colon.add("  d8b  ");
        colon.add("  Y8P  ");

        ArrayList<String> pm = new ArrayList<String>();
        pm.add("8888888b.  888b     d888");
        pm.add("888   Y88b 8888b   d8888");
        pm.add("888    888 88888b.d88888");
        pm.add("888   d88P 888Y88888P888");
        pm.add("8888888P\"  888 Y888P 888");
        pm.add("888        888  Y8P  888");
        pm.add("888        888   \"   888");
        pm.add("888        888       888");

        ArrayList<String> am = new ArrayList<String>();
        am.add("       d8888 888b     d888");
        am.add("      d88888 8888b   d8888");
        am.add("     d88P888 88888b.d88888");
        am.add("    d88P 888 888Y88888P888");
        am.add("   d88P  888 888 Y888P 888");
        am.add("  d88P   888 888  Y8P  888");
        am.add(" d8888888888 888   \"   888");
        am.add("d88P     888 888       888");

        printSimpleTime.put("0", zero);
        printSimpleTime.put("1", one);
        printSimpleTime.put("2", two);
        printSimpleTime.put("3", three);
        printSimpleTime.put("4", four);
        printSimpleTime.put("5", five);
        printSimpleTime.put("6", six);
        printSimpleTime.put("7", seven);
        printSimpleTime.put("8", eight);
        printSimpleTime.put("9", nine);
        printSimpleTime.put("10", colon);
        printSimpleTime.put("11", am);
        printSimpleTime.put("12", pm);

        return printSimpleTime;

    }
}

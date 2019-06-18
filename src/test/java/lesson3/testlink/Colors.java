package lesson3.testlink;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class Colors {

    public static String colorNotRunRegExp="rgb[a]?\\(0, 0, 0, .{1,3}";
    public static String colorPassedRegExp="rgb[a]?\\(0, 100, 0, .{1,3}";
    public static String colorFailedRegExp="rgb[a]?\\(178, 34, 34, .{1,3}";


    {
        statusColor.put("Passed", colorPassedRegExp);
        statusColor.put("Failed", colorFailedRegExp);
        statusColor.put("Not run", colorNotRunRegExp);

    }

    public static Map<String, String> statusColor = new HashMap<String, String>();

}

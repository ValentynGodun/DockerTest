package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private static final String APP_PROP = "/application.properties";
    private static final String HARDCODE_PROP = "/hardcoded.properties";


    public static String loadProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream(APP_PROP));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = "";

        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }

    public static String loadHardcodedProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream(HARDCODE_PROP));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = "";

        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }

}

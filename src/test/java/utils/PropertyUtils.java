package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import enums.ConfigProperties;

public class PropertyUtils {

    private static final Map<String, String> map = new HashMap<>();

    static {
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/configproperties");
            prop.load(fis);

            for (String key : prop.stringPropertyNames()) {
                map.put(key, prop.getProperty(key));  
            }

        } catch (FileNotFoundException e) {
            System.err.println("config.properties file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error while loading properties.");
            e.printStackTrace();
        }
    }

    public static String getConfigProperty(ConfigProperties key) {
        String value = map.get(key.name().toLowerCase());  
        if (value != null) {
            return value;
        } else {
            throw new IllegalArgumentException("Key not found in config.properties: " + key.name().toLowerCase());
        }
    }
    
    
}
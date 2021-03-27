package silny7.uniba.sk.unity.program.configuration;

import java.io.*;
import java.util.Properties;

import static silny7.uniba.sk.unity.program.configuration.ConfigurationFields.*;


public class Configuration {
    private static Properties properties;

    private static final String CONFIG_FILE = "src/system.properties";

    //LOGGING
    public static boolean isLogAll(){ return getBoolean(LOG_ALL, true); }
    public static boolean isLogDeclare(){ return getBoolean(LOG_DECLARE, false); }
    public static boolean isLogInitially(){ return getBoolean(LOG_INITIALLY, false); }
    public static boolean isLogAlways(){ return getBoolean(LOG_ALWAYS, false); }
    public static boolean isLogAssign(){ return getBoolean(LOG_ASSIGN, false); }

    //THREADS
    public static boolean isMultithreading() {return getBoolean(MULTITHREAD, false); }



    private static boolean getBoolean(String propertyName, boolean defaultValue) {
        String propertyValue = properties.getProperty(propertyName);
        if (propertyValue == null) {
            return defaultValue;
        } else {
            return Boolean.parseBoolean(propertyValue);
        }
    }

    private static Integer getInteger(String propertyName, Integer defaultValue) {
        String propertyValue = properties.getProperty(propertyName);
        if (propertyValue == null) {
            return defaultValue;
        } else {
            return Integer.parseInt(propertyValue);
        }
    }

    private static Long getLong(String propertyName, Long defaultValue) {
        String propertyValue = properties.getProperty(propertyName);
        if (propertyValue == null) {
            return defaultValue;
        } else {
            return Long.parseLong(propertyValue);
        }
    }

    public static void loadConfiguration() throws IOException {
        try (InputStream inputProps = new FileInputStream(CONFIG_FILE)){
            properties = new Properties();
            if (inputProps == null) {
                loadDefaultConfig();
            } else {
                properties.load(inputProps);
            }
        }
    }

    private static void loadDefaultConfig() {
        properties = new Properties();
        properties.setProperty(LOG_ALL, "true");
        properties.setProperty(LOG_DECLARE, "false");
        properties.setProperty(LOG_INITIALLY, "false");
        properties.setProperty(LOG_ALWAYS, "false");
        properties.setProperty(LOG_ASSIGN, "false");
        properties.setProperty(MULTITHREAD, "false");
    }

    public static void setProperty(String propertyName, String value){
        properties.setProperty(propertyName, value);
    }

    public static String getProperty(String propertyName){
        if (properties == null) {
            loadDefaultConfig();
        }
        return properties.getProperty(propertyName);
    }

    public static void saveProperties() throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(CONFIG_FILE)){
            properties.store(outputStream, null);
        }
    }
}

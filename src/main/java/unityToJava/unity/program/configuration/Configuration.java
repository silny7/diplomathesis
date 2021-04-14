package unityToJava.unity.program.configuration;

import java.io.*;
import java.util.Properties;


public class Configuration {
    private static Properties properties;

    private static final String CONFIG_FILE = "src/system.properties";


    //LOGGING
    public static boolean isLogAll(){ return getBoolean(ConfigurationFields.LOG_ALL, true); }
    public static boolean isLogDeclarations(){ return getBoolean(ConfigurationFields.LOG_DECLARATIONS, false); }
    public static boolean isLogInitializations(){ return getBoolean(ConfigurationFields.LOG_INITIALIZATIONS, false); }
    public static boolean isLogAssignments(){ return getBoolean(ConfigurationFields.LOG_ASSIGNMENTS, false); }

    //THREADS
    public static boolean isMultithreading() {return getBoolean(ConfigurationFields.MULTITHREAD, false); }

    //QUANTIFICATION
    public static Integer getMinValue() { return getInteger(ConfigurationFields.MIN_VALUE, -50); }
    public static Integer getMaxValue() { return getInteger(ConfigurationFields.MAX_VALUE, 50); }


    private static boolean getBoolean(String propertyName, boolean defaultValue) {
        String propertyValue = getProperty(propertyName);
        if (propertyValue == null) {
            return defaultValue;
        } else {
            return Boolean.parseBoolean(propertyValue);
        }
    }

    private static Integer getInteger(String propertyName, Integer defaultValue) {
        String propertyValue = getProperty(propertyName);
        if (propertyValue == null) {
            return defaultValue;
        } else {
            return Integer.parseInt(propertyValue);
        }
    }

    private static Long getLong(String propertyName, Long defaultValue) {
        String propertyValue = getProperty(propertyName);
        if (propertyValue == null) {
            return defaultValue;
        } else {
            return Long.parseLong(propertyValue);
        }
    }

    public static void loadConfiguration() throws IOException {
        try (InputStream inputProps = new FileInputStream(CONFIG_FILE)){
            properties = new Properties();
            properties.load(inputProps);
        }
    }

    protected static void loadDefaultConfig() {
        properties = new Properties();
        properties.setProperty(ConfigurationFields.LOG_ALL, "true");
        properties.setProperty(ConfigurationFields.LOG_DECLARATIONS, "false");
        properties.setProperty(ConfigurationFields.LOG_INITIALIZATIONS, "false");
        properties.setProperty(ConfigurationFields.LOG_ASSIGNMENTS, "false");
        properties.setProperty(ConfigurationFields.MULTITHREAD, "false");
        properties.setProperty(ConfigurationFields.MIN_VALUE, "-50");
        properties.setProperty(ConfigurationFields.MAX_VALUE, "50");
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

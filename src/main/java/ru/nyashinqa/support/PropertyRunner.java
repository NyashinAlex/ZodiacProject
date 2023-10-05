package ru.nyashinqa.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyRunner {
    private static PropertyRunner propertyRunner;
    private final Properties properties;

    private PropertyRunner() {
        properties = new Properties();
        InputStream fileInputStream;
        try {
            String env = System.getenv("env");
            env = (env != null) ? env : System.getProperty("env");
            if (env == null) {
                env = "st";
            }
            fileInputStream = getClass().getClassLoader().getResourceAsStream("properties/env_config.properties");
            properties.load(fileInputStream);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static PropertyRunner getInstance() {
        if (propertyRunner == null) {
            propertyRunner = new PropertyRunner();
        }
        return propertyRunner;
    }

    public String getProperty(EnvironmentSettings key) {
        return properties.getProperty(key.name());
    }
}

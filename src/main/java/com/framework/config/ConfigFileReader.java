package com.framework.config;

import com.framework.enums.DriverType;
import com.framework.enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final Properties properties;
    private final String filePath;

    public ConfigFileReader() {
        filePath = String.format("%s/src/main/resources/config-%s.properties",
                System.getProperty("user.dir"), System.getProperty("env"));

        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            properties = new Properties();
            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException("Unable to load properties.");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties not found at " + filePath);
        }
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("applicationUrl");
        if (url != null) return url;
        else throw new RuntimeException(String.format("url not specified in the %s file.", filePath));
    }

    public DriverType getBrowser() {
        String browser = System.getenv("browser") == null
                ? properties.getProperty("browser")
                : System.getenv("browser");

        return DriverType.valueOf(browser.toUpperCase());
    }

    public EnvironmentType getEnvironment() {
        String envType = System.getenv("envType") == null
                ? properties.getProperty("envType")
                : System.getenv("envType");

        return EnvironmentType.valueOf(envType.toUpperCase());
    }
}

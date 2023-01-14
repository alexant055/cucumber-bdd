package com.framework.managers;

import com.framework.config.ConfigFileReader;

public class FileReadManager {
    private static final FileReadManager fileReadManager = new FileReadManager();
    private static ConfigFileReader configFileReader;

    private FileReadManager() {
    }

    public static FileReadManager getInstance() {
        return fileReadManager;
    }

    public ConfigFileReader getConfigReader() {
        return configFileReader = (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }
}

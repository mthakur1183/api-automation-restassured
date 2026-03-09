package com.api.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {


    private  static Properties prop = new Properties();

    private ConfigManager(){
//        to prevent accidental instantiation of  this class
    }

    static {
        try {
            FileInputStream fs = new FileInputStream("src/main/resources/config.properties");
            prop.load(fs);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

        public static String get(String key)
        {
           return prop.getProperty(key);
        }

    }


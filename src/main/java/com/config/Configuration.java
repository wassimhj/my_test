package com.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    public static String getProperties(String Key) throws IOException {
        Properties prop = new Properties();
        String projectPath = System.getProperty("user.dir");

        FileInputStream inputStream;
        try {

            inputStream = new FileInputStream(projectPath + File.separator + "src" + File.separator + "test"
                    + File.separator + "app.properties");
            prop.load(inputStream);
        } catch (FileNotFoundException e) {

            System.out.println("File Not Found ");
        }

        return prop.getProperty(Key);
    }
}

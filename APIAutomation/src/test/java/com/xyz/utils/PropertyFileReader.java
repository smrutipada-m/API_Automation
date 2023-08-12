package com.xyz.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

    static Properties readProps;

    public static String getPropertyValue(String propKey, String fileName) {
        readProps = new Properties();
        String propValue;
        System.out.println("Current Directory --> " + System.getProperty("user.dir"));
        try {
            readProps.load(new FileReader(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName)));
            propValue = readProps.getProperty(propKey);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return propValue;
    }
}

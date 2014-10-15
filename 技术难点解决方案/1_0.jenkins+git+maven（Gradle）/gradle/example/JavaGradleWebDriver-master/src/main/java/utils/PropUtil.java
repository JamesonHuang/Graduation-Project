package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {
    private static String configFileRelativePath = "/src/main/resources/config.properties";
    private static String baseDir = System.getProperty("user.dir");
    public static Properties properties;



    public static String getPropertyValue(String name){
        properties = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream(baseDir + configFileRelativePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return properties.getProperty(name);
    }
}

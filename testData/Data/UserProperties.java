package Data;

import commons.GlobalConstants;

import java.io.*;
import java.util.Properties;

public class UserProperties {

    public static void main(String[] args) {
        try (InputStream input = new FileInputStream(GlobalConstants.DATA_TEST_PATH+"user.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("firstName"));
            System.out.println(prop.getProperty("lastName"));
            System.out.println(prop.getProperty("company"));
            System.out.println(prop.getProperty("password"));
            System.out.println(prop.getProperty("email"));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}



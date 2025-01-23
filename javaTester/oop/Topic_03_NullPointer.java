package oop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_03_NullPointer {
    WebDriver driver;

    @Test
    public void testNullPointer(){
        //driver = new FirefoxDriver();
        System.out.println(driver.toString());

    }

}

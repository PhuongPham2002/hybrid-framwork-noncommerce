package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.Random;

/**
 * Dùng hàm common cho tầng testcase: đóng/mở browser, layer testcase sẽ kế thừa từ baseTest
 *
 */

public class BaseTest {
    private WebDriver driver;
    protected WebDriver getBrowserDriver(String browserName,String urlValue){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get(urlValue);
        return driver;
    }
    protected int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    protected int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(10000);
    }

    protected void verifyTrue(boolean condition){
        try {
            Assert.assertTrue(condition);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    protected void verifyFalse(boolean condition){

    }
    protected void verifyEqual(Object actual, Object expected ){

    }
}

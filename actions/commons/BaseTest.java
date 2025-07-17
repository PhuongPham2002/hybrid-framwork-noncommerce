package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;

/**
 * Dùng hàm common cho tầng testcase: đóng/mở browser, layer testcase sẽ kế thừa từ baseTest
 *
 */

public class BaseTest {
    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;
    protected final Logger log;

    public BaseTest(){

        log = LogManager.getLogger(getClass());
    }
    protected WebDriver getBrowserDriver(String browserName,String urlValue){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        Path path = null;
        File extensionFilePath = null;
        switch (browserList){
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--lang=vi");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get(urlValue);
        System.out.println(urlValue);
        return driver;
    }

    private String getUrlByEnvironmentName(String environmentName) {
            String url;
            switch (environmentName){
                case "dev":
                    url = "https://demo.nopcommerce.com/";
                    break;
                case "test":
                    url = "https://testing.nopcommerce.com/";
                    break;
                case "staging":
                    url = "https://staging.nopcommerce.com/";
                default:
                    throw new RuntimeException("Environment name is not valid");
            }
        return url;
    }


    protected int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    protected int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(10000);
    }

    protected boolean verifyTrue(boolean condition){
        boolean status = true;
        try {
            Assert.assertTrue(condition);
            log.info("------------------- PASSED-------------");
        } catch (Throwable e) {
            status = false;
            log.info("---------FAILED---------");

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
    protected boolean verifyFalse(boolean condition){
        boolean status = true;

        try {
            Assert.assertFalse(condition);
            log.info("------------------- PASSED-------------");
        } catch (Throwable e) {
            status = false;
            log.info("---------FAILED---------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;

    }
    protected boolean verifyEqual(Object actual, Object expected ){
        boolean status = true;
        try {
            Assert.assertEquals(actual,expected);
            log.info("------------------- PASSED-------------");
        } catch (Throwable e) {
            status = false;
            log.info("------------------- FAILED-------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;

    }

    @BeforeSuite
    public void deleteReportFolder(){
            deleteAllFileInFolder("htmlReportNG");
            deleteAllFileInFolder("allure-results");
            //deleteAllFileInFolder("htmlAllure");

    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



  }



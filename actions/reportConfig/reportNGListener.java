package reportConfig;

import commons.BaseTest;
import commons.GlobalConstants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class reportNGListener extends BaseTest implements ITestListener  {

    @Override
    public void onTestStart(ITestResult result) {}

    @Override
    public void onTestSuccess(ITestResult result) {}

    @Override
    public void onTestSkipped(ITestResult result) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}

    @Override
    public void onTestFailure(ITestResult result) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        String screenshotPath = captureScreenshot(driver, result.getName());
        Reporter.getCurrentTestResult();
        Reporter.log("<br><a target=\"_blank\" href=\"data:image/png;base64," + screenshotPath + "\">" + "<img src=\"data:image/png;base64," + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
        Reporter.setCurrentTestResult(null);

    }
    public String captureScreenshot(WebDriver driver, String screenshotName) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        }

}

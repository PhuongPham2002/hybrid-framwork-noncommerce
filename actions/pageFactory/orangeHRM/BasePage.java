package pageFactory.orangeHRM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    private long LONG_TIMEOUT =30;
    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }
    public String getPageTitle (WebDriver driver) {
        return driver.getTitle();
    }
    public String getCurrentPageUrl (WebDriver driver) {
        return driver.getCurrentUrl();
    }
    public String getPageSource (WebDriver driver){
        return driver.getPageSource();
    }
    public void backToPage (WebDriver driver){
        driver.navigate().back();
    }
    public void forwardToPage (WebDriver driver){
        driver.navigate().forward();
    }
    public void refreshPage (WebDriver driver) {
        driver.navigate().refresh();
    }
    public Alert waitToAlertPresence (WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert (WebDriver driver) {
        waitToAlertPresence(driver).accept(); // có cơ chế wait
        driver.switchTo().alert().accept(); // không có cơ chế wait
    }
    public void cancelAlert (WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }
    public void sendkeyToAlert (WebDriver driver, String valueToSend) {
        driver.switchTo().alert().sendKeys(valueToSend);}
    public String getAlertText (WebDriver driver) {
        return driver.switchTo().alert().getText();}
    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }
    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }
    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
    private By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public void clickElement (WebElement element) {
        element.click();
    }
    public void sendKeyToElement (WebElement element, String valueToSend){
        element.clear();
        element.sendKeys(valueToSend);
    }
    public List<WebElement> getListWebElement (WebDriver driver, String locator){
        return driver.findElements(getByXpath(locator));
    }
    public String getElementText (WebElement element)
    {
        return element.getText();
    }
    public String getCssValue(WebElement element,String propertyName){
        return element.getCssValue(propertyName);

    }

    public WebElement waitForElementClickable(WebDriver driver, WebElement element){
        return new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementVisible(WebDriver driver, WebElement element){
        return new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.visibilityOf(element));}
}

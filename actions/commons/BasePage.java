package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.jQuery.HomepageUI;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.orangeHRM.BasePUI;
import pageUIs.orangeHRM.pim.employee.PersonalDetailPUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * Phần dùng chung cho các pageObject - thao tác trên page đó có hành động gì (vd: nhập textbox, getID, dashboard có hành động gì?,
 * click. get dữ liệu...)
 *
 */

public class BasePage {
    public static BasePage getBasePage(){
        return new BasePage();
    }
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
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
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
    public String castParameter (String locator, String...restParameter){

        return String.format(locator, (Object[]) restParameter);

    }
    //Truyền tham số vào loại gì sẽ trả về kiểu By tương ứng.
    // String prefix: css/id/name/class --> By.css/By.id/By.name/...
    //Convention: css/Css/CSS- ID/id/Id/iD
    // Css = button#login
    //CSS = button#login  --> By.cssSelector("button#login");
    public By getByLocator(String prefixLocator) {
        By by = null;
        if ((prefixLocator.toLowerCase().startsWith("id") )) {
            by = By.id(prefixLocator.substring(3));}
        else if ((prefixLocator.toLowerCase().startsWith("class") )) {
            by = By.className(prefixLocator.substring(6));}
        else if ((prefixLocator.toLowerCase().startsWith("name")) ){
            by = By.name(prefixLocator.substring(5));}
        else if ((prefixLocator.toLowerCase().startsWith("tagname") )) {
            by = By.tagName(prefixLocator.substring(8));}
        else if ((prefixLocator.toLowerCase().startsWith("xpath"))) {
            by = By.xpath(prefixLocator.substring(6));}
        else if ((prefixLocator.toLowerCase().startsWith("css")) ){
            by = By.cssSelector(prefixLocator.substring(4));}
        else {
            throw new RuntimeException("Locator type is not support!!!");
        }
        
        return by;

    }

    public WebElement getWebElement (WebDriver driver, String locator){
       return driver.findElement(getByLocator(locator));
    }
    public List<WebElement> getListWebElement (WebDriver driver, String locator){
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListWebElement (WebDriver driver, String locator, String...restParameter){
        return driver.findElements(getByLocator(castParameter(locator,restParameter)));
    }
    //Click vào 1 element cố định
    public void clickToElement (WebDriver driver, String locator){
       getWebElement(driver,locator).click();
    }
    //Click vào elements động
    public void clickToElement(WebDriver driver,String locator,String...restParameter){
        getWebElement(driver,castParameter(locator,restParameter)).click();
    }
    public void sendkeyToElement(WebDriver driver, String locator, String valueToSend){
        sleepInSecond(1);
        getWebElement(driver, locator).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        sleepInSecond(1);
        getWebElement(driver,locator).sendKeys(valueToSend);
    }

    public void sendkeyToElement(WebDriver driver, String locator, String valueToSend, String...restParameter){
        getWebElement(driver, castParameter(locator,restParameter)).clear();
        getWebElement(driver,castParameter(locator,restParameter)).sendKeys(valueToSend);
    }


    public void selectItemDropdown (WebDriver driver, String locator, String textItem){
        new Select(getWebElement(driver,locator)).selectByVisibleText(textItem);
    }
    public void selectItemDropdown (WebDriver driver, String locator, String textItem, String...restParameter){
        new Select(getWebElement(driver,castParameter(locator,restParameter))).selectByVisibleText(textItem);
    }
    public String getSelectedItemInDropdown (WebDriver driver, String locator){
        return new Select(getWebElement(driver,locator)).getFirstSelectedOption().getText();
    }
    public boolean isDropdownMultiple(WebDriver driver,String locator){
        return new Select(getWebElement(driver,locator)).isMultiple();
    }
    public String getAttributeValue(WebDriver driver, String locator, String attributeName){
        return getWebElement(driver,locator).getDomProperty(attributeName);
    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName, String...restParameter){
        return getWebElement(driver,castParameter(locator,restParameter)).getDomProperty(attributeName);
    }
    public String getCSSValue(WebDriver driver, String locator, String propertyName){
        return getWebElement(driver,locator).getCssValue(propertyName);
    }
    public void selectItemInCustomDropdown(WebDriver driver, String optionsOpenXpath,String optionsXpath,String textOption){
        waitForElementClickable(driver,optionsOpenXpath).click();
        List <WebElement> allOptions = waitForListElementPresence(driver,optionsXpath);
        for(WebElement option :allOptions){
            if (option.getText().equals(textOption)){
                option.click();
                break;
            }
        }
    }
    public String getElementText (WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }
    public String getCssValue(WebDriver driver, String locator,String propertyName){
        return getWebElement(driver,locator).getCssValue(propertyName);

    }
    public String getHexaColorFromRGBA(String rgbaValue){
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }
    public int getListElementSize(WebDriver driver, String locator){
        return getListWebElement(driver,locator).size();
    }
    public int getListElementSize(WebDriver driver, String locator,String...restParameter){
        return getListWebElement(driver,castParameter(locator,restParameter)).size();
    }
    public void checkToCheckboxOrRadio(WebDriver driver, String locator){
        if (!getWebElement(driver,locator).isSelected()){
            getWebElement(driver, locator).click();}
    }
    public void checkToCheckboxOrRadio(WebDriver driver, String locator, String...restParamater){
        if (!getWebElement(driver,castParameter(locator,restParamater)).isSelected()){
            getWebElement(driver, castParameter(locator,restParamater)).click();}
    }
    public void uncheckTheCheckbox(WebDriver driver, String locator){
        if (getWebElement(driver,locator).isSelected()){
            getWebElement(driver,locator).click();}
    }
    public void uncheckTheCheckbox(WebDriver driver, String locator,String...restParameter){
        if (getWebElement(driver,castParameter(locator,restParameter)).isSelected()){
            getWebElement(driver,castParameter(locator,restParameter)).click();}
    }
    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getWebElement(driver,locator).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String...restParameter) {
        return getWebElement(driver,castParameter(locator,restParameter)).isDisplayed();
    }
    public boolean isElementSelected (WebDriver driver, String locator){
        return getWebElement(driver,locator).isSelected();
    }
    public boolean isElementEnable (WebDriver driver, String locator){
        return getWebElement(driver,locator).isEnabled();
    }
    public void switchToIframe(WebDriver driver, String locator){
        driver.switchTo().frame(getWebElement(driver,locator));
    }
    public void switchToDefaultContent(WebDriver driver, String locator){
        driver.switchTo().defaultContent();
    }
    public boolean waitAttributeTobe(WebDriver driver, String locator,String currentValue, String expectedValue){
      return new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.not(ExpectedConditions.attributeToBe(getByLocator(locator),currentValue,expectedValue)));
    }
    public WebElement waitForElementVisible(WebDriver driver, String locator){
        return new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public WebElement waitForElementVisible(WebDriver driver, String locator,String...restParameter){
        return new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator,restParameter))));
    }

    public void waitForElementAttribute(WebDriver driver, String locator,String attributeName, String attributeValue,String...restParameter){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.attributeToBe(getByLocator(castParameter(locator,restParameter)),attributeName, attributeValue));
    }


    public List <WebElement> waitForListElementVisible (WebDriver driver, String locator){
        return new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
    }
    public boolean waitForElementInvisible (WebDriver driver, String locator){
        return new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }
    public boolean waitForListElementInvisible (WebDriver driver, String locator) {
        return new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver,locator)));
    }
    public WebElement waitForElementClickable(WebDriver driver, String locator){
        return new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }
    public WebElement waitForElementClickable(WebDriver driver, String locator,String...restParameter){
        return new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator,restParameter))));
    }
    public boolean waitForElementSelected(WebDriver driver, String locator,String...restParameter){
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator,restParameter))));
    }
    public WebElement waitForElementPresence (WebDriver driver, String locator){
        return new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }
    public List <WebElement> waitForListElementPresence (WebDriver driver, String locator){
        return new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
    }
    public void switchToIframe(WebDriver driver, WebElement iframeElement){
        driver.switchTo().frame(iframeElement);
    }
    public void switchToDefaultContent (WebDriver driver){
        driver.switchTo().defaultContent();
    }
    public void hoverToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(getWebElement(driver,locator)).perform();
    }
    public void doubleClickToElement(WebDriver driver, String locator){
        new Actions(driver).doubleClick(getWebElement(driver,locator)).perform();
    }

    public void rightClick(WebDriver driver, String locator){
        new Actions(driver).contextClick(getWebElement(driver,locator)).perform();
    }

    public void scrollToElement(WebDriver driver, String locator){
        new Actions(driver).scrollToElement(getWebElement(driver,locator)).perform();
    }

    public void pressKeyBoardToElement(WebDriver driver, String locator, Keys key){
        new Actions(driver).sendKeys(getWebElement(driver,locator),key).perform();
    }
    public void pressKeyBoardToElement(WebDriver driver, String locator, Keys key, String...restParameter){
        new Actions(driver).sendKeys(getWebElement(driver,castParameter(locator, restParameter)),key).perform();
    }

    public String getDomain(WebDriver driver){
        return (String) ((JavascriptExecutor) driver).executeScript("return document.domain;");
    }
    public String getInnerText(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
        sleepInSecond(3);

    }
    public void highlightElement(WebDriver driver,String locator) {
        WebElement element = getWebElement(driver,locator);
        String originalStyle = element.getDomAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver,locator));
        sleepInSecond(3);
    }
    public void scrollToElementOnTop(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver,locator));
    }

    public void scrollToElementToDown(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver,locator));
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public void setAttributeInDOM(WebDriver driver,String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getWebElement(driver,locator));
    }

    public void removeAttributeInDOM(WebDriver driver,String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver,locator));
    }

    public void sendKeyToElementByJS(WebDriver driver,String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver,locator));
    }

    public String getAttributeInDOM(WebDriver driver,String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver,locator));
    }

    public String getElementValidationMessage(WebDriver driver,String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver,locator));
    }

    public boolean isImageLoaded(WebDriver driver,String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver,locator));
    }

    public void uploadMultipleFiles (WebDriver driver, String...fileNames) {
        //Lấy ra đươờng dẫn của thư mục upload file
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        //Dùng vòng lặp duyệt qua các filename
        for (String file:fileNames) {
            fullFileName += filePath +file+"\n";  // mình cần gửi key vào thẻ input là 1 danh sách các đường dẫn nên phải nối các đường dẫn đó lại
        }
        fullFileName = fullFileName.trim();  //cắt ký tự xuống dòng ở 2 đầu chuỗi đi
        getWebElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);

    }

    public void enterTextboxByID(WebDriver driver, String textboxID, String value ){
        waitForElementVisible(driver,BasePageUI.TEXTBOX_BY_ID,textboxID);
        sendkeyToElement(driver,BasePageUI.TEXTBOX_BY_ID,value,textboxID);
    }


    public void clickButtonText(WebDriver driver,String buttonText) {
        waitForElementVisible(driver,BasePageUI.BUTTON_BY_TEXT,buttonText);
        clickToElement(driver,BasePageUI.BUTTON_BY_TEXT,buttonText);
    }

    public String getTexboxValueByID(WebDriver driver, String textboxID) {

        waitForElementVisible(driver,BasePageUI.TEXTBOX_BY_ID,textboxID);
        return getAttributeValue(driver,BasePageUI.TEXTBOX_BY_ID,"value",textboxID);
    }

    public Set<Cookie> getAllCookies (WebDriver driver){
        return driver.manage().getCookies();
    }

    public void setCookies(WebDriver driver,Set<Cookie> cookies){
        for (Cookie cookie:cookies){
            driver.manage().addCookie(cookie);
        }
        sleepInSecond(5);
    }

    public boolean waitAllLoadingIconInvisible(WebDriver driver) {
        return waitForListElementInvisible(driver, BasePUI.LOADING_ICON);}

    public boolean isSuccessMessageDisplayed(WebDriver driver) {
        waitForElementVisible(driver, BasePUI.SUCCESSFUL_MESSAGE_PROFILE);
        return isElementDisplayed(driver,BasePUI.SUCCESSFUL_MESSAGE_PROFILE);

    }
}





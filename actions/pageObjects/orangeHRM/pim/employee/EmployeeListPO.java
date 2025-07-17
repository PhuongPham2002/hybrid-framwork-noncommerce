package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerator;
import pageUIs.orangeHRM.pim.employee.EmployeeListPUI;

public class EmployeeListPO extends BasePage {
    WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    public AddNewPO clickAddEmployeeButton() {
        String browser = driver.toString();
        String locator = null;
        if (browser.contains("chromedriver")){
            locator = EmployeeListPUI.CHROME_ADD_NEW_LINK;
        } else if (browser.contains("firefoxdriver")) {
            locator = EmployeeListPUI.FIREFOX_ADD_NEW_LINK;
        } else {
            locator = EmployeeListPUI.EDGE_ADD_NEW_LINK;
        }
        waitForElementClickable(driver, locator);
        clickToElement(driver,locator);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getAddNewPage(driver);
    }
}

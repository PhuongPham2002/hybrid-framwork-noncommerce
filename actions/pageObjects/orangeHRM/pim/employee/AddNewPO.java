package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerator;
import pageUIs.orangeHRM.pim.employee.AddNewPUI;
import pageUIs.orangeHRM.pim.employee.EmployeeListPUI;
import pageUIs.orangeHRM.pim.employee.PersonalDetailPUI;
import pojo.UserInfo;

public class AddNewPO extends BasePage {
    WebDriver driver;

    public AddNewPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstnameTextbox(String firstname) {
        waitForElementVisible(driver, AddNewPUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver,AddNewPUI.FIRSTNAME_TEXTBOX,firstname);
    }

    public void enterLastnameTextbox(String lastname) {
        waitForElementVisible(driver, AddNewPUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver,AddNewPUI.LASTNAME_TEXTBOX,lastname);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver,AddNewPUI.EMPLOYEE_ID_TEXT);
        return getAttributeValue(driver,AddNewPUI.EMPLOYEE_ID_TEXT,"value");

    }

    public PersonalDetailsPO clickSaveButtonEmployeeContainer() {
        waitForElementClickable(driver,AddNewPUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        clickToElement(driver,AddNewPUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailPage(driver);
    }

    public void enterEmployeeInfo(UserInfo userInfo) {
        enterFirstnameTextbox(userInfo.getFirstName());
        enterLastnameTextbox (userInfo.getLastName());
    }
}

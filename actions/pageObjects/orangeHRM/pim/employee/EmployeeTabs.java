package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerator;
import pageUIs.orangeHRM.pim.employee.EmployeeTabsUI;
import pageUIs.orangeHRM.pim.employee.PersonalDetailPUI;

public class EmployeeTabs extends BasePage {
    WebDriver driver;
    public EmployeeTabs(WebDriver driver) {
        this.driver = driver;
    }
    public PersonalDetailsPO openPersonalDetailsPage(String pageName){
        waitForElementClickable(driver, EmployeeTabsUI.EMPLOYEE_NAVIGATION_LINK,pageName);
        clickToElement(driver,EmployeeTabsUI.EMPLOYEE_NAVIGATION_LINK,pageName);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailPage(driver);
    }
    public ContactDetailsPO openContactDetailsPage(String pageName){
        waitForElementClickable(driver, EmployeeTabsUI.EMPLOYEE_NAVIGATION_LINK,pageName);
        clickToElement(driver,EmployeeTabsUI.EMPLOYEE_NAVIGATION_LINK,pageName);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getContactDetailsPage(driver);
    }

    public EmergencyContactsPO openEmergencyContactPO (String pageName){
        waitForElementClickable(driver, EmployeeTabsUI.EMPLOYEE_NAVIGATION_LINK,pageName);
        clickToElement(driver,EmployeeTabsUI.EMPLOYEE_NAVIGATION_LINK,pageName);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmergencyContactsPage(driver);
    }
}

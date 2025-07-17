package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.employee.EmployeeListPO;
import pageUIs.orangeHRM.pim.employee.EmployeeListPUI;

public class DashboardPO extends BasePage {
    WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeeListPO clickPIMPage() {
        waitForElementClickable(driver, EmployeeListPUI.PIM_LINK);
        clickToElement(driver,EmployeeListPUI.PIM_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmployeePage(driver);
    }
}

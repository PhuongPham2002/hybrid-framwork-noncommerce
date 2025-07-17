package pageObjects.orangeHRM.pim.employee;

import org.openqa.selenium.WebDriver;


public class ContactDetailsPO extends EmployeeTabs{
    WebDriver driver;
    public ContactDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}

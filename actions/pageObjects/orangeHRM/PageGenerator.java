package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.employee.*;
import pageUIs.orangeHRM.LoginPageUI;

public class PageGenerator {

    public static LoginPO getLoginPage (WebDriver driver) {
        return new LoginPO(driver);
    }

    public static DashboardPO getDashboardPage (WebDriver driver){
        return new DashboardPO(driver);
    }

    public static AddNewPO getAddNewPage (WebDriver driver) {
        return new AddNewPO(driver);
    }

    public static ContactDetailsPO getContactDetailsPage (WebDriver driver) {
        return new ContactDetailsPO(driver);
    }

    public  static EmployeeListPO getEmployeePage (WebDriver driver) {
        return new EmployeeListPO(driver);
    }

    public static PersonalDetailsPO getPersonalDetailPage (WebDriver driver) {
        return new PersonalDetailsPO(driver);
    }

    public static EmergencyContactsPO getEmergencyContactsPage (WebDriver driver) {
        return new EmergencyContactsPO(driver);
    }
}

package pageObjects.saucelabs;

import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.DashboardPO;
import pageObjects.orangeHRM.LoginPO;
import pageObjects.orangeHRM.pim.employee.*;

public class PageGenerator {

    public static LoginPageObject getLoginPage (WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static InventoryPageObject getInventoryPageObjet (WebDriver driver){
        return new InventoryPageObject(driver);
    }

}

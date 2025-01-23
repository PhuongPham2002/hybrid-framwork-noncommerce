package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.Admin.AdminDashboardPO;
import pageObjects.nopCommerce.Admin.AdminLoginPO;
import pageObjects.nopCommerce.Users.*;

public class PageGenerator {
    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }

}

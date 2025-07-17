package pageObjects.nopCommerce.Users;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class UserAddressPO extends UserSidebarBasePage {
    private WebDriver driver;

    public UserAddressPO(WebDriver driver) {
        this.driver = driver;
    }
}

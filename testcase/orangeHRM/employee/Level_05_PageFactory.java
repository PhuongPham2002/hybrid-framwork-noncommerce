package orangeHRM.employee;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.orangeHRM.DashboardPageFactory;
import pageFactory.orangeHRM.LoginPageFactory;


public class Level_05_PageFactory extends BaseTest {
    private WebDriver driver;
    private LoginPageFactory loginPage;
    String username, password;
    private DashboardPageFactory dashboardPage;

    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String urlValue,String browserName) {
        driver = getBrowserDriver(urlValue, browserName);
        loginPage = new LoginPageFactory(driver);
        username ="Admin";
        password ="admin123";
    }
    @Test
    public void TC_01_Login() {
        loginPage.enterUsernameTextbox(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        dashboardPage = new DashboardPageFactory(driver);
    }
    @Test
    public void TC_02_New_Employee() {



    }

    @Test
    public void TC_03_MyAccount_Personal_Detail() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }




}

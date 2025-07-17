package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageUIs.orangeHRM.pim.employee.PersonalDetailPUI;
import pojo.UserInfo;

public class PersonalDetailsPO extends EmployeeTabs {
    WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Dimension getAvatarSize() {
        return waitForElementVisible(driver,PersonalDetailPUI.AVATAR_IMAGE).getSize();
    }


    public void clickAvatarImage() {
        waitForElementVisible(driver,PersonalDetailPUI.AVATAR_IMAGE);
        clickToElement(driver,PersonalDetailPUI.AVATAR_IMAGE);
    }

    public void clickSaveButtonAtProfilePictureContainer() {
        waitForElementClickable(driver, PersonalDetailPUI.SAVE_BUTTON_PROFILE);
        clickToElement(driver,PersonalDetailPUI.SAVE_BUTTON_PROFILE);
    }

    public boolean isProfileAvatarUpdateSuccessful(Dimension beforeUpload) {
        sleepInSecond(3);
        Dimension afterUpload = getAvatarSize();
       return !beforeUpload.equals(afterUpload);
    }

    public void enterDateOfBirthTextbox(String valueToSend) {
        waitForElementVisible(driver,PersonalDetailPUI.DATE_OF_BIRTH_TEXTBOX);
        sendkeyToElement(driver,PersonalDetailPUI.DATE_OF_BIRTH_TEXTBOX,valueToSend);


    }

    public void enterFirstNameTextbox(String valueToSend) {
        waitForElementVisible(driver,PersonalDetailPUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver,PersonalDetailPUI.FIRSTNAME_TEXTBOX,valueToSend);
    }

    public void enterLastNameTextbox(String valueToSend) {
        waitForElementVisible(driver,PersonalDetailPUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver,PersonalDetailPUI.LASTNAME_TEXTBOX,valueToSend);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver,PersonalDetailPUI.EMPLOYEE_ID_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailPUI.EMPLOYEE_ID_TEXTBOX,"value");
    }

    public void enterExpiryDateTextbox(String valueToSend) {
        waitForElementVisible(driver,PersonalDetailPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        sendkeyToElement(driver,PersonalDetailPUI.LICENSE_EXPIRY_DATE_TEXTBOX,valueToSend);
    }

    public void enterDriverLicenseTextbox(String valueToSend) {
        waitForElementVisible(driver,PersonalDetailPUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
        sendkeyToElement(driver,PersonalDetailPUI.DRIVER_LICENSE_NUMBER_TEXTBOX,valueToSend);

    }

    public void selectNationalityDropdown(String nation) {
        selectItemInCustomDropdown(driver,PersonalDetailPUI.NATIONALITY_DROPDOWN_ICON,PersonalDetailPUI.NATIONALITY_DROPDOWN_OPTIONS,nation);
    }

    public void selectMaritalStatusDropdown(String status) {
        selectItemInCustomDropdown(driver,PersonalDetailPUI.MARITAL_STATUS_DROPDOWN_ICON,PersonalDetailPUI.MARITAL_STATUS_DROPDOWN_OPTIONS,status);

    }

    public void selectGenderFemaleRadio() {
        waitForElementClickable(driver,PersonalDetailPUI.FEMALE_RADIO_BUTTON);
        clickToElement(driver,PersonalDetailPUI.FEMALE_RADIO_BUTTON);
    }

    public void clickSaveButtonAtPersonalDetailContainer() {
        waitForElementClickable(driver,PersonalDetailPUI.SAVE_BUTTON_AT_EMPLOYEE);
        clickToElement(driver,PersonalDetailPUI.SAVE_BUTTON_AT_EMPLOYEE);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver,PersonalDetailPUI.FIRSTNAME_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailPUI.FIRSTNAME_TEXTBOX,"value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver,PersonalDetailPUI.LASTNAME_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailPUI.LASTNAME_TEXTBOX,"value");
    }

    public String getDriverLicenseTextbox() {
        waitForElementVisible(driver,PersonalDetailPUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailPUI.DRIVER_LICENSE_NUMBER_TEXTBOX,"value");
    }

    public String getExpiryDateTextbox() {
        waitForElementVisible(driver,PersonalDetailPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailPUI.LICENSE_EXPIRY_DATE_TEXTBOX,"value");

    }

    public String getNationalityDropdown() {
     waitForElementVisible(driver,PersonalDetailPUI.NATIONALITY_DROPDOWN_SELECTED_OPTION);
     return getElementText(driver,PersonalDetailPUI.NATIONALITY_DROPDOWN_SELECTED_OPTION);
    }

    public String getMaritalStatusDropdown() {
        waitForElementVisible(driver,PersonalDetailPUI.MARITAL_STATUS_DROPDOWN_SELECTED_OPTION);
        return getElementText(driver,PersonalDetailPUI.MARITAL_STATUS_DROPDOWN_SELECTED_OPTION);
    }

    public String getDateOfBirthTextbox() {
        waitForElementVisible(driver,PersonalDetailPUI.DATE_OF_BIRTH_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailPUI.DATE_OF_BIRTH_TEXTBOX,"value");
    }

    public boolean isGenderFemaleSelected() {
        waitForElementSelected(driver,PersonalDetailPUI.FEMALE_RADIO_BUTTON_VERIFY);
        return isElementSelected(driver,PersonalDetailPUI.FEMALE_RADIO_BUTTON_VERIFY);

    }

    public void enterPersonalDetailsInfo (UserInfo userInfo){
        openPersonalDetailsPage("Personal Details");
        enterFirstNameTextbox(userInfo.getEditFirstname());
        enterLastNameTextbox(userInfo.getEditLastName());
        enterDriverLicenseTextbox(userInfo.getDriverLicense());
        enterExpiryDateTextbox(userInfo.getExpiryDate());
        selectNationalityDropdown(userInfo.getNation());
        selectMaritalStatusDropdown(userInfo.getMaritalStatus());
        enterDateOfBirthTextbox(userInfo.getDateOfBirth());
        selectGenderFemaleRadio();
        clickSaveButtonAtPersonalDetailContainer();
        waitAllLoadingIconInvisible(driver);

    }
}

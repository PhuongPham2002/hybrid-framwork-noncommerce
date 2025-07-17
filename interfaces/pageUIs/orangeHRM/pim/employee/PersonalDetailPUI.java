package pageUIs.orangeHRM.pim.employee;

public class PersonalDetailPUI {
    public static final String AVATAR_IMAGE ="css=div.orangehrm-edit-employee-image img.employee-image";
    public static final String SAVE_BUTTON_PROFILE = "XPATH=//h6[text()='Change Profile Picture']/following-sibling::form/div/button[contains(string(),'Save')]";
    public static final String FIRSTNAME_TEXTBOX ="XPATH=//input[@name='firstName']";
    public static final String LASTNAME_TEXTBOX ="XPATH=//input[@name='lastName']";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String DRIVER_LICENSE_NUMBER_TEXTBOX = "xpath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input";
    public static final String LICENSE_EXPIRY_DATE_TEXTBOX = "xpath=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";
    public static final String NATIONALITY_DROPDOWN_ICON ="XPATH=//label[text()='Nationality']/parent::div/following-sibling::div//i";
    public static final String NATIONALITY_DROPDOWN_OPTIONS ="Xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
    public static final String NATIONALITY_DROPDOWN_SELECTED_OPTION ="XPATH=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String MARITAL_STATUS_DROPDOWN_ICON = "XPATH=//label[text()='Marital Status']/parent::div/following-sibling::div//i";
    public static final String MARITAL_STATUS_DROPDOWN_OPTIONS = "XPATH=//label[text()='Marital Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
    public static final String MARITAL_STATUS_DROPDOWN_SELECTED_OPTION="XPATH=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String DATE_OF_BIRTH_TEXTBOX ="xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
    public static final String FEMALE_RADIO_BUTTON ="xpath=//label[text()='Female']/span";
    public static final String FEMALE_RADIO_BUTTON_VERIFY ="xpath=//label[text()='Female']/input";
    public static final String SAVE_BUTTON_AT_EMPLOYEE ="xpath=//button[contains(string(),'Save')]";






}

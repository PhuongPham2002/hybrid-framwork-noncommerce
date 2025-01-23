package pageObjects.jQuery;

import commons.BasePage;
import graphql.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.HomepageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByNumber(String pageNumber) {
        waitForElementClickable(driver, HomepageUI.DYNAMIC_PAGING, pageNumber);
        clickToElement(driver, HomepageUI.DYNAMIC_PAGING, pageNumber);
        sleepInSecond(2);
    }

    public boolean isPageNumberActivated(String pageNumber) {
        waitForElementClickable(driver, HomepageUI.DYNAMIC_PAGING, pageNumber);

        return getAttributeValue(driver, HomepageUI.DYNAMIC_PAGING, "class", pageNumber)
                .endsWith("active");
    }

    public void enterTextboxByHeaderName(String headerName, String valueToSend) {
        waitForElementVisible(driver, HomepageUI.DYNAMIC_HEADER_NAME, headerName);

        sendkeyToElement(driver, HomepageUI.DYNAMIC_HEADER_NAME, valueToSend, headerName);
        pressKeyBoardToElement(driver, HomepageUI.DYNAMIC_HEADER_NAME, Keys.ENTER, headerName);
    }

    public boolean isRowDataValueDisplayed(String females, String country, String male, String total) {
        waitForElementVisible(driver, HomepageUI.DYNAMIC_DATA_ROW, females, country, male, total);
        return isElementDisplayed(driver, HomepageUI.DYNAMIC_DATA_ROW, females, country, male, total);
    }

    public void deleteRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomepageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomepageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
        sleepInSecond(2);
    }

    public void editRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomepageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomepageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
        sleepInSecond(2);
    }

    public void clickLoadDataButton() {
        waitForElementClickable(driver, HomepageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, HomepageUI.LOAD_DATA_BUTTON);
    }


    public void enterTextboxByIndex(String rowIndex, String columnName, String valueToSendkey) {
        //từ column name làm sao lấy được column index
        int columnIndexNumber = getListElementSize(driver, HomepageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName) + 1;

        //Lấy đc index thì convert từ text quá String  --> vì khi dùng String format để truyền index vào %s thì kiểu dữ liệu của nó là String
        String columnIndex = String.valueOf(columnIndexNumber);

        //Truyền 2 giá trị: rowIndex, columnIndex vào locator để tương tác và sendkey
        sendkeyToElement(driver, HomepageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, valueToSendkey, rowIndex, columnIndex);
    }

    public void selectDropdownByIndex(String rowIndex, String columnName, String valueToSelect) {
        //từ column name làm sao lấy được column index
        int columnIndexNumber = getListElementSize(driver, HomepageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName) + 1;

        //Lấy đc index thì convert từ text quá String  --> vì khi dùng String format để truyền index vào %s thì kiểu dữ liệu của nó là String
        String columnIndex = String.valueOf(columnIndexNumber);

        //Truyền 2 giá trị: rowIndex, columnIndex vào locator để tương tác và select dropdown
        selectItemDropdown(driver, HomepageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX, valueToSelect, rowIndex, columnIndex);
        //selectItemDropdown(driver, HomepageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX_1,valueToSelect,columnIndex,rowIndex);
    }

    public void selectCheckboxByIndex(String rowIndex, String columnName, boolean checkOrUncheck) {
        //từ column name làm sao lấy được column index
        int columnIndexNumber = getListElementSize(driver, HomepageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName) + 1;

        //Lấy đc index thì convert từ text quá String  --> vì khi dùng String format để truyền index vào %s thì kiểu dữ liệu của nó là String
        String columnIndex = String.valueOf(columnIndexNumber);
        if (checkOrUncheck) {
            checkToCheckboxOrRadio(driver, HomepageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        } else {
            uncheckTheCheckbox(driver, HomepageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        }

    }

    public void clickIconByIndex(String rowIndex, String iconType) {
        waitForElementClickable(driver, HomepageUI.DYNAMIC_ICON_BY_ROW_INDEX, rowIndex, iconType);
        clickToElement(driver, HomepageUI.DYNAMIC_ICON_BY_ROW_INDEX, rowIndex, iconType);
    }

    public List<String> getAllValueInAColumn(String columnName) {
        //từ column name làm sao lấy được column index
        int columnIndexNumber = getListElementSize(driver, HomepageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER_1, columnName) + 1;

        //Lấy đc index thì convert từ text quá String  --> vì khi dùng String format để truyền index vào %s thì kiểu dữ liệu của nó là String
        String columnIndex = String.valueOf(columnIndexNumber);
        List<WebElement> allValueInColumn = getListWebElement(driver, HomepageUI.ALL_VALUE_BY_COLUMN_INDEX, columnIndex);
        List<String> allTextValue = new ArrayList<>();
        for (WebElement element : allValueInColumn) {
            allTextValue.add(element.getText());
        }
        return allTextValue;
    }

    public boolean isFileLoadedByName(String fileName) {
        waitForElementVisible(driver,HomepageUI.FILE_LOADED_BY_FILE_NAME,fileName);
        return isElementDisplayed(driver,HomepageUI.FILE_LOADED_BY_FILE_NAME,fileName);
    }

    public void clickUploadButton(WebDriver driver) {
       List <WebElement> startsButtonList = getListWebElement(driver,HomepageUI.UPLOADED_BUTTON);
       for (WebElement button:startsButtonList){
           button.click();
           sleepInSecond(3);
       }
    }
    public boolean isFileUploadedByName(String fileName) {
        waitForElementVisible(driver,HomepageUI.FILE_UPLOADED_SUCCESS_BY_FILE_NAME,fileName);
        return isElementDisplayed(driver,HomepageUI.FILE_UPLOADED_SUCCESS_BY_FILE_NAME,fileName);
    }
}

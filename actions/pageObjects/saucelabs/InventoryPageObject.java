package pageObjects.saucelabs;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import saucelabs.InventoryPageUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPageObject extends BasePage {
    WebDriver driver;

    public InventoryPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSortDropdown(String sortItem) {
        waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
        selectItemDropdown(driver,InventoryPageUI.SORT_DROPDOWN,sortItem);
        sleepInSecond(2);
    }

//    public boolean isNameSortAscending() {
//        List<WebElement> productNameElements =  getListWebElement(driver,InventoryPageUI.PRODUCT_NAME);
//        List<String> productNameText = new ArrayList<String>();
//        System.out.println("Trước khi sort:");
//        for (WebElement productName:productNameElements){
//            System.out.println( productName.getText());
//            productNameText.add(productName.getText());
//        }
//        //Sao chep toàn bộ Text từ productNameText sang 1 text mới
//        List <String> productNameTextClone = new ArrayList<>(productNameText);
//
//        //Sort list đã được clone
//        Collections.sort(productNameTextClone);
//        System.out.println("Sau khi sort:");
//        for (String text: productNameTextClone) {
//            System.out.println(text);
//        }
//        //Kiếm tra 2 list có bằng nhau ko?
//        return productNameTextClone.equals(productNameText); //Return tam false, nho update lai
//    }

//    public boolean isNameSortAscending() {
//        List<WebElement> productNameElements =  getListWebElement(driver,InventoryPageUI.PRODUCT_NAME);
//        List<String> productNameText = productNameElements.stream().
//                map(n -> n.getText()).collect(Collectors.toList());
//        List <String> productNameTextClone = new ArrayList<>(productNameText);
//        Collections.sort(productNameTextClone);
//        return productNameTextClone.equals(productNameText);
//    }

    public boolean isNameSortAscending () {
        var productNameElements =  getListWebElement(driver,InventoryPageUI.PRODUCT_NAME);
        var names = productNameElements.stream()
                .map(WebElement::getText)
                .toList(); // Sử dụng phương thức toList() từ Java 16
        var sortedNames = names.stream().sorted()
                .toList(); // Trực tiếp sắp xếp bằng Stream
        return names.equals(sortedNames);
    }

    public boolean isNameSortDescending() {
        List<WebElement> productNameElements =  getListWebElement(driver,InventoryPageUI.PRODUCT_NAME);
        List<String> productNameText = new ArrayList<String>();
        for (WebElement productName:productNameElements){
            productNameText.add(productName.getText());}
        List <String> productNameTextClone = new ArrayList<>(productNameText);
        Collections.sort(productNameTextClone);
        Collections.reverse(productNameTextClone);  //Dec
        return productNameTextClone.equals(productNameText);

    }

    public boolean isPriceSortAscending() {
        List<WebElement> productPriceElements =  getListWebElement(driver,InventoryPageUI.PRODUCT_PRICE);
        List<Float> productPriceText = new ArrayList<Float>();
        System.out.println("Trước khi sort:");
        for (WebElement productPrice:productPriceElements){
            System.out.println(Float.valueOf(productPrice.getText().replace("$","")));
            productPriceText.add(Float.valueOf(productPrice.getText().replace("$","")));
        }

        List <Float> productPriceTextClone = new ArrayList<>(productPriceText);
        Collections.sort(productPriceTextClone);
        return productPriceTextClone.equals(productPriceText);
    }

    public boolean isPriceSortDescending() {
        List<WebElement> productPriceElements =  getListWebElement(driver,InventoryPageUI.PRODUCT_PRICE);
        List<Float> productPriceText = new ArrayList<Float>();
        for (WebElement productPrice:productPriceElements){
            productPriceText.add(Float.valueOf(productPrice.getText().replace("$","")));
        }

        List <Float> productPriceTextClone = new ArrayList<>(productPriceText);
        Collections.sort(productPriceTextClone);
        Collections.reverse(productPriceTextClone);
        return productPriceTextClone.equals(productPriceText);
    }
}

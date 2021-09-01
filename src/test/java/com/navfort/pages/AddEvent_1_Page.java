package com.navfort.pages;

import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddEvent_1_Page extends BasePage{

    @FindBy(xpath = "//div[@class='pull-right']//a[contains(text(),'Add Event')]")
    public WebElement addEventInGeneralInformation;

    @FindBy(xpath = "//div[@class='control-label wrap']//label")
    public List<WebElement> allFieldsInTheAddEventWindow;

    public void selectDriverByName(String driverName) {
        String driverLocator = "//td[contains(text(),'"+ driverName +"')]";
        WebElement driverElement = Driver.get().findElement(By.xpath(driverLocator));
        driverElement.click();
    }

    public void selectEditDeleteAddEventModule(String module) {
        String moduleLocator = "//div[@class='pull-right']//a[contains(text(),'"+ module +"')]";
        WebElement moduleElement = Driver.get().findElement(By.xpath(moduleLocator));
        moduleElement.click();
    }

    public void fieldsInAddEventWindows(String field) {
        String fieldLocator = "//div[@class='control-label wrap']//label[contains(text(),'"+ field +"')]";
        WebElement fieldElement = Driver.get().findElement(By.xpath(fieldLocator));
    }



}

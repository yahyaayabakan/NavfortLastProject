package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GeneralInfoVehiclePage {

    public GeneralInfoVehiclePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "user-name")
    public WebElement contactFullName;

    @FindBy(css = ".pull-left.btn-group.icons-holder>a")
    public WebElement addEventButton;

    @FindBy(xpath = "//div[@class='pull-right']/div/div/a[@title='Edit Car']")
    public WebElement editButton;

    @FindBy(css = ".btn.icons-holder-text.no-hash.remove-button")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@class='pull-right title-buttons-container']/div/a")
    public List<WebElement> buttons;


    public WebElement cellNameLocation(String cellName) {

        String xpath = "//div[@class='grid-container']//tbody/tr/td[contains(text(),'" + cellName + "')and @data-column-label='Location']";
        return Driver.get().findElement(By.xpath(xpath));
    }




}

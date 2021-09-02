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

    @FindBy(xpath = "//input[@name='oro_calendar_event_form[title]']")
    public WebElement titleTextBox;

    @FindBy(xpath = "//input[@name='oro_calendar_event_form[organizerDisplayName]']")
    public WebElement organizeDisplayNameTextBox;

    @FindBy(xpath = "//input[@name='oro_calendar_event_form[organizerEmail]']")
    public WebElement organizerEmailTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[@class='validation-failed']/span/span")
    public WebElement errorMessage;

    @FindBy(xpath = "//button[@title='close']")
    public WebElement closeEventTab;


    @FindBy(xpath = "//div[@class='flash-messages-holder']//div[@class='message']")
    public WebElement successfullyAddEvent;
    public void selectDriverByName(String driverName) {
        BrowserUtils.waitForPageToLoad(10);
        String driverLocator = "//td[contains(text(),'"+ driverName +"')]";
        WebElement driverElement = Driver.get().findElement(By.xpath(driverLocator));
        BrowserUtils.waitForClickablility(driverElement,10);
        driverElement.click();
    }

    public void selectEditDeleteAddEventModule(String module) {
        BrowserUtils.waitForPageToLoad(10);
        String moduleLocator = "//div[@class='pull-right']//a[contains(text(),'"+ module +"')]";
        WebElement moduleElement = Driver.get().findElement(By.xpath(moduleLocator));
        BrowserUtils.waitForClickablility(moduleElement,10);
        moduleElement.click();
    }

    public void setCloseEventTab(){
        BrowserUtils.waitForPageToLoad(10);
        List<WebElement> closeBtn = Driver.get().findElements(By.xpath("//button[@title='close']"));
        try {
            for (WebElement webElement : closeBtn) {
                if (webElement.isDisplayed()){
                    webElement.click();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebElement descriptionBox() {
        WebElement iframeElement = Driver.get().findElement((By.tagName("iframe")));
        Driver.get().switchTo().frame(iframeElement);
        return Driver.get().findElement(By.xpath("//body[@id='tinymce']//p"));
    }





}

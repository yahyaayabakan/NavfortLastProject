package com.navfort.pages;

import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.XMLFormatter;

public class VehiclesPage extends BasePage{
    @FindBy(xpath = "//i[@class='fa-cog hide-text']")
    public WebElement gridSettingsButton;

    @FindBy(xpath = "//a[@title='Filters']")
    public WebElement filterIcon;

    @FindBy(xpath = "//a[@class='add-filter-button']")
    public WebElement ManageFilters;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement filterSearchBox;

    @FindBy(xpath = "//a[@title='Reset']")
    public WebElement resetIcon;



    public void selectFilter(String filterName){
        String locator = "//label[@title='"+filterName+"']/span";
        BrowserUtils.waitForClickablility(By.xpath(locator),5);
        WebElement filter = Driver.get().findElement(By.xpath(locator));
        filter.click();
    }

    public boolean filterDisplayed(String filterName){
      BrowserUtils.waitFor(5);
      String locator = "//span[@class='filter-items']//*[contains(text(),'"+filterName+"')]";
      WebElement filterTab = Driver.get().findElement(By.xpath(locator));
          if(filterTab.isDisplayed()){
             return true;
          }else{
             return false;
          }
    }

    public boolean optionsContain(String str){
        boolean flag=false;

        List<WebElement> filterOptions = Driver.get().findElements(By.xpath("//input[contains(@value,'" + str + "')]"));

        for (int i = 0; i < filterOptions.size(); i++) {
            if(filterOptions.get(i).isDisplayed()){
                System.out.print("         ********"+filterOptions.get(i).getAttribute("value"));
                System.out.println(" IS DISPLAYED UNDER MANAGE FILTERS:  "+filterOptions.get(i).isDisplayed());
                if(filterOptions.get(i).getAttribute("value").contains(str)){
                    flag=true;
                }else{
                    flag=false;
                }
            }
        }
        return flag;
    }




    @FindBy(xpath = "//input[@placeholder='Quick Search']")
    public WebElement quickSearch;

    @FindBy(xpath = "//span[@class='column-filter-match']")
    public WebElement filterMatch;

    @FindBy(xpath = "//input[@type='checkbox' and @data-role='renderable']")
    public List<WebElement> allCheckboxes;

    @FindBy(xpath = "//span[@class='close']")
    public WebElement closeGridButton;

    @FindBy(xpath = "//thead[@class='grid-header']//span[@class='grid-header-cell__label'][normalize-space()='Id']")
    public WebElement idTable;

    @FindBy(xpath = "//tbody/tr[2]/td[2]/span[1]/i[1]")
    public WebElement hoverToGrab;

    @FindBy(xpath = "//input[@id='column-c295']")
    public WebElement idCheckbox;

    @FindBy(xpath = "//thead[@class='grid-header']//span[@class='grid-header-cell__label'][normalize-space()='License Plate']")
    public WebElement licensePlateTable;

    @FindBy(xpath = "//thead[@class='grid-header']//span[@class='grid-header-cell__label'][normalize-space()='Tags']")
    public WebElement tagsTable;

    @FindBy(xpath = "//*[@class='title-cell']")
    public List<WebElement> columnNames;
}

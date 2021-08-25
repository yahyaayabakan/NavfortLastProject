package com.navfort.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.XMLFormatter;

public class VehiclesPage extends BasePage{
    @FindBy(xpath = "//i[@class='fa-cog hide-text']")
    public WebElement gridSettingsButton;

    @FindBy(css = ".title-cell")
    public List<WebElement> columnNames;

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


}

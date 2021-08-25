package com.navfort.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VehicleTableArrangmentsPage extends BasePage {

    @FindBy(xpath = "//button[@data-toggle='dropdown']")
    public WebElement viewPerPageBtn;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public List<WebElement> rowsOptions;

    @FindBy(xpath = "//a[@title='Reset']/i[@class='fa-refresh']")
    public WebElement resetBtn;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> rowCount;




}

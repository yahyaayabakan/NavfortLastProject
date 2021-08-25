package com.navfort.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehiclesPage {
    @FindBy(xpath = "//i[@class='fa-cog hide-text']")
    public WebElement gridSettingsButton;
}

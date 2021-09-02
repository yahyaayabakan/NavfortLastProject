package com.navfort.pages;

import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TableViewPage extends BasePage {

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div/div[4]/label[2]")
    public WebElement pageNumber;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div/div[4]/label[3]")
    public WebElement TotalRecordsVehicles;

    @FindBy(xpath ="//html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/div/a")
    public WebElement exportGridbutton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/div/ul/li[1]/a")
    public WebElement CSVbutton;


    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div/div/div/div")
    public WebElement downloadConfirmation;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[2]")
    public WebElement vehiclesAllinfo;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div/div[4]/ul/li[3]/a/i")
    public WebElement goNextPage;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div/div[4]/ul/li[1]/a/i")
    public WebElement goBackPage;



    /**
     * navigates forward
     */

    public void goNext(){
        goNextPage.isEnabled();
    }


    /**
     * Navigates back
     */
    public void goBack(){
        goBackPage.isEnabled();

    }



    public void vehiclesInfo(){

        vehiclesAllinfo.isDisplayed();
    }




    public String downConf(){

        return downloadConfirmation.getText();
    }



    public void clickCSV(){
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.clickWithJS(CSVbutton);
    }


    public void clickGrid(){

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.clickWithJS(exportGridbutton);

    }

    /**
     * @return record of vehicles
     *
     */
    public String getTotalRecordsVehicles(){
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        return TotalRecordsVehicles.getText();
    }


    /**
     *
     * @return page number
     */


    public String getPageNumber(){
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        return pageNumber.getText();
    }
}

